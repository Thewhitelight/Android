package com.example.downloadmanger;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {
	private Button btn_down;
	private DownloadManager manger;
	private DownLoadedReceiver receiver;
	private Context context;
	private DownloadManager.Request down;
	private long refernece;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = this;
		manger = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
		receiver = new DownLoadedReceiver();
		btn_down = (Button) findViewById(R.id.btn_down);
		btn_down.setOnClickListener(new OnClickListener() {

			@SuppressLint("NewApi")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				down = new DownloadManager.Request(
						Uri.parse("http://180.163.68.22/dd.myapp.com/16891/B5304B1B3A040D12FAD1FB74AB6AD366.apk?mkey=55458b0a8483c48f&f=2c01&fsname=com.tencent.mobileqq_5.5.1_236.apk&asr=8eff&p=.apk"));
				down.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI
						| DownloadManager.Request.NETWORK_MOBILE);
				down.setShowRunningNotification(true);
				down.setVisibleInDownloadsUi(true);
				down.setNotificationVisibility(Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
				down.setDestinationInExternalFilesDir(context,
						Environment.DIRECTORY_DOWNLOADS, "qq.apk");
				down.setMimeType("application/vnd.android.package-archive");
				refernece = manger.enqueue(down);

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		registerReceiver(receiver, new IntentFilter(
				DownloadManager.ACTION_DOWNLOAD_COMPLETE));
		super.onResume();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		if (receiver != null) {
			unregisterReceiver(receiver);
		}
		super.onDestroy();
	}

	public class DownLoadedReceiver extends BroadcastReceiver {

		IntentFilter filter = new IntentFilter(
				DownloadManager.ACTION_DOWNLOAD_COMPLETE);

		@SuppressLint("NewApi")
		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			if (intent.getAction().equals(
					DownloadManager.ACTION_DOWNLOAD_COMPLETE)) {
				long downId = intent.getLongExtra(
						DownloadManager.EXTRA_DOWNLOAD_ID, -1);
				Log.i("DownLoadManger", intent.getAction() + "id is" + downId);

				if (refernece == downId) {
					Intent install = new Intent(Intent.ACTION_VIEW);
					Uri fileUri = manger.getUriForDownloadedFile(refernece);
					install.setDataAndType(fileUri,
							"application/vnd.android.package-archive");
					install.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					startActivity(install);
				}
			}
		}
	}
}
