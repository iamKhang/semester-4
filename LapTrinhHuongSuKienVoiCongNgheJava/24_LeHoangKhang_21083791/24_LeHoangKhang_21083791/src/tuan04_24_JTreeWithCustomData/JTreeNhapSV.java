package tuan04_24_JTreeWithCustomData;

import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;

public class JTreeNhapSV extends JFrame implements ActionListener,
		TreeSelectionListener {
	JButton btnAdd, btnRemove;
	JTextField txt1, txt2, txt3;
	JCheckBox chkGT;
	JComboBox cboML;

	// tree
	JTree tree;
	DefaultTreeModel treemodel;
	
	DSLop dsLop;

	public JTreeNhapSV() {
		super("Danh sach sinh vien");

		// tao cay
		DefaultMutableTreeNode root = createTree();
		treemodel = new DefaultTreeModel(root);
		tree = new JTree(treemodel);
		JScrollPane scrollTree = new JScrollPane(tree);
		
		tree.addTreeSelectionListener(this);

		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p4 = new JPanel();
		p1.add(new JLabel("Ma SV:"));
		p1.add(txt1 = new JTextField(10));
		p2.add(new JLabel("Ho ten:"));
		p2.add(txt2 = new JTextField(10));
		p3.add(new JLabel("Gioi tinh:"));
		p3.add(chkGT = new JCheckBox("Nam"));
		p4.add(btnAdd = new JButton("Them"));
		p4.add(btnRemove = new JButton("Xoa"));

		Box b = Box.createVerticalBox();
		b.add(p1);
		b.add(p2);
		b.add(p3);
		b.add(p4);
		JPanel p = new JPanel();
		p.add(b);

		JSplitPane sp = new JSplitPane();
		sp.setLeftComponent(scrollTree);
		sp.setRightComponent(p);
		add(sp);
		sp.setResizeWeight(0.6);

		txt1.addActionListener(this);
		btnAdd.addActionListener(this);
		btnRemove.addActionListener(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 320);
		setLocationRelativeTo(null);

	}

	private DefaultMutableTreeNode createTree() {
		dsLop = new DSLop();
		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("DS Lop");
		
		Lop l = new Lop("CDTH6K", "Cao dang tin hoc 6K", 58);
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(l);
		root.add(node);
		dsLop.addLop(l);
		
		l = new Lop("CDTH7K", "Cao dang tin hoc 7K", 90);
		node = new DefaultMutableTreeNode(l);
		root.add(node);
		dsLop.addLop(l);
		
		l = new Lop("CDTH8K", "Cao dang tin hoc 8K", 50);
		node = new DefaultMutableTreeNode(l);
		root.add(node);
		dsLop.addLop(l);
		
		return root;
	}

	public void addSV() {
		// kiem tra xem co nhap lieu het chua
		if (txt1.getText().equals("")) { // ||...
			JOptionPane.showMessageDialog(this, "Please input name!");
			return;
		}
		// kiem tra co chon lop chua
		DefaultMutableTreeNode selectedNode = 
			(DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
		if (selectedNode == null) {
			JOptionPane.showMessageDialog(this, "Chua chon ma lop!");
			return;
		}
		// kiem tra khong duoc chon nut goc hoac nut sinh vien??

		// kiem tra co trung khoa khong
		if (TrungKhoa(txt1.getText(), selectedNode)) {
			JOptionPane.showMessageDialog(this, "Khong nhap trung ma sv");
			return;
		}

		// du lieu hop le thi them vao cay
		String msv, ht;
		boolean gt;

		msv = txt1.getText();
		ht = txt2.getText();
		gt = chkGT.isSelected();
		SinhVien sv;
		sv = new SinhVien(msv, ht, gt);

		addNode(selectedNode, sv);
		
		
		// add to collection
		int index = ((DefaultMutableTreeNode) treemodel.getRoot())
				.getIndex(selectedNode);
		dsLop.getElement(index).addSinhVien(sv);

	}

	public void deleteSV() {
		// khong duoc xoa nut lop
		// phai hoi truoc khi xoa nut
		DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree
				.getLastSelectedPathComponent();
		if (selectedNode == null)
			JOptionPane.showMessageDialog(null, "Phải chọn trước khi xóa");
		else if (selectedNode.getLevel() == 0 || selectedNode.getLevel() == 1)
			JOptionPane.showMessageDialog(null, "Khong duoc xoa nut nay");
		else {
			treemodel.removeNodeFromParent((DefaultMutableTreeNode) tree
					.getLastSelectedPathComponent());
		}
	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnAdd) || o.equals(txt1)) {
			addSV();
		} else if (o.equals(btnRemove)) {
			deleteSV();
		}
	}

	public void addNode(DefaultMutableTreeNode selectedNode, SinhVien sv) {
		DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(sv);
		treemodel.insertNodeInto(newNode, selectedNode, selectedNode.getChildCount());

		// now display new node
		TreeNode[] nodes = treemodel.getPathToRoot(newNode);
		TreePath path = new TreePath(nodes);
		tree.scrollPathToVisible(path);

	}

	public void valueChanged(TreeSelectionEvent event) {
		DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree
				.getLastSelectedPathComponent();
		// kiem tra xem co chon nut hay khong
		if (selectedNode == null)
			return;
		// kiem tra xem co phai chon nut goc khong
		if (selectedNode.getLevel() == 0)
			return;
		// kiem tra xem co phai chon nut ma lop khong
		if (selectedNode.getLevel() == 1)
			return;
		else {
			// chon hop le
			SinhVien sv = (SinhVien) selectedNode.getUserObject();
			txt1.setText(sv.getMaSV());
			txt2.setText(sv.getHoTen());
		}
	}

	// Trung: ham tra ve true, nguoc lai tra ve false
	public boolean TrungKhoa(String masv, DefaultMutableTreeNode nodeLop) {
		Enumeration e = nodeLop.breadthFirstEnumeration();
		e.nextElement();
		while (e.hasMoreElements()) {
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) e
					.nextElement();
			// process node
			SinhVien sv = (SinhVien) node.getUserObject();
			if (sv.getMaSV().equals(masv))
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		new JTreeNhapSV().setVisible(true);;
	}
}
