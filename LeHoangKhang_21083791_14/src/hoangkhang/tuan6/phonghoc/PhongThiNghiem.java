package hoangkhang.tuan6.phonghoc;

public class PhongThiNghiem extends PhongHoc{
	private String chuyenNganh;
	private int sucChua;
	private boolean hasBonRua;
	
	public PhongThiNghiem() {
		// TODO Auto-generated constructor stub
	}

	public PhongThiNghiem(String maPhong, String dayNha, double dienTich, int soBongDen, String chuyenNganh, int sucChua, boolean hasBonRua) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.chuyenNganh = chuyenNganh;
		this.sucChua = sucChua;
		this.hasBonRua = hasBonRua;
	}

	public String getChuyenNganh() {
		return chuyenNganh;
	}

	public void setChuyenNganh(String chuyenNganh) {
		this.chuyenNganh = chuyenNganh;
	}

	public int getSucChua() {
		return sucChua;
	}

	public void setSucChua(int sucChua) {
		this.sucChua = sucChua;
	}

	public boolean isHasBonRua() {
		return hasBonRua;
	}

	public void setHasBonRua(boolean hasBonRua) {
		this.hasBonRua = hasBonRua;
	}

	@Override
	public boolean isDatChuan() {
		return (isDuAnhSang() && hasBonRua);
	}
	
	@Override
	public String toString() {
		String result = super.toString();
		
		result += String.format("%-20s %10d %-16s %-15s", chuyenNganh, sucChua, (hasBonRua ? "Có" : "Không"), (isDatChuan() ? "Đạt" : "Không đạt"));
		
		return result;
	}
}
