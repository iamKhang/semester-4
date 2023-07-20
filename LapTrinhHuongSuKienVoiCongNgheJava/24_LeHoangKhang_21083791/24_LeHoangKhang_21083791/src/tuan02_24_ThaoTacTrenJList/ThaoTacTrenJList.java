package tuan02_24_ThaoTacTrenJList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class ThaoTacTrenJList extends JFrame {
	private DefaultListModel dfModel;
	private JList<Integer> list;
	private JPanel pnlCenter;
	private JPanel pnlTieuDe;
	private JLabel lblTieuDe;
	private JPanel pnlChonTacVu;
	private JButton btnToDenChan;
	private JButton btnToDenLe;
	private JButton btnToDenSoNguyenTo;
	private JButton btnBoToden;
	private JButton btnXoaCacGiaTriToDen;
	private JButton btnTongGiaTriTrongJlist;
	private JPanel pnlNhapThongTin;
	private JButton btnNhap;
	private JTextField txtNhap;
	private JCheckBox chkChoNhapSoAm;
	private JTextArea txa;
	private JButton btnDongChuongTrinh;

	public ThaoTacTrenJList() {
		setTitle("Thao tác trên JList");
		setSize(600, 450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setResizable(false);

		pnlTieuDe = new JPanel();
		lblTieuDe = new JLabel("Thao tác trên Jlist - Checkbox");
		pnlTieuDe.add(lblTieuDe);
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 25));
		lblTieuDe.setForeground(Color.BLUE);

		pnlChonTacVu = new JPanel();
		pnlChonTacVu.setLayout(new BoxLayout(pnlChonTacVu, BoxLayout.Y_AXIS));
		pnlChonTacVu.setBorder(new TitledBorder(new LineBorder(Color.red), "Chọn tác vụ"));

		btnToDenChan = new JButton("Tô đen số chẵn");
		btnToDenLe = new JButton("Tô đen số lẻ");
		btnToDenSoNguyenTo = new JButton("Tô đen số nguyên tố");
		btnBoToden = new JButton("Bỏ tô đen");
		btnXoaCacGiaTriToDen = new JButton("Xóa các giá trị đang tô đen");
		btnTongGiaTriTrongJlist = new JButton("Tổng các giá trị trong JList");

		pnlChonTacVu.add(btnToDenChan);
		pnlChonTacVu.add(Box.createVerticalStrut(5));
		pnlChonTacVu.add(btnToDenLe);
		pnlChonTacVu.add(Box.createVerticalStrut(5));
		pnlChonTacVu.add(btnToDenSoNguyenTo);
		pnlChonTacVu.add(Box.createVerticalStrut(5));
		pnlChonTacVu.add(btnBoToden);
		pnlChonTacVu.add(Box.createVerticalStrut(5));
		pnlChonTacVu.add(btnXoaCacGiaTriToDen);
		pnlChonTacVu.add(Box.createVerticalStrut(5));
		pnlChonTacVu.add(btnTongGiaTriTrongJlist);
		
		
		
		Box bNhapThongTin = Box.createVerticalBox();
		Box b = Box.createHorizontalBox();
		btnNhap = new JButton("Nhập");
		txtNhap = new JTextField(13);
		chkChoNhapSoAm = new JCheckBox("Cho nhập số âm");
		
		pnlNhapThongTin = new JPanel();
		JPanel pnlTop = new JPanel();
		pnlTop.add(btnNhap);
		pnlTop.add(txa);
		pnlTop.add(chkChoNhapSoAm);
		
		b.add(btnNhap);
		b.add(Box.createHorizontalStrut(5));
		b.add(txtNhap);
		b.add(Box.createHorizontalStrut(5));
		b.add(chkChoNhapSoAm);
		b.setPreferredSize(new Dimension(40, 10));

		bNhapThongTin.add(b);
		bNhapThongTin.setBorder(new TitledBorder(new LineBorder(Color.red), "Nhập thông tin"));
		
		
		//Tạo JList
		dfModel = new DefaultListModel<>();
		list = new JList<Integer>(dfModel);
		Box bList = Box.createHorizontalBox();
		bList.add(new JScrollPane(list,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));
		
		pnlNhapThongTin.add(bList, BorderLayout.CENTER);
		
		//Số dòng hiển thị trong JList
//		list.setVisibleRowCount(10);
//		list.setFixedCellHeight(200);//Độ rộng
//		list.setFixedCellWidth(250);
		
		
		
		
		
		JPanel pnlDongChuongTrinh = new JPanel();
		btnDongChuongTrinh = new JButton("Đóng chương trình");
		pnlDongChuongTrinh.add(btnDongChuongTrinh);
		pnlDongChuongTrinh.setBorder(new TitledBorder(new LineBorder(Color.red)));

		this.add(pnlTieuDe, BorderLayout.NORTH);
		this.add(pnlChonTacVu, BorderLayout.WEST);
		this.add(bNhapThongTin, BorderLayout.CENTER);
		this.add(pnlDongChuongTrinh, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		new ThaoTacTrenJList().setVisible(true);
	}

}
