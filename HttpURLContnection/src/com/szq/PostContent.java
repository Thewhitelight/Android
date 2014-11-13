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
		// http��ַ
		String httpUrl = "http://10.64.130.101:8080/JspDemo/PostFile.jsp";
		// ��õ�����
		String resultData = "";
		URL url = null;
		try {
			// ����һ��URL����
			url = new URL(httpUrl);
		} catch (MalformedURLException e) {
			Log.e(TAG, "MalformedURLException");
		}
		if (url != null) {
			try {
				// ʹ��HttpURLConnection������
				HttpURLConnection urlConn = (HttpURLConnection) url
						.openConnection();
				// post������������Ϊtrue
				urlConn.setDoOutput(true);
				urlConn.setDoInput(true);
				urlConn.setRequestMethod("POST");// urlconnectionĬ��Ϊget��ʽ�����������ｫ����ʽ����Ϊpost
				urlConn.setUseCaches(false);// post����ʹ�û���
				urlConn.setInstanceFollowRedirects(true);
				// ���ñ������ӵ�content-type,����Ϊapplication/w-form-urlencoded
				urlConn.setRequestProperty("Content-Type",
						"application/x-www-form-urlencoded");
				urlConn.connect();
				DataOutputStream out = new DataOutputStream(
						urlConn.getOutputStream());
				String content = "par="
						+ URLEncoder.encode("ABCDEFG", "gb2312");// Ҫ�ϴ��Ĳ���
				out.writeBytes(content);// ��Ҫ�ϴ�������д������
				out.flush();// ˢ��
				out.close();
				// �õ���ȡ������(��)
				InputStreamReader in = new InputStreamReader(
						urlConn.getInputStream());
				// Ϊ�������BufferedReader
				BufferedReader buffer = new BufferedReader(in);
				String inputLine = null;
				// ʹ��ѭ������ȡ��õ�����
				while (((inputLine = buffer.readLine()) != null)) {
					// ������ÿһ�к������һ��"\n"������
					resultData += inputLine + "\n";
				}
				// �ر�InputStreamReader
				in.close();
				// �ر�http����
				urlConn.disconnect();
				// ������ʾȡ�õ�����
				if (resultData != null) {
					mTextView.setText(resultData);
				} else {
					mTextView.setText("��ȡ������ΪNULL");
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
