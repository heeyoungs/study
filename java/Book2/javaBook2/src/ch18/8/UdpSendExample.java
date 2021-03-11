package chap18.src.sec08.exam01_udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UdpSendExample {
	public static void main(String[] args) throws Exception {
		DatagramSocket datagramSocket = new DatagramSocket();
		
		System.out.println("[�߽� ����]");
		
		for(int i=1; i<3; i++) {
			String data = "�޽���" + i;
			byte[] byteArr = data.getBytes("UTF-8");
			DatagramPacket packet = new DatagramPacket(
				byteArr, byteArr.length, 
				new InetSocketAddress("localhost", 5001)
			);
			
			datagramSocket.send(packet);
			System.out.println("[���� ����Ʈ ��]: " + byteArr.length + " bytes");
		}
		
		System.out.println("[�߽� ����]");
		
		datagramSocket.close();
	}
}
