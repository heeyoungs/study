package Chapter09;/*
// header - edit "Data/yourJavaHeader" to customize
// contents - edit "EventHandlers/Java file/onCreate" to customize
//
*/

import java.awt.*;

public class TextFieldEx{
	public static void main(String[] args){

		Frame f=new Frame("�ؽ�Ʈ�ʵ� �׽�Ʈ");
		Panel p=new Panel();
		
		TextField tf1=new TextField("���̵� �Է�",12);
		TextField tf2=new TextField("��ȣ �Է�", 10);

		tf1.selectAll();
		tf2.selectAll();
		
		tf2.setEchoChar('*');
				
		p.add(tf1);
		p.add(tf2);
		
		f.add(p);
		
		f.setSize(300,100);
		f.setVisible(true);
	}
}

