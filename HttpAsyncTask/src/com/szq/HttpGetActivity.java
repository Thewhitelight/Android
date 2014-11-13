package com.szq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.example.httpget.R;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class HttpGetActivity extends Activity {
	private Button btn_show;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		btn_show = (Button) findViewById(R.id.btn_show);
		btn_show.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new AsyncTask<String, Void, Void>() {

					@Override
					protected Void doInBackground(String... params) {
						// TODO Auto-generated method stub
						try {
							URL url = new URL(params[0]);
							URLConnection connection = url.openConnection();
							InputStream is = connection.getInputStream();
							InputStreamReader in = new InputStreamReader(is,
									"utf-8");
							BufferedReader buffer = new BufferedReader(in);
							String inputLine;
							while ((inputLine = buffer.readLine()) != null) {
								Log.i("***AsyncTask****", inputLine);
							}
							buffer.close();
							in.close();
							is.close();
						} catch (MalformedURLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return null;
					}

				}.execute("http://fanyi.youdao.com/openapi.do?keyfrom=testhttpclient&key=1320375195&type=data&doctype=json&version=1.1&q=good");
			}
		});
	}
}
