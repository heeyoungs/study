package Chapter10;

import java.awt.*;
import java.awt.event.*; 

public class KeyEventEx extends Frame implements KeyListener{
	TextArea ta=new TextArea();

	public KeyEventEx(){ 
		super("KeyEvent �׽�Ʈ");
		
		add(ta);

		setBounds(300,300,300,300);
		setVisible(true); 

		ta.addKeyListener(this);
	}
		
 	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}
	public void keyPressed(KeyEvent e)
	{ 
		if(e.getKeyCode()==e.VK_DOWN){
			ta.append("Down Key\n");
		} 
     
        if(e.getKeyCode()==e.VK_UP){
			ta.append("Up Key\n");
		} 
        if(e.getKeyCode()==e.VK_LEFT){
			ta.append("Left Key\n");
		} 
		if(e.getKeyCode()==e.VK_RIGHT){
			ta.append("Right Key\n");
		} 
		if(e.getKeyCode()==e.VK_ENTER){
			ta.append("Enter Key\n");
		} 
    }     
    
	public static void main(String[] args){
		new KeyEventEx();
	} 
} 