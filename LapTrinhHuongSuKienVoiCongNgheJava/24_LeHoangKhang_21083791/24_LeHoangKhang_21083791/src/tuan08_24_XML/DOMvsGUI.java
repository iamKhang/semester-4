package tuan08_24_XML;

import java.awt.BorderLayout;
import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class DOMvsGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 6736610855443618564L;

	private DefaultTableModel model;
	private JTable table;
	private ManageProduct dom;
	private JButton btnDelete;
	private JButton btnSave;
	private JButton btnUpdate;
	private JButton btnAdd;
	private TableRowSorter<TableModel> sorter;
	private JButton btnFilter;

	private JTextField txtProductID;

	private JTextField txtProductName;

	private JTextField txtManufacture;

	private JTextField txtDescription;

	private JTextField txtSuplierName;

	private JTextField txtCountry;

	private JTextField txtWebsite;

	private JTextField txtPrice;

	public DOMvsGUI() {
		setTitle("Dom parser");
		setExtendedState(MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(1000, 600));
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel pnl_ThongTin = new JPanel();
		pnl_ThongTin.setLayout(new BoxLayout(pnl_ThongTin, BoxLayout.Y_AXIS));

		// Dòng 1
		JPanel row1 = new JPanel();
		row1.setLayout(new BoxLayout(row1, BoxLayout.X_AXIS));

		JLabel lblProductID = new JLabel("Product ID");
		txtProductID = new JTextField(20);
		row1.add(lblProductID);
		row1.add(Box.createRigidArea(new Dimension(10, 0)));
		row1.add(txtProductID);
		row1.add(Box.createHorizontalGlue());

		JLabel lblProductName = new JLabel("Product Name");
		txtProductName = new JTextField(20);
		row1.add(lblProductName);
		row1.add(Box.createRigidArea(new Dimension(10, 0)));
		row1.add(txtProductName);
		row1.add(Box.createHorizontalGlue());

		JLabel lblManufacture = new JLabel("Manufacture");
		txtManufacture = new JTextField(20);
		row1.add(lblManufacture);
		row1.add(Box.createRigidArea(new Dimension(10, 0)));
		row1.add(txtManufacture);
		row1.add(Box.createHorizontalGlue());

		JLabel lblDescription = new JLabel("Description");
		txtDescription = new JTextField(20);
		row1.add(lblDescription);
		row1.add(Box.createRigidArea(new Dimension(10, 0)));
		row1.add(txtDescription);
		row1.add(Box.createHorizontalGlue());

		pnl_ThongTin.add(row1);

		// Dòng 2
		JPanel row2 = new JPanel();
		row2.setLayout(new BoxLayout(row2, BoxLayout.X_AXIS));

		JLabel lblSuplierName = new JLabel("Suplier Name");
		txtSuplierName = new JTextField(20);
		row2.add(lblSuplierName);
		row2.add(Box.createRigidArea(new Dimension(10, 0)));
		row2.add(txtSuplierName);
		row2.add(Box.createHorizontalGlue());

		JLabel lblCountry = new JLabel("Country");
		txtCountry = new JTextField(20);
		row2.add(lblCountry);
		row2.add(Box.createRigidArea(new Dimension(10, 0)));
		row2.add(txtCountry);
		row2.add(Box.createHorizontalGlue());

		JLabel lblWebsite = new JLabel("Website");
		txtWebsite = new JTextField(20);
		row2.add(lblWebsite);
		row2.add(Box.createRigidArea(new Dimension(10, 0)));
		row2.add(txtWebsite);
		row2.add(Box.createHorizontalGlue());

		JLabel lblPrice = new JLabel("Price");
		txtPrice = new JTextField(20);
		row2.add(lblPrice);
		row2.add(Box.createRigidArea(new Dimension(10, 0)));
		row2.add(txtPrice);
		row2.add(Box.createHorizontalGlue());

		pnl_ThongTin.add(row2);

		add(pnl_ThongTin, BorderLayout.NORTH);

		String[] headers = { "productID", "productName", "manufacture", "description", "suplierName", "country",
				"website", "price" };
		add(new JScrollPane(table = new JTable(model = new DefaultTableModel(headers, 0))), BorderLayout.CENTER);

		dom = new ManageProduct();
		updateTableData();

		sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);

		JPanel pnlSouth;
		add(pnlSouth = new JPanel(), BorderLayout.SOUTH);
		pnlSouth.add(btnAdd = new JButton("Add"));
		pnlSouth.add(btnDelete = new JButton("Delete"));
		pnlSouth.add(btnUpdate = new JButton("Update"));
		pnlSouth.add(btnSave = new JButton("Save"));
		pnlSouth.add(btnFilter = new JButton("Filter"));

//		this.add(ProductPanel(), BorderLayout.NORTH);

		btnDelete.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnSave.addActionListener(this);
		btnFilter.addActionListener(this);
		btnAdd.addActionListener(this);
	}

	private void updateTableData() {

		// xoa du lieu tren table
		while (table.getRowCount() != 0)
			model.removeRow(0);

		ArrayList<Product> list = dom.getAllProducts();
		for (Product p : list) {
			String rowData[] = { p.getProductID(), p.getName(), p.getManufacture(), p.getDescription(),
					p.getSuplier().getSupName(), p.getSuplier().getWebsite(), p.getSuplier().getCountry(),
					p.getPrice() + "" };
			model.addRow(rowData);
		}
	}

	public static void main(String[] args) {
		new DOMvsGUI().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnAdd)) {
			if (checkEmptyFields()) {
				String id = txtProductID.getText().trim();
				String name = txtProductName.getText().trim();
				String manufacture = txtManufacture.getText().trim();
				String description = txtDescription.getText().trim();

				// suplier
				String suplierName = txtSuplierName.getText().trim();
				String country = txtCountry.getText().trim();
				String website = txtWebsite.getText().trim();

				String price = txtPrice.getText().trim();

				Suplier s = new Suplier(suplierName, country, website);
				Product p = new Product(id, name, manufacture, description, s, Double.parseDouble(price));

				dom.addProduct(p);
				JOptionPane.showMessageDialog(this, "Them thanh cong");
				updateTableData();
				dom.writeXMLFile();
			} else
				JOptionPane.showMessageDialog(this, "Phải nhập đủ các trường");
		}
		if (o.equals(btnDelete)) {
			ArrayList<Product> list = dom.getAllProducts();
			int r = table.getSelectedRow();

			if (r < 0) {
				JOptionPane.showMessageDialog(this, "Chon hang can xoa!");
			} else {
				boolean check = JOptionPane.showConfirmDialog(this, "Co chan chan xoa khong?", "Canh bao",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

				if (check) {
					Product tmp = list.get(r);
					dom.deleteProduct(tmp.getProductID());
					model.removeRow(r);
				}
			}
		}
		if (o == btnUpdate) {
			 int r = table.getSelectedRow();
			 if(r < 0)
			 {
				 JOptionPane.showMessageDialog(this, "Chon hang can update");
			 }
     
			 String productID = table.getValueAt(r, 0).toString();
			 
			 double newprice = Double.parseDouble(JOptionPane.showInputDialog("Enter new price: "));
			 dom.updatePrice(productID, newprice);
     		 
	        updateTableData();
			

		}
		if (o == btnSave) {
			dom.writeXMLFile();
			JOptionPane.showMessageDialog(this, "Lưu thành công");
		}
		if (o == btnFilter) {

		}
	}

	public boolean checkEmptyFields() {
		String productId = txtProductID.getText().trim();
		String productName = txtProductName.getText().trim();
		String manufacture = txtManufacture.getText().trim();
		String description = txtDescription.getText().trim();
		String supplierName = txtSuplierName.getText().trim();
		String country = txtCountry.getText().trim();
		String website = txtWebsite.getText().trim();
		String price = txtPrice.getText().trim();

		return !productId.equals("") && !productName.equals("") && !manufacture.equals("") && !description.equals("")
				&& !supplierName.equals("") && !country.equals("") && !website.equals("") && !price.equals("");
	}

	private Product createProduct() {
		String productID = txtProductID.getText().trim();
		String name = txtProductName.getText().trim();
		String manufacture = txtManufacture.getText().trim();
		String description = txtDescription.getText().trim();
		String supName = txtSuplierName.getText().trim();
		String website = txtWebsite.getText().trim();
		String country = txtCountry.getText().trim();
		double price = Double.parseDouble(txtPrice.getText().trim());

		Suplier suplier = new Suplier(supName, website, country);

		return new Product(productID, name, manufacture, description, suplier, price);
	}

}
