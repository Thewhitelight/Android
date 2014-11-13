package com.szq;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import com.example.httpactvity.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PostContent extends Activity {
	private final String TAG = "DirectContent";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.content);
		TextView mTextView = (TextView) this.findViewById(R.id.tv_conent);
		// http地址
		String httpUrl = "http://10.64.130.101:8080/JspDemo/PostFile.jsp";
		// 获得的数据
		String resultData = "";
		URL url = null;
		try {
			// 构造一个URL对象
			url = new URL(httpUrl);
		} catch (MalformedURLException e) {
			Log.e(TAG, "MalformedURLException");
		}
		if (url != null) {
			try {
				// 使用HttpURLConnection打开连接
				HttpURLConnection urlConn = (HttpURLConnection) url
						.openConnection();
				// post请求，所以设置为true
				urlConn.setDoOutput(true);
				urlConn.setDoInput(true);
				urlConn.setRequestMethod("POST");// urlconnection默认为get方式，所以在这里将请求方式设置为post
				urlConn.setUseCaches(false);// post请求不使用缓存
				urlConn.setInstanceFollowRedirects(true);
				// 配置本次连接的content-type,配置为application/w-form-urlencoded
				urlConn.setRequestProperty("Content-Type",
						"application/x-www-form-urlencoded");
				urlConn.connect();
				DataOutputStream out = new DataOutputStream(
						urlConn.getOutputStream());
				String content = "par="
						+ URLEncoder.encode("ABCDEFG", "gb2312");// 要上传的参数
				out.writeBytes(content);// 将要上传的内容写入流中
				out.flush();// 刷新
				out.close();
				// 得到读取的内容(流)
				InputStreamReader in = new InputStreamReader(
						urlConn.getInputStream());
				// 为输出创建BufferedReader
				BufferedReader buffer = new BufferedReader(in);
				String inputLine = null;
				// 使用循环来读取获得的数据
				while (((inputLine = buffer.readLine()) != null)) {
					// 我们在每一行后面加上一个"\n"来换行
					resultData += inputLine + "\n";
				}
				// 关闭InputStreamReader
				in.close();
				// 关闭http连接
				urlConn.disconnect();
				// 设置显示取得的内容
				if (resultData != null) {
					mTextView.setText(resultData);
				} else {
					mTextView.setText("读取的内容为NULL");
				}
			} catch (IOException e) {
				Log.e(TAG, "IOException");
			}
		} else {
			Log.e(TAG, "Url NULL");
		}
		Button button_Back = (Button) findViewById(R.id.btn_back);
		button_Back.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(PostContent.this, MainActivity.class);
				startActivity(intent);
				PostContent.this.finish();
			}
		});
	}
}
