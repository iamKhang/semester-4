package tuan04_24_QuanLySachDefaultTable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class GUI_QuanLySach extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame = this;
	private JTextField txtMaSach, txtTuaSach, txtTacGia, txtNamXuatBan, txtNhaXuatBan, txtSoTrang, txtDonGia, txtISBN;
	private JPanel pnl_ThongTin;
	private JButton btnThem;
	private JButton btnXoaRong;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnLuu;
	private JComboBox<String> cboMaSach;
	private JButton btnLoc;
	private DefaultTableModel model;
	private JTable table;
	private JPanel pnl_South;
	private JPanel pnl_Center;
	private DanhSachSach dsSach = new DanhSachSach();
	private DanhSachSach dsTim = new DanhSachSach();

	public GUI_QuanLySach() {
		setTitle("Quản lý sách");
		setSize(800, 580);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		pnl_ThongTin = new JPanel();
		pnl_ThongTin.setLayout(new BoxLayout(pnl_ThongTin, BoxLayout.Y_AXIS));
		Box bThongTin = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();
		Box b4 = Box.createHorizontalBox();
		Box b5 = Box.createHorizontalBox();

		bThongTin.add(b1);
		bThongTin.add(Box.createVerticalStrut(5));
		bThongTin.add(b2);
		bThongTin.add(Box.createVerticalStrut(5));
		bThongTin.add(b3);
		bThongTin.add(Box.createVerticalStrut(5));
		bThongTin.add(b4);
		bThongTin.add(Box.createVerticalStrut(5));
		bThongTin.add(b5);
		bThongTin.add(Box.createVerticalStrut(5));

		Box bMaSach, bTuaSach, bTacGia, bNamXuatBan, bNhaXuatBan, bSoTrang, bDonGia, bISBN;
		bMaSach = Box.createHorizontalBox();
		bTuaSach = Box.createHorizontalBox();
		bTacGia = Box.createHorizontalBox();
		bNamXuatBan = Box.createHorizontalBox();
		bNhaXuatBan = Box.createHorizontalBox();
		bSoTrang = Box.createHorizontalBox();
		bDonGia = Box.createHorizontalBox();
		bISBN = Box.createHorizontalBox();

		JLabel lblMaSach = new JLabel("   Mã sách:");
		JLabel lblTuaSach = new JLabel("   Tựa sách:");
		JLabel lblTacGia = new JLabel("   Tác giả:");
		JLabel lblNamXuatBan = new JLabel("   Năm xuất bản:");
		JLabel lblNhaXuatBan = new JLabel("   Nhà xuất bản:");
		JLabel lblSoTrang = new JLabel("   Số trang:");
		JLabel lblDonGia = new JLabel("   Đơn giá:");
		JLabel lblISBN = new JLabel("   International Standard Book Number (ISBN):");

		Dimension dm = new Dimension(100, 10);
		lblMaSach.setPreferredSize(dm);
		lblTuaSach.setPreferredSize(dm);
		lblNamXuatBan.setPreferredSize(dm);
		lblSoTrang.setPreferredSize(dm);
		lblDonGia.setPreferredSize(dm);
		lblTacGia.setPreferredSize(dm);
		lblNhaXuatBan.setPreferredSize(dm);

		bMaSach.add(lblMaSach);
		bMaSach.add(txtMaSach = new JTextField());

		txtMaSach.setSize(50, 30);

		bTuaSach.add(lblTuaSach);
		bTuaSach.add(txtTuaSach = new JTextField());

		bTacGia.add(lblTacGia);
		bTacGia.add(txtTacGia = new JTextField());

		bNamXuatBan.add(lblNamXuatBan);
		bNamXuatBan.add(txtNamXuatBan = new JTextField());

		bNhaXuatBan.add(lblNhaXuatBan);
		bNhaXuatBan.add(txtNhaXuatBan = new JTextField());

		bSoTrang.add(lblSoTrang);
		bSoTrang.add(txtSoTrang = new JTextField());

		bDonGia.add(lblDonGia);
		bDonGia.add(txtDonGia = new JTextField());

		b5.add(lblISBN);
		b5.add(txtISBN = new JTextField());

		b1.add(bMaSach);
		b2.add(bTuaSach);
		b2.add(bTacGia);
		b3.add(bNamXuatBan);
		b3.add(bNhaXuatBan);
		b4.add(bSoTrang);
		b4.add(bDonGia);
		b5.add(bISBN);

		pnl_ThongTin.add(bThongTin);
		pnl_ThongTin.setBorder(BorderFactory.createTitledBorder("Records Editor"));

		JPanel pnl_ChucNang = new JPanel();
		pnl_ChucNang.add(btnThem = new JButton("Thêm"));
		pnl_ChucNang.add(btnXoaRong = new JButton("Xóa rỗng"));
		pnl_ChucNang.add(btnXoa = new JButton("Xóa"));
		pnl_ChucNang.add(btnSua = new JButton("Sửa"));
		pnl_ChucNang.add(btnLuu = new JButton("Lưu"));
		pnl_ChucNang.add(Box.createHorizontalStrut(40));
		pnl_ChucNang.add(new JLabel("Tìm theo mã sách: "));
		pnl_ChucNang.add(cboMaSach = new JComboBox<String>());
		cboMaSach.setPreferredSize(new Dimension(100, 25));
		pnl_ChucNang.add(btnLoc = new JButton("Lọc theo tựa sách"));

		pnl_Center = new JPanel(new BorderLayout());
		pnl_Center.add(pnl_ChucNang, BorderLayout.NORTH);

		taoBang();
		themSuKien();

		this.add(pnl_ThongTin, BorderLayout.NORTH);
		this.add(pnl_Center, BorderLayout.CENTER);

	}


	private void updateComboboxData(ArrayList<Sach> list) {
		int n = list.size();
		String[] items = new String[n];
		int i = 0;
		for (Sach s : list) {
			items[i] = s.getMaSach();
			i++;
		}
		cboMaSach.setModel(new DefaultComboBoxModel<String>(items));
	}

	private void updateTableData() {
		table.setModel(model);

	}

	/**
	 * 
	 */
	public void taoBang() {
		JPanel pnl_Table = new JPanel(new BorderLayout());
		pnl_Table.setBorder(BorderFactory.createTitledBorder("Danh sách các cuốn sách"));
		model = new DefaultTableModel();
		table = new JTable(model);
		model.addColumn("Mã sách");
		model.addColumn("Tựa sách");
		model.addColumn("Tác giả");
		model.addColumn("Năm xuất bản");
		model.addColumn("Nhà xuất bản");
		model.addColumn("Số trang");
		model.addColumn("Đơn giá");
		model.addColumn("ISBN");

		try {
			dsSach = new DanhSachSach(LuuTru.docTuFile());
			themDuLieuVaoBang(dsSach.getDsSach());

		} catch (Exception e1) {
			// TODO: handle exception
			e1.printStackTrace();
		}

		pnl_Table.add(new JScrollPane(table), BorderLayout.CENTER);
		pnl_Center.add(pnl_Table, BorderLayout.CENTER);
	}

	public void themSuKien() {

		btnXoaRong.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xoaTrang();

			}
		});

		btnThem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (valiData() == true) {
					Sach s = revertSachFromTextfields();
					if (dsSach.themSach(s)) {
						themDuLieuVaoBang(dsSach.getDsSach());
					} else {
						JOptionPane.showMessageDialog(frame, "Sách bị trùng");
					}

				} else
					JOptionPane.showMessageDialog(frame, "Phải nhập đủ thông tin!");
			}
		});

		btnXoa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				if (row != -1) {
					if (JOptionPane.showConfirmDialog(frame, "Bạn có muốn xóa dòng này không?", "Cảnh báo",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						if (dsSach.xoaSach(row)) {
							JOptionPane.showMessageDialog(frame, "Đã xóa thành công!");
							updateTableData();
							updateComboboxData(dsSach.getDsSach());
							themDuLieuVaoBang(dsSach.getDsSach());
						}
					}
				} else
					JOptionPane.showMessageDialog(frame, "Phải chọn sách cần xóa");
			}
		});

		btnLuu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LuuTru.ghiXuongFile(dsSach.getDsSach());
				JOptionPane.showMessageDialog(frame, "Lưu thành công!");

			}
		});

		btnLoc.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String regex = JOptionPane.showInputDialog("Nhập tựa sách cần lọc: ");
				if(regex != null && !regex.trim().equals("")){
					dsTim = new DanhSachSach();
					dsTim = locSachTheoTuaSach(regex);
					if (dsTim.getDsSach()!=null) {
						themDuLieuVaoBang(dsTim.getDsSach());
						updateComboboxData(dsTim.getDsSach());
					}
				}else
					if (regex.trim().equals("")) {
						themDuLieuVaoBang(dsSach.getDsSach());
						updateComboboxData(dsSach.getDsSach());
					}
			}
		});

		cboMaSach.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String maSach = (String) cboMaSach.getSelectedItem();
				int rowCount = table.getRowCount();
				for (int row = 0; row < rowCount; row++) {
				    if (model.getValueAt(row, 0).toString().equals(maSach)) {
				    	fillForm(row);
				        table.setRowSelectionInterval(row, row);
				        table.setSelectionBackground(Color.orange);
				    }
				}
			}
		});

		btnSua.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Sach s = revertSachFromTextfields();
				dsSach.suaSach(s);
				model.setRowCount(0);
				themDuLieuVaoBang(dsSach.getDsSach());

			}
		});

		btnLuu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LuuTru.ghiXuongFile(dsSach.getDsSach());
			}
		});

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
				txtMaSach.setText(model.getValueAt(row, 0).toString());
				txtMaSach.setEditable(false);
				txtTuaSach.setText(model.getValueAt(row, 1).toString());
				txtTacGia.setText(model.getValueAt(row, 2).toString());
				txtNamXuatBan.setText(model.getValueAt(row, 3).toString());
				txtNhaXuatBan.setText(model.getValueAt(row, 4).toString());
				txtSoTrang.setText(model.getValueAt(row, 5).toString());
				txtDonGia.setText(model.getValueAt(row, 6).toString());
				txtISBN.setText(model.getValueAt(row, 7).toString());
			}
		});

	}

	private Sach revertSachFromTextfields() {
		String maSach = txtMaSach.getText().trim();
		String tuaSach = txtTuaSach.getText().trim();
		String tacGia = txtTacGia.getText().trim();
		String nam = txtNamXuatBan.getText().trim();
		int namXB = nam.length() == 0 ? 0 : Integer.parseInt(nam);
		String nhaXB = txtNhaXuatBan.getText().trim();
		String trang = txtSoTrang.getText().trim();
		int soTrang = trang.length() == 0 ? 0 : Integer.parseInt(trang);
		String gia = txtDonGia.getText().trim();
		double donGia = gia.equals("") ? 0 : Double.parseDouble(gia);
		String isbn = txtISBN.getText().trim();
		return new Sach(maSach, tuaSach, tacGia, namXB, nhaXB, soTrang, donGia, isbn);
	}

	private void xoaTrang() {
		txtMaSach.setText("");
		txtMaSach.setEditable(true);
		txtDonGia.setText("");
		txtISBN.setText("");
		txtNhaXuatBan.setText("");
		txtNamXuatBan.setText("");
		txtTuaSach.setText("");
		txtSoTrang.setText("");
		txtTacGia.setText("");
	}

	public void themDuLieuVaoBang(ArrayList<Sach> list) {
		model.setRowCount(0);
		for (Sach sach : list) {
			model.addRow(sach.getRow());
		}
		updateComboboxData(dsSach.getDsSach());
	}

	public static void main(String[] args) {
		new GUI_QuanLySach().setVisible(true);
	}
	
	private void fillForm(int row) {
		if (row!=-1) {
			String maSach = table.getValueAt(row, 0).toString();
			Sach sach = new Sach(maSach);
//			ArrayList<Sach> list = dsSach.getDsSach();
			if(dsSach.getDsSach().contains(sach)) {
				sach = dsSach.getDsSach().get(dsSach.getDsSach().indexOf(sach));
				txtMaSach.setText(sach.getMaSach());
				txtTuaSach.setText(sach.getTuaSach());
				txtTacGia.setText(sach.getTacGia());
				txtNhaXuatBan.setText(sach.getNhaXuatBan());
				txtNamXuatBan.setText(sach.getNamXuatBan()+"");
				txtSoTrang.setText(sach.getSoTrang()+"");
				txtDonGia.setText(sach.getDonGia()+"");
				txtISBN.setText(sach.getIsbn());
				txtMaSach.setEditable(false);
				
			}
		}
	}
	
	public DanhSachSach locSachTheoTuaSach(String regex) {
	    DanhSachSach dsTim = new DanhSachSach();
	    Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
	    for (Sach sach : dsSach.getDsSach()) {
	        Matcher matcher = pattern.matcher(sach.getTuaSach());
	        if (matcher.find()) {
	            dsTim.themSach(sach);
	        }
	    }
	    return dsTim;
	}
	
	public boolean valiData() {
		String ma = txtMaSach.getText().trim();
		String ten = txtTuaSach.getText().trim();
		String tacGia = txtTacGia.getText().trim();
		String namXuatBan = txtNamXuatBan.getText().trim();
		String nhaXuatBan = txtNhaXuatBan.getText().trim();
		String soTrang = txtSoTrang.getText().trim();
		String donGia = txtDonGia.getText().trim();
		String isbn = txtISBN.getText().trim();
		
		//Kiểm tra rỗng
		if(ma.length()==0||ten.length()==0||tacGia.length()==0||namXuatBan.length()==0||nhaXuatBan.length()==0||soTrang.length()==0||donGia.length()==0||isbn.length()==0)
			JOptionPane.showMessageDialog(this, "Phải nhập đủ thông tin tất cả các trường");
		//Mã tựa sách gồm 1 chữ cái và 3 chữ số
		if(!ma.matches("[A-Z]\\d{3}")) {
			JOptionPane.showMessageDialog(this, "Mã sách phải có cấu trúc là Axxx (A là chữ cái in hoa, x là 1 sô)");
			return false;
		}
		if(!ten.matches("[a-zA-Z' ]")) {
			JOptionPane.showMessageDialog(this, "Tựa sách chỉ gồm chữ dấu ' và khoảng trắng");
			return false;
		}
		if(!ten.matches("[a-zA-Z' ]")) {
			JOptionPane.showMessageDialog(this, "Tên tác giả chỉ gồm chữ dấu ' và khoảng trắng");
			return false;
		}
		try {
			int x = Integer.parseInt(namXuatBan);
			if(x<0) {
				JOptionPane.showMessageDialog(this, "Năm phải là số nguyên dương");
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Năm xuất bản phải nhập số");
			return false;
		}
		try {
			int x = Integer.parseInt(soTrang);
			if(x<0) {
				JOptionPane.showMessageDialog(this, "Số trang phải là số nguyên dương");
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Số trang phải nhập số nguyên dương");
			return false;
		}
		try {
			double x = Double.parseDouble(donGia);
			if(x<0) {
				JOptionPane.showMessageDialog(this, "Giá phải là số nguyên dương");
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Giá phải nhập số nguyên dương");
			return false;
		}
		if (!isbn.matches("\\d+(-\\d+){3,4}")) {
			JOptionPane.showMessageDialog(this, "Mẫu có dạng X-X-X-X hoặc X-X-X-X-X");
			return false;
		}	
		return true;
	}

}
