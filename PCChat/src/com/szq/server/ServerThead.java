package com.szq.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Vector;

public class ServerThead extends Thread {
	ServerSocket serverSocket;// 声明ServerSocket类对象
	public static final int PORT = 8089;// 服务器监听端口号
	Vector<Object> messages;// 用于存储客户端发送的消息
	Vector<ClientThread> clients;// 用于存储客户端连接的ClientThread对象
	BroadCast broadCast;// 负责服务器端向客户端广播消息
	String ip;
	InetAddress myIPaddress = null;

	public ServerThead() {
		// TODO Auto-generated constructor stub
		clients = new Vector<ClientThread>();
		messages = new Vector<Object>();
		try {
			serverSocket = new ServerSocket(PORT);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// 获取本地服务器地址信息
		try {
			myIPaddress = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		ip = myIPaddress.getHostAddress();// 获取ip
		Server.jTextArea.append("服务器地址：" + ip + "        " + "端口号："
				+ String.valueOf(serverSocket.getLocalPort()) + "\n");
		broadCast = new BroadCast(this);// 创建广播信息并启动
		broadCast.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// super.run();
		while (true) {

			try {
				// 获取客户端连接，并创建一个新的Socket对象
				Socket socket = serverSocket.accept();
				System.out.println(socket.getInetAddress().getHostAddress());
				ClientThread clientThread = new ClientThread(socket, this);// 创建ClientThread并启动，监听对应的客户端发送的消息并获取
				clientThread.start();
				if (socket != null) {
					synchronized (clients) {
						clients.addElement(clientThread);// 将客户端连接加入到Vector数组保存
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("发生异常" + e);
				System.out.println("建立客户端联机失败！");
				System.exit(1);
			}
		}

	}

	@Override
	public void finalize() {
		// TODO Auto-generated method stub
		try {
			serverSocket.close();
		} catch (IOException e) {
			// TODO: handle exception
			serverSocket = null;
		}
	}
}
