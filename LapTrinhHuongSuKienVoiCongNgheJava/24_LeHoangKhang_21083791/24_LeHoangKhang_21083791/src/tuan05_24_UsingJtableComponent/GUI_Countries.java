package tuan05_24_UsingJtableComponent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class GUI_Countries extends JFrame implements ActionListener {
	private JPanel pnlTitle;
	private JLabel lblTitle;
	private JPanel pnlCenter;
	private JPanel pnlThongTin;
	private JTextField txtCountry;
	private JTextField txtCapital;
	private JTextField txtPopulation;
	private JTextField txtDemocracy;
	private JComboBox cboDemocracy;
	private DefaultTableModel model;
	private JTable table;
	private JComboBox cbo;
	private JButton btnAdd;
	private JButton btnClear;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnSearch;
	private JPanel pnlChucNang;
	private ListCountry list = new ListCountry();

	public GUI_Countries() {
		setTitle("Quản lý các quốc gia");
		setSize(700, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		pnlTitle = new JPanel();
		lblTitle = new JLabel("Using Jtable Component");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 25));
		lblTitle.setForeground(Color.BLUE);
		pnlTitle.add(lblTitle);

		pnlCenter = new JPanel();
		pnlCenter.setLayout(new BoxLayout(pnlCenter, BoxLayout.Y_AXIS));
		Box bThongTin = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();
		Box b4 = Box.createHorizontalBox();

		JLabel lblCounty = new JLabel("Enter country");
		JLabel lblCapital = new JLabel("Enter capital");
		JLabel lblPopulation = new JLabel("Enter population");
		JLabel lblDemocracy = new JLabel("Enter democracy");
		cbo = new JComboBox<>();
		cbo.addItem("True");
		cbo.addItem("False");

		b1.add(lblCounty);
		b1.add(txtCountry = new JTextField());
		b2.add(lblCapital);
		b2.add(txtCapital = new JTextField());
		b3.add(lblPopulation);
		b3.add(txtPopulation = new JTextField());
		b4.add(lblDemocracy);
		b4.add(cbo);

		Dimension dms = new Dimension(100, 30);
		lblCounty.setPreferredSize(dms);
		lblCapital.setPreferredSize(dms);
		lblPopulation.setPreferredSize(dms);
		lblDemocracy.setPreferredSize(dms);

		bThongTin.add(b1);
		bThongTin.add(Box.createVerticalStrut(5));
		bThongTin.add(b2);
		bThongTin.add(Box.createVerticalStrut(5));
		bThongTin.add(b3);
		bThongTin.add(Box.createVerticalStrut(5));
		bThongTin.add(b4);
		bThongTin.add(Box.createVerticalStrut(5));

		pnlChucNang = new JPanel();
		Box bChucNang = Box.createHorizontalBox();
		btnAdd = new JButton("Add");
		btnClear = new JButton("Clear");
		btnUpdate = new JButton("Update");
		btnDelete = new JButton("Delete");
		btnSearch = new JButton("Search");
		pnlChucNang.add(btnAdd);
		pnlChucNang.add(btnClear);
		pnlChucNang.add(btnUpdate);
		pnlChucNang.add(btnDelete);
		pnlChucNang.add(btnSearch);

		btnAdd.addActionListener(this);
		btnClear.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnSearch.addActionListener(this);

		pnlCenter.add(bThongTin);
		taoBang();
		this.add(pnlTitle, BorderLayout.NORTH);
		this.add(pnlCenter);
		this.add(pnlChucNang, BorderLayout.SOUTH);

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
				txtCountry.setText(table.getValueAt(row, 0).toString());
				txtCapital.setText(table.getValueAt(row, 1).toString());
				txtPopulation.setText(table.getValueAt(row, 2).toString());
				cbo.setSelectedItem(table.getValueAt(row, 3));

			}
		});
	}

	public static void main(String[] args) {
		new GUI_Countries().setVisible(true);
	}

	public void taoBang() {
		model = new DefaultTableModel();
		table = new JTable(model);
		model.addColumn("Country");
		model.addColumn("Capital");
		model.addColumn("Population");
		model.addColumn("Democracy");

		JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		pnlCenter.add(sp);
	}

	public void clear() {
		txtCountry.setText("");
		txtCapital.setText("");
		txtPopulation.setText("");
	}

	public void add() {
		String country = txtCountry.getText();
		String capital = txtCapital.getText();
		double population = Double.parseDouble(txtPopulation.getText());
		boolean democracy = cbo.getSelectedItem().equals("True");

		Country c = new Country(country, capital, population, democracy);
		list.addCountry(c);
		updateTable();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnClear)) {
			clear();
		} else if (o.equals(btnAdd)) {
			add();
		}
	}

	public void updateTable() {
		model.setRowCount(0);
		for (Country c : list.getList()) {
			model.addRow(c.getRow());
		}
	}
}
