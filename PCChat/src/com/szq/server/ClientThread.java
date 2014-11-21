package com.szq.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientThread extends Thread {
	Socket clientSocket;// 保存服务器端用accept方法得到的客户端连接
	// 声明服务器端存贮的Socket对象的输入输出流
	DataInputStream in = null;
	DataOutputStream out = null;
	ServerThead serverThead;
	String str;

	public ClientThread(Socket clientSocket, ServerThead serverThead) {
		// TODO Auto-generated constructor stub
		this.serverThead = serverThead;
		this.clientSocket = clientSocket;
		try {
			in = new DataInputStream(clientSocket.getInputStream());
			out = new DataOutputStream(clientSocket.getOutputStream());
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("发生异常连接" + e);
			System.out.println("建立I/O通道失败！");
			System.exit(1);
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// super.run();
		while (true) {
			try {
				String message = in.readUTF();// 读取客户端发送来的消息
				synchronized (serverThead.messages) {
					if (message != null) {
						serverThead.messages.addElement(message);// 将发送来的消息存放在message数组中
						Server.jTextArea.append(message + "\n");
						int length = Server.jTextArea.getText().length();// jTextArea自动向上滚动
						Server.jTextArea.setCaretPosition(length);
					}
				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
