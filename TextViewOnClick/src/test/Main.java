package test;

import com.example.textview.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main extends Activity {
	private TextView tv = null;
	private String coursename="";
	private String coursetime="";
	private String coursesite="";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mian);
		tv = (TextView) findViewById(R.id.tv01);
		Intent intent1 = Main.this.getIntent();
		coursename = intent1.getStringExtra("coursename");
		coursetime = intent1.getStringExtra("coursetime");
		coursesite = intent1.getStringExtra("coursesite");
		tv.setText("课程名称:"+coursename+"\n"+"上课时间:"+coursetime+"\n"+"上课地点:"+coursesite);
		/*tv.append("课程名称:"+coursename+"\n");
		tv.append("上课时间:"+coursetime+"\n");
		tv.append("上课地点:"+coursesite+"\n");*/
		tv.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent();
				intent.setClassName(getApplicationContext(), "test.Activity01");
				startActivity(intent);
			}
		});


	}
}
