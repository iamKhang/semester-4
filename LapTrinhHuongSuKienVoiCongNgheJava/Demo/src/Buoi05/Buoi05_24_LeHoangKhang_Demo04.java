package Buoi05;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class Buoi05_24_LeHoangKhang_Demo04 extends JFrame implements ItemListener, ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JRadioButton leftRadioButton, rightRadiobutton;
	private JCheckBox italicCheckBox;
	private JLabel displatLable;

	public Buoi05_24_LeHoangKhang_Demo04() {
		setTitle("Demo checkBoxRadio");
		setSize(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel pTop = new JPanel();
		this.add(pTop, BorderLayout.NORTH);
		add(italicCheckBox = new JCheckBox("Italic"));
		pTop.add(leftRadioButton = new JRadioButton("Left", true));
		pTop.add(leftRadioButton = new JRadioButton("Right"));
		ButtonGroup group = new ButtonGroup();
		group.add(leftRadioButton);
		group.add(rightRadiobutton);
		this.add(displatLable = new JLabel("Hello world!!"));

		italicCheckBox.addItemListener(this);
		leftRadioButton.addActionListener(this);
		rightRadiobutton.addActionListener(this);

	}
	

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(leftRadioButton))
			displatLable.setHorizontalAlignment(SwingConstants.LEFT);
		else if (o.equals(rightRadiobutton))
			displatLable.setHorizontalAlignment(SwingConstants.RIGHT);

	}

	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		Font f = displatLable.getFont();
		if (e.getStateChange() == ItemEvent.SELECTED)
			displatLable.setFont(new Font(f.getName(), Font.ITALIC, f.getSize()));
		else
			displatLable.setFont(new Font(f.getName(), Font.PLAIN, f.getSize()));

	}
	
	public static void main(String[] args) {
		new Buoi05_24_LeHoangKhang_Demo04().setVisible(true);
	}
}
