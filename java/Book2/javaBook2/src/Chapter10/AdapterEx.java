package Chapter10;

import java.awt.*;
import java.awt.event.*;

public class AdapterEx extends Frame implements ActionListener{
	
	Panel p1, p2, p3;
	
	TextField tf;
	TextArea ta;
	
	Button b1, b2;
	
	public AdapterEx(){

		super("Adapter �׽�Ʈ");
		
		p1=new Panel();
		p2=new Panel();
		p3=new Panel();

		tf=new TextField(35);
		ta=new TextArea(10,35);
		
		b1=new Button("Clear");
		b2=new Button("Exit");
		
		p1.add(tf);
		p2.add(ta);
		p3.add(b1);
		p3.add(b2);

		add("North",p1);
		add("Center",p2);
		add("South",p3);
		
		setBounds(300,200,300,300);
		setVisible(true);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
	
		tf.addKeyListener(new KeyEventHandler(tf, ta));

		addWindowListener(new WindowEventHandler());
	}
	
	public void actionPerformed(ActionEvent e){
		String str=e.getActionCommand();
		if(str.equals("Clear")){
			ta.setText("");
			tf.setText("");
			tf.requestFocus(); 
		}
		else if(str.equals("Exit")){
			System.exit(0);
		}
	}

	public static void main(String[] args){
		new AdapterEx();
	}
	class KeyEventHandler extends KeyAdapter{
		TextField tf;
		TextArea ta;

		public KeyEventHandler(TextField tf, TextArea ta){
			this.tf=tf;
			this.ta=ta;
		}

		public void keyTyped(KeyEvent e){
			if(e.getKeyChar() == KeyEvent.VK_ENTER){
				ta.append(tf.getText()+"\n");
				tf.setText("");
			}
		}
	}

	class WindowEventHandler extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			System.exit(0);
		}
	}
}


