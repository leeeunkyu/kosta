package com.kosta.j0817;

import java.io.IOException;
import java.net.ServerSocket;

public class EchoServer {
	public static void main(String[] args) throws IOException {
		ServerSocket ss =new ServerSocket(5000);
		System.out.println("����");
		ss.accept();
		System.out.println("����");
	}
}
