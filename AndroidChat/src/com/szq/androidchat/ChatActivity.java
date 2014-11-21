package com.szq.androidchat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.androidchat.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChatActivity extends Activity {
	private EditText edt_ip;
	private EditText edt_username;
	private Button btn_start;
	private Button btn_end;
	private EditText edt_list;
	private EditText edt_message;
	private Button btn_send;
	private String username, ip, chat_in, chat_txt;
	public static final int PORT = 8089;
	Socket socket;
	Thread thread;
	DataInputStream in;
	DataOutputStream out;
	boolean flag = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chat_layout);
		edt_ip = (EditText) findViewById(R.id.edt_ip);
		edt_username = (EditText) findViewById(R.id.edt_name);
		edt_list = (EditText) findViewById(R.id.edt_list);
		edt_message = (EditText) findViewById(R.id.edt_message);
		btn_start = (Button) findViewById(R.id.btn_start);
		btn_end = (Button) findViewById(R.id.btn_end);
		btn_send = (Button) findViewById(R.id.btn_send);
		// edt_list.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
		// edt_list.setGravity(Gravity.TOP);
		// edt_list.setSingleLine(false);
		btn_start.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (flag == true) {
					Toast.makeText(getApplicationContext(), "已经登陆过了",
							Toast.LENGTH_SHORT).show();
				}
				username = edt_username.getText().toString();
				ip = edt_ip.getText().toString();
				if (username != "" && username != null && ip != null
						&& username != "Android") {
					try {
						socket = new Socket(ip, PORT);
						in = new DataInputStream(socket.getInputStream());
						out = new DataOutputStream(socket.getOutputStream());
						Date nowtime = new Date(System.currentTimeMillis());
						SimpleDateFormat format = new SimpleDateFormat(
								"hh:mm:ss");
						String timeStr = format.format(nowtime);
						out.writeUTF("$_$" + username + "　" + timeStr + "上线了！");
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					thread = new Thread(runnable);
					thread.start();
					flag = true;
				}

			}

		});
		btn_end.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (flag == true) {
					if (flag == false) {
						Toast.makeText(getApplicationContext(), "没有登陆，请登录",
								Toast.LENGTH_SHORT).show();
						return;
					}
					try {
						out.writeUTF("=_=" + username + "下线了");
						out.close();
						in.close();
						socket.close();
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					flag = false;
					Toast.makeText(getApplicationContext(), "已退出",
							Toast.LENGTH_SHORT).show();
				}
			}
		});
		btn_send.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (flag == false) {
					Toast.makeText(getApplicationContext(), "没有登陆，请登陆",
							Toast.LENGTH_SHORT).show();
				}
				chat_txt = edt_message.getText().toString();
				edt_message.setText("");
				if (chat_txt != null) {
					Date nowtime = new Date(System.currentTimeMillis());
					SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
					String timeStr = format.format(nowtime);
					try {
						out.writeUTF("^_^" + username + " " + timeStr + "说\n"
								+ chat_txt);

					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			}
		});
	}

	Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			edt_list.append(msg.getData().getString("chat_in"));
			// edt_list.append(chat_in);
		}
	};

	Runnable runnable = new Runnable() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				try {
					chat_in = in.readUTF();
					chat_in = chat_in + "\n";
					Message msg = new Message();
					Bundle b = new Bundle();
					b.putString("chat_in", chat_in);
					msg.setData(b);
					handler.sendMessage(msg);
					// handler.sendMessage(handler.obtainMessage());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	};
}
