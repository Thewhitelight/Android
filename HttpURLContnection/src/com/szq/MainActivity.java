package com.szq;

import com.example.httpactvity.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button btn_content;
	private Button btn_getcontent;
	private Button btn_httpcontent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainactivity);
		btn_content = (Button) findViewById(R.id.btn_content);
		btn_getcontent = (Button) findViewById(R.id.btn_getcontent);
		btn_httpcontent = (Button) findViewById(R.id.btn_httpcontent);
		btn_content.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent();
				i.setClass(getApplicationContext(), DirectContent.class);
				startActivity(i);
				MainActivity.this.finish();
			}
		});
		btn_getcontent.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent();
				i.setClass(getApplicationContext(), GetContent.class);
				startActivity(i);
				MainActivity.this.finish();
			}
		});
		btn_httpcontent.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent();
				i.setClass(getApplicationContext(), PostContent.class);
				startActivity(i);
				MainActivity.this.finish();
			}
		});
	}
}
