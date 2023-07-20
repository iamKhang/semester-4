package hoangkhang.tuan1.quanlixe;

import java.util.Scanner;

public class TestVehicle {
	static Scanner sc = new Scanner(System.in);
	public static void printLine() {
		System.out.println("------------------------------------------------------------------------------------------------------");
	}
	public static void printLine2() {
		System.out.println("======================================================================================================");
	}
	
	public static Vehicle createVehicle(int index) {
		printLine();
		Vehicle vehicle = new Vehicle();
		System.out.println("* Nhap thong tin cho xe thu " + ++index + " : ");
		printLine();
		
		System.out.print("1. Ten chu xe: ");
		vehicle.setOwnerName(sc.nextLine());
		
		System.out.print("2. Ten xe: ");
		vehicle.setVehicleName(sc.nextLine());
		
		System.out.print("3. Nhap dung tich xe: ");
		vehicle.setXylanh(sc.nextInt());
		
		System.out.print("4. Nhap gia xe: ");
		vehicle.setPrice(sc.nextFloat());
		return vehicle;
	}
	
	public static void inputList(Vehicle[] vehicles) {
		for (int i = 0; i < vehicles.length; i++) {
			vehicles[i] = createVehicle(i);
			sc.nextLine(); // fflush
		}
	}
	
	public static void printList(Vehicle[] vehicles) {
		printLine();
		System.out.printf("%-30s\t%-20s\t%10s\t%10s\t%10s\n", "Ten chu xe", "Loai xe", "Dung tich", "Tri gia", "Thue nop");
		printLine();
		
		for (int i = 0; i < vehicles.length; i++) {
			System.out.println(vehicles[i]);
		}
	}
	
	public static void main(String[] args) {
		printLine2();
		System.out.printf("%60s\n","===QUAN LI XE===");
		printLine2();
		
		Vehicle[] vehicles = new Vehicle[3];
		inputList(vehicles);
		printList(vehicles);
	
		sc.close();
	}
}