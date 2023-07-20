package hoangkhang.tuan4.hangthucpham;

import java.text.ParseException;

public class TestHangThucPham {
	public static void main(String[] args) throws ParseException {
		try {
			HangThucPham gao = new HangThucPham("001", "Gạo", 100000, "10/07/2022", "10/12/2023");
			HangThucPham mi = new HangThucPham("002", "Mì", 5000, "01/03/2022", "01/12/2022");
			HangThucPham nuoc = new HangThucPham("003", "Nước", 10000, "10/02/2022", "22/09/2022");
			
			System.out.println("-----------------------------------------------------------------------------------------------------------");
			System.out.printf("%-10s %-20s %20s  %-15s %-15s %-20s\n", "Mã hàng", "Tên hàng", "Giá thành", "Ngày sản xuất", "Ngày hết hạn", "Ghi chú");
			System.out.println("-----------------------------------------------------------------------------------------------------------");
			System.out.println(gao);
			System.out.println(mi);
			System.out.println(nuoc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
