package com.szq.client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.szq.server.Server;

public class PCClient extends JFrame implements Runnable, ActionListener {
	private static final long serialVersionUID = 1L;
	public static final int PORT = 8089;

	BorderLayout bordeLayout1 = new BorderLayout();
	BorderLayout bordeLayout2 = new BorderLayout();
	JPanel jPanel1 = new JPanel();
	JPanel jPanel2 = new JPanel();
	JPanel jPanel3 = new JPanel();
	static JTextArea jTextArea1 = new JTextArea();
	JScrollPane jScrollPane = new JScrollPane();

	JLabel jLable_username = new JLabel();
	JTextField JTextField_username = new JTextField(7);
	JButton JButton_login = new JButton();
	JButton JButton_leave = new JButton();

	JLabel JLabel_address = new JLabel();
	JTextField jTextField_address = new JTextField();
	JTextField jTextField_info = new JTextField(40);
	JButton JButton_send = new JButton();

	Socket socket;
	Thread thread;
	DataInputStream in;
	DataOutputStream out;
	boolean flag = false;
	String name, chat_txt, chat_in;
	String ip = null;

	// 初始化PC客户端界面
	public PCClient() {
		super("PCClient");

		jLable_username.setText("昵称");
		JTextField_username.setText("V");
		JButton_login.setText("进入聊天室");
		JButton_leave.setText("退出聊天室");
		jTextArea1.setText("");
		JLabel_address.setText("服务器地址");
		jTextField_address.setText("10.64.130.101");
		jTextField_info.setText("发送的内容");
		JButton_send.setText("发送");

		getContentPane().setLayout(bordeLayout1);
		this.getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);
		jPanel1.add(jLable_username);
		jPanel1.add(JTextField_username);
		jPanel1.add(JButton_login);
		jPanel1.add(JButton_leave);
		jPanel1.add(JLabel_address);
		jPanel1.add(jTextField_address);

		jPanel2.add(jTextField_info);
		jPanel2.add(JButton_send);
		jPanel3.setLayout(bordeLayout2);
		jPanel3.add(jScrollPane, java.awt.BorderLayout.CENTER);
		jScrollPane.getViewport().add(jTextArea1);
		this.getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);
		this.getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);
		JButton_login.addActionListener(this);
		JButton_leave.addActionListener(this);
		JButton_send.addActionListener(this);

		this.setSize(700, 700);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		PCClient client = new PCClient();
		client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == JButton_login) {
			name = JTextField_username.getText();
			ip = jTextField_address.getText();
			if (name != "V" && ip != null) {
				try {
					socket = new Socket(ip, PORT);
					in = new DataInputStream(socket.getInputStream());
					out = new DataOutputStream(socket.getOutputStream());
					Date now = new Date(System.currentTimeMillis());
					SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
					String nowStr = format.format(now);
					out.writeUTF("$_$" + name + " " + nowStr + "上线了");
				} catch (Exception e1) {
					System.out.println("can not connect" + e1.toString());
				}
				thread = new Thread(this);
				thread.start();
				flag = true;
			}
		} else if (e.getSource() == JButton_send) {
			chat_txt = jTextField_info.getText();
			if (chat_txt != null) {
				Date now = new Date(System.currentTimeMillis());
				SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
				String nowStr = format.format(now);
				try {
					out.writeUTF("^_^" + JTextField_username.getText() + " "
							+ nowStr + "说\n" + chat_txt);
					jTextField_info.setText(null);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			} else {
				try {
					out.writeUTF("请说话");
				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}
		} else if (e.getSource() == JButton_leave) {
			if (flag == true) {
				try {
					out.writeUTF("#_#" + name + "下线了！");
					out.close();
					in.close();
					socket.close();
				} catch (Exception e4) {
					e4.printStackTrace();
				}
			}
			flag = false;
			this.setVisible(false);
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				chat_in = in.readUTF();
				jTextArea1.append(chat_in + "\n\n");
				int length = jTextArea1.getText().length();// jTextArea1自动向上滚动
				jTextArea1.setCaretPosition(length);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
