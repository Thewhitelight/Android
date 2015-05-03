package com.example.regularexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	private EditText edt;
	private Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		edt = (EditText) findViewById(R.id.editText1);
		btn = (Button) findViewById(R.id.button1);

		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				if (TextUtils.isEmpty(edt.getText().toString())) {
					Toast.makeText(getApplicationContext(), "输入不能为空",
							Toast.LENGTH_SHORT).show();
				} else {
					if (isEmail(edt.getText().toString()) == true) {
						Toast.makeText(getApplicationContext(), "邮箱格式正确",
								Toast.LENGTH_SHORT).show();
					}
					if (isEmail(edt.getText().toString()) == false) {
						Toast.makeText(getApplicationContext(), "邮箱格式不正确",
								Toast.LENGTH_SHORT).show();
					}

				}
			}
		});
	}

	public static boolean isEmail(String strEmail) {
		Pattern pattern = Pattern
				.compile("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$");
		Matcher matcher = pattern.matcher(strEmail);
		// System.out.println(matcher.matches());
		return matcher.matches();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
