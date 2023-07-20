package hoangkhang.tuan1.quanlisinhvien;

import java.util.Scanner;

class TestSinhVien {
	
	public static void tenPhanMem() {
		System.out.println("\t\t\t--QUAN LI SINH VIEN--");
		System.out.println("======================================================================");
	}
	
	public static void nhapThongTin(SinhVien sv) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("* Vui long nhap thong tin cho sinh vien moi: ");
		
		System.out.print("1. MSSV: ");
		sv.setMssv(scanner.nextInt());
		
		System.out.print("2. Ho va ten: ");
		scanner.nextLine(); // clear /n
		sv.setHoTen(scanner.nextLine());
		
		System.out.print("3. Diem LT: ");
		sv.setDiemLT(scanner.nextFloat());
		
		System.out.print("4. Diem TH: ");
		sv.setDiemTH(scanner.nextFloat());
		
		scanner.close();
	}
	
	public static void inTieuDe() {
		System.out.println("\t\t\t---DANH SACH SINH VIEN---");
		System.out.println("======================================================================");
		System.out.printf("%8s\t%-30s\t%5s\t%5s\t%5s\n", "MSSV", "HO VA TEN", "LT", "TH", "TB");
		System.out.print("======================================================================");
	}

	public static void main(String[] args) {
		tenPhanMem();
		
		SinhVien sv1 = new SinhVien(21086671, "Nguyen Thanh Canh", 10, 10);
		SinhVien sv2 = new SinhVien(87654321, "Trinh Ngoc Anh", 10, 10);
		SinhVien sv3 = new SinhVien();
		nhapThongTin(sv3);
		
		inTieuDe();
		System.out.println(sv1);
		System.out.println(sv2);
		System.out.println(sv3);
	}
}