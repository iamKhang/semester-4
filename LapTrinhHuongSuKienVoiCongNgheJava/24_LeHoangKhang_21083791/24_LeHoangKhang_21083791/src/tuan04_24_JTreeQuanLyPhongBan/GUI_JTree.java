package tuan04_24_JTreeQuanLyPhongBan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class GUI_JTree extends JFrame implements MouseListener {
	private JTree jtree;
	private DanhSachPhongBan dsPhongBan;
	private DefaultMutableTreeNode root;

	public GUI_JTree() {
		// TODO Auto-generated constructor stub
		setTitle("^_^");
		setSize(500, 450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		dsPhongBan = new DanhSachPhongBan();
		PhongBan phongToChuc = new PhongBan("001", "Phòng tổ chức");
		PhongBan phongKiThuat = new PhongBan("002", "Phòng kĩ thuật");

		try {
			NhanVien nv1 = new NhanVien("001", "Lê Hoàng", "Khang", 21, true, 2000);
			NhanVien nv2 = new NhanVien("002", "Nguyễn Văn", "A", 21, true, 2000);
			NhanVien nv3 = new NhanVien("003", "Trần Văn", "C", 21, true, 2000);
			NhanVien nv4 = new NhanVien("004", "Tống Nhi Phương", "Trúc", 21, false, 2000);
			NhanVien nv5 = new NhanVien("005", "Nguyễn Thanh", "Cảnh", 21, true, 2000);
			NhanVien nv6 = new NhanVien("006", "Trần Đình", "Kiên", 21, true, 2000);
			NhanVien nv7 = new NhanVien("007", "Hồ Thị Như", "Tâm", 21, false, 200);

			phongToChuc.getDsNhanVien().themNhanVien(nv1);
			phongToChuc.getDsNhanVien().themNhanVien(nv2);
			phongToChuc.getDsNhanVien().themNhanVien(nv3);
			phongKiThuat.getDsNhanVien().themNhanVien(nv4);
			phongKiThuat.getDsNhanVien().themNhanVien(nv5);
			phongKiThuat.getDsNhanVien().themNhanVien(nv6);
			phongKiThuat.getDsNhanVien().themNhanVien(nv7);

		} catch (Exception e) {
			// TODO: handle exception
		}

		dsPhongBan.themPhongBan(phongToChuc);
		dsPhongBan.themPhongBan(phongKiThuat);

		root = new DefaultMutableTreeNode("Danh sách phòng ban");
		for (PhongBan phongBan : dsPhongBan.getDsPhongBan()) {
			root.add(new DefaultMutableTreeNode(phongBan));
		}

		for (int i = 0; i < root.getChildCount(); i++) {
			PhongBan temp = (PhongBan) ((DefaultMutableTreeNode) (root.getChildAt(i))).getUserObject();
			DanhSachNhanVien dsTemp = temp.getDsNhanVien();
			for (NhanVien nhanVien : dsTemp.getDsNhanVien()) {
				((DefaultMutableTreeNode) root.getChildAt(i)).add(new DefaultMutableTreeNode(nhanVien));
			}
		}

		jtree = new JTree(root);

		jtree.expandPath(new TreePath(jtree.getModel().getRoot()));
		jtree.addMouseListener(this);

		this.add(jtree);

	}

	public static void main(String[] args) {
		new GUI_JTree().setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object obj = jtree.getSelectionPath().getLastPathComponent();
		DefaultMutableTreeNode dmt = (DefaultMutableTreeNode) obj;
		if (e.getClickCount() == 2) {
			if (dmt.getLevel() == 1) {
				new GUI_PhongBan((PhongBan) (((DefaultMutableTreeNode) obj).getUserObject())).setVisible(true);
			}
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

}
