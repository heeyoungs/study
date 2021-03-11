package chap18.src.sec03.exam02_console;

import java.io.Console;

public class ConsoleExample {
	public static void main(String[] args) {
		Console console = System.console();
		
		System.out.print("���̵�: ");
		String id = console.readLine();
		
		System.out.print("�н�����: ");
		char[] charPass = console.readPassword();
		String strPassword = new String(charPass);
		
		System.out.println("---------------------");
		System.out.println(id);
		System.out.println(strPassword);
	}
}
