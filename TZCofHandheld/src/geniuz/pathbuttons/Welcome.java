package geniuz.pathbuttons;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.AnimationDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

public class Welcome extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		requestWindowFeature(Window.FEATURE_NO_TITLE);// ��������û����
		super.onCreate(savedInstanceState);

		setContentView(R.layout.welcome);
		overridePendingTransition(android.R.anim.fade_in,
				android.R.anim.fade_out);// ���뵭��Ч��
		ImageView imageView = (ImageView) findViewById(R.id.imageView1);
		imageView.setBackgroundResource(R.drawable.welcome_list);
		final AnimationDrawable animationDrawable = (AnimationDrawable) imageView
				.getBackground();
		imageView.post(new Runnable() {
			@Override
			public void run() {
				animationDrawable.start();
			}
		});

	}

	private boolean isNetworkConnected() {

		// TODO �Զ����ɵķ������
		ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
		NetworkInfo info = cm.getActiveNetworkInfo();
		if (info != null && info.isConnected()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	protected void onStart() {
		// TODO �Զ����ɵķ������
		super.onStart();
		if (isNetworkConnected()) {
			new Thread() {
				public void run() {
					try {
						Thread.sleep(2000);// ����������
						Intent intent = new Intent(
								geniuz.pathbuttons.Welcome.this,
								geniuz.pathbuttons.MainActivity.class);
						startActivity(intent);
						finish();
					} catch (InterruptedException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				};
			}.start();
		} else {
			AlertDialog.Builder builder = new Builder(this);
			builder.setTitle("��������");
			builder.setMessage("�������������");
			builder.setPositiveButton("��������", new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO �Զ����ɵķ������
					if (android.os.Build.VERSION.SDK_INT > 10) {// �������õ�Android�汾����3.0ʱ���ô˷���
						Intent intent = new Intent(
								android.provider.Settings.ACTION_WIRELESS_SETTINGS);
						startActivity(intent);
					} else {// �汾3.0����
						startActivityForResult(new Intent(
								Settings.ACTION_WIRELESS_SETTINGS), 0);
					}
				}
			});
			builder.setNegativeButton("ȡ��", new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO �Զ����ɵķ������
					Toast.makeText(getApplicationContext(), "������״̬ Ӱ�콻������",
							Toast.LENGTH_LONG).show();
					Intent intent = new Intent(geniuz.pathbuttons.Welcome.this,
							geniuz.pathbuttons.MainActivity.class);
					startActivity(intent);
					finish();
				}
			});
			builder.create().show();
		}
	}
}
