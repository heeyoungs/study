package chap18.src.sec03.exam01_system_in_out;

import java.io.InputStream;

public class SystemInExample2 {
	public static void main(String[] args) throws Exception {			
		InputStream is = System.in;
		
		byte[] datas = new byte[100];
		
		System.out.print("�̸�: ");
		int nameBytes = is.read(datas);
		String name = new String(datas, 0, nameBytes-2);
		
		System.out.print("�ϰ� ������: ");
		int commentBytes = is.read(datas);
		String comment = new String(datas, 0, commentBytes-2);
		
		System.out.println("�Է��� �̸�: " + name);	
		System.out.println("�Է��� �ϰ� ������: " + comment);	
	}
}

