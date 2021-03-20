package ch18.page4;

import java.io.FileReader;

public class FileReaderExample {
	public static void main(String[] args) throws Exception {
		FileReader fr = new FileReader("C:\\Users\\user\\Desktop\\study\\java\\Book2\\javaBook2\\src\\ch18\\page4\\FileReaderExample.java");
		
		int readCharNo;
		char[] cbuf = new char[100];
		while ((readCharNo=fr.read(cbuf)) != -1) {
			String data = new String(cbuf, 0, readCharNo);
			System.out.print(data);
		}
		fr.close();
	}
}

