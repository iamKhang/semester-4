package hoangkhang.tuan6.phonghoc;

public class PhongLyThuyet extends PhongHoc{
	private boolean hasMayChieu;
	
	public PhongLyThuyet() {
		super();
	}

	public PhongLyThuyet(String maPhong, String dayNha, double dienTich, int soBongDen) {
		super(maPhong, dayNha, dienTich, soBongDen);
	}

	public PhongLyThuyet(String maPhong, String dayNha, double dienTich, int soBongDen, boolean hasMayChieu) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.hasMayChieu = hasMayChieu;
	}

	public boolean isHasMayChieu() {
		return hasMayChieu;
	}

	public void setHasMayChieu(boolean hasMayChieu) {
		this.hasMayChieu = hasMayChieu;
	}

	@Override
	public boolean isDatChuan() {
		return (isDuAnhSang() && hasMayChieu);
	}

	@Override
	public String toString() {
		String result = super.toString();
		
		result += String.format("%-10s %-15s", (hasMayChieu ? "Có" : "Không"), (isDatChuan() ? "Đạt" : "Không đạt"));
		
		return result;
	}
	
	
}
