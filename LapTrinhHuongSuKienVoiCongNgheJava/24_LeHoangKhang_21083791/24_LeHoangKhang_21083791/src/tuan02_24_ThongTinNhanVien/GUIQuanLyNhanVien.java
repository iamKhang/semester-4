package tuan02_24_ThongTinNhanVien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class GUIQuanLyNhanVien extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel model;
	private JTextField txt_MaNv, txt_TenNV, txt_Ho, txt_Tuoi, txt_TienLuong;
	private JRadioButton rad_Nam, rad_Nu;
	private JPanel pnl_Center;
	private JTable table;
	private JPanel pnl_timKiem;
	private JTextField txt_timKiem;
	private JButton btn_timKiem;
	private JPanel pnl_ChucNang;
	private JButton btn_Them;
	private JButton btn_XoaTrang;
	private JButton btn_Xoa;
	private JButton btn_Luu;
	private JComboBox comboBox;
	private DanhSachNhanVien dsNV = new DanhSachNhanVien();
	private JButton btn_Sua;

	public GUIQuanLyNhanVien() {
		setTitle("Thông tin nhân viên");
		setSize(800, 500);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel pnl_Title = new JPanel();
		JLabel lbl_Title;
		pnl_Title.add(lbl_Title = new JLabel("THÔNG TIN NHÂN VIÊN"));
		lbl_Title.setFont(new Font("Arial", Font.BOLD, 25));
		lbl_Title.setForeground(Color.BLUE);

		pnl_Center = new JPanel();
		pnl_Center.setLayout(new BoxLayout(pnl_Center, BoxLayout.Y_AXIS));
		Box b_ThongTin = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();
		Box b4 = Box.createHorizontalBox();

		b_ThongTin.add(b1);
		b_ThongTin.add(Box.createVerticalStrut(5));
		b_ThongTin.add(b2);
		b_ThongTin.add(Box.createVerticalStrut(5));
		b_ThongTin.add(b3);
		b_ThongTin.add(Box.createVerticalStrut(5));
		b_ThongTin.add(b4);
		b_ThongTin.add(Box.createVerticalStrut(5));

		
		JLabel lbl_MaNhanVien = new JLabel("Mã nhân viên: ");
		JLabel lbl_Ho = new JLabel("Họ:");
		JLabel lbl_Ten = new JLabel("Tên: ");
		JLabel lbl_Tuoi = new JLabel("Tuổi");
		JLabel lbl_Phai = new JLabel("Phái: ");
		JLabel lbl_TienLuong = new JLabel("Tiền lương");

		Dimension dms = new Dimension(100, 30);
		lbl_MaNhanVien.setPreferredSize(dms);
		lbl_Ho.setPreferredSize(dms);
		lbl_Tuoi.setPreferredSize(dms);
		lbl_TienLuong.setPreferredSize(dms);

		b1.add(lbl_MaNhanVien);
		b1.add(txt_MaNv = new JTextField());

		b2.add(lbl_Ho);
		b2.add(txt_Ho = new JTextField());
		b2.add(lbl_Ten);
		b2.add(txt_TenNV = new JTextField());
		lbl_Ho.setPreferredSize(lbl_MaNhanVien.getPreferredSize());

		b3.add(lbl_Tuoi);
		b3.add(txt_Tuoi = new JTextField());
		b3.add(lbl_Phai);
		ButtonGroup btn_Group = new ButtonGroup();
		btn_Group.add(rad_Nam = new JRadioButton("Nam"));
		btn_Group.add(rad_Nu = new JRadioButton("Nữ"));
		b3.add(rad_Nam);
		b3.add(rad_Nu);
		lbl_Tuoi.setPreferredSize(lbl_MaNhanVien.getPreferredSize());

		b4.add(lbl_TienLuong);
		b4.add(txt_TienLuong = new JTextField());

		pnl_Center.add(b_ThongTin);
		pnl_Center.add(Box.createVerticalStrut(10));

		taoBang();

		pnl_timKiem = new JPanel();
		JLabel jpTim = new JLabel("Nhập mã cần tìm:");
		txt_timKiem = new JTextField(12);
		btn_timKiem = new JButton("Tìm kiếm");
		

		pnl_timKiem.add(jpTim);
		pnl_timKiem.add(txt_timKiem);
		pnl_timKiem.add(btn_timKiem);
		pnl_timKiem.setBorder(BorderFactory.createLoweredBevelBorder());

		pnl_ChucNang = new JPanel();
		btn_Them = new JButton("Thêm");
		btn_XoaTrang = new JButton("Xóa trắng");
		btn_Xoa = new JButton("Xóa");
		btn_Luu = new JButton("Lưu");
		btn_Sua = new JButton("Sửa");

		pnl_ChucNang.add(btn_Them);
		pnl_ChucNang.add(btn_Xoa);
		pnl_ChucNang.add(btn_Sua);
		pnl_ChucNang.add(btn_XoaTrang);
		pnl_ChucNang.add(btn_Luu);
		pnl_ChucNang.setBorder(BorderFactory.createLoweredBevelBorder());

		JSplitPane split = new JSplitPane(SwingConstants.VERTICAL, pnl_timKiem, pnl_ChucNang);

		btn_Them.addActionListener(this);
		btn_Xoa.addActionListener(this);
		btn_Luu.addActionListener(this);
		btn_XoaTrang.addActionListener(this);
		btn_timKiem.addActionListener(this);
		btn_Sua.addActionListener(this);
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				txt_MaNv.setText(model.getValueAt(row, 0).toString());
				txt_Ho.setText(model.getValueAt(row, 1).toString());
				txt_TenNV.setText(model.getValueAt(row, 2).toString());
				if (model.getValueAt(row, 3) == "Nam")
					rad_Nam.setSelected(true);
				else
					rad_Nu.setSelected(true);
				txt_Tuoi.setText(model.getValueAt(row, 4).toString());

				txt_TienLuong.setText(model.getValueAt(row, 5).toString());
			}
		});

		this.add(pnl_Title, BorderLayout.NORTH);
		this.add(pnl_Center);
		this.add(split, BorderLayout.SOUTH);

	}

	public static void main(String[] args) {
		new GUIQuanLyNhanVien().setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btn_Them)) {
			if (txt_MaNv.getText().equals("") || txt_Ho.getText().equals("") || txt_TenNV.getText().equals("")
					|| txt_Tuoi.getText().equals("") || txt_TienLuong.getText().equals("")
					|| (rad_Nam.isSelected() == false && rad_Nu.isSelected() == false) == true)
				JOptionPane.showConfirmDialog(this, "Phải nhập đủ dữ liệu!");
			else {
				String ma = txt_MaNv.getText();
				String ho = txt_Ho.getText();
				String ten = txt_TenNV.getText();
				int tuoi = Integer.parseInt(txt_Tuoi.getText());
				boolean gioiTinh = rad_Nam.isSelected();
				double luong = Double.parseDouble(txt_TienLuong.getText());
				NhanVien nv = null;
				try {
					nv = new NhanVien(ma, ho, ten, tuoi, gioiTinh, luong);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(this, e1.getMessage());
				}
				if (dsNV.them(nv)) {
					model.addRow(new Object[] { ma, ho, ten, gioiTinh ? "Nam" : "Nữ", tuoi, luong });
					xoaTrang();
				} else
					JOptionPane.showMessageDialog(this, "Nhân viên đã tồn tại!");

			}
		} else if (o.equals(btn_XoaTrang)) {
			xoaTrang();
		} else if (o.equals(btn_Xoa)) {
			if (table.getSelectedRow() == -1)
				JOptionPane.showMessageDialog(this, "Phải chọn dòng cần xóa!!");
			else {
				if (JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa dòng này không?", "Cảnh báo",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					int[] selectedRows = table.getSelectedRows();
					for (int i = selectedRows.length - 1; i >= 0; i--) {
					    int selectedRow = selectedRows[i];
					    dsNV.xoaNhanVien(new NhanVien(model.getValueAt(selectedRow, 0).toString()));
					    // xóa hàng tương ứng trong JTable
					    ((DefaultTableModel) table.getModel()).removeRow(selectedRow);
					}
				}

			}
		} else if (o.equals(btn_Luu)) {
			try {
				StoreData stData = new StoreData();
				if (stData.saveFile(dsNV, "data\\DanhSachNhanVien.txt")) {
					JOptionPane.showMessageDialog(this, "Lưu thông tin nhân viên thành công!");
				} else {
					JOptionPane.showMessageDialog(this, "Lưu thông tin nhân viên thất bại!");
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

		else if (o.equals(btn_timKiem)) {
			timTheoMaNV();
		}

		else if (o.equals(btn_Sua)) {
			if (table.getSelectedRow() == -1)
				JOptionPane.showMessageDialog(this, "Phải chọn dòng cần sửa!!");
			else {
				String ma = txt_MaNv.getText();
				String ho = txt_Ho.getText();
				String ten = txt_TenNV.getText();
				int tuoi = Integer.parseInt(txt_Tuoi.getText());
				boolean gioiTinh = rad_Nam.isSelected();
				double luong = Double.parseDouble(txt_TienLuong.getText());
				try {
					NhanVien nv = new NhanVien(ma, ho, ten, tuoi, gioiTinh, luong);
					dsNV.updateNhanVien(nv);
					xoaHetDuLieu();
					themDuLieuVaoBang(dsNV.getList(), model);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}
	}

	private void timTheoMaNV() {
		String str = txt_timKiem.getText();
		if (str != null && str.trim().equals("") == false) {
			NhanVien nv1 = dsNV.timKiem(str);
			if (nv1 != null) {
				xoaHetDuLieu();
				model.addRow(new Object[] { nv1.getMaNV(), nv1.getHoNV(), nv1.getTenNV(), nv1.getTuoiNV(),
						nv1.isPhai() ? "Nam" : "Nữ", nv1.getTienLuong() });
				txt_timKiem.setText("");
			} else {
				JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên!");
				return;
			}
		} else {
			
//			JOptionPane.showMessageDialog(this, "Chưa nhập mã nhân viên cần tìm kiếm");
//			txt_timKiem.requestFocus();
			themDuLieuVaoBang(dsNV.getList(), model);
		}
	}

	private void xoaHetDuLieu() {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		dm.getDataVector().removeAllElements();
	}
	
	

	public void xoaTrang() {
		this.txt_MaNv.setText("");
		this.txt_Ho.setText("");
		this.txt_TenNV.setText("");
		this.txt_Tuoi.setText("");
		this.txt_TienLuong.setText("");

	}

	public void themDuLieuVaoBang(ArrayList<NhanVien> lst, DefaultTableModel tblModel) {
		for (NhanVien nhanVien : lst) {
			model.addRow(nhanVien.getRow());
		}
	}

	public void taoBang() {
		JPanel pnl_Table = new JPanel();
		model = new DefaultTableModel();
		table = new JTable(model);
		model.addColumn("Mã nhân viên");
		model.addColumn("Họ");
		model.addColumn("Tên");
		model.addColumn("Phái");
		model.addColumn("Tuổi");
		model.addColumn("Tiền lương");
		TableColumn c_Phai = table.getColumnModel().getColumn(3);
		comboBox = new JComboBox();
		comboBox.addItem("Nam");
		comboBox.addItem("Nữ");

		// =====================Load dữ liệu và bảng======================
		StoreData stData = new StoreData();
		try {
			dsNV = (DanhSachNhanVien) stData.loadFile("data\\DanhSachNhanVien.txt");
			themDuLieuVaoBang(dsNV.getList(), model);

		} catch (Exception e1) {
			// TODO: handle exception
			e1.printStackTrace();
		}

		c_Phai.setCellEditor(new DefaultCellEditor(comboBox));
		TableColumn column = new TableColumn();
		column.setPreferredWidth(100);
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		DefaultTableCellRenderer xcenter = new DefaultTableCellRenderer();
		xcenter.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

		table.getColumnModel().getColumn(0).setCellRenderer(xcenter);
		table.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);

		JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setPreferredSize(new Dimension(650, 250));
		pnl_Center.add(sp);
	}
}
