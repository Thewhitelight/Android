package test;

import com.example.course.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Course extends Activity {
	private TextView tv = null;
	private String coursename = null;
	private String coursetime = null;
	private String coursesite = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		setContentView(R.layout.course);
		tv = (TextView) findViewById(R.id.tv1);
		long list_id = getIntent().getLongExtra("list_id", 0);
		if (list_id == 0) {
			Intent intent1 = Course.this.getIntent();
			coursename = intent1.getStringExtra("coursename");
			coursetime = intent1.getStringExtra("coursetime");
			coursesite = intent1.getStringExtra("coursesite");
			if (savedInstanceState != null) {
				String saveString = savedInstanceState.getString("tv");
				tv.setText(saveString);
			}
			tv.setText("�γ�����" + coursename + "\n" + "�Ͽ�ʱ��" + coursetime + "\n"
					+ "�Ͽεص�" + coursesite);
			tv.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO �Զ����ɵķ������
					Intent i = new Intent();
					i.setClass(getApplicationContext(), EditCourse.class);
					startActivity(i);
				}
			});

		}
	}

	@Override
	protected void onResume() {
		// TODO �Զ����ɵķ������
		String saveString = this.getSharedPreferences("save", MODE_PRIVATE)
				.getString("tv", null);

		super.onResume();
	}

	@Override
	protected void onPause() {
		// TODO �Զ����ɵķ������
		super.onPause();
		String saveString = tv.getText().toString();
		SharedPreferences sp = this.getSharedPreferences("save", MODE_PRIVATE);
		sp.edit().putString("tv", saveString).commit();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO �Զ����ɵķ������
		String saveString = tv.getText().toString();
		outState.putString("tv", saveString);
		super.onSaveInstanceState(outState);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO �Զ����ɵķ������

		Intent ii = new Intent();
		ii.setClass(getApplicationContext(), ListView_Course.class);
		startActivity(ii);

		//finish();
		return super.onKeyDown(keyCode, event);
	}

}
