package hoangkhang.tuan3.cd;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class TestCDList {
	static CDList listCD;
	static Menu menu;
	static Scanner scanner;
	static NumberFormat vnd;
	
	static void init() {
		// Khởi tạo đối tượng định dạng tiền
		vnd = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
		
		// Khởi tọa obj đọc dữ liệu
		scanner = new Scanner(System.in);
		
		// Khởi  tạo list
		listCD = new CDList(10);
		// Thêm sẵn vài CD
		try {			
			listCD.themCD(new CD(1, "Đi theo bóng mặt trời", "Đen", 100, 200000));
			listCD.themCD(new CD(2, "Có em", "Madihu", 48, 150000));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String[] menuItem = {
				"Thêm CD mới",
				"Danh Sách CD",
				"Sắp xếp theo tựa CD",
				"Sắp xếp theo giá giảm",
				"Tìm kiếm CD",
				"Sửa CD",
				"Xóa CD",
				"Thoát"
				};
		menu = new Menu(menuItem, "Quản Lí CD", 100);
	}
	
	public static void pressToContinue() {
		System.out.println(menu.centerText("-/- Nhấn phím bất kỳ để tiếp tục -/-"));
		try {System.in.read();}
        catch(Exception e){}
	}
	
	static void menu() {
		int choose;
		do {
			System.out.println(menu);
			System.out.print("Bạn chọn: ");
			choose = scanner.nextInt();
			
			switch (choose) {
			case 1:
				themCD();
				break;
			case 2:
				inDanhSach();
				break;
			case 3:
				listCD.sapXepTheoTuaCD();
				log("Đã sắp xếp theo tựa CD");
				break;
			case 4:
				listCD.sapXepTheoGiaGiam();
				log("Đã sắp xếp theo giá giảm");
				break;
			case 5:
				timCD();
				break;
			case 6:
				suaCD();
				break;
			case 7:
				xoaCD();
				break;
			case 8:
			default:
				System.exit(0);
			}
			
			pressToContinue();
		} while (choose != 8);
	}


	private static void timCD() {
		System.out.println(menu.subTitle2("Tìm thông tin CD"));
	
		System.out.print(menu.question("Nhập mã CD muốn tìm: "));
		int key = scanner.nextInt();
		
		int indexCD = listCD.timKiem(key);
		
		if (indexCD != -1) {
			System.out.println(menu.tableTitle(String.format("%6s %-30s %-30s %3s %15s", "Mã", "Tựa CD", "Ca sỹ", "SBH", "Giá")));
			System.out.println(listCD.getList()[indexCD]);
			System.out.println("\n" + menu.getLine1());
		} else {
			System.out.println(menu.notification("INFO", "Không tìm thấy mã CD " + key));
		}
	}

	private static void log(String message) {
		System.out.println(menu.subTitle2(message));
	}

	private static void themCD() {
		System.out.println(menu.subTitle2("Thêm CD"));
		System.out.print(menu.subTitle("*Nhập thông tin của CD:"));
		CD newCD = new CD();
		
		System.out.print(menu.question("Mã CD: "));
		newCD.setMaCD(scanner.nextInt());
		
		System.out.print(menu.question("Tựa đề CD: "));
		if (scanner.hasNextLine()) scanner.nextLine();
		newCD.setTuaCD(scanner.nextLine());
		
		System.out.print(menu.question("Tên Ca sỹ: "));
		newCD.setCaSy(scanner.nextLine());
		
		System.out.print(menu.question("Số bài hát: "));
		newCD.setSoBaiHat(scanner.nextInt());
		
		System.out.print(menu.question("Giá thành: "));
		newCD.setGiaThanh(scanner.nextDouble());
		
		System.out.println("\n" + menu.getLine1());
		
		System.out.println(menu.centerText("Đang thử thêm vào danh sách"));
		try {
			listCD.themCD(newCD);
			System.out.println(menu.notification("success", "Đã thêm thành công CD vào trong danh sách"));
		} catch (Exception e) {
			System.out.println(menu.notification("error", e.getMessage()));
		}
	}

	private static void inDanhSach() {
		System.out.println(menu.subTitle2("Danh sách CD hiện có"));

		System.out.println(menu.tableTitle(String.format("%6s %-30s %-30s %3s %15s", "Mã", "Tựa CD", "Ca sỹ", "SBH", "Giá")));
		
		for (int i = 0; i < listCD.soLuongHT; i++) {
			System.out.println(listCD.getList()[i]);
		}
		
		System.out.println("\n" + menu.getLine1());
	}

	private static void suaCD() {
		System.out.println(menu.subTitle2("Sửa thông tin CD"));
		
		System.out.print(menu.question("Nhập mã CD muốn sửa: "));
		int maCDSua = scanner.nextInt();
		
		int indexCdSua = listCD.timKiem(maCDSua);
		
		if (indexCdSua != -1) { // Tim thay
			CD modifyCD = new CD();
			modifyCD.setMaCD(maCDSua); // Giữ lại mã CD để truyền vào trong class xử lí
			
			System.out.println(menu.tableTitle(String.format("%6s %-30s %-30s %3s %15s", "Mã", "Tựa CD", "Ca sỹ", "SBH", "Giá")));
			System.out.println(listCD.getList()[indexCdSua]);
			System.out.println("\n" + menu.getLine1());
			
			System.out.println(menu.subTitle("Nhập thông tin mới cho CD " + maCDSua));
			
			System.out.print(menu.question("Tựa đề CD: "));
			if (scanner.hasNextLine()) scanner.nextLine();
			modifyCD.setTuaCD(scanner.nextLine());
			
			System.out.print(menu.question("Tên Ca sỹ: "));
			modifyCD.setCaSy(scanner.nextLine());
			
			System.out.print(menu.question("Số bài hát: "));
			modifyCD.setSoBaiHat(scanner.nextInt());
			
			System.out.print(menu.question("Giá thành: "));
			modifyCD.setGiaThanh(scanner.nextDouble());
			
			System.out.println("\n" + menu.getLine1());
			
			System.out.println(menu.centerText("Đang thử sửa CD"));
			try {
				listCD.suaCD(modifyCD);
				System.out.println(menu.notification("success", "Sửa CD thành công!"));
			} catch (Exception e) {
				System.out.println(menu.notification("error", "Không thể sửa mã CD"));
			}
		} else {
			System.out.println(menu.notification("INFO", "Không tìm thấy mã CD " + maCDSua));
		}
	}

	private static void xoaCD() {
		System.out.println(menu.subTitle2("Xóa CD"));
		
		System.out.print(menu.question("Nhập mã CD muốn xóa: "));
		int maCDXoa = scanner.nextInt();
		
		int indexCdSua = listCD.timKiem(maCDXoa);
		
		if (indexCdSua != -1) { // Tim thay
			CD modifyCD = new CD();
			modifyCD.setMaCD(maCDXoa); // Giữ lại mã CD để truyền vào trong class xử lí
			
			System.out.println(menu.tableTitle(String.format("%6s %-30s %-30s %3s %15s", "Mã", "Tựa CD", "Ca sỹ", "SBH", "Giá")));
			System.out.println(listCD.getList()[indexCdSua]);
			System.out.println("\n" + menu.getLine1());
			
			System.out.print(menu.question("Bạn có muốn xóa CD này không (Y/N): "));
			if (scanner.hasNextLine()) scanner.nextLine();
			String c = scanner.next();
			
			if (c.equalsIgnoreCase("Y")) {
				try {					
					listCD.xoaCD(maCDXoa);
					System.out.println(menu.notification("success", "Đã xóa đĩa CD thành công"));
				} catch (Exception e) {
					System.out.println(menu.notification("error", e.getMessage()));
				}
			} else {
				
			}
		} else {
			System.out.println(menu.notification("INFO", "Không tìm thấy mã CD " + maCDXoa));
		}
	}

	public static void main(String[] args) {
		init();
		menu();
	}
}
