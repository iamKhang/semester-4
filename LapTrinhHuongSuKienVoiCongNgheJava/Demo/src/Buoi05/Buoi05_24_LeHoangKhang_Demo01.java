package Buoi05;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class Buoi05_24_LeHoangKhang_Demo01 extends JFrame implements ActionListener {
	JPasswordField pwd_Password;
	JButton btn_ok, btn_cancel;

	public Buoi05_24_LeHoangKhang_Demo01() {
		setTitle("JpasswordField Demo");
		setSize(300, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		JPanel pnl_left , pnl_right;

		pwd_Password = new JPasswordField(12);
		pwd_Password.addActionListener(this);
		
		pnl_left = new JPanel();
		pnl_left.add(new JLabel("Password: "));
		pnl_left.add(pwd_Password);

		pnl_right = new JPanel(new GridLayout(0, 1));
		pnl_right.add(btn_ok = new JButton("OK"));
		pnl_right.add(btn_cancel = new JButton("Cancel"));
		add(pnl_left, BorderLayout.WEST);
		add(pnl_right, BorderLayout.CENTER);
		btn_ok.addActionListener(this);
		btn_cancel.addActionListener(this);
	}

	public static void main(String[] args) {
		new Buoi05_24_LeHoangKhang_Demo01().setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
