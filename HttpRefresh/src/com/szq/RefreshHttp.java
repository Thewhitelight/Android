package com.szq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.example.httprefresh.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RefreshHttp extends Activity {
	private final String TAG = "RefreshHttp";
	private TextView mTextView;
	private Button mButton;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		mTextView = (TextView) this.findViewById(R.id.tv);
		//mButton = (Button) this.findViewById(R.id.btn);
		//mButton.setOnClickListener(new Button.OnClickListener() {
		//	@Override
		//	public void onClick(View arg0) {
				// TODO Auto-generated method stub
				refresh();
		//	}
		//});
		// �����߳�
		new Thread(mRunnable).start();
	}

	// ˢ����ҳ��ʾ
	private void refresh() {
		String httpUrl = "http://10.64.130.101:8080/JspDemo/NewFile.jsp";
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
	}

	private Runnable mRunnable = new Runnable() {
		public void run() {
			while (true) {
				try {
					 Thread.sleep(100);//ÿ��100�������һ��ʱ��
					// ������Ϣ
					mHandler.sendMessage(mHandler.obtainMessage());

				} catch (Exception e) {
					// TODO Auto-generated catch block
					Log.e(TAG, "Exception");
				}
			}
		}
	};
	Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			// ˢ��
			refresh();
		}
	};
}
