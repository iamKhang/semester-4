package Buoi04;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class STT24_HoangKhang_Demo02 extends JFrame {
    JTextField textFN, textLN;
    public STT24_HoangKhang_Demo02(){
        super("Input data");
        JPanel jp = new JPanel();
        jp.add(new JLabel("First name:"));
        jp.add(textFN=new JTextField(10));
        jp.add(new JLabel("Last name:"));
        jp.add(textLN=new JTextField(10));
        add(jp);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(250, 100);
    }
    public static void main(String[] args) {
        new STT24_HoangKhang_Demo02().setVisible(true);
    }
}
