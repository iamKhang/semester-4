package hoangkhang.tuan5.congnhan;

public class Test {
	public static void main(String[] args) {
		DanhSachCongNhan list = new DanhSachCongNhan(5);
		
		try {
			list.them(new CongNhan("A", "A", 400));
			list.them(new CongNhan("B", "B", 200));
			list.them(new CongNhan("C", "C", 100));
			list.them(new CongNhan("D", "D",300));
			list.them(new CongNhan("E", "E", 600));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		list.sort();
		
		for (CongNhan item : list.getList()) {
			System.out.println(item);
		}
	}
}
