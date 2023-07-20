package gui;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JScrollPane;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import connection.ConnectDB;
import dao.LoaiPhong_dao;
import dao.Phong_dao;
import entity.LoaiPhong;
import entity.Phong;

public class GUI_Phong extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTable tablePhong;
	private DefaultTableModel modelPhong;

	private JTextField txtMaPhong;
	private JTextField txtTenPhong;
	private JTextField txtDienTich;

	private JTextField txtGhiChu;

	private JButton bttTim;
	private JButton bttThem;
	private JButton bttXoa;
	private JButton bttKetThuc;
	private JButton bttXoaTrang;
	private JComboBox<String> cboLoaiPhong;

	private Phong_dao phong_dao = new Phong_dao();
	private LoaiPhong_dao loaiPhong_dao = new LoaiPhong_dao();

	public GUI_Phong() {
		ConnectDB.connect();
		setTitle("Kiểm Tra Cuối Kỳ <<Họ tên SV >>  <<MaSSV>> -<<Lớp>> ");
		setSize(700, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JLabel lblTieuDe;
		lblTieuDe = new JLabel(" -- THÔNG TIN PHÒNG - - ", SwingConstants.CENTER);
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
		lblTieuDe.setForeground(Color.blue);
		add(lblTieuDe, BorderLayout.NORTH);

		JPanel pW = new JPanel(new GridLayout(12, 1));

		JLabel lblMaPhong, lblTenPhong, lblDienTich, lblLoaiPhong, lblGhiChu;

		pW.add(lblMaPhong = new JLabel(" Mã Phòng: "));
		pW.add(txtMaPhong = new JTextField());

		pW.add(lblTenPhong = new JLabel(" Tên phòng "));
		pW.add(txtTenPhong = new JTextField(17));
		pW.add(lblDienTich = new JLabel(" Diện tích: "));
		pW.add(txtDienTich = new JTextField());

		// +++++++++++++++++++++++++++++++++++++++++++++++++
		pW.add(lblLoaiPhong = new JLabel(" Loại phòng: "));
		pW.add(cboLoaiPhong = new JComboBox<String>());

		pW.add(lblGhiChu = new JLabel(" Ghi chú: "));
		pW.add(txtGhiChu = new JTextField());
		add(pW, BorderLayout.WEST);

		String[] colHeader = { "Mã Phòng", "Tên Phòng", "Diện tích", "Loại Phòng ", "Ghi chú" };
		modelPhong = new DefaultTableModel(colHeader, 0);
		tablePhong = new JTable(modelPhong);
		add(new JScrollPane(tablePhong), BorderLayout.CENTER);

		JPanel p = new JPanel();
		add(p, BorderLayout.SOUTH);
		JPanel pnlRight;
		p.add(pnlRight = new JPanel());

		pnlRight.add(bttThem = new JButton("Thêm Phòng"));
		pnlRight.add(bttXoaTrang = new JButton(" Làm mới"));
		pnlRight.add(bttXoa = new JButton("Xóa Phòng"));

		pnlRight.add(bttTim = new JButton("Tìm theo loại phòng"));
		bttTim.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		bttTim.setForeground(Color.BLUE);
		pnlRight.add(bttKetThuc = new JButton("Kết thúc"));

		renderPhong(phong_dao.getAllPhong());
		renderLoaiPhong(loaiPhong_dao.getAllLoaiPhong());

		bttTim.addActionListener(this);
		bttThem.addActionListener(this);
		bttXoa.addActionListener(this);
		bttKetThuc.addActionListener(this);
		bttXoaTrang.addActionListener(this);
		tablePhong.addMouseListener(this);
	}

	public static void main(String[] args) {
		new GUI_Phong().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(bttXoaTrang)) {
			xoaTrang();
		}
		if (obj.equals(bttThem)) {
			if (checkData()) {
				phong_dao.themPhong(getPhong());
				renderPhong(phong_dao.getAllPhong());
			}

		}
		if (obj.equals(bttXoa)) {
			int row  = tablePhong.getSelectedRow();
			if(row==-1) {
				JOptionPane.showMessageDialog(this, "Phải chọn dòng cần xóa");
			}
			else {
				if(JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không", "Xác nhận xóa", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
					if(phong_dao.xoaPhong(tablePhong.getValueAt(row, 0).toString())) {
						renderPhong(phong_dao.getAllPhong());
						JOptionPane.showMessageDialog(this, "Xóa thành công");
					}
					
				}
			}
		}
		if(obj.equals(bttKetThuc)) {
			if(JOptionPane.showConfirmDialog(this, "Bạn có muốn thoat không", "Xác nhận thoát", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = tablePhong.getSelectedRow();
		if (row != -1) {
			txtMaPhong.setText(tablePhong.getValueAt(row, 0).toString());
			txtTenPhong.setText(tablePhong.getValueAt(row, 1).toString());
			txtDienTich.setText(tablePhong.getValueAt(row, 2).toString());
			cboLoaiPhong.setSelectedItem(tablePhong.getValueAt(row, 3).toString());
			txtGhiChu.setText(tablePhong.getValueAt(row, 4).toString());
		}
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

	public void renderPhong(ArrayList<Phong> list) {
		modelPhong.setRowCount(0);

		for (Phong phong : list) {
			modelPhong.addRow(new Object[] { phong.getMaPhong(), phong.getTenPhong(), phong.getDienTich(),
					phong.getLoaiPhong().getMaLoaiPhong(), phong.getGhiChu() });
		}
	}

	public void renderLoaiPhong(ArrayList<LoaiPhong> list) {
		for (LoaiPhong loai : list) {
			cboLoaiPhong.addItem(loai.getMaLoaiPhong());
		}
	}

	public void xoaTrang() {
		txtMaPhong.setText("");
		txtTenPhong.setText("");
		txtGhiChu.setText("");
		txtDienTich.setText("");
		cboLoaiPhong.setSelectedItem(loaiPhong_dao.getAllLoaiPhong().get(0).getMaLoaiPhong());
	}

	public Phong getPhong() {
		String ma = txtMaPhong.getText();
		String ten = txtTenPhong.getText();
		int dienTich = Integer.parseInt(txtDienTich.getText());
		LoaiPhong loai = new LoaiPhong(cboLoaiPhong.getSelectedItem().toString());
		String ghiChu = txtGhiChu.getText();
		Phong phong = new Phong(ma, ten, dienTich, loai, ghiChu);
		return phong;
	}

	public boolean checkData() {
		String ma = txtMaPhong.getText().trim();
		if (ma.equals("") || !Pattern.matches("(BES|VIS|VIR)\\d{3}", ma)) {
			JOptionPane.showMessageDialog(this,
					"Mã không được phép rỗng và phải có dạng là BESxxx, VISxxx hoặc VIExxx");
			txtMaPhong.requestFocus();
			return false;
		}
		if(phong_dao.getAllPhong().equals(new Phong(ma))) {
			JOptionPane.showMessageDialog(this, "Mã đã tồn tại");
			return false;
		}
		if(txtTenPhong.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Tên phòng không được phép bỏ trống");
			txtTenPhong.requestFocus();
			return false;
		}
		
		if(Pattern.matches("\\d+", txtDienTich.getText().trim())) {
			int dienTich = Integer.parseInt(txtDienTich.getText());
			txtDienTich.requestFocus();
			if(dienTich<25) {
				JOptionPane.showMessageDialog(this, "Diện tích phải là số và tối thiểu là 25m2");
				return false;
			}
		}
		else {
			txtDienTich.requestFocus();
			JOptionPane.showMessageDialog(this, "Diện tích phải là số, không được rỗng và tối thiểu là 25m2");
		}
		return true;
	}

}
