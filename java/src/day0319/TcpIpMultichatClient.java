package day0319;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TcpIpMultichatClient {
	public static void main(String args[]) {
		if(args.length!=1) {
			System.out.println("USAGE: java TcpIpMultichatClient 대화명");
			System.exit(0);
		}

		try {
			String serverIp = "192.168.0.11"; // 연결할 서버 ip
            // 소켓을 생성하여 연결을 요청한다.
			Socket socket = new Socket(serverIp, 7788); // 서버 ip와 사용할 port로 서버-클라이언트 연결
			System.out.println("서버에 연결되었습니다.");

			// 두가지가 동시에 실행되어야 하므로보내는것과 받는것 각각 Thread 생성.
			// 두 객체는 아래에서 thread 를 상속받은 클래스를 작성한 것으로 만들어졌음.
			Thread sender = new Thread(new ClientSender(socket, args[0]));
			// 생성자는 ClientSender(Socket socket, String name)로 args[0]이 대화명이 된다.
			Thread receiver = new Thread(new ClientReceiver(socket));

			sender.start(); // 보내기 위한 thread 실행
			receiver.start(); // 받는 thread 실행
		} catch(ConnectException ce) {
			ce.printStackTrace();
		} catch(Exception e) {}
	} // main

	static class ClientSender extends Thread {
		Socket socket;
		DataOutputStream out;
		String name;

		ClientSender(Socket socket, String name) {
			this.socket = socket;
			try {
				out = new DataOutputStream(socket.getOutputStream());
				// 데이터 전송에 사용될 객체 생성
				this.name = name;
			} catch(Exception e) {}
		}

		public void run() { // Thread 상속받은 메서드 오버라이드
			Scanner scanner = new Scanner(System.in);
			try {
				// 위에서 ClientSender 생성자로 socket, out, name 대입하는데
				// 생성자를 통해 객체 생성이 정상적으로 되었으면 서버에 name 1번 보낸다.
				if(out!=null) { 
					out.writeUTF(name);
				}	

				// 이후 while 문을 통해서 입력이 있을때마다 보낸다.
				while(out!=null) {
					out.writeUTF("["+name+"]"+scanner.nextLine());		
				}
			} catch(IOException e) {}
		} // run()
	}

	static class ClientReceiver extends Thread {
		Socket socket;
		DataInputStream in;

		ClientReceiver(Socket socket) {
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
				// 서버에서 보내는 데이터(메시지) 받음
			} catch(IOException e) {}
		}

		public void run() { // Thread 상속받은 메서드 오버라이드
			while(in!=null) {
				try {
					System.out.println(in.readUTF());
					// 서버에서 보낸 메시지 출력
				} catch(IOException e) {}
			}
		} // run
	}
} // class