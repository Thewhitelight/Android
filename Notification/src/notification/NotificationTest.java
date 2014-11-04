package notification;


import com.example.notification.R;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NotificationTest extends Activity {
	private Notification notification;
	private NotificationManager notificationManger;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notificationtest);
		Button btn1=(Button)findViewById(R.id.button1);
		Button btn2=(Button)findViewById(R.id.button2);
		String service=NOTIFICATION_SERVICE;//��ȡϵͳ����
		notificationManger=(NotificationManager)getSystemService(service);
		notification=new Notification();//ʵ����һ��Notification
		notification.icon=R.drawable.ic_launcher;//ָ����ʾͼ��
		notification.tickerText="Notification����";//ָ����ʾ��Ϣ
		notification.when=System.currentTimeMillis();//ָ����ʾ��ʱ��
		notification.flags=Notification.FLAG_AUTO_CANCEL;//��֪ͨ�����֮���Զ���ʧ
		btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				Intent intent=new Intent(NotificationTest.this, NotificationTest.class);
				PendingIntent pendingIntent=PendingIntent.getActivity(NotificationTest.this, 0, intent, 0);
				notification.setLatestEventInfo(NotificationTest.this, "�ҵı���", "�ҵ�����", pendingIntent);
				notificationManger.notify(1,notification);//����֪ͨ
			}
		});
		btn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
			notificationManger.cancel(1);//ȡ��֪ͨ	
			}
		});
	}
}
