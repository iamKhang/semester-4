package Buoi04;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class STT24_HoangKhang_Demo06 extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	JButton btnLogin;
	JButton btnExit;
	JTextField txtUser;
	JPasswordField tpxPass;

	public STT24_HoangKhang_Demo06() {
		// Set JFrame
		this.setTitle("Demo Layout");
		this.setSize(400, 150);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Components
		Box bMain = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box bControl = Box.createHorizontalBox();
		
		b1.add(new JLabel("User name:"));
		b1.add(txtUser = new JTextField(20));
		b2.add(new JLabel("Password:"));
		b2.add(tpxPass = new JPasswordField(20));
		
		btnLogin = new JButton("Login");
		btnExit = new JButton("Exit");
		bControl.add(btnLogin);
		bControl.add(btnExit);
		
		bMain.add(Box.createRigidArea(new Dimension(10, 10)));
		bMain.add(b1);
		bMain.add(Box.createRigidArea(new Dimension(10, 10)));
		bMain.add(b2);
		bMain.add(Box.createRigidArea(new Dimension(10, 10)));
		bMain.add(bControl);
		
		btnLogin.addActionListener(this);
		btnExit.addActionListener(this);
		
		this.add(bMain, BorderLayout.NORTH);
	}
	
	public static void main(String[] args) {
			new STT24_HoangKhang_Demo06().setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
	
	}

}
