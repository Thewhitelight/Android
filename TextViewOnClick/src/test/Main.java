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
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mian);
		tv = (TextView) findViewById(R.id.tv01);
		Intent intent1 = Main.this.getIntent();
		coursename = intent1.getStringExtra("coursename");
		coursetime = intent1.getStringExtra("coursetime");
		coursesite = intent1.getStringExtra("coursesite");
		tv.setText("�γ�����:"+coursename+"\n"+"�Ͽ�ʱ��:"+coursetime+"\n"+"�Ͽεص�:"+coursesite);
		/*tv.append("�γ�����:"+coursename+"\n");
		tv.append("�Ͽ�ʱ��:"+coursetime+"\n");
		tv.append("�Ͽεص�:"+coursesite+"\n");*/
		tv.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				Intent intent = new Intent();
				intent.setClassName(getApplicationContext(), "test.Activity01");
				startActivity(intent);
			}
		});


	}
}
