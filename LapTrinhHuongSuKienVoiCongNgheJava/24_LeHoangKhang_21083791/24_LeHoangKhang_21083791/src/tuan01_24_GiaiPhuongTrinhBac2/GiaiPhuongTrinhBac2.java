package tuan01_24_GiaiPhuongTrinhBac2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GiaiPhuongTrinhBac2 extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnGiai;
	private JButton btnXoaRong;
	private JButton btnThoat;
	private TextField txtA;
	private TextField txtB;
	private TextField txtC;
	private TextField txtKQ;
	
	
	public GiaiPhuongTrinhBac2() {
		setTitle("Giải phương trình bậc 2");
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		createGUI();
	}
	
	private void createGUI() {
		JPanel jpTilte;
		add(jpTilte = new JPanel(), BorderLayout.NORTH);
		jpTilte.setBackground(Color.CYAN);
		JLabel lbTieuDe;
		jpTilte.add(lbTieuDe = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC 2"));
		lbTieuDe.setFont(new Font("Arial", Font.BOLD, 30));
		
		
		JPanel jpCenter;
		add(jpCenter = new JPanel(), BorderLayout.CENTER);
		jpCenter.setLayout(null);
		
		JLabel lbNhapA, lbNhapB, lbNhapC, lbKQ;
		jpCenter.add(lbNhapA = new JLabel("Nhập a:"));
		int x=20, y=40, width = 100, height = 30;
		lbNhapA.setBounds(x,y,width,height);
		
		jpCenter.add(lbNhapB = new JLabel("Nhập b:"));
		y += 50;
		lbNhapB.setBounds(x,y,width,height);
		
		jpCenter.add(lbNhapC = new JLabel("Nhập c:"));
		y += 50;
		lbNhapC.setBounds(x,y,width,height);
		
		jpCenter.add(lbKQ = new JLabel("Kết quả:"));
		y += 50;
		lbKQ.setBounds(x,y,width,height);
		
		jpCenter.add(txtA=new TextField());
		x+=100; y = 40; width = 300;
		txtA.setBounds(x,y,width,height);
		
		jpCenter.add(txtB=new TextField());
		y+=50;
		txtB.setBounds(x,y,width,height);
		
		jpCenter.add(txtC=new TextField());
		y+=50;
		txtC.setBounds(x,y,width,height);
		
		jpCenter.add(txtKQ=new TextField());
		y+=50;
		txtKQ.setBounds(x,y,width,height);
		txtKQ.setEditable(false);
		
		JPanel jpTuyChon;
		add(jpTuyChon = new JPanel(), BorderLayout.SOUTH);
		jpTuyChon.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		jpTuyChon.add(btnGiai = new JButton("Giải"));
		jpTuyChon.add(btnXoaRong = new JButton("Xóa rỗng"));
		jpTuyChon.add(btnThoat = new JButton("Thoát"));
		
		
		btnThoat.addMouseListener(new MouseListener() {
			//Bật khi nút chuột được nhả ra
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			//Bật khi nhấn chuột lên 1 thành phần
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			//Được gọi khi chuột thoát ra khỏi thành phần
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			//Được gọi khi nhập vào một thành phần
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			//Xuất hiện khi click chuột
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.exit(1);
				
			}
		});
		
		btnXoaRong.addMouseListener(new MouseListener() {
			
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
				txtA.setText("");
				txtB.setText("");
				txtC.setText("");
				txtKQ.setText("");
				// TODO Auto-generated method stub
				
			}
		});
		
		btnGiai.addMouseListener(new MouseListener() {
			
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
				try {
					double a = Double.parseDouble(txtA.getText());
					double b = Double.parseDouble(txtB.getText());
					double c = Double.parseDouble(txtC.getText());
					double delta=(b*b)-(4*a*c);
					double x1, x2;
					if(delta>0) {
						x1=(double)((-b+Math.sqrt(delta))/(2*a));
						x2=(double)((-b-Math.sqrt(delta))/(2*a));
						txtKQ.setText("x1 = "+ " " +x1+ " và x2 = " +x2);
					}
					else if(delta==0) {
						x1=(-b/(2*a));
						txtKQ.setText("x1 = x2 = " + x1);
					}
					else {
						txtKQ.setText("Phương trình vô nghiệm");
					}
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(null, "Input không hợp lệ");
				}
				
			}
		});
	}
	
	
	public static void main(String[] args) {
		new GiaiPhuongTrinhBac2().setVisible(true);
	}
}
