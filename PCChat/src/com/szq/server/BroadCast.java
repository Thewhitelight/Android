package com.szq.server;

import java.io.IOException;

public class BroadCast extends Thread {
	ClientThread clientThread;
	ServerThead serverThread;
	String str;

	public BroadCast(ServerThead serverThread) {
		// TODO Auto-generated constructor stub
		this.serverThread = serverThread;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// super.run();
		while (true) {
			try {
				Thread.sleep(100);// ÿ��100���룬�����пͻ��˷���messages������δ���͵���Ϣ
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			// ͬ����serveThread.messages
			synchronized (serverThread.messages) {
				// �ж��Ƿ���δ���͵���Ϣ
				if (serverThread.messages.isEmpty()) {
					continue;
				}
				str = (String) this.serverThread.messages.firstElement();// ��ȡ����������Ҫ���͵ĵ�һ����Ϣ
			}
			// ͬ����serveThread.clients
			synchronized (serverThread.clients) {

				// ��ȡ�������˴��������н�������ͻ��˵�����
				for (int i = 0; i < serverThread.clients.size(); i++) {
					clientThread = (ClientThread) serverThread.clients
							.elementAt(i);
					try {
						clientThread.out.writeUTF(str);// ���¼��ÿһ���ͻ��˷�����Ϣ
					} catch (IOException e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
				}
				this.serverThread.messages.removeElement(str);// ��messages������ɾ���Ѿ����͵���Ϣ
			}

		}
	}
}
