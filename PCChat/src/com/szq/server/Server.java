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
	// 设置布局方式
	BorderLayout bLayout1 = new BorderLayout();
	BorderLayout bLayout2 = new BorderLayout();
	// 创建面板
	JPanel jPanel1 = new JPanel();
	JPanel jPanel2 = new JPanel();
	// 创建按钮
	JButton jButton_start = new JButton();
	JButton jButton_end = new JButton();
	JScrollPane jScrollPane = new JScrollPane();// 创建滚动窗口
	static JTextArea jTextArea = new JTextArea();// 创建静态文本区
	boolean bool = false, start = false;
	// 声明ServerThread线程类对象
	ServerThead serverThead;
	Thread thread;
	//初始化
	public Server() {
		// TODO Auto-generated constructor stub
		super("Server");
		getContentPane().setLayout(bLayout1);// 设置面板布局方式
		jButton_start.setText("启动服务器");
		jButton_start.addActionListener(this);
		jButton_end.setText("关闭服务器");
		jButton_end.addActionListener(this);
		this.getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);// 初始化面板并添加控件
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

	// 重写按钮事件
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
