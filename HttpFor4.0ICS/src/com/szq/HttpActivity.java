package com.szq;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.example.httpforICS.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class HttpActivity extends Activity {
	private TextView tv;
	private Button btn;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		tv = (TextView) this.findViewById(R.id.tv);
		btn = (Button) this.findViewById(R.id.btn);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Thread thread = new Thread(runnable);
				thread.start();// �����߳�
			}
		});

	}

	Handler handler = new Handler() {
		public void handleMessage(Message msg) { // ������д�˷��������ڽ�������
			super.handleMessage(msg);
			switch (msg.what) { // ����UI
			case 1:
				tv.setText(msg.getData().getString("result"));// ��ȡMessage��ֵ
				break;
			}

		}
	};
	Runnable runnable = new Runnable() {

		@Override
		public void run() {// �����������
			// TODO Auto-generated method stub
			String httpUrl = "http://www.baidu.com";
			URL url = null;
			String result = "";
			try {
				url = new URL(httpUrl);
			} catch (Exception e) {
				// TODO: handle exception
				tv.setText(e.getMessage().toString());
			}
			if (url != null) {
				try {
					HttpURLConnection con = (HttpURLConnection) url
							.openConnection();
					InputStreamReader input = new InputStreamReader(
							con.getInputStream());
					BufferedReader buffer = new BufferedReader(input);
					String inputLine = null;
					while ((inputLine = buffer.readLine()) != null) {
						result += inputLine + "\n";
					}
					buffer.close();
					input.close();
					con.disconnect();
					if (result != null) {
						Message msg = new Message();// �½�Message����
						Bundle b = new Bundle();// ������
						msg.what = 1;// �Զ�����Ϣ���룬��ֹ������handler����
						b.putString("result", result);
						msg.setData(b);
						handler.sendMessage(msg);// ��Message����handler
					} else {
						tv.setText("��ȡ����Ϊ��");
					}
				} catch (Exception e) {
					// TODO: handle exception
					tv.setText(e.getMessage().toString());
				}
			} else {
				tv.setText("URLΪ��");
			}
		}
	};
}
