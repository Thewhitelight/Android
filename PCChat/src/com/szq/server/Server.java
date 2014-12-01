package com.szq.server;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Server extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	// ���ò��ַ�ʽ
	BorderLayout bLayout1 = new BorderLayout();
	BorderLayout bLayout2 = new BorderLayout();
	// �������
	JPanel jPanel1 = new JPanel();
	JPanel jPanel2 = new JPanel();
	// ������ť
	JButton jButton_start = new JButton();
	JButton jButton_end = new JButton();
	JScrollPane jScrollPane = new JScrollPane();// ������������
	static JTextArea jTextArea = new JTextArea();// ������̬�ı���
	boolean bool = false, start = false;
	// ����ServerThread�߳������
	ServerThead serverThead;
	Thread thread;
	//��ʼ��
	public Server() {
		// TODO Auto-generated constructor stub
		super("Server");
		getContentPane().setLayout(bLayout1);// ������岼�ַ�ʽ
		jButton_start.setText("����������");
		jButton_start.addActionListener(this);
		jButton_end.setText("�رշ�����");
		jButton_end.addActionListener(this);
		this.getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);// ��ʼ����岢��ӿؼ�
		jPanel1.add(jButton_start);
		jPanel1.add(jButton_end);
		jTextArea.setText("");
		jPanel2.setLayout(bLayout2);
		jPanel2.add(jScrollPane, java.awt.BorderLayout.CENTER);
		jScrollPane.getViewport().add(jTextArea);
		this.getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);
		this.setSize(500, 500);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		Server server = new Server();
		server.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// ��д��ť�¼�
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jButton_start) {
			serverThead = new ServerThead();
			serverThead.start();
		} else if (e.getSource() == jButton_end) {
			bool = false;
			start = false;
			serverThead.finalize();
			this.setVisible(false);
		}
	}

}
