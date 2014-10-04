package com.qq.xgdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

//import com.qq.xgdemo.R;
import com.tencent.android.tpush.XGPushManager;

public class MsgInfoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(geniuz.pathbuttons.R.layout.activity_msginfo);
		overridePendingTransition(android.R.anim.fade_in,
				android.R.anim.fade_out);// 淡入淡出效果
		Bundle xgnotification = this.getIntent().getExtras();
		/*
		 * getSupportActionBar().setTitle("ID:" +
		 * xgnotification.getLong("msg_id"));
		 * getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		 * getSupportActionBar().show();
		 */

		TextView textView = (TextView) this
				.findViewById(geniuz.pathbuttons.R.id.title);
		textView.setText(xgnotification.getString("title"));
		textView = (TextView) this
				.findViewById(geniuz.pathbuttons.R.id.content);
		textView.setText(xgnotification.getString("content"));
		textView = (TextView) this
				.findViewById(geniuz.pathbuttons.R.id.update_time);
		textView.setText("推送时间" + xgnotification.getString("update_time"));
		/*
		 * textView = (TextView) this
		 * .findViewById(geniuz.pathbuttons.R.id.activityType);
		 */
		/*
		 * TextView textViewContent = (TextView) this
		 * .findViewById(geniuz.pathbuttons.R.id.activityContent);
		 */
		/*
		 * if (xgnotification.getInt("notificationActionType", 0) == 1) {
		 * textView.setText("推送页面"); } else if
		 * (xgnotification.getInt("notificationActionType", 0) == 2) {
		 * textView.setText(" URL"); } else if
		 * (xgnotification.getInt("notificationActionType", 0) == 3) {
		 * textView.setText("Intent:"); }
		 */
		// textViewContent.setText(xgnotification.getString("activity"));

	}

	@Override
	protected void onResume() {
		super.onResume();
		XGPushManager.onActivityStarted(this);
	}

	@Override
	protected void onPause() {
		super.onPause();
		XGPushManager.onActivityStoped(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// getMenuInflater().inflate(R.menu.other, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			Intent mainIntent = new Intent(this, MainActivity.class);
			mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
					| Intent.FLAG_ACTIVITY_NEW_TASK);
			this.startActivity(mainIntent);
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
