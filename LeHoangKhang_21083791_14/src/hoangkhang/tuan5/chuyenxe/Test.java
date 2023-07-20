package hoangkhang.tuan5.chuyenxe;

import java.util.Scanner;

public class Test {
	static ChuyenXeArray list;
	static Scanner sc;
	
	static void init() {
		list = new ChuyenXeArray();
		sc = new Scanner(System.in);
	}
	
	static void menu() {
		int choose = 0;
		
		do {
			System.out.println("==============================================================");
			System.out.println("\t\t\tQUẢN LÍ CHUYẾN XE");
			System.out.println("==============================================================");
			System.out.println("1. Thêm cứng");
			System.out.println("2. Thêm chuyến xe");
			System.out.println("3. In danh sách các chuyến xe");
			System.out.println("4. Sửa thông tin chuyến xe");
			System.out.println("5. Xóa chuyến xe");
			System.out.println("6. Sắp xếp theo họ tên tài xế");
			System.out.println("7. Sắp xếp theo doanh thu");
			System.out.println("8. Tự sắp xếp");
			System.out.println("9. Thoát");
			System.out.println("==============================================================");
			System.out.print("Lựa chọn của bạn: ");
			choose = sc.nextInt();
			
			switch (choose) {
			case 1:
				themCung();
				break;
			case 2: 
				themChuyenXe();
				break;
			case 3:
				inDanhSach();
				break;
			case 4: 
				suaThongTin();
				break;
			case 5:
				xoaChuyenXe();
				break;
			case 6:
				sapXepTheoTen();
				break;
			case 7:
				sapXepTheoDoanhThu();
				break;
			case 8:
				sapXep2Truong();
				break;
			case 9: 
				System.exit(0);
			}
			
			System.out.println("Nhấn phím bất kỳ để tiếp tục");
			try {
				System.in.read();
			} catch(Exception e) {};
		} while (choose != 9);
	}
	
	private static void themCung() {
		ChuyenXe nt1 = new ChuyenXeNoiThanh("NT001", "Ngô Quyền", 9986523, 2000000, 10, 20.2);
		ChuyenXe nt2 = new ChuyenXeNoiThanh("NT002", "Đinh Bộ Lĩnh", 8122523, 1240000, 30, 90.2);
		ChuyenXe ngt1 = new ChuyenXeNgoaiThanh("NGT001", "Tôn Thất Thuyết", 23812903, 420000, "Gia Lai", 3);
		ChuyenXe ngt2 = new ChuyenXeNgoaiThanh("NGT002", "Trưng Trắc", 76273728, 960000, "Hà Nội", 5);
		
		try {
			list.them(nt1);
			list.them(nt2);
			list.them(ngt1);
			list.them(ngt2);
			System.out.println("Hoàn tất nhập cứng!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void themChuyenXe() {
		System.out.println("\t\t\t THÊM CHUYẾN XE");
		
		String maChuyen;
		System.out.print("Nhập vào mã số chuyến: ");
		if (sc.hasNextLine()) sc.reset();
		maChuyen = sc.next();
		
		if (list.timKiemViTri(maChuyen) != -1) {
			System.out.println("Mã chuyến xe đã tồn tại");
			return;
		}
		
		System.out.print("Nhập tên tài xế: ");
		if (sc.hasNextLine()) sc.nextLine();
		String name = sc.nextLine();
		
		System.out.print("Nhập vào số xe: ");
		int soXe = sc.nextInt();
		
		System.out.print("Nhập vào doanh thu xe: ");
		double doanhThu = sc.nextDouble();
		
		System.out.print("Đây là chuyến xe nội thành/ngoại thành (1/-): ");
		int isNoiThanh = sc.nextInt();
		
		ChuyenXe chuyenXeMoi;
		if (isNoiThanh == 1) {
			chuyenXeMoi = new ChuyenXeNoiThanh(maChuyen, name, soXe, doanhThu);
			
			System.out.print("Nhập số tuyến: ");
			((ChuyenXeNoiThanh)chuyenXeMoi).setSoTuyen(sc.nextInt());
			System.out.print("Nhập số km đi được: ");
			((ChuyenXeNoiThanh)chuyenXeMoi).setSoKmDiDuoc(sc.nextDouble());
		} else {
			chuyenXeMoi = new ChuyenXeNgoaiThanh(maChuyen, name, soXe, doanhThu);
			
			System.out.print("Nhập nơi đến: ");
			if(sc.hasNextLine()) sc.reset();
			((ChuyenXeNgoaiThanh)chuyenXeMoi).setNoiDen(sc.nextLine());
			System.out.print("Nhập số ngày di chuyển: ");
			((ChuyenXeNgoaiThanh)chuyenXeMoi).setSoNgayDiDuoc(sc.nextInt());
		}
		
		try {
			list.them(chuyenXeMoi);
			System.out.println("\nĐã thêm thành công chuyến xe");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void inDanhSach() {
		System.out.println("CÁC CHUYẾN XE NỘI THÀNH:");
		System.out.println("------------------------------------------------------------------------------------------------------------");
		System.out.printf("%-15s %-30s %15s %10s %10s %20s\n", "Mã chuyến", "Tài xế", "Số xe", "Số chuyến", "Số km", "Doanh thu");
		System.out.println("------------------------------------------------------------------------------------------------------------");
		for (ChuyenXe item : list.getListNoiThanh()) {
			System.out.println(item);
		}
		System.out.println("------------------------------------------------------------------------------------------------------------");
		
		System.out.println("\n\nCÁC CHUYẾN XE NGOẠI THÀNH:");
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%-15s %-30s %15s %-20s %10s %20s\n", "Mã chuyến", "Tài xế", "Số xe", "Nơi đến", "Số ngày", "Doanh thu");
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		for (ChuyenXe item : list.getListNgoaiThanh()) {
			System.out.println(item);
		}
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
	}

	private static void suaThongTin() {
		System.out.println("\t\t\tSửa thông tin");
		
		System.out.print("Nhập mã chuyến xe muốn sửa: ");
		if (sc.hasNextLine()) {
			sc.nextLine();
		}
		String maChuyen = sc.nextLine();
		
		ChuyenXe chuyenXeSua = list.timKiem(maChuyen);
		
		if (chuyenXeSua == null) {
			System.out.println("Không tìm thấy chuyến xe");
			return;
		}
		
		if (chuyenXeSua instanceof ChuyenXeNoiThanh) {
			System.out.println("CHUYẾN XE NỘI THÀNH:");
			System.out.println("------------------------------------------------------------------------------------------------------------");
			System.out.printf("%-15s %-30s %15s %10s %10s %20s\n", "Mã chuyến", "Tài xế", "Số xe", "Số tuyến", "Số km", "Doanh thu");
			System.out.println("------------------------------------------------------------------------------------------------------------");
		} else {
			System.out.println("CHUYẾN XE NGOẠI THÀNH:");
			System.out.println("---------------------------------------------------------------------------------------------------------------------");
			System.out.printf("%-15s %-30s %15s %-20s %10s %20s\n", "Mã chuyến", "Tài xế", "Số xe", "Nơi đến", "Số ngày", "Doanh thu");
			System.out.println("---------------------------------------------------------------------------------------------------------------------");
		}
		
		System.out.println(chuyenXeSua);
		System.out.println("------------------------------------------------------------------------------------------------------------");
		
		System.out.println("Bạn có muốn sửa thông tin xe này không? (1/0)");
		int check = sc.nextInt();
		
		if (check == 1) {
			int choose;
			
			do {
				System.out.println("===================================================");
				System.out.println("\t\t Sửa thông tin chuyến xe");
				System.out.println("===================================================");
				System.out.println("1. Sửa tên tài xế");
				System.out.println("2. Sửa số xe");
				System.out.println("3. Sửa doanh thu");
				if (chuyenXeSua instanceof ChuyenXeNoiThanh) {
					System.out.println("4. Sửa số chuyến");
					System.out.println("5. Sửa số km đi được");
				} else {
					System.out.println("4. Sửa nơi đến");
					System.out.println("5. Sửa số ngày đi");
				}
				System.out.println("6. Quay lại menu");
				System.out.println("===================================================");
				System.out.println("Lựa chọn của bạn");
				choose = sc.nextInt();
				
				switch (choose) {
				case 1:
					System.out.print("Nhập tên tài xế: ");
					if (sc.hasNextLine()) sc.nextLine();
					chuyenXeSua.setHoTenTaiXe(sc.nextLine());
					break;
				case 2:
					System.out.print("Nhập số xe: ");
					chuyenXeSua.setSoXe(sc.nextInt());
					break;
				case 3:
					System.out.print("Nhập doanh thu: ");
					chuyenXeSua.setDoanhThu(sc.nextDouble());
					break;
				case 4:
					if (chuyenXeSua instanceof ChuyenXeNoiThanh) {
						System.out.print("Nhập số chuyến: ");
						((ChuyenXeNoiThanh) chuyenXeSua).setSoTuyen(sc.nextInt());
					} else {
						System.out.print("Nhập nơi đến: ");
						if (sc.hasNextLine()) sc.nextLine();
						((ChuyenXeNgoaiThanh) chuyenXeSua).setNoiDen(sc.nextLine());
					}
					break;
				case 5:
					if (chuyenXeSua instanceof ChuyenXeNoiThanh) {
						System.out.print("Nhập số km đi được: ");
						((ChuyenXeNoiThanh) chuyenXeSua).setSoKmDiDuoc(sc.nextDouble());
					} else {
						System.out.print("Nhập số ngày di chuyển: ");
						((ChuyenXeNgoaiThanh) chuyenXeSua).setSoNgayDiDuoc(sc.nextInt());
					}
					break;
				}
			} while (choose != 6);
			
			list.sua(chuyenXeSua);
		}
	}

	private static void xoaChuyenXe() {
		System.out.println("\t\t Xóa chuyến xe");
		System.out.print("Nhập mã chuyến xe muốn sửa: ");
		if (sc.hasNextLine()) {
			sc.nextLine();
		}
		String maChuyen = sc.nextLine();
		
		ChuyenXe chuyenXeXoa = list.timKiem(maChuyen);
		
		if (chuyenXeXoa == null) {
			System.out.println("Không tìm thấy chuyến xe");
			return;
		}
		
		if (chuyenXeXoa instanceof ChuyenXeNoiThanh) {
			System.out.println("CHUYẾN XE NỘI THÀNH:");
			System.out.println("------------------------------------------------------------------------------------------------------------");
			System.out.printf("%-15s %-30s %15s %10s %10s %20s\n", "Mã chuyến", "Tài xế", "Số xe", "Số tuyến", "Số km", "Doanh thu");
			System.out.println("------------------------------------------------------------------------------------------------------------");
		} else {
			System.out.println("CHUYẾN XE NGOẠI THÀNH:");
			System.out.println("---------------------------------------------------------------------------------------------------------------------");
			System.out.printf("%-15s %-30s %15s %-20s %10s %20s\n", "Mã chuyến", "Tài xế", "Số xe", "Nơi đến", "Số ngày", "Doanh thu");
			System.out.println("---------------------------------------------------------------------------------------------------------------------");
		}
		
		System.out.println(chuyenXeXoa);
		System.out.println("------------------------------------------------------------------------------------------------------------");
		
		System.out.println("Bạn có muốn xóa xe này không? (1/0)");
		int check = sc.nextInt();
		
		if (check == 1) {
			list.xoa(chuyenXeXoa);
			System.out.println("Đã xóa chuyến xe");
		} else {
			System.out.println("Đã hủy việc xóa xe");
		}
	}

	private static void sapXepTheoTen() {
		list.sortTheoTenTaiXe();
		System.out.println("Đã sắp xếp theo tên");
	}

	private static void sapXepTheoDoanhThu() {
		list.sortTheoDoanhThu();
		System.out.println("Đã sắp theo doanh thu");
	}

	private static void sapXep2Truong() {
		list.sortTheo2Truong();
		System.out.println("Đã sắp theo mặc định");
	}

	public static void main(String[] args) {
		init();
		menu();
	}
}
