package hoangkhang.tuan4.toado_array;

import java.util.Scanner;

public class TestHinhTronArray {
	static HinhTronArray list;
	static Menu menu;
	static Scanner sc;

	public static void init() {
		sc = new Scanner(System.in);
		list = new HinhTronArray(10);

		String[] menuItem = { "Danh sách hình tròn", "Thêm hình tròn", "Sửa hình tròn", "Xóa hình tròn",
				"Sắp xếp mặc định (tên của tâm)", "Sắp xếp theo bán kính", "Thoát" };
		menu = new Menu(menuItem, "MẢNG HÌNH TRÒN", 80);

		// Tạo cứng sẵn

		try {
			list.add(new HinhTron(new ToaDo("C", 1, 1), 3.2));
			list.add(new HinhTron(new ToaDo("A", 0, 0), 4.2));
			list.add(new HinhTron(new ToaDo("B", 1, 1), 2.5));
		} catch (Exception e) {
			menu.notification("error", e.getMessage());
		}
	}

	public static void handleMenu() {
		int choose = 0;
		do {
			System.out.println(menu);
			System.out.print("Lựa chọn của bạn: ");

			choose = sc.nextInt();
			switch (choose) {
			case 1:
				inListHinhTron();
				break;
			case 2:
				themHinhTron();
				break;
			case 3:
				suaHinhTron();
				break;
			case 4:
				xoaHinhTron();
				break;
			case 5:
				sapXep();
				break;
			case 6:
				sapXepTheoBanKinh();
				break;
			case 7:
				System.exit(0);
			}

			pressToContinue();
		} while (choose != menu.getLength());
	}

	private static void inListHinhTron() {
		System.out.println(menu.subTitle2("Danh sách các hình tròn"));
		System.out.println(menu
				.tableTitle(String.format("%-20s %15s %15s %15s", "Tọa độ tâm", "Bán kính", "Diện tích", "Chu vi")));
		for (int i = 0; i < list.currSize; i++) {
			System.out.println(list.getList()[i]);
		}
		System.out.println('\n' + menu.getLine1());
	}

	private static void themHinhTron() {
		System.out.println(menu.subTitle2("Thêm hình tròn mới"));
		String name;
		float x, y;
		double r;

		System.out.print(menu.question("Nhập tên tâm hình tròn: "));
		if (sc.hasNextLine())
			sc.nextLine();
		name = sc.nextLine();
		System.out.print(menu.question("Nhập lần lượt tọa độ x, y tâm " + name + ": "));
		x = sc.nextFloat();
		y = sc.nextFloat();

		System.out.print(menu.question("Nhập bán kính hình tròn: "));
		r = sc.nextDouble();

		try {
			list.add(new HinhTron(new ToaDo(name, x, y), r));
			System.out.println(menu.notification("success", "Thêm hình tròn " + name + " thành công"));
		} catch (Exception e) {
			System.out.println(menu.notification("error", e.getMessage()));
		}
	}

	private static void suaHinhTron() {
		System.out.println(menu.subTitle2("Sửa hình tròn"));
		System.out.print(menu.question("Nhập tên của tâm hình tròn muốn sửa: "));
		if (sc.hasNextLine())
			sc.nextLine();
		String key = sc.nextLine();

		int index = list.search(key);
		if (index == -1) {
			System.out.println(menu.notification("info", "Không tìm thấy hình tròn có tâm tên " + key));
		} else {
			System.out.println(menu.subTitle("Sửa thông tin hình tròn tâm " + key));
			String name;
			float x, y;
			double r;

			System.out.print(menu.question("Nhập tên mới cho tâm hình tròn: "));
			if (sc.hasNextLine() == true) {
				sc.reset();
			}
			name = sc.nextLine();
			System.out.print(menu.question("Nhập lần lượt tọa độ x, y tâm " + name + ": "));
			x = sc.nextFloat();
			y = sc.nextFloat();

			System.out.print(menu.question("Nhập bán kính hình tròn: "));
			r = sc.nextDouble();

			try {
				list.sua(index, new HinhTron(new ToaDo(name, x, y), r));
				System.out.println(menu.notification("success", "Sửa thông tin hình tròn " + key + " thành công"));
			} catch (Exception e) {
				System.out.println(menu.notification("error", e.getMessage()));
			}
		}
	}

	private static void xoaHinhTron() {
		System.out.println(menu.subTitle2("Xóa hình tròn"));

		System.out.print(menu.question("Nhập tên của tâm hình tròn muốn xóa: "));

		if (sc.hasNextLine())
			sc.nextLine();
		String key = sc.nextLine();

		int index = list.search(key);

		if (index != -1) {
			try {
				list.xoa(index);
				System.out.println(menu.notification("success", "Đã xóa hình tròn có tâm " + key));
			} catch (Exception e) {
				System.out.println(menu.notification("error", e.getMessage()));
			}
		} else {
			System.out.println(menu.notification("info", "Không tìm thấy hình tròn tâm " + key));
		}
	}

	private static void sapXep() {
		list.sort();
		System.out.println(menu.notification("success", "Đã sắp xếp thành công!"));
	}

	private static void sapXepTheoBanKinh() {
		list.sortBanKinh();
		System.out.println(menu.notification("success", "Đã sắp xếp theo bán kính thành công!"));
	}

	public static void pressToContinue() {
		System.out.println(menu.centerText("-/- Nhấn phím bất kỳ để tiếp tục -/-"));
		try {
			System.in.read();
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) {
		init();
		handleMenu();
	}
}
