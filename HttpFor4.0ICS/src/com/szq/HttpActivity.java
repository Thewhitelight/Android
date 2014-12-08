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
				thread.start();// 开启线程
			}
		});

	}

	Handler handler = new Handler() {
		public void handleMessage(Message msg) { // 必须重写此方法，用于接收数据
			super.handleMessage(msg);
			switch (msg.what) { // 更新UI
			case 1:
				tv.setText(msg.getData().getString("result"));// 获取Message的值
				break;
			}

		}
	};
	Runnable runnable = new Runnable() {

		@Override
		public void run() {// 进行网络操作
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
						Message msg = new Message();// 新建Message对象
						Bundle b = new Bundle();// 绑定数据
						msg.what = 1;// 自定义消息代码，防止和其他handler混淆
						b.putString("result", result);
						msg.setData(b);
						handler.sendMessage(msg);// 将Message传给handler
					} else {
						tv.setText("读取内容为空");
					}
				} catch (Exception e) {
					// TODO: handle exception
					tv.setText(e.getMessage().toString());
				}
			} else {
				tv.setText("URL为空");
			}
		}
	};
}
