package Buoi04;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LeHoangKhang_24 extends JFrame implements ActionListener, MouseListener {
	private static final long serialVersionUID = 1L;
	private JTextField txtUserName;
	private JTextField txtPassword;
	private JButton btnLogin;
	private JButton btnExit;
	
	public void Demo1() {
		setTitle("Demo");
		setSize(250, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JLabel lblUser = new JLabel("User	Name");
		JLabel lblPassword = new JLabel("Password: ");
		txtUserName = new JTextField(15);
		txtPassword = new JTextField(15);
		btnLogin = new JButton("Login");
		btnExit = new JButton("Exit");
		JPanel p = new JPanel();
		p.setBorder(BorderFactory.createTitledBorder("username: "));
		add(p);
		
		lblPassword.setPreferredSize(lblUser.getPreferredSize());
		p.add(lblUser);
		p.add(txtUserName);
		p.add(lblPassword);
		p.add(txtPassword);
		p.add(btnLogin);
		p.add(btnExit);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnLogin));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
