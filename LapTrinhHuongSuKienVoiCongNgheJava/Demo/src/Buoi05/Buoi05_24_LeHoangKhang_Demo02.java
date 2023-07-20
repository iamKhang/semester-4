package Buoi05;

import java.awt.BorderLayout;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Buoi05_24_LeHoangKhang_Demo02 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton insertButton;
	private JButton wraptButton;
	private JTextArea textArea;

	public Buoi05_24_LeHoangKhang_Demo02() {
		setTitle("JtextArea Demo");
		setSize(700, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		JPanel jpnPanel = new JPanel();
		jpnPanel.add(insertButton = new JButton("Insert"));
		jpnPanel.add(wraptButton = new JButton("Wrap"));
		add(jpnPanel, BorderLayout.SOUTH);
		
		textArea =new JTextArea(8, 40);
		add(textArea, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		new Buoi05_24_LeHoangKhang_Demo02().setVisible(true);
	}
}
