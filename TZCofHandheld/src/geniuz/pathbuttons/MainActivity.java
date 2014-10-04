package geniuz.pathbuttons;

import com.tencent.android.tpush.XGPushManager;

import geniuz.myPathbutton.composerLayout;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends Activity {
	private long firstime = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);// ��������û���ˡ�
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		XGPushManager.registerPush(getApplicationContext());
		overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);//���뵭��Ч��
		// ���ÿؼ�
		composerLayout clayout = (composerLayout) findViewById(R.id.test);
		clayout.init(new int[] { R.drawable.composer_with, R.drawable.message,R.drawable.thebus,
				R.drawable.schedule, R.drawable.food, R.drawable.weather,
				R.drawable.composer_place, }, R.drawable.composer_button,
				R.drawable.composer_icn_plus, composerLayout.LEFTBOTTOM, 300,
				300);
		// �ӂ��c���O ��100+0����composer_camera��100+1����composer_music�������������Ў׶������o�ͼӎ׶�����
		OnClickListener clickit = new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (v.getId() == 100 + 0) {
					Intent intent = new Intent();
					intent.setClassName("geniuz.pathbuttons",
							"geniuz.pathbuttons.AboutUs");// �򿪹�������
					startActivity(intent);
				} else if (v.getId() == 100 + 1) {
					Intent intent = new Intent();
					intent.setClassName("geniuz.pathbuttons",
							"com.qq.xgdemo.MainActivity");// ��֪ͨ
					startActivity(intent);
				} else if (v.getId() == 100 + 2) {
					Intent intent = new Intent();
					intent.setClassName("geniuz.pathbuttons",
							"geniuz.pathbuttons.BusListView");// �򿪹���
					startActivity(intent);
				} else if (v.getId() == 100 + 3) {
					Intent intent = new Intent();
					intent.setClassName("geniuz.pathbuttons",
							"com.tzc.course.Course_List");// �򿪿α�
					startActivity(intent);
				} else if (v.getId() == 100 + 4) {
					Intent intent = new Intent();
					intent.setClassName("geniuz.pathbuttons",
							"geniuz.pathbuttons.ResterauntListView");// ������
					startActivity(intent);
				} else if (v.getId() == 100 + 5) {
					Intent intent = new Intent();
					intent.setClassName("geniuz.pathbuttons",
							"geniuz.pathbuttons.WeatherMain");// ������Ԥ��
					startActivity(intent);
				} else if (v.getId() == 100 + 6) {

					Intent intent = new Intent();
					intent.setClassName("geniuz.pathbuttons",
							"geniuz.pathbuttons.TzcMap");// �򿪰ٶȵ�ͼ�Ľ���
					startActivity(intent);
				}
			}
		};
		clayout.setButtonsOnClickListener(clickit);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {// ��дback��
		// TODO �Զ����ɵķ������
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			long secondtime = System.currentTimeMillis();
			if (secondtime - firstime > 3000) { // �������3�� ����toast��ʾ
				Toast toast = Toast.makeText(MainActivity.this, "�ٰ�һ���˳�����̨Ժ",
						Toast.LENGTH_SHORT);
				firstime = System.currentTimeMillis();
				toast.setGravity(Gravity.CENTER, 0, 0);// ����toast��ʾλ��
				toast.show();

				return true;
			} else { // ���С��3���˳�����
				finish();
				System.exit(0);
			}
		}
		return super.onKeyDown(keyCode, event);
	}
}
