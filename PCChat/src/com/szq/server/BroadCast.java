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
				Thread.sleep(100);// 每隔100毫秒，向所有客户端发送messages数组中未发送的消息
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			// 同步化serveThread.messages
			synchronized (serverThread.messages) {
				// 判断是否有未发送的消息
				if (serverThread.messages.isEmpty()) {
					continue;
				}
				str = (String) this.serverThread.messages.firstElement();// 获取服务器端需要发送的第一条消息
			}
			// 同步化serveThread.clients
			synchronized (serverThread.clients) {

				// 获取服务器端存贮的所有建立的与客户端的连接
				for (int i = 0; i < serverThread.clients.size(); i++) {
					clientThread = (ClientThread) serverThread.clients
							.elementAt(i);
					try {
						clientThread.out.writeUTF(str);// 向记录的每一个客户端发送消息
					} catch (IOException e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
				}
				this.serverThread.messages.removeElement(str);// 从messages数组中删除已经发送的消息
			}

		}
	}
}
