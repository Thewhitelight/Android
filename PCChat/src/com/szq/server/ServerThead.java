package com.szq.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Vector;

public class ServerThead extends Thread {
	ServerSocket serverSocket;// ����ServerSocket�����
	public static final int PORT = 8089;// �����������˿ں�
	Vector<Object> messages;// ���ڴ洢�ͻ��˷��͵���Ϣ
	Vector<ClientThread> clients;// ���ڴ洢�ͻ������ӵ�ClientThread����
	BroadCast broadCast;// �������������ͻ��˹㲥��Ϣ
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
		// ��ȡ���ط�������ַ��Ϣ
		try {
			myIPaddress = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		ip = myIPaddress.getHostAddress();// ��ȡip
		Server.jTextArea.append("��������ַ��" + ip + "        " + "�˿ںţ�"
				+ String.valueOf(serverSocket.getLocalPort()) + "\n");
		broadCast = new BroadCast(this);// �����㲥��Ϣ������
		broadCast.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// super.run();
		while (true) {

			try {
				// ��ȡ�ͻ������ӣ�������һ���µ�Socket����
				Socket socket = serverSocket.accept();
				System.out.println(socket.getInetAddress().getHostAddress());
				ClientThread clientThread = new ClientThread(socket, this);// ����ClientThread��������������Ӧ�Ŀͻ��˷��͵���Ϣ����ȡ
				clientThread.start();
				if (socket != null) {
					synchronized (clients) {
						clients.addElement(clientThread);// ���ͻ������Ӽ��뵽Vector���鱣��
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("�����쳣" + e);
				System.out.println("�����ͻ�������ʧ�ܣ�");
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
