package Chapter10;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class quiz6 extends Frame implements ActionListener {
    Panel p,p1;
    TextField tf;
    Label l1;
    Button out;
    StringBuffer sb;

    public quiz6() {
        super("Dial");

        p = new Panel();
        p1 = new Panel();

        sb = new StringBuffer("");
        tf = new TextField(11);
        l1 = new Label("Dial-Number");
        out = new Button("delete");

        p.setLayout(new GridLayout(1,3));
        p1.setLayout(new GridLayout(4, 3));

        Button b1 = new Button("1");
        Button b2 = new Button("2");
        Button b3 = new Button("3");
        Button b4 = new Button("4");
        Button b5 = new Button("5");
        Button b6 = new Button("6");
        Button b7 = new Button("7");
        Button b8 = new Button("8");
        Button b9 = new Button("9");
        Button b10 = new Button("*");
        Button b11 = new Button("0");
        Button b12 = new Button("#");

        p.add(l1);
        p.add(tf);
        p.add(out);

        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(b4);
        p1.add(b5);
        p1.add(b6);
        p1.add(b7);
        p1.add(b8);
        p1.add(b9);
        p1.add(b10);
        p1.add(b11);
        p1.add(b12);

        add(p,BorderLayout.NORTH);
        add(p1);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b10.addActionListener(this);
        b11.addActionListener(this);
        b12.addActionListener(this);
        out.addActionListener(this);

        setBounds(300, 300, 300, 500);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowOpened(WindowEvent e) {
                tf.requestFocus();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if (str.equals("delete")) {
            sb.delete(0,sb.capacity());
        } else if (str.equals("1"))
            sb.append("1");
        else if (str.equals("2"))
            sb.append("2");
        else if (str.equals("3"))
            sb.append("3");
        else if (str.equals("4"))
            sb.append("4");
        else if (str.equals("5"))
            sb.append("5");
        else if (str.equals("6"))
            sb.append("6");
        else if (str.equals("7"))
            sb.append("7");
        else if (str.equals("8"))
            sb.append("8");
        else if (str.equals("9"))
            sb.append("9");
        else if (str.equals("*"))
            sb.append("*");
        else if (str.equals("0"))
            sb.append("0");
        else if (str.equals("#"))
            sb.append("#");
        tf.setText(sb.toString());
    }

    public static void main(String[] args) {
        new quiz6();
    }
}
