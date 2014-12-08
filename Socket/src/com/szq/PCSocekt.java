package com.szq;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class PCSocekt {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(8089);
			Socket socket = serverSocket.accept();
			BufferedReader buffer = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			BufferedReader sin = new BufferedReader(new InputStreamReader(
					System.in));
			String str = null;
			while ((str = buffer.readLine()) != null) {
				System.out.println("$_$" + str);
				out.println(sin.readLine());
				out.flush();
			}
			System.out.println("The connection is closing");
			buffer.close();
			out.close();
			socket.close();
			serverSocket.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error" + e);
		}
	}
}
