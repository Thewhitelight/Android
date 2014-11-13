package com.szq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.example.httpactvity.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DirectContent extends Activity {
	private final String TAG = "DirectContent";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.content);
		TextView mTextView = (TextView) this.findViewById(R.id.tv_conent);
		// http��ַ
		String httpUrl = "http://10.64.130.101:8080/JspDemo/NewFile.jsp";
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
				intent.setClass(DirectContent.this, MainActivity.class);
				startActivity(intent);
				DirectContent.this.finish();
			}
		});
	}
}
