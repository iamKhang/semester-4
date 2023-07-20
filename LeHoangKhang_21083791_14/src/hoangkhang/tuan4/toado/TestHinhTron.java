package hoangkhang.tuan4.toado;

import java.util.Scanner;

public class TestHinhTron {
	public static void main(String[] args) {
		HinhTron hc;
		ToaDo o;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Chương trình tính chu vi và diện tích của hình tròn");
		System.out.print("Nhập vào x và y là tọa độ tâm O: ");
		float x = sc.nextFloat(), y = sc.nextFloat();
		System.out.print("Nhập vào bán kính hình tròn: ");
		sc.reset();
		double r = sc.nextDouble();
		
		o = new ToaDo("O", x, y);
		hc = new HinhTron(o, r);
		
		System.out.println(hc);
		
		sc.close();
	}
}
