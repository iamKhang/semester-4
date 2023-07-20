package tuan06_24_OnJDBCGiuaKi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class GUI extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtCountry, txtCapital, txtPopulation;
	private JLabel lblCountry, lblCapital, lblPopulation, lbldDemocracy;
	private JComboBox cboDemocracy;
	private ListCountry list = new ListCountry();
	private JTable table;
	private DefaultTableModel model;
	private JPanel pnlCenter;
	private JButton btnAdd, btnClear, btnUpdate, btnDelate, btnSearch;
	
	public GUI() {
		setTitle("Kiem tra giua ki");
		setSize(800,700);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel pnlTitle = new JPanel();
		JLabel lblTitle = new JLabel("Kiem tra giua ki");
		pnlTitle.add(lblTitle);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
		lblTitle.setForeground(Color.blue);
		
		pnlCenter = new JPanel();
		pnlCenter.setLayout(new BoxLayout(pnlCenter, BoxLayout.Y_AXIS));
		Box boxNhap = Box.createVerticalBox();
		Box boxCountry = Box.createHorizontalBox();
		Box boxCapital = Box.createHorizontalBox();
		Box boxPopulation = Box.createHorizontalBox();
		Box boxDemocrecy = Box.createHorizontalBox();
		
		boxCountry.add(lblCountry = new JLabel("Enter country:"));
		boxCountry.add(txtCountry = new JTextField());
		
		boxCapital.add(lblCapital = new JLabel("Enter capital:"));
		boxCapital.add(txtCapital = new JTextField());
		
		boxPopulation.add(lblPopulation = new JLabel("Enter population:"));
		boxPopulation.add(txtPopulation = new JTextField());
		
		boxDemocrecy.add(lbldDemocracy = new JLabel("Select democracy:"));
		cboDemocracy = new JComboBox<>();
		cboDemocracy.addItem("True");
		cboDemocracy.addItem("False");
		boxDemocrecy.add(cboDemocracy);
		
		Dimension dms = new Dimension(150, 30);
		lblCountry.setPreferredSize(dms);
		lblCapital.setPreferredSize(dms);
		lblPopulation.setPreferredSize(dms);
		lbldDemocracy.setPreferredSize(dms);
		
		boxNhap.add(boxCountry);
		boxNhap.add(boxCapital);
		boxNhap.add(boxPopulation);
		boxNhap.add(boxDemocrecy);
		
		pnlCenter.add(boxNhap);
		createTable();
		
		JPanel pnlChucNang = new JPanel();
		pnlChucNang.add(btnAdd = new JButton("Add"));
		pnlChucNang.add(btnClear = new JButton("Clear"));
		pnlChucNang.add(btnUpdate = new JButton("Update"));
		pnlChucNang.add(btnDelate = new JButton("Delete"));
		pnlChucNang.add(btnSearch = new JButton("Search"));
		
		btnAdd.addActionListener(this);
		btnClear.addActionListener(this);;
		
		this.add(pnlTitle, BorderLayout.NORTH);
		this.add(pnlCenter);
		this.add(pnlChucNang, BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) {
		new GUI().setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj == btnAdd) {
			themCountry();
			updateTable();
		}
		else if(obj == btnClear) {
			clear();
		}
		
	}
	
	public void createTable() {
		JPanel pnlTable = new JPanel();
		model = new DefaultTableModel();
		table = new JTable(model);
		model.addColumn("Country");
		model.addColumn("Capital");
		model.addColumn("Population");
		model.addColumn("Democracy");
		JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnlTable.add(sp);
		pnlCenter.add(sp);
	}
	
	public void clear() {
		txtCountry.setText("");
		txtCapital.setText("");
		txtPopulation.setText("");
	}
	
	public void updateTable() {
		model.setRowCount(0);
		for (Country c : list.getList()) {
			model.addRow(c.getRow());
		}
	}
	
	public void themCountry() {
		String country = txtCountry.getText();
		String capital = txtCapital.getText();
		int population = Integer.parseInt(txtPopulation.getText());
		boolean democracy;
		if(cboDemocracy.getSelectedItem().toString().equals("True"))
			democracy = true;
		else democracy = false;
		Country c = new Country(country, capital, population, democracy);
		list.addCountry(c);
	}
	
}
