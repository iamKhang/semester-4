package Buoi04;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class STT24_HoangKhang_Demo04 extends JFrame {
    public STT24_HoangKhang_Demo04(){
        setTitle("Demo Border Layout");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(400,250);
        this.add(new JButton("NORTH"), BorderLayout.NORTH);
        this.add(new JButton("SOUTH"), BorderLayout.SOUTH);
        this.add(new JButton("WEST"), BorderLayout.WEST);
        this.add(new JButton("EAST"), BorderLayout.EAST);
        this.add(new JButton("CENTER"), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new STT24_HoangKhang_Demo04().setVisible(true);
    }
}
