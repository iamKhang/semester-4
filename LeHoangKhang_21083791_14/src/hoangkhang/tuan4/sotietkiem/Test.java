package hoangkhang.tuan4.sotietkiem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Test {
	public static void main(String[] args) {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		KhachHang canh = new KhachHang("KH001", "Nguyễn Thanh Cảnh", 10);
		try {
			canh.themSoTietKiem(new SoTietKiem("111", LocalDate.parse("01/03/2022", dateFormatter), 1000000, 3, 0.005f));
			canh.themSoTietKiem(new SoTietKiem("112", LocalDate.parse("10/05/2021", dateFormatter), 10000000, 6, 0.006f));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(canh);
	}
}
