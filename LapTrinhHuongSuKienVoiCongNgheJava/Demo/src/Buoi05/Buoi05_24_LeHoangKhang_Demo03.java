package Buoi05;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Buoi05_24_LeHoangKhang_Demo03 extends JFrame implements ItemListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Component txtField;
	private JCheckBox bold, italic;

	public Buoi05_24_LeHoangKhang_Demo03() {
		setTitle("CheckBox Demo");
		setSize(400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);

		setLayout(new GridLayout(2, 1));
		JPanel p1 = new JPanel();
		p1.add(txtField = new JTextField("Watch the font style change", 20));
		txtField.setFont(new Font("Serif", Font.PLAIN, 16));
		add(p1);
		JPanel p2 = new JPanel();
		p2.add(bold = new JCheckBox("Bold"));
		p2.add(italic = new JCheckBox("Italic"));
		add(p2);

		bold.addItemListener(new ItemListener() {
			
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				Font f = txtField.getFont();
				txtField.setFont(new Font(f.getName(), f.getStyle()^Font.BOLD, f.getSize()));
				
			}
		});;
		
		italic.addItemListener(new ItemListener() {
			
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				Font f = txtField.getFont();
				txtField.setFont(new Font(f.getName(), f.getStyle()^Font.ITALIC, f.getSize()));
			}
		});

	}

	public static void main(String[] args) {
		new Buoi05_24_LeHoangKhang_Demo03().setVisible(true);
	}

	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}


}
