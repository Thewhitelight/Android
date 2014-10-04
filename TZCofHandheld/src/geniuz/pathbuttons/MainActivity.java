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
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 标题栏就没有了。
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		XGPushManager.registerPush(getApplicationContext());
		overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);//淡入淡出效果
		// 引用控件
		composerLayout clayout = (composerLayout) findViewById(R.id.test);
		clayout.init(new int[] { R.drawable.composer_with, R.drawable.message,R.drawable.thebus,
				R.drawable.schedule, R.drawable.food, R.drawable.weather,
				R.drawable.composer_place, }, R.drawable.composer_button,
				R.drawable.composer_icn_plus, composerLayout.LEFTBOTTOM, 300,
				300);
		// 加個點擊監聽，100+0對應composer_camera，100+1對應composer_music……如此類推你有幾多個按鈕就加幾多個。
		OnClickListener clickit = new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (v.getId() == 100 + 0) {
					Intent intent = new Intent();
					intent.setClassName("geniuz.pathbuttons",
							"geniuz.pathbuttons.AboutUs");// 打开关于我们
					startActivity(intent);
				} else if (v.getId() == 100 + 1) {
					Intent intent = new Intent();
					intent.setClassName("geniuz.pathbuttons",
							"com.qq.xgdemo.MainActivity");// 打开通知
					startActivity(intent);
				} else if (v.getId() == 100 + 2) {
					Intent intent = new Intent();
					intent.setClassName("geniuz.pathbuttons",
							"geniuz.pathbuttons.BusListView");// 打开公交
					startActivity(intent);
				} else if (v.getId() == 100 + 3) {
					Intent intent = new Intent();
					intent.setClassName("geniuz.pathbuttons",
							"com.tzc.course.Course_List");// 打开课表
					startActivity(intent);
				} else if (v.getId() == 100 + 4) {
					Intent intent = new Intent();
					intent.setClassName("geniuz.pathbuttons",
							"geniuz.pathbuttons.ResterauntListView");// 打开外卖
					startActivity(intent);
				} else if (v.getId() == 100 + 5) {
					Intent intent = new Intent();
					intent.setClassName("geniuz.pathbuttons",
							"geniuz.pathbuttons.WeatherMain");// 打开天气预报
					startActivity(intent);
				} else if (v.getId() == 100 + 6) {

					Intent intent = new Intent();
					intent.setClassName("geniuz.pathbuttons",
							"geniuz.pathbuttons.TzcMap");// 打开百度地图的界面
					startActivity(intent);
				}
			}
		};
		clayout.setButtonsOnClickListener(clickit);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {// 重写back键
		// TODO 自动生成的方法存根
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			long secondtime = System.currentTimeMillis();
			if (secondtime - firstime > 3000) { // 如果大于3秒 弹出toast提示
				Toast toast = Toast.makeText(MainActivity.this, "再按一次退出掌上台院",
						Toast.LENGTH_SHORT);
				firstime = System.currentTimeMillis();
				toast.setGravity(Gravity.CENTER, 0, 0);// 设置toast显示位置
				toast.show();

				return true;
			} else { // 如果小于3秒退出程序
				finish();
				System.exit(0);
			}
		}
		return super.onKeyDown(keyCode, event);
	}
}
