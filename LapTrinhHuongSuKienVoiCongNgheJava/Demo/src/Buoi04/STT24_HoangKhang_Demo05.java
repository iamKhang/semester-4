package Buoi04;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;

public class STT24_HoangKhang_Demo05 extends JFrame {
    public STT24_HoangKhang_Demo05(){
        setTitle("Demo Grid Layout");
        setSize(400,250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4,4));
        for (int i = 0; i < 14; i++) {
            this.add(new JButton("Button" + i));
        }
    }
}
