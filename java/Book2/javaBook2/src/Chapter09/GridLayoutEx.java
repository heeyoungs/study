package Chapter09;

import java.awt.*;

public class GridLayoutEx{

	public static void main(String[] args){
		Frame f=new Frame("GridLayout");
		
		f.setLayout(new GridLayout(4,3));

		Button b1=new Button("1");
		Button b2=new Button("2");
		Button b3=new Button("3");
		Button b4=new Button("4");
		Button b5=new Button("5");
		Button b6=new Button("6");
		Button b7=new Button("7");
		Button b8=new Button("8");
		Button b9=new Button("9");
		Button b10=new Button("*");
		Button b11=new Button("0");
		Button b12=new Button("#");
		
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);
		f.add(b6);
		f.add(b7);
		f.add(b8);
		f.add(b9);
		f.add(b10);
		f.add(b11);
		f.add(b12);
		
		f.setLocation(300,300);
		f.setSize(200,200);
		f.setVisible(true);
	}
}
