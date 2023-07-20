package Buoi04;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class STT24_HoangKhang_Demo01 extends JFrame {
    public STT24_HoangKhang_Demo01() {
        super("Panel on a Frame");
        JPanel jp = new JPanel();
        jp.add( new JLabel("User Name: ", new ImageIcon("blue-ball.gif"),SwingConstants.CENTER));
        jp.add( new JLabel("Password: "));
        add(jp);
        setSize(400, 400);
        }

    public static void main(String args[]) {
        new STT24_HoangKhang_Demo01().setVisible(true);
    }
}
