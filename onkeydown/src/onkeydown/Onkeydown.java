package onkeydown;

import java.util.Calendar;
import java.util.TimeZone;

import com.example.onkeydown.R;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Onkeydown extends Activity {
	private TextView tv = null;
	private TextView tv2 = null;
	private String mWay = null;
	private String mWay1 = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity);
		final Calendar c = Calendar.getInstance();
		//c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));

		final EditText name = (EditText) findViewById(R.id.username);
		final EditText key = (EditText) findViewById(R.id.userkey);
		Button btn1 = (Button) findViewById(R.id.button1);
		Button btn2 = (Button) findViewById(R.id.button2);
		tv = (TextView) findViewById(R.id.time);
		tv2=(TextView) findViewById(R.id.time2);
		mWay = String.valueOf(c.get(Calendar.DAY_OF_WEEK));
		mWay1=String.valueOf((c.get(Calendar.DAY_OF_WEEK)+1)%7);
		if ("1".equals(mWay)) {
			mWay = "天";
		} else if ("2".equals(mWay)) {
			mWay = "一";
		} else if ("3".equals(mWay)) {
			mWay = "二";
		} else if ("4".equals(mWay)) {
			mWay = "三";
		} else if ("5".equals(mWay)) {
			mWay = "四";
		} else if ("6".equals(mWay)) {
			mWay = "五";
		} else if ("7".equals(mWay)) {
			mWay = "六";
		}
		if ("1".equals(mWay1)) {
			mWay1 = "天";
		} else if ("2".equals(mWay1)) {
			mWay1 = "一";
		} else if ("3".equals(mWay1)) {
			mWay1 = "二";
		} else if ("4".equals(mWay1)) {
			mWay1 = "三";
		} else if ("5".equals(mWay1)) {
			mWay1 = "四";
		} else if ("6".equals(mWay1)) {
			mWay1 = "五";
		} else if ("7".equals(mWay1)) {
			mWay1 = "六";
		}
		tv.setText("星期"+mWay);
		if ("0".equals(mWay1)) {
			mWay1 = "六";
		}
		tv2.setText("星期"+mWay1);
		btn1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				ComponentName componentName = new ComponentName(
						onkeydown.Onkeydown.this, "onkeydown.activity01");
				Intent intent = new Intent();
				// intent.setAction(MY_ACTION);
				intent.setClassName(onkeydown.Onkeydown.this,
						"onkeydown.activity01");
				intent.putExtra("name", name.getText().toString());
				intent.putExtra("key", key.getText().toString());
				startActivity(intent);
			}
		});
		btn2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				finish();
			}
		});
	}
}