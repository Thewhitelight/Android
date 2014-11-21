package com.szq.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientThread extends Thread {
	Socket clientSocket;// �������������accept�����õ��Ŀͻ�������
	// �����������˴�����Socket��������������
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
			System.out.println("�����쳣����" + e);
			System.out.println("����I/Oͨ��ʧ�ܣ�");
			System.exit(1);
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// super.run();
		while (true) {
			try {
				String message = in.readUTF();// ��ȡ�ͻ��˷���������Ϣ
				synchronized (serverThead.messages) {
					if (message != null) {
						serverThead.messages.addElement(message);// ������������Ϣ�����message������
						Server.jTextArea.append(message + "\n");
						int length = Server.jTextArea.getText().length();// jTextArea�Զ����Ϲ���
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
