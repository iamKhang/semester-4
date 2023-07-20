package tuan01_24_CongTruNhanChia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class CongTruNhanChia extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JRadioButton rbt_Cong, rbt_Tru, rbt_Nhan, rbt_Chia;
	private JButton btn_Xoa, btn_Giai, btn_Thoat;
	private JTextField txt_A, txt_B, txt_KQ;

	public CongTruNhanChia() {

		this.setTitle("Cộng - Trừ - Nhân - Chia");
		this.setSize(550, 400);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel pnl_Title = new JPanel();
		JLabel lbl_Title = new JLabel("Cộng - Trừ - Nhân - Chia");
		lbl_Title.setFont(new Font("Arial", Font.BOLD, 28));
		lbl_Title.setForeground(Color.BLUE);
		pnl_Title.add(lbl_Title);

		JPanel pnl_Option = new JPanel();
		pnl_Option.setBorder(new TitledBorder(new LineBorder(Color.cyan), "Chọn tác vụ:"));
		pnl_Option.setBackground(Color.lightGray);
		pnl_Option.setLayout(new GridLayout(10, 1));
		pnl_Option.setPreferredSize(new Dimension(120, 40));
		pnl_Option.add(btn_Giai = new JButton("Giải"));
		pnl_Option.add(btn_Xoa = new JButton("Xóa"));
		pnl_Option.add(btn_Thoat = new JButton("Thoát"));

		JPanel pnl_footer = new JPanel();
		JButton btn_blue = new JButton(), btn_red = new JButton(), btn_yellow = new JButton();
		Dimension dms = new Dimension(20, 20);
		pnl_footer.setBackground(Color.pink);
		pnl_footer.setPreferredSize(new Dimension(getWidth(), 50));

		btn_blue.setBackground(Color.BLUE);
		pnl_footer.add(btn_blue);
		btn_blue.setPreferredSize(dms);

		pnl_footer.add(btn_red);
		btn_red.setBackground(Color.RED);
		btn_red.setPreferredSize(dms);

		pnl_footer.add(btn_yellow);
		btn_yellow.setBackground(Color.YELLOW);
		btn_yellow.setPreferredSize(dms);

		JPanel pnl_main = new JPanel();
		pnl_main.setBorder(new TitledBorder(new LineBorder(Color.cyan), "Tính toán"));

		Box b_Y = Box.createVerticalBox();

		Box b_A = Box.createHorizontalBox();
		JLabel lbl_A = new JLabel("Nhập a: ");
		txt_A = new JTextField(25);
		b_A.setPreferredSize(new Dimension(350, 30));
		b_A.add(lbl_A);
		b_A.add(txt_A);

		Box b_B = Box.createHorizontalBox();
		JLabel lbl_B = new JLabel("Nhập b: ");
		txt_B = new JTextField(25);
		b_B.setPreferredSize(new Dimension(350, 30));
		b_B.add(lbl_B);
		b_B.add(txt_B);

		Box b_PT = Box.createHorizontalBox();
		JPanel pnl_PT = new JPanel();
		pnl_PT.setBorder(new TitledBorder(new LineBorder(Color.cyan), "Phép toán"));
		JLabel pnl_rong = new JLabel("");
		pnl_rong.setPreferredSize(new Dimension(55, 100));

		rbt_Cong = new JRadioButton("Cộng");
		rbt_Tru = new JRadioButton("Trừ");
		rbt_Nhan = new JRadioButton("Nhân");
		rbt_Chia = new JRadioButton("Chia");
		pnl_PT.setLayout(new GridLayout(2, 2));
		ButtonGroup group = new ButtonGroup();
		group.add(rbt_Cong);
		group.add(rbt_Tru);
		group.add(rbt_Nhan);
		group.add(rbt_Chia);

		pnl_PT.add(rbt_Cong);
		pnl_PT.add(rbt_Tru);
		pnl_PT.add(rbt_Nhan);
		pnl_PT.add(rbt_Chia);
		b_PT.setPreferredSize(new Dimension(300, 100));
		b_PT.add(pnl_rong);
		b_PT.add(pnl_PT);

		Box b_kq = Box.createHorizontalBox();
		JLabel lbl_kq = new JLabel("Kết quả: ");
		txt_KQ = new JTextField(25);
		b_kq.setPreferredSize(new Dimension(300, 40));
		b_kq.add(lbl_kq);
		b_kq.add(txt_KQ);
		txt_KQ.setEditable(false);

		b_Y.add(b_A);
		b_Y.add(b_B);
		b_Y.add(b_PT);
		b_Y.add(b_kq);

		pnl_main.add(b_Y);

		// Add Action
		btn_Giai.addActionListener(this);
		btn_Thoat.addActionListener(this);
		btn_Xoa.addActionListener(this);
		rbt_Tru.addActionListener(this);
		rbt_Cong.addActionListener(this);
		rbt_Nhan.addActionListener(this);
		rbt_Chia.addActionListener(this);

		// Add JFrame
		this.add(pnl_main);
		this.add(pnl_footer, BorderLayout.SOUTH);
		this.add(pnl_Option, BorderLayout.WEST);
		this.add(pnl_Title, BorderLayout.NORTH);
	}

	public static void main(String[] args) {
		new CongTruNhanChia().setVisible(true);
	}

	public boolean checkInt() {
		try {
			Integer.parseInt(txt_A.getText());
			Integer.parseInt(txt_B.getText());
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Lỗi input!");
			btn_Xoa.doClick();
			return false;
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btn_Thoat))
			System.exit(0);
		else if (o.equals(btn_Xoa)) {
			txt_A.setText("");
			txt_B.setText("");
			txt_KQ.setText("");
			txt_A.requestFocus();
		} else if (o.equals(btn_Giai)) {
			checkInt();
			int a = Integer.parseInt(txt_A.getText());
			int b = Integer.parseInt(txt_B.getText());
			if (rbt_Cong.isSelected())
				txt_KQ.setText("" + (a + b));
			else if (rbt_Tru.isSelected())
				txt_KQ.setText("" + (a - b));
			else if (rbt_Nhan.isSelected())
				txt_KQ.setText("" + (a * b));
			else if (rbt_Chia.isSelected())
				txt_KQ.setText("" + (float) (a / b));
			else
				JOptionPane.showMessageDialog(this, "Chon Phep Tinh !");

		}

	}
}

