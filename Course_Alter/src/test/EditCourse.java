package test;

import com.example.course.R;

import android.R.integer;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditCourse extends Activity {
	private EditText coursename = null;
	private EditText coursetime = null;
	private EditText coursesite = null;
	private Button btn_ok = null;
	private SharedPreferences share;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.editcourse);
		coursename=(EditText) findViewById(R.id.coursename);
		coursetime=(EditText) findViewById(R.id.coursetime);
		coursesite=(EditText) findViewById(R.id.coursesite);
		btn_ok=(Button) findViewById(R.id.ok);
		btn_ok.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
			/*	ComponentName com=new ComponentName(getApplicationContext(), Course.class);*/
				Intent intent=new Intent();
				intent.setClass(getApplicationContext(), Course.class);
				intent.putExtra("coursename", coursename.getText().toString());
				intent.putExtra("coursetime", coursetime.getText().toString());
				intent.putExtra("coursesite", coursesite.getText().toString());
				startActivity(intent);
			}
		});
	}
}
