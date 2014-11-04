package test;

import com.example.textview.R;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity01 extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity01);
		final EditText coursename = (EditText) findViewById(R.id.coursename);
		final EditText coursetime = (EditText) findViewById(R.id.coursetime);
		final EditText coursesite = (EditText) findViewById(R.id.coursenamesite);
		final Button btn_ok = (Button) findViewById(R.id.Ok);
		btn_ok.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				ComponentName com = new ComponentName(getApplicationContext(),
						Main.class);
				Intent intent1 = new Intent();
				intent1.setClass(getApplicationContext(), Main.class);
				intent1.putExtra("coursename", coursename.getText().toString());
				intent1.putExtra("coursetime", coursetime.getText().toString());
				intent1.putExtra("coursesite", coursesite.getText().toString());
				startActivity(intent1);
			}
		});
	}
}
