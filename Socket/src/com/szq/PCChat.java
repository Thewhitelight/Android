package com.szq;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class PCChat {
	public static void main(String[] args) {
		try {
			Socket socket=new Socket("127.0.0.1",8089);
			PrintWriter out=new PrintWriter(socket.getOutputStream());
			BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedReader sin=new BufferedReader(new InputStreamReader(System.in));
			String str=null;
			while(str!=null){
				str=sin.readLine();
				out.println(str);
				out.flush();
				if (str!=null) {
					System.out.println("@server response"+in.readLine());
				}else {
					System.out.println("The connection is closing");
				}
			}
			in.close();
			sin.close();
			socket.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error"+e);
		}
	}
}
