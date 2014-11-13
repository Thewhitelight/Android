package com.szq;

import java.io.IOException;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.DefaultClientConnection;
import org.apache.http.util.EntityUtils;

import com.example.httpclient.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.widget.TextView;

public class HttpClientGet extends Activity {
	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.http);
		tv = (TextView) findViewById(R.id.tv);
		String httpUrl = "http://10.64.130.101:8080/JspDemo/GetFile.jsp?par=ShiZhiQiang";
		HttpGet httpRequest = new HttpGet(httpUrl);// httpget连接对象
		try {
			HttpClient httpClient = new DefaultHttpClient();// 获取httclient对象
			HttpResponse httpResponse = httpClient.execute(httpRequest);
			// 请求成功
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				String strResult = EntityUtils.toString(httpResponse
						.getEntity());
				tv.setText(strResult);
			} else {
				tv.setText("请求错误");
			}
		} catch (ClientProtocolException e) {
			tv.setText(e.getMessage().toString());
		} catch (IOException e) {
			// TODO: handle exception
			tv.setText(e.getMessage().toString());
		} catch (Exception e) {
			// TODO: handle exception
			tv.setText(e.getMessage().toString());
		}
	}
}
