package tuan04_24_JTreeQuanLyPhongBan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

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

public class GUI_PhongBan extends JFrame {

	private PhongBan phongBan;
	private DefaultTableModel model;
	private JTextField txt_MaNv, txt_TenNV, txt_Ho, txt_Tuoi, txt_TienLuong;
	private JRadioButton rad_Nam, rad_Nu;
	private JPanel pnl_Center;
	private JTable table;
	private JComboBox comboBox;

	public GUI_PhongBan(PhongBan phongBan) {
		// TODO Auto-generated constructor stub
		setTitle(phongBan.getTenPhongBan());
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
		
//		themDuLieuVaoBang(phongBan.getDsNhanVien().getDsNhanVien());

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

	public void themDuLieuVaoBang(ArrayList<NhanVien> list) {
		for (NhanVien nhanVien : list) {
			model.addRow(nhanVien.getRow());
		}
	}
}
