package tuan09_24_OnTapCuoiKiJDBC;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class VanDongVien_GUI extends JFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = -1554680235689968471L;

	private JButton btnThem;
	private JButton btnLuu;
	private JButton btnXoa;
	private JButton btnKetThuc;
	private JButton btnXoaRong;

	private DefaultTableModel dataModel;
	private JTable table;

	private JScrollPane scroll;

	private JComboBox<CauLacBo> cboCauLB;
	private JTextField txtMaVDV;
	private JTextField txtTenVDV;
	private JTextField txtTuoi;

	private JButton btnLoc;

	private CauLacBo_dao clb_dao = new CauLacBo_dao();
	private VanDongVien_dao vdv_dao = new VanDongVien_dao();

	public VanDongVien_GUI() {

		try {
			ConnectDB.connect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		setSize(630, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		Box b, b1, b2, b3, b4, b5, b6, b7, b8;
		add(b = Box.createVerticalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b4 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b5 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b8 = Box.createHorizontalBox());

		b.add(Box.createVerticalStrut(10));
		b.add(b6 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b7 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b8 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		JLabel lblTieuDe, lblMaVDV, lblTenVDV, lblTuoi, lblCLB;
		b1.add(lblTieuDe = new JLabel("-THÔNG TIN VẬN ĐỘNG VIÊN- ", JLabel.CENTER));
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblTieuDe.setForeground(Color.BLUE);

		b2.add(lblMaVDV = new JLabel("  Mã số vận động viên:  ", JLabel.RIGHT));
		b2.add(txtMaVDV = new JTextField());
		b2.add(Box.createHorizontalStrut(50));
		b3.add(lblTenVDV = new JLabel("Tên Vận động viên:  ", JLabel.RIGHT));
		b3.add(txtTenVDV = new JTextField());
		b3.add(Box.createHorizontalStrut(50));
		b4.add(lblTuoi = new JLabel("Câu lạc bộ:  ", JLabel.RIGHT));
		b4.add(cboCauLB = new JComboBox<>());
		b4.add(Box.createHorizontalStrut(300));

		b5.add(lblCLB = new JLabel("Tuổi:  ", JLabel.RIGHT));
		b5.add(txtTuoi = new JTextField());
		b5.add(Box.createHorizontalStrut(50));

		DefaultComboBoxModel<CauLacBo> dataModelLop = new DefaultComboBoxModel<>();

		cboCauLB.setModel(dataModelLop);

		lblTuoi.setPreferredSize(lblMaVDV.getPreferredSize());
		lblTenVDV.setPreferredSize(lblMaVDV.getPreferredSize());
		lblCLB.setPreferredSize(lblMaVDV.getPreferredSize());

		b6.add(Box.createHorizontalStrut(40));
		b6.add(btnThem = new JButton("Thêm Mới "));
		b6.add(Box.createHorizontalStrut(10));
		b6.add(btnLuu = new JButton("Lưu "));
		b6.add(Box.createHorizontalStrut(10));
		b6.add(btnXoaRong = new JButton("Xóa rỗng"));
		b6.add(Box.createHorizontalStrut(10));
		b6.add(btnXoa = new JButton("Xóa"));
		b6.add(Box.createHorizontalStrut(50));
		b6.add(btnKetThuc = new JButton("Kết Thúc"));

		String[] tieuDe = { "Mã Số", "Tên vận động viên", "Tuổi", "Câu Lạc Bộ" };
		b7.add(scroll = new JScrollPane(table = new JTable(dataModel = new DefaultTableModel(tieuDe, 0))));
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách vận động viên:"));

		JLabel lblName;
		b8.add(lblName = new JLabel("Họ tên: Lê Hoàng Khang - Mã sinh viên:21083791"));
		lblName.setFont(new Font("Times", Font.ITALIC, 12));
		lblName.setForeground(Color.RED);
		b8.add(Box.createHorizontalStrut(50));
		b8.add(btnLoc = new JButton("   Lọc danh sách VĐV theo câu lạc bộ "));
		btnLoc.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		btnLoc.setForeground(Color.BLUE);
		table.addMouseListener(this);
		btnKetThuc.addActionListener(this);
		btnLoc.addActionListener(this);
		btnLuu.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaRong.addActionListener(this);

		renderCLB();

		renderAllVDV();
	}

	private void renderVDV(ArrayList<VanDongVien> list) {
		dataModel.setRowCount(0);
		for (VanDongVien vdv : list) {
			dataModel.addRow(new Object[] { vdv.getMaVDV(), vdv.getTenVDV(), vdv.getTuoi(), vdv.getClb().getMaCLB() });
		}
	}

	private void renderAllVDV() {
		renderVDV(vdv_dao.getAll());
	}

	private void renderCLB() {
		for (CauLacBo clb : clb_dao.getAll()) {
			cboCauLB.addItem(clb);
		}
	}

	public void clearAll() {
		txtMaVDV.setText("");
		txtTenVDV.setText("");
		txtTuoi.setText("");
		cboCauLB.setSelectedItem(0);
		txtMaVDV.requestFocus();
		
	}

	public void showMessageFocus(String msg, JTextField txt) {
		JOptionPane.showMessageDialog(this, msg);
		txt.selectAll();
		txt.requestFocus();
	}

	public boolean validateInput() {
		String ma = txtMaVDV.getText().trim();
		String ten = txtTenVDV.getText().trim();
		String tuoiS = txtTuoi.getText().trim();

		if (ma.length() == 0 || !Pattern.matches("VDV\\d{3}", ma)) {
			showMessageFocus("Mã không được rỗng và có dạng VDVXXX (X là kí số)", txtMaVDV);
			return false;
		}

		if (ten.length() == 0 || !Pattern.matches("[^!@#$%^&*()]*", ten)) {
			showMessageFocus("Tên không chứa ký tự đặc biệt", txtTenVDV);
			return false;
		}

		int tuoi;
		try {
			tuoi = Integer.parseInt(tuoiS);
			if (tuoi < 18 || tuoi > 23) {
				showMessageFocus("Tuổi vận động viên phải từ 18 đến 23", txtTuoi);
				return false;
			}
		} catch (Exception ee) {
			showMessageFocus("Tuổi không được rỗng và phải là số", txtTuoi);
			return false;
		}

		return true;
	}

	public VanDongVien revertObjectFromInput() {
		String ma = txtMaVDV.getText().trim();
		String ten = txtTenVDV.getText().trim();
		String maCLB = ((CauLacBo)cboCauLB.getSelectedItem()).getMaCLB();
		int tuoi = Integer.parseInt(txtTuoi.getText().trim());

		VanDongVien vdv = new VanDongVien(ma, ten, tuoi, new CauLacBo(maCLB));
		return vdv;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj.equals(btnXoa)) {
			int row = table.getSelectedRow();
			if (row != -1 && JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa vận động viên này không?",
					"Xác nhận xóa", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				String ma = table.getValueAt(row, 0).toString();
				if (vdv_dao.xoa(ma)) {
					JOptionPane.showMessageDialog(this, "Xoa thanh cong");
					renderAllVDV();
				} else
					JOptionPane.showMessageDialog(this, "Xoa that bai");
			}
		} else if (obj.equals(btnKetThuc)) {
			System.exit(0);
		} else if (obj.equals(btnLoc)) {
			String maCLB = ((CauLacBo)cboCauLB.getSelectedItem()).getMaCLB();

			ArrayList<VanDongVien> list = new ArrayList<>();

			for (VanDongVien vdv : vdv_dao.getAll()) {
				if (vdv.getClb().getMaCLB().equals(maCLB)) {
					list.add(vdv);
				}
			}

			renderVDV(list);
		} else if (obj.equals(btnThem)) {
			if (validateInput()) {
				VanDongVien vdv = revertObjectFromInput();
				if (vdv_dao.them(vdv)) {
					JOptionPane.showMessageDialog(this, "Thêm thành công");
					renderAllVDV();
					clearAll();
				} else {
					JOptionPane.showMessageDialog(this, "Thêm thất bại - mã bị trùng");
				}
			}
		} else if (obj.equals(btnLuu)) {
			if (validateInput()) {
				VanDongVien vdv = revertObjectFromInput();

				if (vdv_dao.sua(txtMaVDV.getText().trim(), vdv)) {
					JOptionPane.showMessageDialog(this, "Sửa thành công");
					renderAllVDV();
					clearAll();
				} else {
					JOptionPane.showMessageDialog(this, "Sửa thất bại");
				}
			}
		} else if (obj.equals(btnXoaRong)) {
			clearAll();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		if (row != -1) {
			txtMaVDV.setText(table.getValueAt(row, 0).toString());
			txtTenVDV.setText(table.getValueAt(row, 1).toString());
			txtTuoi.setText(table.getValueAt(row, 2).toString());
			cboCauLB.setSelectedItem(new CauLacBo(table.getValueAt(row, 3).toString()));
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
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

}
