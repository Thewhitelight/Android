package com.szq;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.example.threaddownloaded.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ThreadDownloaded extends Activity {

	private ProgressBar pb1 = null;
	private TextView tv1 = null;
	private ProgressBar pb2 = null;
	private TextView tv2 = null;

	private String root = Environment.getExternalStorageDirectory()
			.getAbsolutePath() + File.separator;
	private String downloadFile = "http://www.sohu.com";
	private String downloadFile1 = "http://www.baidu.com";

	// �����Ѿ������ĳ��ȱ���
	private int hasRead = 0;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.threaddownloaded_layout);

		pb1 = (ProgressBar) findViewById(R.id.prb_one);
		tv1 = (TextView) findViewById(R.id.tv_one);

		pb2 = (ProgressBar) findViewById(R.id.prb_two);
		tv2 = (TextView) findViewById(R.id.tv_two);

		download(downloadFile, root, pb1, tv1);

		download(downloadFile1, root, pb2, tv2);
	}

	private void download(String url, String targetPath, ProgressBar pb,
			TextView tv) {
		DownloadThread dt = new DownloadThread(url, targetPath, pb, tv);

		dt.start();
	}

	// �Զ���һ��Handler�࣬�����߳���Ϣ
	public class MyHandler extends Handler {
		private ProgressBar progressBar;
		private TextView textView;

		// ͨ�����캯����ȷ�����ĸ�ProgressBarˢ��
		public MyHandler(ProgressBar progressBar, TextView textView) {
			this.progressBar = progressBar;
			this.textView = textView;
		}

		public void handleMessage(Message msg) {
			this.progressBar.setProgress(msg.arg1);
			this.textView.setText(msg.arg1 + "%");

			super.handleMessage(msg);
		}
	}

	// �����߳�
	public class DownloadThread extends Thread {
		private String url = "";
		private String targetPath = "";

		// private int hasDownload = 0;

		private int len = -1;
		private byte buffer[] = new byte[4 * 1024];
		private int size = 0;
		private int rate = 0;

		private MyHandler myHandler = null;
		private Message msg = null;

		private ProgressBar pb = null;
		private TextView tv = null;

		public DownloadThread(String url, String targetPath, ProgressBar pb,
				TextView tv) {
			this.url = url;
			this.targetPath = targetPath;

			this.pb = pb;
			this.tv = tv;

			myHandler = new MyHandler(this.pb, this.tv);
		}

		public void run() {
			String targetFileName = this.targetPath
					+ this.url.substring(this.url.lastIndexOf("/") + 1,
							this.url.length());
			File downloadFile = new File(targetFileName);

			if (!downloadFile.exists()) {
				try {
					downloadFile.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			try {
				URL fileUrl = new URL(this.url);
				HttpURLConnection conn = (HttpURLConnection) fileUrl
						.openConnection();

				// ��ȡ�ļ���С
				size = conn.getContentLength();

				InputStream is = conn.getInputStream();

				OutputStream os = new FileOutputStream(targetFileName);

				while ((len = is.read(buffer)) != -1) {
					os.write(buffer);

					hasRead += len;

					rate = (hasRead * 100 / size);

					msg = new Message();

					msg.arg1 = rate;

					myHandler.sendMessage(msg);

					System.out.println(rate + "%");
				}
				is.close();
				os.close();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}