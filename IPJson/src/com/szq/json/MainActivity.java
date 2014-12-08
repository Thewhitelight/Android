package com.szq.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;

import com.example.ipjson.R;

import android.R.integer;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	private Button btn_get;
	private TextView tv_json;
	private static final String http = "http://ip.taobao.com/service/getIpInfo.php?ip=122.226.131.131";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		btn_get = (Button) findViewById(R.id.button1);
		tv_json = (TextView) findViewById(R.id.textView1);
		btn_get.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				getJson();
			}
		});
	}

	private void getJson() {
		// TODO Auto-generated method stub
		new AsyncTask<String, integer, String>() {

			@Override
			protected String doInBackground(String... params) {
				// TODO Auto-generated method stub
				try {
					URL url = new URL(params[0]);
					URLConnection urlcon = url.openConnection();
					InputStream is = urlcon.getInputStream();
					InputStreamReader in = new InputStreamReader(is, "utf-8");
					BufferedReader buffer = new BufferedReader(in);
					String str = null;
					while ((str = buffer.readLine()) != null) {
						return str;
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

			@Override
			protected void onPostExecute(String result) { // 更新前台UI
				super.onPostExecute(result);
				try {
					JSONObject json = new JSONObject(result);
					JSONObject str = json.getJSONObject("data");
					String country = str.getString("country");
					String area = str.getString("area");
					String region = str.getString("region");
					String city = str.getString("city");
					String county = str.getString("county");
					String isp = str.getString("isp");
					String ip = str.getString("ip");
					tv_json.setText(country + "\n" + area + "\n" + region
							+ "\n" + city + "\n" + county + "\n" + isp + "\n"
							+ ip);
				} catch (Exception e) {
					// TODO: handle exception
				}

			};
		}.execute(http);
	}
}
