package hoangkhang.tuan6.phonghoc;

public class PhongMayTinh extends PhongHoc{
	private int soMayTinh;
	
	public PhongMayTinh() {
		// TODO Auto-generated constructor stub
	}
	
	public PhongMayTinh(String maPhong, String dayNha, double dienTich, int soBongDen, int soMayTinh) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.soMayTinh = soMayTinh;
	}

	public int getSoMayTinh() {
		return soMayTinh;
	}

	public void setSoMayTinh(int soMayTinh) {
		this.soMayTinh = soMayTinh;
	}

	@Override
	public boolean isDatChuan() {
		if (isDuAnhSang() && dienTich/soMayTinh <= 1.5) return true;
		
		return false;
	}
	
	
	@Override
	public String toString() {
		String result = super.toString();
		
		result += String.format("%10d %-15s", soMayTinh, (isDatChuan() ? "Đạt" : "Không đạt"));
		
		return result;
	}
}
