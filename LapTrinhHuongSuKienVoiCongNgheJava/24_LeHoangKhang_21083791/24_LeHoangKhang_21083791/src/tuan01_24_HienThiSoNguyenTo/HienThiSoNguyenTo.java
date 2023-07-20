package tuan01_24_HienThiSoNguyenTo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class HienThiSoNguyenTo extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNhap;
	private JButton btnNhap;
	private JTextArea txaXuat;

	public HienThiSoNguyenTo() {
		setTitle("Hiển thị N số nguyên tố đầu tiên");
		setSize(400, 350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		createGUI();
	}

	private void createGUI() {

		this.setLayout(null);

		txtNhap = new JTextField(20);
		btnNhap = new JButton("Generate");
		int x = 20, y = 30, width = 200, height = 20;
		txtNhap.setBounds(x, y, width, height);
		btnNhap.setBounds(x + width + 20, y, 100, height);

		txaXuat = new JTextArea();
		txaXuat.setEditable(false);
		JScrollPane jspScroll = new JScrollPane(txaXuat);
		jspScroll.setBounds(x, y + 40, 320, 200);

		this.add(txtNhap);
		this.add(btnNhap);
		this.add(jspScroll);

		btnNhap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Double n = Double.parseDouble(txtNhap.getText());
				String s = new String("");
				int k = 0, i = 1;
				while (k < n) {
					if(isPrime(i)) {
						k++;
						s+= Integer.toString(i) + "\n";
					}
					i++;
				}
				txaXuat.setText(s);
			}
		});
	}

	public static boolean isPrime(int i2) {
		if (i2 <= 1) {
			return false;
		}

		for (int i = 2; i <= i2 / 2; i++) {
			if (i2 % i == 0) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		new HienThiSoNguyenTo().setVisible(true);
	}
}
