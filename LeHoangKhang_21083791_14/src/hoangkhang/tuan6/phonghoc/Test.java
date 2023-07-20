package hoangkhang.tuan6.phonghoc;

import java.util.Scanner;

public class Test {
	static Scanner sc = new Scanner(System.in);
	static QuanLiPhongHoc list = new QuanLiPhongHoc();
	
	public static void handleMenu() {
		int choose;
		
		do {

			System.out.println("===================================================================================");
			System.out.println("\t\t\t\tQuản lí phòng học");
			System.out.println("===================================================================================");
			System.out.println("1. Thêm cứng");
			System.out.println("2. Thêm phòng học");
			System.out.println("3. Tìm kiếm phòng học");
			System.out.println("4. Danh sách các phòng");
			System.out.println("5. Danh sách phòng học đạt chuẩn");
			System.out.println("6. Sắp xếp tăng dần theo dãy nhà");
			System.out.println("7. Sắp xếp tăng dần theo diện tích");
			System.out.println("8. Sắp xếp tăng dần theo số bóng đèn");
			System.out.println("9. Sắp xếp tự động");
			System.out.println("10. Cập nhật số máy tính cho phòng");
			System.out.println("11. Xóa phòng");
			System.out.println("12. Danh sách phòng có 60 máy");
			System.out.println("13. Thoát");
			System.out.println("===================================================================================");
			System.out.print("Lựa chọn của bạn: ");
						
			choose = sc.nextInt();
			switch(choose) {
			case 1:
				themCung();
				break;
			case 2:
				themPhongHoc();
				break;
			case 3:
				timPhongHoc();
				break;
			case 4:
				danhSachPhong();
				break;
			case 5:
				danhSachPhongDatChuan();
				break;
			case 6:
				sapXepTheoDayNha();
				break;
			case 7:
				sapXepTheoDienTich();
				break;
			case 8: 
				sapXepTheoSoBongDen();
				break;
			case 9: 
				sapXepTuDong();
				break;
			case 10:
				capNhatSoMayTinh();
				break;
			case 11:
				xoaPhong();
				break;
			case 12:
				danhSachPhong60May();
				break;
			case 13:
				System.exit(0);
			}
			
			System.out.println("**Ấn phìm bất kỳ để tiếp tục");
			try {
				System.in.read();
			} catch (Exception e) {};
		} while (choose != 12);
	}
	
	private static void themCung() {
		PhongHoc lt1 = new PhongLyThuyet("LT001", "A", 200, 30, false);
		PhongHoc lt2 = new PhongLyThuyet("LT002", "F", 130, 2, false);
		PhongHoc lt3 = new PhongLyThuyet("LT003", "C", 950, 97, true);
		
		PhongHoc mt1 = new PhongMayTinh("MT001", "E", 100, 20, 90);
		PhongHoc mt2 = new PhongMayTinh("MT002", "Q", 300, 60, 95);
		PhongHoc mt3 = new PhongMayTinh("MT003", "G", 100, 5, 2);
		
		PhongHoc tn1 = new PhongThiNghiem("TN001", "O", 300, 35, "Bom nguyên tử", 23, true);
		PhongHoc tn2 = new PhongThiNghiem("TN002", "S", 200, 23, "Hóa Sinh", 4, false);
		PhongHoc tn3 = new PhongThiNghiem("TN003", "Z", 250, 12, "Cơ khí", 23, true);
		
		try {
			list.themPhong(lt1);
			list.themPhong(lt2);
			list.themPhong(lt3);
			
			list.themPhong(mt1);
			list.themPhong(mt2);
			list.themPhong(mt3);
			
			list.themPhong(tn1);
			list.themPhong(tn2);
			list.themPhong(tn3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void themPhongHoc() {
		System.out.println("\t\t\tThêm phòng học");
		
		System.out.println("Nhập mã phòng:");
		if (sc.hasNextLine()) sc.nextLine();
		String maPhong = sc.next();
		
		if (list.timPhong(maPhong) != null) {
			System.out.println("Đã tồn tại mã phòng");
			return;
		}
		
		System.out.println("Nhập dãy: ");
		if (sc.hasNextLine()) sc.nextLine();
		String day = sc.next();
		
		
		System.out.println("Diện tích: ");
		double dienTich = sc.nextDouble();
		
		System.out.println("Số bóng đèn: ");
		int soBongDen = sc.nextInt();
		
		System.out.println("Nhập kiểu phòng {Lý thuyết = 1, Máy tính = 2, Thí nghiệm = khác}:"); 
		int type = sc.nextInt();
		
		PhongHoc newPhong;
		if (type == 1) {
			System.out.println("Máy chiếu [true/false]: ");
			boolean mayChieu = sc.nextBoolean();
			
			newPhong = new PhongLyThuyet(maPhong, day, dienTich, soBongDen, mayChieu);
		} else if (type == 2) {
			System.out.println("Số máy tính: ");
			int soMayTinh = sc.nextInt();
			
			newPhong = new PhongMayTinh(maPhong, day, dienTich, soBongDen, soMayTinh);
		} else {
			System.out.println("Chuyên ngành: ");
			if (sc.hasNextLine()) sc.nextLine();
			String chuyenNganh = sc.nextLine();
			
			System.out.println("Sức chứa: ");
			int sucChua = sc.nextInt();
			
			System.out.println("Bồn rửa [true/false]: ");
			boolean bonRua = sc.nextBoolean();
			
			newPhong = new PhongThiNghiem(maPhong, day, dienTich, soBongDen, chuyenNganh, sucChua, bonRua);
		}
		
		try {
			list.themPhong(newPhong);
			System.out.println("Đã thêm phòng thành công!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void timPhongHoc() {
		System.out.println("\t\t\t Tìm phòng");
		
		System.out.println("Nhập mã phòng: ");
		if (sc.hasNextLine()) sc.nextLine();
		String maPhong = sc.next();
		
		PhongHoc k = list.timPhong(maPhong);
		
		if (k != null) {
			if (k instanceof PhongLyThuyet) {
				System.out.println("\n*PHÒNG LÝ THUYẾT:");
				System.out.println("==============================================================================================");
				System.out.printf("%-15s %-15s %10s %10s %-15s %-10s %-15s\n", "Mã Phòng", "Dãy", "Diện tích", "Bóng đèn", "Ánh sáng", "Máy chiếu", "Đạt chuẩn");
				System.out.println("==============================================================================================");
			} else if (k instanceof PhongMayTinh) {
				System.out.println("\n*PHÒNG MÁY TÍNH:");
				System.out.println("==============================================================================================");
				System.out.printf("%-15s %-15s %10s %10s %-15s %10s %-15s\n", "Mã Phòng", "Dãy", "Diện tích", "Bóng đèn", "Ánh sáng", "Số máy", "Đạt chuẩn");
				System.out.println("==============================================================================================");
			} else {
				System.out.println("\n*PHÒNG THÍ NGHIỆM:");
				System.out.println("=====================================================================================================================================");
				System.out.printf("%-15s %-15s %10s %10s %-15s %-20s %10s %-16s %-15s\n", "Mã Phòng", "Dãy", "Diện tích", "Bóng đèn", "Ánh sáng", "Chuyên ngành", "Sức chứa", "Bồn rửa", "Đạt chuẩn");
				System.out.println("=====================================================================================================================================");
			}
			
			System.out.println(k);
		} else {
			System.out.println("Không tồn tại mã phòng này");
		}
	}

	private static void danhSachPhong() {
		System.out.println("\n*PHÒNG LÝ THUYẾT:");
		System.out.println("==============================================================================================");
		System.out.printf("%-15s %-15s %10s %10s %-15s %-10s %-15s\n", "Mã Phòng", "Dãy", "Diện tích", "Bóng đèn", "Ánh sáng", "Máy chiếu", "Đạt chuẩn");
		System.out.println("==============================================================================================");
		for (PhongHoc phong : list.getListPhongLyThuyet()) {
			System.out.println(phong);
		}
		
		
		System.out.println("\n*PHÒNG MÁY TÍNH:");
		System.out.println("==============================================================================================");
		System.out.printf("%-15s %-15s %10s %10s %-15s %10s %-15s\n", "Mã Phòng", "Dãy", "Diện tích", "Bóng đèn", "Ánh sáng", "Số máy", "Đạt chuẩn");
		System.out.println("==============================================================================================");
		for (PhongHoc phong : list.getListPhongMayTinh()) {
			System.out.println(phong);
		}
		
		
		System.out.println("\n*PHÒNG THÍ NGHIỆM:");
		System.out.println("=====================================================================================================================================");
		System.out.printf("%-15s %-15s %10s %10s %-15s %-20s %10s %-16s %-15s\n", "Mã Phòng", "Dãy", "Diện tích", "Bóng đèn", "Ánh sáng", "Chuyên ngành", "Sức chứa", "Bồn rửa", "Đạt chuẩn");
		System.out.println("=====================================================================================================================================");
		for (PhongHoc phong : list.getListPhongThiNghiem()) {
			System.out.println(phong);
		}
	}

	private static void danhSachPhongDatChuan() {
		System.out.println("\n*PHÒNG LÝ THUYẾT:");
		System.out.println("==============================================================================================");
		System.out.printf("%-15s %-15s %10s %10s %-15s %-10s %-15s\n", "Mã Phòng", "Dãy", "Diện tích", "Bóng đèn", "Ánh sáng", "Máy chiếu", "Đạt chuẩn");
		System.out.println("==============================================================================================");
		for (PhongHoc phong : list.getListPhongLyThuyet()) {
			if (phong.isDatChuan()) System.out.println(phong);
		}
		
		
		System.out.println("\n*PHÒNG MÁY TÍNH:");
		System.out.println("==============================================================================================");
		System.out.printf("%-15s %-15s %10s %10s %-15s %10s %-15s\n", "Mã Phòng", "Dãy", "Diện tích", "Bóng đèn", "Ánh sáng", "Số máy", "Đạt chuẩn");
		System.out.println("==============================================================================================");
		for (PhongHoc phong : list.getListPhongMayTinh()) {
			if (phong.isDatChuan()) System.out.println(phong);
		}
		
		
		System.out.println("\n*PHÒNG THÍ NGHIỆM:");
		System.out.println("=====================================================================================================================================");
		System.out.printf("%-15s %-15s %10s %10s %-15s %-20s %10s %-16s %-15s\n", "Mã Phòng", "Dãy", "Diện tích", "Bóng đèn", "Ánh sáng", "Chuyên ngành", "Sức chứa", "Bồn rửa", "Đạt chuẩn");
		System.out.println("=====================================================================================================================================");
		for (PhongHoc phong : list.getListPhongThiNghiem()) {
			if (phong.isDatChuan()) System.out.println(phong);
		}
	}

	private static void sapXepTheoDayNha() {
		list.sortTheoDayNha();
		System.out.println("Đã sắp xếp theo dãy nhà");
	}

	private static void sapXepTheoDienTich() {
		list.sortTheoDienTich();
		System.out.println("Đã sắp xếp theo diện tích");
	}

	private static void sapXepTheoSoBongDen() {
		list.sortTheoSoBongDen();
		System.out.println("Đã sắp xếp theo số bóng đèn");
	}
	
	private static void sapXepTuDong() {
		list.sort3Truong();
		System.out.println("Đã sắp xếp trên 3 trường");
	}

	private static void capNhatSoMayTinh() {
		System.out.println("\t\tCập nhật số máy tính");
		
		System.out.println("Nhập mã phòng: ");
		if (sc.hasNextLine()) sc.nextLine();
		String maPhong = sc.next();
		
		PhongHoc k = list.timPhong(maPhong);
		
		if (k != null) {
			System.out.println("Nhập số máy mới: ");
			int soMay = sc.nextInt();
			try {
				list.capNhatSoMay(maPhong, soMay);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Không tồn tại mã phòng này");
		}
		
	}

	private static void xoaPhong() {
		System.out.println("\t\t\t Xóa phòng");
		
		System.out.println("Nhập mã phòng: ");
		if (sc.hasNextLine()) sc.nextLine();
		String maPhong = sc.next();
		
		PhongHoc k = list.timPhong(maPhong);
		
		if (k != null) {
			if (k instanceof PhongLyThuyet) {
				System.out.println("\n*PHÒNG LÝ THUYẾT:");
				System.out.println("==============================================================================================");
				System.out.printf("%-15s %-15s %10s %10s %-15s %-10s %-15s\n", "Mã Phòng", "Dãy", "Diện tích", "Bóng đèn", "Ánh sáng", "Máy chiếu", "Đạt chuẩn");
				System.out.println("==============================================================================================");
			} else if (k instanceof PhongMayTinh) {
				System.out.println("\n*PHÒNG MÁY TÍNH:");
				System.out.println("==============================================================================================");
				System.out.printf("%-15s %-15s %10s %10s %-15s %10s %-15s\n", "Mã Phòng", "Dãy", "Diện tích", "Bóng đèn", "Ánh sáng", "Số máy", "Đạt chuẩn");
				System.out.println("==============================================================================================");
			} else {
				System.out.println("\n*PHÒNG THÍ NGHIỆM:");
				System.out.println("=====================================================================================================================================");
				System.out.printf("%-15s %-15s %10s %10s %-15s %-20s %10s %-16s %-15s\n", "Mã Phòng", "Dãy", "Diện tích", "Bóng đèn", "Ánh sáng", "Chuyên ngành", "Sức chứa", "Bồn rửa", "Đạt chuẩn");
				System.out.println("=====================================================================================================================================");
			}
			
			System.out.println(k);
			
			System.out.println("Bạn có muốn xóa phòng này không? [true/false]: ");
			boolean confirm = sc.nextBoolean();
			if (confirm) {
				try {
					list.xoaPhong(maPhong);
					System.out.println("Đã xóa thành công");
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("Đã hủy việc xóa phòng");
			}
		} else {
			System.out.println("Không tồn tại mã phòng này");
		}
	}

	private static void danhSachPhong60May() {
		System.out.println("\n*PHÒNG MÁY TÍNH 60 MÁY:");
		System.out.println("==============================================================================================");
		System.out.printf("%-15s %-15s %10s %10s %-15s %10s %-15s\n", "Mã Phòng", "Dãy", "Diện tích", "Bóng đèn", "Ánh sáng", "Số máy", "Đạt chuẩn");
		System.out.println("==============================================================================================");
		for (PhongHoc phong : list.getListPhongMayTinh()) {
			if (((PhongMayTinh)phong).getSoMayTinh() == 60) System.out.println(phong);
		}
	}

	public static void main(String[] args) {
		handleMenu();
	}
}
