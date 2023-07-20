package Buoi05;

import java.awt.Color;
import java.awt.GridLayout;
 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
 
public class Buoi05_24_LeHoangKhang_Demo06 extends JFrame {
 
    public Buoi05_24_LeHoangKhang_Demo06() {
        createGUI();
        setDisplay();
    }
 
    /**
     * set display for JFrame
     */
    private void setDisplay() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
 
    /**
     * add JTabbedPane into JFrame
     */
    private void createGUI() {
        add(createTabbedPane());
    }
 
    /**
     * create a JTabbedPane contain three tab
     */
    private JTabbedPane createTabbedPane() {
        JTabbedPane tabbedPane = new JTabbedPane();
 
        /* create three JPanel, which is content of tabs */
        JPanel Mercury = createPane1();
        JPanel Venus = createPane1();
        JPanel Earth = createPane1();
        JPanel Mars = createPane1();
        JPanel JuPiter = createPane1();
     
 
        /* add three tab with three JPanel */
        tabbedPane.addTab("Mercury", null, Mercury, "click to show panel Mercury");
        tabbedPane.addTab("Venus", null, Venus, "click to show panel Venus");
        tabbedPane.addTab("Earth", null, Earth, "click to show panel Earth");
        tabbedPane.addTab("Mars", null, Mars, "click to show panel Mars");
        tabbedPane.addTab("JuPiter", null, JuPiter, "click to show panel JuPiter");
        
 
        return tabbedPane;
    }
 
    /**
     * create JPanel 1 contain a JTextArea
     */
    private JPanel createPane1() {
        JPanel panel = new JPanel();
        panel.add(new JScrollPane(createTextArea(10, 40)));
        return panel;
    }
 
    /**
     * create a JPanel contain a JLabel
     */
    private JPanel createJPanel(String text) {
        JPanel panel = new JPanel(new GridLayout(1, 1));
        JLabel lb = new JLabel(text);
        lb.setHorizontalAlignment(JLabel.CENTER);
        panel.add(lb);
        return panel;
    }
 
    /**
     * create a JTextArea with rows and columns, two method setWrapStyleWord and
     * setLineWrap make text can down line when text too long
     */
    private JTextArea createTextArea(int row, int col) {
        JTextArea ta = new JTextArea(row, col);
        ta.setWrapStyleWord(true);
        ta.setLineWrap(true);
        ta.setForeground(Color.BLUE);
        return ta;
    }
 
    public static void main(String[] args) {
        new Buoi05_24_LeHoangKhang_Demo06().setVisible(true);;
    }
}