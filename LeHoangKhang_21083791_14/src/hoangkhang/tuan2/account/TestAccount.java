package hoangkhang.tuan2.account;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class TestAccount {
	private static Menu menu;
	private static Account virtualAccount2;
	private static Account virtualAccount1;
	private static Account userAccount;
	private static NumberFormat vnd;

	public static void init() {
		Locale vn = new Locale("vi", "VN");
		vnd = NumberFormat.getCurrencyInstance(vn);
		
		String[] menuItem = {
				"Tạo các tài khoản ảo", 
				"Tạo tài Khoản",
				"Xem thông tin các tài khoản",
				"Nạp tiền", 
				"Rút tiền", 
				"Chuyển khoản", 
				"Thoát"
		};
		
		menu = new Menu(menuItem);
	}
	
	@SuppressWarnings("resource")
	public static void menu() {
		int selected;
		
		do {
			System.out.println(menu);
			System.out.print("* Mời bạn lựa chọn: ");
			selected = menu.getUserSelect();
			System.out.println(menu.centerText("Bạn đã chọn " + selected));
			switch (selected) {
			case 1:
				taoTaiKhoanAo();
				break;
			case 2:
				taoTaiKhoan();
				break;
			case 3:
				printListAccount();
				break;
			case 4:
				napTien();
				break;
			case 5:
				rutTien();
				break;
			case 6:
				chuyenTien(virtualAccount2);
				break;
			case 7:
				System.out.println(menu.centerText("Chương trình kết thúc"));
				System.exit(0);
				break; 
			}
			
			System.out.println();
			System.out.println(menu.centerText("-Nhấn phím bất kỳ để tiếp tục-"));
			new Scanner(System.in).nextLine();
		} while (selected != 7);
		
	}
	
	public static void taoTaiKhoanAo() {
		virtualAccount1 = new Account("Thanh Cảnh", 123456);
		virtualAccount2 = new Account("Ngọc Anh", 654321);
		System.out.println(menu.centerText("-/- Đã tạo 2 tài khoản ảo -/-"));
	}
	
	@SuppressWarnings("resource")
	public static void taoTaiKhoan() {
			Account newAccount = new Account();

			System.out.println(menu.title("Tạo Tài Khoản"));
			
			System.out.print("* Họ và tên: ");
			newAccount.setAccountName(new Scanner(System.in).nextLine());
			
			long stk = (long)(Math.random()* Math.pow(10, 10));
			newAccount.setAccountNumber(stk);
			System.out.println("* STK bạn được cấp: " + stk);
			
			newAccount.setAccountAmount(50000);
			System.out.println("* Tiền khởi tạo: " + vnd.format(newAccount.getAccountAmount()));
			
			System.out.println("\n");
			System.out.println(menu.centerText("-/- TẠO TÀI KHOẢN THÀNH CÔNG -/-"));
			
			userAccount = newAccount;
	}
	
	public static void printListAccount() {
		System.out.print(menu.getLine1());
		System.out.printf("%-30s %-10s %-20s\n", "Tên tài khoản", "STK", "Tiền");
		System.out.print(menu.getLine1());
		System.out.println(virtualAccount1);
		System.out.println(virtualAccount2);
		System.out.println(userAccount);
	}
	
	@SuppressWarnings("resource")
	public static void napTien() {
		System.out.println(menu.title("NẠP TIỀN"));
		double quantity;
		do {			
			System.out.print("*Nhập số tiền bạn muốn nạp vào tài khoản: ");
			quantity = new Scanner(System.in).nextDouble();
			
			try {
				userAccount.cashIn(quantity);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (quantity <= 0);
		
		
		System.out.println("Đã nạp thành công " + vnd.format(quantity) + " vào STK " + userAccount.getAccountNumber());
		System.out.println("Số dư hiện tại: " + vnd.format(userAccount.getAccountAmount()));
	}
	
	@SuppressWarnings("resource")
	public static void rutTien() {
		boolean complete = false;
		double quantity;
		do {			
			System.out.println(menu.title("RÚT TIỀN"));
			System.out.print("*Nhập số tiền bạn muốn rút: ");
			quantity = new Scanner(System.in).nextDouble();
			try {
				complete = userAccount.cashOut(quantity);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				if (e.getMessage().equals("*BẠN KHÔNG THỂ RÚT TIỀN")) break;
			}
		} while (quantity <= 0 || !complete);
		
		if (complete) {			
			System.out.println("Đã rút " + vnd.format(quantity) + " Từ tài khoản " + userAccount.getAccountNumber());
			System.out.println("Phí rút: " + vnd.format(1000));
			System.out.println("Số dư còn lại: " + vnd.format(userAccount.getAccountAmount()));
		}
	}
	
	@SuppressWarnings("resource")
	public static void chuyenTien(Account accountNhan) {
		System.out.println(menu.title("CHUYỂN TIỀN"));
		System.out.println("Chuyển tới "+ accountNhan.getAccountNumber());
		
		boolean complete = false;
		double quantity;
		do {			
			System.out.print("*Nhập số tiền muốn chuyển: ");
			quantity = new Scanner(System.in).nextDouble();
			try {
				complete = userAccount.cashOut(quantity);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				if (e.getMessage().equals("*BẠN KHÔNG THỂ RÚT TIỀN")) break;
			}
		} while (quantity <= 0 || !complete);
		
		
		if (complete) {		
			try {
				accountNhan.cashIn(quantity);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			System.out.println("*CHUYỂN TIỀN THÀNH CÔNG!!!");
		}
	}
	
	
	public static void main(String[] args) {
		init();
		menu();
		
		
	}
}
