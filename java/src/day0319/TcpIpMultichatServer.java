package day0319;

import java.net.*;
import java.io.*;
import java.util.*;

public class TcpIpMultichatServer {
	HashMap clients;
	// HashMap K,V	K로 clients 의 이름, v 메시지 내용 사용 
	
	TcpIpMultichatServer() {
		clients = new HashMap();
		Collections.synchronizedMap(clients);	// 객체가 들어올 때마다 동기화
	}

	public void start() {
		ServerSocket serverSocket = null;
		Socket socket = null;

		try {
			serverSocket = new ServerSocket(7788); // client 들과 서버간의 socket 연결에 사용할 port 설정
			System.out.println("서버가 시작되었습니다.");

			while(true) {
				socket = serverSocket.accept(); // 클라이언트가 접속시 클라이언트 객체를 대입
				System.out.println("["+socket.getInetAddress() + ":"+socket.getPort()+"]"+"에서 접속하였습니다.");
				ServerReceiver thread = new ServerReceiver(socket); // 클라이언트를 매개변수로 쓰레드 객체 생성
				thread.start(); // 쓰레드 객체 실행
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	} // start()

	// 클라이언트가 보낸 메시지를 msg 매개변수로 받아서 연결된 모든 클라이언트에 보낸다
	void sendToAll(String msg) { 
		Iterator it = clients.keySet().iterator(); // key (클라이언트 이름)만 꺼내기 위한 반복자
		
		while(it.hasNext()) {
			try {
				DataOutputStream out = (DataOutputStream)clients.get(it.next());
				out.writeUTF(msg); // 메시지(대화내용) 전송
			} catch(IOException e){}
		} // while
	} // sendToAll

	public static void main(String args[]) {
//		new TcpIpMultichatServer().start();

		TcpIpMultichatServer t = new TcpIpMultichatServer();	// 자신의 객체 생성
		t.start();	// 서버 시작	
	} 

	class ServerReceiver extends Thread {
		Socket socket;
		DataInputStream in;
		DataOutputStream out;

		ServerReceiver(Socket socket) {
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream()); // 클라이언트에서 보내는 데이터(대화내용) 읽기 위한 객체
				out = new DataOutputStream(socket.getOutputStream()); // 받은 데이터를 클라이언트에게 보내개 위한 객체 
			} catch(IOException e) {}
		}

		public void run() {
			String name = "";
			try {
				name = in.readUTF(); // 클라이언트 접속시 대화명을 읽음
				sendToAll("#"+name+"님이 들어오셨습니다.");

				clients.put(name, out); // 대화명을 key 로 사용해서 저장
				System.out.println("현재 서버접속자 수는 " + clients.size() + "입니다."); // 접속자 수 출력
				while(in!=null) { // 읽어들인 데이터가 있다면 클라이언트에게 전송
					sendToAll(in.readUTF());
				}
			} catch(IOException e) {
				// ignore
			} finally {
				sendToAll("#"+name+"님이 나가셨습니다.");
				clients.remove(name); // 클라이언트가 나가면 메시지 전송 후 삭제
				System.out.println("["+socket.getInetAddress()+":"+socket.getPort()+"]"+"에서 접속을 종료하였습니다.");
				System.out.println("현재 서버접속자 수는 "+ clients.size()+"입니다.");
			} // try
		} // run
	} // ReceiverThread
} // class