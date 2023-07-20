package hoangkhang.tuan3.account_array;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class AccountListTest {
	private static NumberFormat vnd; // dinh dang tien
	private static Menu mainMenu; 
	private static Menu userMenu;
	private static Scanner scanner;
	private static AccountList accList;
	private static Account currentAccount; // con tro chua tai khoan de dung
	
	public static void khoiTao() throws Exception {
		currentAccount = null;
		
		accList = new AccountList(10);
		// Tao tai khoan ao
		accList.themTaiKhoan(new Account(456456456, "Trịnh Ngọc Anh", 100000));
		accList.themTaiKhoan(new Account(123123123, "Chủ tịch Cảnh", 100000000));
		
		scanner = new Scanner(System.in);
		
		vnd = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
		
		// Khoi tao main menu
		String[] mainMenuList = {
				"Thêm tài khoản", 
				"Xem thông tin tài khoản",
				"Sắp xếp mặc định",
				"Sắp xếp theo số dư",
				"Tìm kiếm tài khoản",
				"Xóa tài khoản",
				"Sửa tài khoản",
				"Sử dụng tài khoản",
				"Thoát"
				};
		mainMenu = new Menu(mainMenuList, "QUẢN LÍ ACCOUNT", 80);
		
		// Khoi tao user menu
		String[] userMenuList = {
			"Chọn tài khoản",
			"Nạp tiền",
			"Rút tiền",
			"Chuyển tiền",
			"Quay về menu chính"
		};
		userMenu = new Menu(userMenuList, "DỊCH VỤ NGÂN HÀNG", 80);
	}
	
	public static void pressToContinue() {
		System.out.println(mainMenu.centerText("-/- Nhấn phím bất kỳ để tiếp tục -/-"));
		try {System.in.read();}
        catch(Exception e){}
	}
	
	public static void mainMenu() {
		int choose = 0;
		do {			
			System.out.println(mainMenu);
			System.out.print("Bạn chọn: ");
			choose = scanner.nextInt();
			
			switch(choose) {
			case 1:
				themTaiKhoan();
				break;
			case 2:
				inThongTin();
				break;
			case 3:
				accList.sapXep();
				log("Đã sắp xếp theo mặc định!");
				break;
			case 4:
				accList.sapXepTheoTien();
				log("Đã sắp xếp theo số dư!");
				break;
			case 5:
				timTaiKhoan();
				break;
			case 6:
				xoaTaiKhoan();
				break;
			case 7:
				suaTaiKhoan();
				break;
			case 8:
				userMenu();
				break;
			case 9:
				System.exit(0);
				break;
			default: 
				System.out.println("*WARN: Không tìm thấy mục " + choose);
			}
			
			if (choose != 8) pressToContinue(); // tránh cái menu con
		} while (choose != 9);
	}
	
	private static void timTaiKhoan() {
		System.out.println(mainMenu.subTitle2("TÌM TÀI KHOẢN"));
		
		System.out.print("Nhập STK của tài khoản để tìm thông tin: ");
		long stkDel = scanner.nextLong();
		
		int index = accList.timKiem(stkDel);
		
		if (index != -1 ) {
			System.out.println(mainMenu.subTitle("Truy vấn thông tin tài khoản"));
			
			System.out.printf("%-30s %10s %20s\n", "Chủ tài khoản", "Số TK", "Số dư");
			System.out.println(accList.getList()[index]);
			System.out.println(mainMenu.getLine1());
		} else { 
			System.out.println(mainMenu.centerText("*Không tìm thấy thông tin tài khoản " + stkDel));
		}
	}

	public static void log(String message) {
		System.out.println(mainMenu.subTitle2(message));
	}
	
	public static void themTaiKhoan() {
		// Tránh dính bộ đệm những lần trước
		if (scanner.hasNextLine()) scanner.nextLine();
		
		System.out.println(mainMenu.subTitle2("Tạo tài khoản"));
		
		System.out.print("Nhập tên của bạn: ");
		String name = scanner.nextLine();
		
		long randomAccNumber = (long)(Math.random() * Math.pow(10, 10));
		System.out.println("Số tài khoản được cấp là: " + randomAccNumber);
		System.out.println("Số dư mặc định: " + vnd.format(50000));
		
		System.out.println("\n" + mainMenu.getLine1());
		
		Account newAccount = new Account(name, randomAccNumber);
		try {
			accList.themTaiKhoan(newAccount);
			System.out.println(mainMenu.centerText("SUCCESS: Tạo tài khoản thành công!"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void inThongTin() {
		System.out.println(mainMenu.subTitle2("THÔNG TIN TÀI KHOẢN HIỆN CÓ"));

		System.out.print(mainMenu.getLine1());
		System.out.printf("%-30s %10s %20s\n", "Chủ tài khoản", "Số TK", "Số dư");
		System.out.println(mainMenu.getLine1());
		for (int i = 0; i < accList.soLuongHT; i++) {
			System.out.println(accList.getList()[i]);
		}
		System.out.println(mainMenu.getLine1());
	}
	
	public static void xoaTaiKhoan() {
		// Tránh dính bộ đệm những lần trước
		if (scanner.hasNextLine()) scanner.nextLine();
		
		System.out.println(mainMenu.subTitle2("XÓA TÀI KHOẢN"));
		
		System.out.print("Nhập STK của tài khoản muốn xóa: ");
		long stkDel = scanner.nextLong();
		
		int index = accList.timKiem(stkDel);
		
		if (index != -1 ) {
			System.out.println(mainMenu.subTitle("Truy vấn thông tin tài khoản"));
			
			System.out.printf("%-30s %10s %20s\n", "Chủ tài khoản", "Số TK", "Số dư");
			System.out.println(accList.getList()[index]);
			System.out.println(mainMenu.getLine1());
			
			System.out.print("Bạn có muốn xóa tài khoản này không (1/0)? ");
			int confirm = scanner.nextInt();
			
			if (confirm == 1) {
				try {
					accList.xoaTaiKhoan(stkDel);
					System.out.println(mainMenu.centerText("Xóa tài khoản thành công!"));
				} catch (Exception e) {
					System.out.println(e.getMessage());
					System.out.println(mainMenu.centerText("Xóa tài khoản thất bại!"));
				}
			}
		} else { 
			System.out.println(mainMenu.centerText("*Không tìm thấy thông tin tài khoản"));
		}
		
	}
	
	public static void suaTaiKhoan() {
		// Tránh dính bộ đệm những lần trước
		if (scanner.hasNextLine()) scanner.nextLine();

		System.out.println(mainMenu.subTitle2("SỬA TÀI KHOẢN"));

		System.out.print("Nhập STK của tài khoản muốn sửa: ");
		long stkDel = scanner.nextLong();

		int index = accList.timKiem(stkDel);

		if (index != -1) {
			System.out.println(mainMenu.subTitle("Truy vấn thông tin tài khoản"));

			System.out.printf("%-30s %10s %20s\n\n", "Chủ tài khoản", "Số TK", "Số dư");
			System.out.println(accList.getList()[index]);
			System.out.println(mainMenu.getLine1());
			
			System.out.print("Bạn có muốn sửa đổi tài khoản này không? (1/0) ");
			int confirm = scanner.nextInt();
			
			if (confirm == 1) {
				if (scanner.hasNextLine()) scanner.nextLine();
				
				System.out.println(mainMenu.subTitle2("SỬA THÔNG TIN"));
				System.out.print("Nhập tên mới: ");
				String newName = scanner.nextLine(); 
				
				System.out.print("Nhập STK mong muốn: ");
				long newSTK = scanner.nextLong();
				
				Account modifyAccount = new Account(newName, newSTK);
				
				try {
					accList.suaTaiKhoan(index, modifyAccount);
				} catch (Exception e) {
					System.out.println(mainMenu.centerText(e.getMessage()));
				}
				System.out.println(mainMenu.centerText("Đổi thông tin thành công!"));
			}
		} else {
			System.out.println(mainMenu.centerText("*Không tìm thấy tài khoản"));
		}
	}
	
	public static void userMenu() {
		if (accList.soLuongHT == 0) {
			System.out.println(userMenu.centerText("INF: Hiện đang không có tài khoản nào được quản lí"));
			return;
		}
		
		int choose = 0;
		do {
			System.out.println(userMenu);
			if (currentAccount != null) {
				System.out.println("[Tài khoản đang dùng: " 
									+ currentAccount.getAccountNumber() + ", " 
									+ currentAccount.getAccountName() + ", "
									+ vnd.format(currentAccount.getAccountAmount()) + "]");
			}
			
			System.out.print("\nLựa chọn của bạn: ");
			choose = scanner.nextInt();
			
			switch(choose) {
			case 1:
				chonAccount();
				break;
			case 2:
				napTien();
				break;
			case 3:
				rutTien();
				break;
			case 4:
				chuyenTien();
				break;
			}
			if (choose <= 4 && choose > 0) {
				pressToContinue();
			}
		} while (choose != userMenu.getLength());
	}
	
	public static void chonAccount() {
		System.out.println(userMenu.subTitle2("CHỌN TÀI KHOẢN"));
		System.out.print(mainMenu.getLine1());
		System.out.printf("%-30s %10s %20s\n", "Chủ tài khoản", "Số TK", "Số dư");
		System.out.println(mainMenu.getLine1());
		
		for (int i = 0; i < accList.soLuongHT; i++) {
			System.out.println("" + (i+1) + ". " + accList.getList()[i]);
		}
		
		System.out.println(userMenu.getLine1());
		System.out.print("Lựa chọn của bạn: ");
		int choose = 0;
		
		do {
			choose = scanner.nextInt();
			if (choose >= 0 && choose <= accList.soLuongHT) currentAccount = accList.getList()[choose-1]; // Gan tai khoan duoc chon
		} while (choose < 0 || choose > accList.soLuongHT);
		
		System.out.println(userMenu.centerText("Chọn tài khoản thành công!"));
	}
	
	public static void napTien() {
		if (currentAccount == null) {
			System.out.println(userMenu.centerText("WARN: Bạn phải chọn tài khoản để dùng tình năng này"));
			return;
		}
		
		System.out.println(userMenu.subTitle2("Nạp Tiền"));
		double quantity;
		do {			
			System.out.print("*Nhập số tiền bạn muốn nạp vào tài khoản: ");
			quantity = scanner.nextDouble();
			
			try {
				currentAccount.cashIn(quantity);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (quantity <= 0);
		
		
		System.out.println("\nĐã nạp thành công " + vnd.format(quantity) + " vào STK " + currentAccount.getAccountNumber());
		System.out.println("\nSố dư hiện tại: " + vnd.format(currentAccount.getAccountAmount()));
	}
	
	public static void rutTien() {
		if (currentAccount == null) {
			System.out.println(userMenu.centerText("WARN: Bạn phải chọn tài khoản để dùng tình năng này"));
			return;
		}
		
		boolean complete = false;
		double quantity;
		do {			
			System.out.println(userMenu.subTitle2("RÚT TIỀN"));
			System.out.print("*Nhập số tiền bạn muốn rút: ");
			quantity = scanner.nextDouble();
			try {
				complete = currentAccount.cashOut(quantity);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				if (e.getMessage().equals("*BẠN KHÔNG THỂ RÚT TIỀN")) break;
			}
		} while (quantity <= 0 || !complete);
		
		if (complete) {			
			System.out.println("Đã rút " + vnd.format(quantity) + " Từ tài khoản " + currentAccount.getAccountNumber());
			System.out.println("Phí rút: -" + vnd.format(1000));
			System.out.println("Số dư còn lại: " + vnd.format(currentAccount.getAccountAmount()));
			System.out.println(userMenu.centerText("Rút tiền thành công!"));
		}
	}
	
	public static void chuyenTien() {
		if (currentAccount == null) {
			System.out.println(userMenu.centerText("WARN: Bạn phải chọn tài khoản để dùng tình năng này"));
			return;
		}
		
		System.out.println(userMenu.subTitle2("CHUYỂN TIỀN"));
		
		System.out.print("Nhập STK người nhận: ");
		long stkNhan = scanner.nextLong();
		
		int index = accList.timKiem(stkNhan);
		
		if (index != -1) {
			Account accNhan = accList.getList()[index];
			
			System.out.println("Người nhận: " + accNhan.getAccountName());
			
			System.out.print("\n*Nhập số tiền bạn muốn chuyển: ");
			double quantity = scanner.nextDouble();
			
			try {
				currentAccount.cashOut(quantity);
				accNhan.cashIn(quantity);
				
				System.out.println(
					"Đã chuyển " + vnd.format(quantity) + " từ " 
					+ currentAccount.getAccountNumber() + " đến " 
					+ accNhan.getAccountNumber()
				);
				
				System.out.println(userMenu.subTitle("SUCC: Chuyển tiền thành công!"));
			} catch (Exception e) {
				System.out.println("ERR: Có lỗi xảy ra, chuyển tiền thất bại");
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println(userMenu.centerText("Không tìm thấy tài khoản số " + stkNhan));
		}
	}
	
	public static void main(String[] args) {
		try {
			khoiTao();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mainMenu();
	}
}
