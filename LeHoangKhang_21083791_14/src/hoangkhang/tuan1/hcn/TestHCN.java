package hoangkhang.tuan1.hcn;

import java.util.Scanner;

public class TestHCN {
	public static void printNotice(String message) {
		System.out.println("====================================");
		System.out.println(message);
		System.out.println("====================================");
	}
	
	public static void main(String[] args) {
		printNotice("---Day la phan mem tinh S, V HCN---");
		Scanner sc = new Scanner(System.in);
		
		HCN hcn1 = new HCN();
		System.out.print("+ Moi ban nhap chieu dai HCN: ");
		hcn1.setChieuDai(sc.nextDouble());
		System.out.print("+ Moi ban nhap chieu rong HCN: ");
		hcn1.setChieuRong(sc.nextDouble());

		printNotice("\t-/- DANG XU LY -/-");
		
		System.out.println(hcn1);
		
		printNotice("--Chuong trinh ket thuc--");
		sc.close();
	}
}
