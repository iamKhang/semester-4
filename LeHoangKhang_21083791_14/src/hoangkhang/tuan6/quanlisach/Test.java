package hoangkhang.tuan6.quanlisach;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Test {
	static Scanner sc = new Scanner(System.in);
	static DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	static DanhSachSach list = new DanhSachSach();
	
	static void menu() {
		int choose;
		
		do {
			System.out.println("==================================================================");
			System.out.println("\t\t\tQuản lí sách");
			System.out.println("==================================================================");
			System.out.println("1. Xem danh sách");
			System.out.println("2. Thêm cứng");
			System.out.println("3. Thêm sách");
			System.out.println("4. Sửa thông tin sách");
			System.out.println("5. Xóa sách");
			System.out.println("6. Tìm kiếm thông tin sách");
			System.out.println("7. Sắp xếp theo tên nhà xuất bản");
			System.out.println("8. Sắp xếp theo ngày nhập");
			System.out.println("9. Sắp xếp theo thành tiền");
			System.out.println("10. Sắp xếp mặc định");
			System.out.println("11. Thoát");
			System.out.println("==================================================================");
			
			System.out.print("Lựa chọn của bạn: ");
			choose = sc.nextInt();
			
			switch (choose) {
			case 1:
				xemDanhSach();
				break;
			case 2:
				themCung();
				break;
			case 3:
				themSach();
				break;
			case 4:
				suaSach();
				break;
			case 5:
				xoaSach();
				break;
			case 6:
				timSach();
				break;
			case 7:
				sapXepTheoNXB();
				break;
			case 8:
				sapXepTheoNgayNhap();
				break;
			case 9: 
				sapXepTheoThanhTien();
				break;
			case 10:
				sapXepTheoMacDinh();
				break;
			case 11:
				System.exit(0);
			}
			
			System.out.println("Ấn phím bất kỳ để tiếp tục");
			try {
				System.in.read();
			} catch(Exception e) {};
			
		} while (choose != 10);
	}
	
	private static void xemDanhSach() {
		System.out.println("\n*SÁCH GIÁO KHOA: ");
		System.out.println("=================================================================================================================");
		System.out.printf("%-15s %-15s %15s %10s %-20s %-10s %20s\n", "Mã Sách", "Ngày nhập", "Đơn giá", "Số Lượng", "Nhà xuất bản", "Tình trạng", "Thành tiền");
		System.out.println("=================================================================================================================");
		for (Sach item : list.getListSachGiaoKhoa()) {
			System.out.println(item);
		}
		System.out.println("=================================================================================================================");
		
		System.out.println("\n*SÁCH THAM KHẢO: ");
		System.out.println("======================================================================================================================");
		System.out.printf("%-15s %-15s %15s %10s %-20s %15s %20s\n", "Mã Sách", "Ngày nhập", "Đơn giá", "Số Lượng", "Nhà xuất bản", "Thuế", "Thành tiền");
		System.out.println("======================================================================================================================");
		for (Sach item : list.getListSachThamKhao()) {
			System.out.println(item);
		}
		System.out.println("======================================================================================================================");
	}

	private static void themCung() {
		Sach sgk1 = new SachGiaoKhoa("SGK001", LocalDate.parse("25/04/2022", formatDate), 20000, 123, "Bộ Giáo Dục", true);
		Sach sgk2 = new SachGiaoKhoa("SGK002", LocalDate.parse("20/04/2022", formatDate), 45000, 1000, "Nhà xuất bản vô danh", false);
		
		Sach stk1 = new SachThamKhao("STK001", LocalDate.parse("10/09/2022", formatDate), 90000, 55, "Kim Đồng", 200);
		Sach stk2 = new SachThamKhao("STK002", LocalDate.parse("08/09/2022", formatDate), 50000, 1225, "Bộ Giáo Dục", 500);
		
		try {
			list.them(sgk1);
			list.them(sgk2);
			list.them(stk1);
			list.them(stk2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void themSach() {
		System.out.println("\t\t\tTHÊM SÁCH");
		
		System.out.print("Nhập mã sách muốn thêm: ");
		if (sc.hasNextLine()) sc.nextLine();
		String maSach = sc.next();
		
		if (list.timKiemViTri(maSach) != -1) {
			System.out.println("Mã sách đã trùng!");
			return;
		}
		
		System.out.print("Ngày nhập sách (dd/MM/yyyy): ");
		String ngayNhap = sc.next();
		
		System.out.print("Đơn giá: ");
		double donGia = sc.nextDouble();
		
		System.out.print("Số lượng: ");
		int soLuong = sc.nextInt();
		
		System.out.print("Tên nhà xuất bản: ");
		if (sc.hasNextLine()) sc.nextLine();
		String nxb = sc.nextLine();
		
		System.out.print("Loại sách (Giáo khoa[0]/Tham khảo[1]): ");
		short type = sc.nextShort();
		
		Sach sachMoi;
		if (type == 0) {
			System.out.print("Nhập tình trạng sách (Mới[true]/Cũ[false]): ");
			boolean tinhTrang = sc.nextBoolean();
			
			sachMoi = new SachGiaoKhoa(maSach, LocalDate.parse(ngayNhap, formatDate), donGia, soLuong, nxb, tinhTrang);
		} else {
			System.out.print("Nhập thuế: ");
			double thue = sc.nextDouble();
			
			sachMoi = new SachThamKhao(maSach, LocalDate.parse(ngayNhap, formatDate), donGia, soLuong, nxb, thue);
		}
		
		try {
			list.them(sachMoi);
			System.out.println("Đã thêm sách thành công");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void suaSach() {
		System.out.println("\t\t\tSửa sách");
		System.out.print("Nhập mã sách muốn sửa: ");
		if (sc.hasNextLine()) sc.nextLine();
		String maSach = sc.next();
		
		int index = list.timKiemViTri(maSach);
		if (index != -1) {
			Sach current = list.getList().get(index);
	
			if (current instanceof SachGiaoKhoa) {
				System.out.println("\n*SÁCH GIÁO KHOA: ");
				System.out.println("=================================================================================================================");
				System.out.printf("%-15s %-15s %15s %10s %-20s %-10s %20s\n", "Mã Sách", "Ngày nhập", "Đơn giá", "Số Lượng", "Nhà xuất bản", "Tình trạng", "Thành tiền");
				System.out.println("=================================================================================================================");
				System.out.println(current);
				System.out.println("=================================================================================================================");
			} else {
				System.out.println("\n*SÁCH THAM KHẢO: ");
				System.out.println("======================================================================================================================");
				System.out.printf("%-15s %-15s %15s %10s %-20s %15s %20s\n", "Mã Sách", "Ngày nhập", "Đơn giá", "Số Lượng", "Nhà xuất bản", "Thuế", "Thành tiền");
				System.out.println("======================================================================================================================");
				System.out.println(current);
				System.out.println("======================================================================================================================");
			}
			
			System.out.println("Bạn có muốn sửa sách này không? (true/false)");
			boolean confirm = sc.nextBoolean();
			if (confirm) {
				int choose;
				do {
					System.out.println("\t\tSửa sách");
					System.out.println("==============================================");
					System.out.println("1. Sửa ngày nhập");
					System.out.println("2. Sửa đơn giá");
					System.out.println("3. Sửa số lượng");
					System.out.println("4. Sửa nhà xuất bản");
					System.out.printf("5. Sửa %s\n", (current instanceof SachGiaoKhoa ? "Tình trạng" : "Thuế"));
					System.out.println("6. Hoàn tất sửa");
					System.out.println("==============================================");
					
					System.out.println("Lựa chọn của bạn: ");
					choose = sc.nextInt();
					
					switch (choose) {
					case 1:
						System.out.print("Ngày nhập sách (dd/MM/yyyy): ");
						current.setNgayNhap(LocalDate.parse(sc.next(), formatDate));
						break;
					case 2:
						System.out.print("Đơn giá: ");
						current.setDonGia(sc.nextDouble());
						break;
					case 3:
						System.out.print("Số lượng: ");
						current.setDonGia(sc.nextDouble());
						break;
					case 4:
						System.out.print("Tên nhà xuất bản: ");
						if (sc.hasNextLine()) sc.nextLine();
						current.setNhaXuatBan(sc.nextLine());
						break;
					case 5:
						if (current instanceof SachGiaoKhoa) {
							System.out.print("Nhập tình trạng sách (Mới[true]/Cũ[false]): ");
							((SachGiaoKhoa)current).setTinhTrang(sc.nextBoolean());
						} else {
							System.out.print("Nhập thuế: ");
							((SachThamKhao)current).setThue(sc.nextDouble());
						}
						break;
					}
				} while (choose != 6);
			} else {
				System.out.println("Đã hủy việc sửa");
			}
		} else {
			System.out.println("Không tìm thấy sách có mã " + maSach);
		}
	}

	private static void xoaSach() {
		System.out.println("\t\t\tXóa sách");
		System.out.print("Nhập mã sách muốn xóa: ");
		if (sc.hasNextLine()) sc.nextLine();
		String maSach = sc.next();
		
		int index = list.timKiemViTri(maSach);
		if (index != -1) {
			Sach current = list.getList().get(index);
	
			if (current instanceof SachGiaoKhoa) {
				System.out.println("\n*SÁCH GIÁO KHOA: ");
				System.out.println("=================================================================================================================");
				System.out.printf("%-15s %-15s %15s %10s %-20s %-10s %20s\n", "Mã Sách", "Ngày nhập", "Đơn giá", "Số Lượng", "Nhà xuất bản", "Tình trạng", "Thành tiền");
				System.out.println("=================================================================================================================");
				System.out.println(current);
				System.out.println("=================================================================================================================");
			} else {
				System.out.println("\n*SÁCH THAM KHẢO: ");
				System.out.println("======================================================================================================================");
				System.out.printf("%-15s %-15s %15s %10s %-20s %15s %20s\n", "Mã Sách", "Ngày nhập", "Đơn giá", "Số Lượng", "Nhà xuất bản", "Thuế", "Thành tiền");
				System.out.println("======================================================================================================================");
				System.out.println(current);
				System.out.println("======================================================================================================================");
			}
			
			System.out.println("Bạn có muốn xóa sách này không? (true/false)");
			boolean confirm = sc.nextBoolean();
			if (confirm) {
				list.xoa(index);
				System.out.println("Đã xóa sách!");
			} else {
				System.out.println("Đã hủy việc xóa");
			}
		} else {
			System.out.println("Không tìm thấy sách có mã " + maSach);
		}
	}

	private static void timSach() {
		System.out.println("\t\t\tTìm sách");
		System.out.print("Nhập mã sách muốn tìm: ");
		if (sc.hasNextLine()) sc.nextLine();
		String maSach = sc.next();
		
		int index = list.timKiemViTri(maSach);
		if (index != -1) {
			Sach current = list.getList().get(index);
	
			if (current instanceof SachGiaoKhoa) {
				System.out.println("\n*SÁCH GIÁO KHOA: ");
				System.out.println("=================================================================================================================");
				System.out.printf("%-15s %-15s %15s %10s %-20s %-10s %20s\n", "Mã Sách", "Ngày nhập", "Đơn giá", "Số Lượng", "Nhà xuất bản", "Tình trạng", "Thành tiền");
				System.out.println("=================================================================================================================");
				System.out.println(current);
				System.out.println("=================================================================================================================");
			} else {
				System.out.println("\n*SÁCH THAM KHẢO: ");
				System.out.println("======================================================================================================================");
				System.out.printf("%-15s %-15s %15s %10s %-20s %15s %20s\n", "Mã Sách", "Ngày nhập", "Đơn giá", "Số Lượng", "Nhà xuất bản", "Thuế", "Thành tiền");
				System.out.println("======================================================================================================================");
				System.out.println(current);
				System.out.println("======================================================================================================================");
			}
		} else {
			System.out.println("Không tìm thấy sách có mã " + maSach);
		}
	}

	private static void sapXepTheoNXB() {
		list.sapXepTheoNXB();
		System.out.println("Đã sắp xếp theo nhà xuất bản");
	}

	private static void sapXepTheoNgayNhap() {
		list.sapXepTheoNgayNhap();
		System.out.println("Đã sắp xếp theo ngày nhập");
	}

	private static void sapXepTheoThanhTien() {
		list.sapXepTheoDonGia();
		System.out.println("Đã sắp xếp theo thành tiền");
	}
	
	private static void sapXepTheoMacDinh() {
		list.sapXep();
		System.out.println("Đã sắp xếp theo mặc định");
	}

	public static void main(String[] args) {
		menu();
	}
}
