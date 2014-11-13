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
		// 开启线程
		new Thread(mRunnable).start();
	}

	// 刷新网页显示
	private void refresh() {
		String httpUrl = "http://10.64.130.101:8080/JspDemo/NewFile.jsp";
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
	}

	private Runnable mRunnable = new Runnable() {
		public void run() {
			while (true) {
				try {
					 Thread.sleep(100);//每隔100毫秒更新一次时间
					// 发送消息
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
			// 刷新
			refresh();
		}
	};
}
