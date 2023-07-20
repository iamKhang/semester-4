package Buoi04;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class STT24_HoangKhang_Demo03 extends JFrame {
    STT24_HoangKhang_Demo03(){
        setTitle("FlowLayout Demo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,250);
        setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
        for (int i = 0; i < 10; i++) {
            this.add(new JButton("Button "+i));
        }
    }

    public static void main(String[] args) {
        new STT24_HoangKhang_Demo03().setVisible(true);
    }
}
