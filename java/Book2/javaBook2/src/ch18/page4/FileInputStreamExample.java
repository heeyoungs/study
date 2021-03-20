package ch18.page4;

import java.io.FileInputStream;

public class FileInputStreamExample {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\user\\Desktop\\study\\java\\Book2\\javaBook2\\src\\ch18\\page4\\FileInputStreamExample.java");
			int data;
			while ( (data = fis.read() ) != -1 ) {
				System.out.write(data);
			}
			fis.close();	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

