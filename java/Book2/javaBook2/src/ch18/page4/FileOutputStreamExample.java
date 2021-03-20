package ch18.page4;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileOutputStreamExample {
	public static void main(String[] args) throws Exception {
		String originalFileName = "C:\\Users\\user\\Desktop\\study\\java\\Book2\\javaBook2\\src\\ch18\\page4\\dasd.png";
		String targetFileName = "C:\\Users\\user\\Desktop\\example.png";
		
		FileInputStream fis = new FileInputStream(originalFileName);
		FileOutputStream fos = new FileOutputStream(targetFileName);
		
		int readByteNo;
		byte[] readBytes = new byte[100];
		while( (readByteNo = fis.read(readBytes)) != -1 ) {
			fos.write(readBytes, 0, readByteNo);
		}
		
		fos.flush();
		fos.close();
		fis.close();
		
		System.out.println("복사가 잘 되었습니다.");
	}
}

