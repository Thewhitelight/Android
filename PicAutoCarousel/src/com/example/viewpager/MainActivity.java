package com.example.viewpager;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.example.picautocarousel.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ImageView.ScaleType;

public class MainActivity extends Activity implements OnPageChangeListener {
	/**
	 * ViewPager
	 */
	private ViewPager viewPager;

	/**
	 * 装点点的ImageView数组
	 */
	private ImageView[] tips;

	/**
	 * 装ImageView数组
	 */
	private ImageView[] mImageViews;

	/**
	 * 图片资源id
	 */
	private List<Drawable> list;
	private ImageView imageViewTips, imageView;
	Timer mTimer;
	TimerTask mTask;
	int pageIndex = 1;
	boolean isTaskRun;
	int x;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ViewGroup group = (ViewGroup) findViewById(R.id.viewGroup);
		viewPager = (ViewPager) findViewById(R.id.viewPager);
		list = new ArrayList<Drawable>();
		// 载入图片资源ID
		list.add(getResources().getDrawable(R.drawable.item01));
		list.add(getResources().getDrawable(R.drawable.item02));
		list.add(getResources().getDrawable(R.drawable.item03));
		list.add(getResources().getDrawable(R.drawable.item04));
		list.add(getResources().getDrawable(R.drawable.item05));
		// 将点点加入到ViewGroup中
		tips = new ImageView[list.size()];
		for (int i = 0; i < tips.length; i++) {
			imageViewTips = new ImageView(this);
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					15, 15);
			params.setMargins(3, 0, 3, 0);// 左，上，右，下
			imageViewTips.setLayoutParams(params);
			imageViewTips.setScaleType(ScaleType.FIT_XY);
			tips[i] = imageViewTips;
			if (i == 0) {
				tips[i].setBackgroundResource(R.drawable.page_indicator_focused);
			} else {
				tips[i].setBackgroundResource(R.drawable.page_indicator_unfocused);
			}
			group.addView(imageViewTips);
		}

		// 将图片装载到数组中
		mImageViews = new ImageView[list.size()];
		for (int i = 0; i < mImageViews.length; i++) {

			imageView = new ImageView(this);
			mImageViews[i] = imageView;
			imageView.setBackgroundDrawable(list.get(i));
			final Message msg = Message.obtain();
			msg.arg1 = i;
			msg.what = 1;
			mImageViews[i].setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					mHandler.sendMessage(msg);
				}
			});

		}

		// 设置Adapter
		viewPager.setAdapter(new MyAdapter());
		// 设置监听，主要是设置点点的背景
		viewPager.setOnPageChangeListener(this);
		// 设置ViewPager的默认项, 设置为长度的100倍，这样子开始就能往左滑动
		viewPager.setCurrentItem((mImageViews.length) * 100);
	}

	/**
	 * 开启定时任务
	 */
	private void startTask() {
		// TODO Auto-generated method stub
		isTaskRun = true;
		mTimer = new Timer();
		mTask = new TimerTask() {
			@Override
			public void run() {
				pageIndex++;
				mHandler.sendEmptyMessage(0);
			}
		};
		mTimer.schedule(mTask, 2 * 1000, 2 * 1000);// 这里设置自动切换的时间，单位是毫秒，2*1000表示2秒
	}

	// 处理EmptyMessage(0)

	public Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			setCurrentItem();
			if (msg.what == 1) {
				int i = msg.arg1;
				Toast.makeText(getApplicationContext(), i + "",
						Toast.LENGTH_SHORT).show();
			}
		}
	};

	/**
	 * 处理Page的切换逻辑
	 */
	private void setCurrentItem() {
		if (pageIndex == 0) {
			pageIndex = 1;
		} else if (pageIndex == list.size()) {
			pageIndex = 1;
		}
		viewPager.setCurrentItem(pageIndex, false);// 取消动画
	}

	/**
	 * 停止定时任务
	 */
	private void stopTask() {
		// TODO Auto-generated method stub
		isTaskRun = false;
		mTimer.cancel();
	}

	@Override
	public void onResume() {
		super.onResume();
		setCurrentItem();
		startTask();
	}

	@Override
	public void onPause() {
		super.onPause();
		stopTask();
	}

	public class MyAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return Integer.MAX_VALUE;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(View container, int position, Object object) {
			((ViewPager) container).removeView(mImageViews[position
					% mImageViews.length]);

		}

		/**
		 * 载入图片进去，用当前的position 除以 图片数组长度取余数是关键
		 */
		@Override
		public Object instantiateItem(View container, final int position) {

			((ViewPager) container).addView(mImageViews[position
					% mImageViews.length], 0);

			return mImageViews[position % mImageViews.length];
		}

	}

	@Override
	public void onPageScrollStateChanged(int arg0) {

		// TODO Auto-generated method stub
		// System.out.println("state:" + state);
		if (arg0 == 0 && !isTaskRun) {
			setCurrentItem();
			startTask();
		} else if (arg0 == 1 && isTaskRun)
			stopTask();

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {

	}

	@Override
	public void onPageSelected(int arg0) {
		setImageBackground(arg0 % mImageViews.length);
		pageIndex = arg0;
	}

	/**
	 * 设置选中的tip的背景
	 * 
	 * @param selectItems
	 */
	private void setImageBackground(int selectItems) {
		for (int i = 0; i < tips.length; i++) {
			if (i == selectItems) {
				tips[i].setBackgroundResource(R.drawable.page_indicator_focused);
			} else {
				tips[i].setBackgroundResource(R.drawable.page_indicator_unfocused);
			}
		}
	}

}
