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
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notificationtest);
		Button btn1=(Button)findViewById(R.id.button1);
		Button btn2=(Button)findViewById(R.id.button2);
		String service=NOTIFICATION_SERVICE;//获取系统服务
		notificationManger=(NotificationManager)getSystemService(service);
		notification=new Notification();//实例化一个Notification
		notification.icon=R.drawable.ic_launcher;//指定提示图标
		notification.tickerText="Notification测试";//指定提示信息
		notification.when=System.currentTimeMillis();//指定显示的时间
		notification.flags=Notification.FLAG_AUTO_CANCEL;//再通知栏点击之后自动消失
		btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Intent intent=new Intent(NotificationTest.this, NotificationTest.class);
				PendingIntent pendingIntent=PendingIntent.getActivity(NotificationTest.this, 0, intent, 0);
				notification.setLatestEventInfo(NotificationTest.this, "我的标题", "我的内容", pendingIntent);
				notificationManger.notify(1,notification);//发出通知
			}
		});
		btn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
			notificationManger.cancel(1);//取消通知	
			}
		});
	}
}
