package hoangkhang.tuan2.account;

import java.util.Scanner;

/**
 * 
 * @author thanhCanh
 * Class tạo ra để khởi tạo các menu làm bài tập nhanh hơn
 *
 */

public class Menu {
	private String[] listItem;
	private int maxLength;
	private String line1 = "";
	private String line2 = "";
	
	// Contructor sẽ truyền vào 1 mảng các chuỗi là các item của menu
	/*
	 * String[] menuItem = {
				"Tạo các tài khoản ảo", 
				"Tạo tài Khoản",
				"Xem thông tin các tài khoản",
				"Nạp tiền", 
				"Rút tiền", 
				"Chuyển khoản", 
				"Thoát"
		};
		
		Menu menu = new Menu(menuItem); 
	*/
	public Menu(String[] listItem) {
		this.listItem = listItem;
		maxLength = this.getMaxLengthOfItem();
		this.initLine();
	}
	
	// Dùng để căn chỉnh menu cho hợp lý
	private int getMaxLengthOfItem() {
		int tmp_max = 0;
		
		for (int i = 0; i < listItem.length; i++) {
			if (listItem[i].length() > tmp_max) tmp_max = listItem[i].length();
		}
		
		return (tmp_max + 20);
	}
	
	// Khời tạo các đường kẻ phù hợp với menu
	private void initLine() {
		int num = (this.maxLength > 40 ? this.maxLength : 60);
		this.maxLength = num;
		for (int i = 0; i < this.maxLength; i++) {
			this.line1 += '-';
			this.line2 += "=";
		}
		
		this.line1 += '\n';
		this.line2 += '\n';
	}
	
	// trả về 1 chuỗi sẽ được căn giữa theo các đường kẻ
	public String centerText(String text) { 
		String stringFormat =  String.format("%" 
				+ String.valueOf(maxLength/2 + text.length()/2 + 1) 
				+ "s", text);
		
		return stringFormat;
	}
	
	// Nhận nhanh số người dùng nhập
	@SuppressWarnings("resource")
	public int getUserSelect() {
		int select = new Scanner(System.in).nextInt();
		return select;
	}
	
	// Trả về đường kẻ nếu bạn cần dùng
	public String getLine1() {
		return this.line1;
	}
	
	public String getLine2() {
		return this.line2;
	}
	
	public String title(String titleText) {
		return (this.line1 + this.centerText(titleText) +'\n' + this.line1);
	}

	@Override
	// Trả về chuỗi chính là menu
	public String toString() {
		String menu = line2 + centerText("MENU\n") + line2 + '\n';
		for (int i = 0; i < this.listItem.length; i++) {
			menu += (i+1) + ". " + this.listItem[i] + "\n";
		}
		menu += '\n' + line1;
		
		return menu;
	}
	
	
}
