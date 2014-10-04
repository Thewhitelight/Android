package com.qq.xgdemo;

import geniuz.pathbuttons.R;

import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.qq.xgdemo.common.NotificationService;
import com.qq.xgdemo.po.XGNotification;
import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushClickedResult;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.service.cache.CacheManager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class MainActivity extends Activity implements OnItemClickListener,
		OnQueryTextListener, OnScrollListener {
	private LinearLayout bloadLayout;// ������ʾ�Ĳ���
	private LinearLayout tloadLayout;// ������ʾ�Ĳ���
	private TextView bloadInfo;// ������ʾ
	private TextView tloadInfo;// ������ʾ
	private TextView mSearchText;// ������
	private ListView pushListV;// �б�

	private  NotificationService notificationService;// ��ȡ֪ͨ���ݷ���
	private pushAdapter adapter;// �б�������

	private int currentPage = 1;// Ĭ�ϵ�һҳ
	private static final int lineSize = 10;// ÿ����ʾ��
	private int allRecorders = 0;// ȫ����¼��
	private int pageSize = 1;// Ĭ�Ϲ�1ҳ
	private boolean isLast = false;// �Ƿ����һ��
	private int firstItem;// ��һ����ʾ���������ݵ��α�
	private int lastItem;// �����ʾ�������ݵ��α�
	private String id = "";// ��ѯ����
	private boolean isUpdate = false;
	private MsgReceiver updateListViewReceiver;
	Message m = null;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.xgactivity_main);
		overridePendingTransition(android.R.anim.fade_in,
				android.R.anim.fade_out);// ���뵭��Ч��
		// XGPushConfig.enableDebug(this, true);
		// setContentView(R.layout.activity_main);
		// getSupportActionBar().setHomeButtonEnabled(true);
		// 0.ע�����ݸ��¼�����
		updateListViewReceiver = new MsgReceiver();
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction("com.qq.xgdemo.activity.UPDATE_LISTVIEW");
		registerReceiver(updateListViewReceiver, intentFilter);
		// 1.��ȡ�豸Token
		Handler handler = new HandlerExtension(MainActivity.this);
		m = handler.obtainMessage();
		// ע��ӿ�
		XGPushManager.registerPush(getApplicationContext(),
				new XGIOperateCallback() {
					@Override
					public void onSuccess(Object data, int flag) {
						/*
						 * Log.w(Constants.LogTag,
						 * "+++ register push sucess. token:" + data); m.obj =
						 * "+++ register push sucess. token:" + data;
						 * m.sendToTarget();
						 */
						CacheManager.getRegisterInfo();
					}

					@Override
					public void onFail(Object data, int errCode, String msg) {
						/*
						 * Log.w(Constants.LogTag,
						 * "+++ register push fail. token:" + data +
						 * ", errCode:" + errCode + ",msg:" + msg);
						 * 
						 * m.obj = "+++ register push fail. token:" + data +
						 * ", errCode:" + errCode + ",msg:" + msg;
						 */
						m.sendToTarget();
					}
				});
		initView();
	}

	/*
	 * private void setContentView(int xgactivityMain) { // TODO Auto-generated
	 * method stub
	 * 
	 * }
	 */
	private void initView() {
		// 2.���б�չʾ
		notificationService = NotificationService.getInstance(this);
		pushListV = (ListView) this.findViewById(R.id.push_list);

		// ����¼�
		pushListV.setOnItemClickListener(this);
		// �����¼�
		pushListV.setOnScrollListener(this);

		// 3. ����һ���Ǳ����Բ�������ʾ���ڼ���
		bloadLayout = new LinearLayout(this);
		bloadLayout.setMinimumHeight(100);
		bloadLayout.setGravity(Gravity.CENTER);

		// ����һ���ı���ʾ"���ڼ����ı�"
		bloadInfo = new TextView(this);
		bloadInfo.setTextSize(16);
		bloadInfo.setTextColor(Color.parseColor("#858585"));
		bloadInfo.setText("���ظ���...");
		bloadInfo.setGravity(Gravity.CENTER);

		// �����M��
		bloadLayout.addView(bloadInfo, new LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT));
		bloadLayout.getBottom();

		// ����ʾ���б�ײ�
		pushListV.addFooterView(bloadLayout);

		// 4. ����һ���Ǳ����Բ�������ʾ���ڼ���
		tloadLayout = new LinearLayout(this);
		tloadLayout.setGravity(Gravity.CENTER);

		// ����һ���ı���ʾ"���ڼ����ı�"
		tloadInfo = new TextView(this);
		tloadInfo.setTextSize(16);
		tloadInfo.setTextColor(Color.parseColor("#858585"));
		// tloadInfo.setBackgroundResource(R.color.gray);
		tloadInfo.setText("��������Ϣ...");
		tloadInfo.setGravity(Gravity.CENTER);
		tloadInfo.setHeight(0);

		// �����M��
		tloadLayout.addView(tloadInfo, new LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT));

		// ����ʾ���б�ײ�
		pushListV.addHeaderView(tloadLayout);
		tloadLayout.setVisibility(View.GONE);

		// 5.�Ҳ�3�㰴ť
		getOverflowMenu();

		// 6������������
		mSearchText = new TextView(this);

		// 7.��������
		getNotifications(id);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		/*
		 * SearchView searchView = (SearchView)
		 * MenuItemCompat.getActionView(menu .findItem(R.id.action_search));
		 */
		/*
		 * if (searchView != null) { searchView.setOnQueryTextListener(this); }
		 */
		return true;
	}

	@Override
	protected void onNewIntent(Intent intent) {
		// TODO Auto-generated method stub
		super.onNewIntent(intent);
		setIntent(intent);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		XGPushClickedResult click = XGPushManager.onActivityStarted(this);
		Log.d("TPush", "onResumeXGPushClickedResult:" + click);
		if (click != null) { // �ж��Ƿ������Ÿ�Ĵ򿪷�ʽ
		/*
		 * Toast.makeText(this, "֪ͨ�����:" + click.toString(),
		 * Toast.LENGTH_SHORT).show();
		 */
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
		XGPushManager.onActivityStoped(this);
	}

	@Override
	protected void onDestroy() {
		unregisterReceiver(updateListViewReceiver);
		super.onDestroy();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			getNotifications(id);
			break;
		case R.id.action_clear:
			this.adapter.setData(null);
			this.adapter.notifyDataSetChanged();
			this.findViewById(R.id.nodata).setVisibility(View.VISIBLE);
			this.findViewById(R.id.deviceToken).setVisibility(View.VISIBLE);
			this.findViewById(R.id.deviceTokenHint).setVisibility(View.VISIBLE);
			this.findViewById(R.id.deviceLine).setVisibility(View.VISIBLE);
			notificationService.getInstance(this).deleteAll();
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	private class pushAdapter extends BaseAdapter {

		private Activity mActivity;
		private LayoutInflater mInflater;
		List<XGNotification> adapterData;

		public pushAdapter(Activity aActivity) {
			mActivity = aActivity;
			mInflater = LayoutInflater.from(mActivity);
		}

		public List<XGNotification> getData() {
			return adapterData;
		}

		public void setData(List<XGNotification> pushInfoList) {
			adapterData = pushInfoList;
		}

		@Override
		public int getCount() {
			return (null == adapterData ? 0 : adapterData.size());
		}

		@Override
		public Object getItem(int position) {
			return (null == adapterData ? null : adapterData.get(position));
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			pushViewHolder aholder = null;
			XGNotification item = adapterData.get(position);
			if (convertView == null) {
				aholder = new pushViewHolder();
				convertView = mInflater.inflate(R.layout.item_push, null);
				aholder.msg_idv = (TextView) convertView
						.findViewById(R.id.push_msg_id);
				aholder.contentv = (TextView) convertView
						.findViewById(R.id.push_content);
				aholder.timev = (TextView) convertView
						.findViewById(R.id.push_time);
				aholder.titlev = (TextView) convertView
						.findViewById(R.id.push_title);
				convertView.setTag(aholder);
			} else {
				aholder = (pushViewHolder) convertView.getTag();
			}

			aholder.msg_idv.setText("ID:" + item.getMsg_id());
			aholder.titlev.setText(item.getTitle());
			aholder.contentv.setText(item.getContent());
			if (item.getUpdate_time() != null
					&& item.getUpdate_time().length() > 18) {
				String notificationdate = item.getUpdate_time()
						.substring(0, 10);
				String notificationtime = item.getUpdate_time().substring(11);
				if (new SimpleDateFormat("yyyy-MM-dd").format(
						Calendar.getInstance().getTime()).equals(
						notificationdate)) {
					aholder.timev.setText(notificationtime);
				} else {
					aholder.timev.setText(notificationdate);
				}
			} else {
				aholder.timev.setText("δ֪");
			}
			return convertView;
		}
	};

	private class pushViewHolder {
		TextView msg_idv;
		TextView titlev;
		TextView timev;
		TextView contentv;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View view, int index, long pram) {
		Intent ait = new Intent(this, MsgInfoActivity.class);
		if (index > 0 && index <= lastItem) {
			XGNotification xgnotification = adapter.getData().get(index - 1);
			ait.putExtra("msg_id", xgnotification.getMsg_id());
			ait.putExtra("title", xgnotification.getTitle());
			ait.putExtra("content", xgnotification.getContent());
			ait.putExtra("activity", xgnotification.getActivity());
			ait.putExtra("notificationActionType",
					xgnotification.getNotificationActionType());
			ait.putExtra("update_time", xgnotification.getUpdate_time());
			this.startActivity(ait);
		}
	}

	public boolean onQueryTextChange(String newText) {
		newText = newText.isEmpty() ? "" : newText;
		mSearchText.setText(newText);
		return true;
	}

	public boolean onQueryTextSubmit(String id) {
		Toast.makeText(this, "��������: " + id + "...", Toast.LENGTH_SHORT).show();
		getNotifications(id);
		return true;
	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		firstItem = firstVisibleItem;
		lastItem = totalItemCount - 1;
		if (firstVisibleItem + visibleItemCount == totalItemCount) {
			isLast = true;
		} else {
			isLast = false;
		}
	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		// �Ƿ���ײ��������ݻ�û����
		if (scrollState == OnScrollListener.SCROLL_STATE_IDLE) {
			if (isLast && currentPage < pageSize) {
				currentPage++;
				// ������ʾλ��
				pushListV.setSelection(lastItem);
				// ��������
				appendNotifications(id);
			} else if (firstItem == 0) {
				if (isUpdate && tloadInfo.getHeight() >= 50) {
					isUpdate = false;
					updateNotifications(id);
					TranslateAnimation alp = new TranslateAnimation(0, 0, 80, 0);
					alp.setDuration(1000);
					alp.setRepeatCount(1);
					tloadLayout.setAnimation(alp);
					alp.setAnimationListener(new AnimationListener() {

						@Override
						public void onAnimationStart(Animation animation) {
							tloadInfo.setText("���ڸ���...");
						}

						@Override
						public void onAnimationRepeat(Animation animation) {
						}

						@Override
						public void onAnimationEnd(Animation animation) {
							tloadInfo.setText("��������Ϣ...");
							tloadLayout.setVisibility(View.GONE);
							tloadInfo.setHeight(0);
							tloadLayout.setMinimumHeight(0);
						}
					});
				}
			}
		} else if (scrollState == OnScrollListener.SCROLL_STATE_TOUCH_SCROLL
				&& firstItem == 0) {
			if (tloadInfo.getHeight() < 50) {
				isUpdate = true;
				tloadInfo.setHeight(50);
				tloadLayout.setMinimumHeight(100);
				tloadLayout.setVisibility(View.VISIBLE);
			}
		}
	}

	private void getOverflowMenu() {
		try {
			ViewConfiguration config = ViewConfiguration.get(this);
			Field menuKeyField = ViewConfiguration.class
					.getDeclaredField("sHasPermanentMenuKey");
			if (menuKeyField != null) {
				menuKeyField.setAccessible(true);
				menuKeyField.setBoolean(config, false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getNotifications(String id) {
		// ��������������
		allRecorders = notificationService.getCount();
		getNotificationswithouthint(id);
		/*
		 * Toast.makeText( this, "��" + allRecorders + "����Ϣ,������" +
		 * adapter.getData().size() + "����Ϣ", Toast.LENGTH_SHORT).show();
		 */
	}

	private void updateNotifications(String id) {
		// ��������������
		int oldAllRecorders = allRecorders;
		allRecorders = notificationService.getCount();
		getNotificationswithouthint(id);
		Toast.makeText(
				this,
				"��" + allRecorders + "����Ϣ,������"
						+ (allRecorders - oldAllRecorders) + "������Ϣ",
				Toast.LENGTH_SHORT).show();
	}

	private void getNotificationswithouthint(String id) {
		if (allRecorders != 0) {
			this.findViewById(R.id.nodata).setVisibility(View.GONE);
			this.findViewById(R.id.deviceToken).setVisibility(View.GONE);
			this.findViewById(R.id.deviceTokenHint).setVisibility(View.GONE);
			this.findViewById(R.id.deviceLine).setVisibility(View.GONE);
		}

		// ������ҳ��
		pageSize = (allRecorders + lineSize - 1) / lineSize;

		// ����������
		adapter = new pushAdapter(this);
		adapter.setData(NotificationService.getInstance(this).getScrollData(
				currentPage = 1, lineSize, id));
		if (allRecorders <= lineSize) {
			bloadLayout.setVisibility(View.GONE);
			bloadInfo.setHeight(0);
			bloadLayout.setMinimumHeight(0);
		} else {
			if (pushListV.getFooterViewsCount() < 1) {
				bloadLayout.setVisibility(View.VISIBLE);
				bloadInfo.setHeight(50);
				bloadLayout.setMinimumHeight(100);
			}
		}
		pushListV.setAdapter(adapter);
	}

	private void appendNotifications(String id) {
		// ��������������
		allRecorders = notificationService.getCount();
		// ������ҳ��
		pageSize = (allRecorders + lineSize - 1) / lineSize;
		int oldsize = adapter.getData().size();
		// ����������
		adapter.getData().addAll(
				NotificationService.getInstance(this).getScrollData(
						currentPage, lineSize, id));
		// ���������ĩβ��ȥ��"���ڼ���"
		if (allRecorders == adapter.getCount()) {
			bloadInfo.setHeight(0);
			bloadLayout.setMinimumHeight(0);
			bloadLayout.setVisibility(View.GONE);
		} else {
			bloadInfo.setHeight(50);
			bloadLayout.setMinimumHeight(100);
			bloadLayout.setVisibility(View.VISIBLE);
		}
		Toast.makeText(
				this,
				"��" + allRecorders + "����Ϣ,������"
						+ (adapter.getData().size() - oldsize) + "����Ϣ",
				Toast.LENGTH_SHORT).show();
		// ֪ͨ�ı�
		adapter.notifyDataSetChanged();
	}

	private static class HandlerExtension extends Handler {
		WeakReference<MainActivity> mActivity;

		HandlerExtension(MainActivity activity) {
			mActivity = new WeakReference<MainActivity>(activity);
		}

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			MainActivity theActivity = mActivity.get();
			if (msg != null) {
				// Log.w(Constants.LogTag, msg.obj.toString());
				TextView textView = (TextView) theActivity
						.findViewById(R.id.deviceToken);
				textView.setText(XGPushConfig.getToken(theActivity));
			}
			// XGPushManager.registerCustomNotification(theActivity,
			// "BACKSTREET", "BOYS", System.currentTimeMillis() + 5000, 0);
		}
	}

	public class MsgReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			allRecorders = notificationService.getCount();
			getNotificationswithouthint(id);
		}
	}

}
