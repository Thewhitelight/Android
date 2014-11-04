package testnetwork;

import com.example.testnetwork.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.provider.Settings; 
import android.view.Window;
import android.widget.ImageView;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

public class welcome extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);//标题栏就没有了
		setContentView(R.layout.welcome);
		ImageView image=(ImageView)findViewById(R.id.tv01);
		image.setImageDrawable(getResources().getDrawable(R.drawable.qq));
	}
	private boolean isNetworkConnected() {
		
		// TODO 自动生成的方法存根
		ConnectivityManager cm=(ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
		NetworkInfo info=cm.getActiveNetworkInfo();
		if (info!=null&&info.isConnected()) {
			return true;
		}
		else{
		return false;
		}
	}
	@Override
	protected void onStart() {
		// TODO 自动生成的方法存根
		super.onStart();
		if (isNetworkConnected()) {
			new Thread(){
				public void run() {
					try {
						Thread.sleep(2000);//休眠两秒钟
						Intent intent=new Intent(testnetwork.welcome.this, testnetwork.mainactivity.class);
						startActivity(intent);
						finish();
					} catch (InterruptedException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				};
			}.start();
		}else {
			AlertDialog.Builder builder=new Builder(this);
			builder.setTitle("网络设置");
			builder.setMessage("网络错误请设置");
			builder.setPositiveButton("设置网络", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO 自动生成的方法存根
					if (android.os.Build.VERSION.SDK_INT>10) {//网络设置当Android版本大于3.0时调用此方法
						Intent intent =new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS);
						startActivity(intent);
					}
					else{//版本3.0以下
						startActivityForResult(new Intent(Settings.ACTION_WIRELESS_SETTINGS),0);  
						}    
				}
			});
			builder.setNegativeButton("取消", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO 自动生成的方法存根
					finish();
				}
			});
			builder.create().show();
		}
	}
}
