package Buoi05;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Buoi05_24_LeHoangKhang_Demo07 extends JFrame implements ActionListener {
	JButton btnAdd, btnRemove, btnEdit;
	JTextField txtName;
	DefaultListModel<String> listmodelName;
	JList listName;

	public Buoi05_24_LeHoangKhang_Demo07() {
		super("List Edit Demo");
		// list
		listmodelName = new DefaultListModel();
		listName = new JList(listmodelName);
		add(new JScrollPane(listName), BorderLayout.CENTER);
		JPanel pRight;
		JPanel pTop, pBottom;
		pTop = new JPanel();
		pTop.add(new JLabel("Input Name"));
		pTop.add(txtName = new JTextField(15));
		pBottom = new JPanel();
		pBottom.add(btnAdd = new JButton("Add Item"));
		pBottom.add(btnRemove = new JButton("Remove Item"));
		pBottom.add(btnEdit = new JButton("Edit Item"));
		pRight = new JPanel(new BorderLayout());
		pRight.add(pTop, BorderLayout.NORTH);
		pRight.add(pBottom, BorderLayout.CENTER);
		add(pRight, BorderLayout.EAST);
		txtName.addActionListener(this);
		btnAdd.addActionListener(this);
		btnRemove.addActionListener(this);
		setSize(500, 320);
	}

	public static void main(String[] args) {
		new Buoi05_24_LeHoangKhang_Demo07().setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o == btnAdd) {
			String name = txtName.getText().trim();
			if (name == "")
				JOptionPane.showMessageDialog(this, "Please input name!");
			else {
				listmodelName.addElement(name);
				txtName.setText("");
			}
		} else if (o.equals(btnRemove))
			listmodelName.removeElement(listName.getSelectedValue());
		else if (o.equals(btnEdit))
			listmodelName.setElementAt(txtName.getText(), listName.getSelectedIndex());
	}

}