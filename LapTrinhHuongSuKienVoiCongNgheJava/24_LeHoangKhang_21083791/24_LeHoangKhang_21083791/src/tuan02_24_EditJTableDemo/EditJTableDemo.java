package tuan02_24_EditJTableDemo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class EditJTableDemo extends JFrame implements ActionListener {
	private DefaultTableModel model;
	private JTable tbl_SV;
	private JTextField txtFirstname;
	private JTextField txtName;
	private JButton btn_Add;
	private JButton btn_Remove;
	private JButton btn_Exit;

	public EditJTableDemo() {
		super("Table Demo");
		String[] cols = {"Ho sinh vien", "Ten sinh vien"};
		model = new DefaultTableModel(cols, 0);
		tbl_SV = new JTable(model);
		JScrollPane pane =  new JScrollPane(tbl_SV);
		JPanel p1 = new JPanel();
		p1.add(new JLabel("Ho"));
		txtFirstname = new JTextField(20);
		p1.add(txtFirstname);
		p1.add(new JLabel("Ten"));
		txtName = new JTextField(20);
		p1.add(txtName);
		
		JPanel p2 = new JPanel();
		btn_Add = new JButton("Them");
		btn_Remove = new JButton("Remove");
		btn_Exit = new JButton("Thoat");
		p2.add(btn_Add);
		p2.add(btn_Remove);
		p2.add(btn_Exit);
		
		JPanel pTop, pBottom;
		pTop = new JPanel();
		add(p1, BorderLayout.NORTH);
		add(pane, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);
		btn_Exit.addActionListener(this);
		btn_Add.addActionListener(this);
		btn_Remove.addActionListener(this);
		setSize(600,420);
		
		
	}
	
	public static void main(String[] args) {
		new EditJTableDemo().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btn_Add)) {
			if(txtName.getText().equals("")||txtFirstname.getText().equals(""))
				JOptionPane.showConfirmDialog(this, "Khong nhap du du lieu");
			else {
				Object[] obj = new Object[2];
					obj[0] = txtFirstname.getText();
					obj[1] = txtName.getText();
					model.addRow(obj);
					this.txtName.setText("");
					this.txtFirstname.setText("");
		
			}
		}
		else if(o.equals(btn_Remove)) {
			if(tbl_SV.getSelectedRow() == -1)
				JOptionPane.showMessageDialog(this, "Phai chon dong can xoa");
			else {
				if(JOptionPane.showConfirmDialog(this, "ban co muon xoa dong nay khong?","Canh bao",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
				model.removeRow(tbl_SV.getSelectedRow());
			}
		}
		
	}
}
