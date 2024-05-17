package day0319;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

/*
	소켓 Socket
		- 네트워크를 통해 다른 컴퓨터와 통신하기 위한 자바 API
		- 서버-클라이언트
*/
public class SocketEx {
	public static void main(String[] args) {
		try { // cmd 에서 ipconfig 통해서 ip 확인 
			Socket client = new Socket("192.168.0.152", 8000);
			InputStream is = client.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			Object obj = ois.readObject();
			System.out.println("시간 : "+obj);
			ois.close();
			client.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
