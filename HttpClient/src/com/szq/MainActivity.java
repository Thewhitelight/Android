package com.szq;

import com.example.httpclient.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button btnGet;
	private Button btnPost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		btnGet = (Button) findViewById(R.id.button1);
		btnPost = (Button) findViewById(R.id.button2);
		btnGet.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent();
				i.setClass(getApplicationContext(), HttpClientGet.class);
				startActivity(i);
			}
		});
		btnPost.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent();
				i.setClass(getApplicationContext(), HttpClientPost.class);
				startActivity(i);
			}
		});
	}
}
