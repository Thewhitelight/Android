/**
 * ֻ����4.1���ϰ汾�����ô���ͼ
 */
package com.szq;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.notification_bigview.R;

/**
 * @author SZQ
 *
 */

public class MainActivity extends Activity {
	private Button btn;
	// private Notification.Builder builder;
	private NotificationManager manager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		btn = (Button) this.findViewById(R.id.btn);
		manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		// builder = new Notification.Builder(this);

		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				NotificationCompat.Builder builer = new NotificationCompat.Builder(
						MainActivity.this);
				builer.setLargeIcon(BitmapFactory.decodeResource(
						getResources(), R.drawable.ic_launcher));
				builer.setWhen(System.currentTimeMillis());
				builer.setSmallIcon(R.drawable.ic_launcher);
				builer.setSubText("SubText");
				builer.setTicker("֪ͨ����");
				builer.setContentTitle("֪ͨ");
				builer.setContentText("�������");
				NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
				builer.setStyle(inboxStyle);
				String[] contentText = new String[] {
						"֪ͨ���ԣ�֪ͨ���ԣ�֪ͨ���ԣ�֪ͨ���ԣ�֪ͨ���ԣ�֪ͨ���ԣ�֪ͨ���ԡ�", "android",
						"Java", "SQL" };
				inboxStyle.setBigContentTitle("Android֪ͨ����");
				// inboxStyle.setSummaryText("�ܽ��ַ�");
				for (int i = 0; i < contentText.length; i++) {
					inboxStyle.addLine(contentText[i]);
				}
				Intent intent = new Intent(MainActivity.this,
						MainActivity.class);
				PendingIntent pendingIntent = PendingIntent.getActivity(
						MainActivity.this, 1, intent,
						PendingIntent.FLAG_ONE_SHOT);
				builer.setContentIntent(pendingIntent);
				manager.notify(1, builer.build());
				builer.setAutoCancel(true);

			}
		});
	}
}
