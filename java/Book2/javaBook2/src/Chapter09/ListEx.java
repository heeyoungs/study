package Chapter09;/*
// header - edit "Data/yourJavaHeader" to customize
// contents - edit "EventHandlers/Java file/onCreate" to customize
//
*/

import java.awt.*;

public class ListEx{
	public static void main(String[] arsg){

		Frame f=new Frame("����Ʈ �׽�Ʈ");
		Panel p=new Panel();
		
		List list1=new List(3,true);
		
		list1.add("����");
		list1.add("�뱸");
		list1.add("����");
		list1.add("�λ�");
		
		p.add(list1);
		
		f.add(p);
		
		f.setSize(300,100);
		f.setVisible(true);
	}
}

