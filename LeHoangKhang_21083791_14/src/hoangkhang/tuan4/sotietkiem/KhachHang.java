package hoangkhang.tuan4.sotietkiem;

public class KhachHang {
	private String maKH;
	private String hoTenKH;
	private SoTietKiem[] dsSoTietKiem;
	private int soLuongSoHienCo;
	private int soLuongSoToiDa;
	private int soLuongSoHienTai;
	
	KhachHang(String maKH, String hoTenKh, int soLuongSoToiDa) {
		this.maKH = maKH;
		this.hoTenKH = hoTenKh;
		this.soLuongSoToiDa = soLuongSoToiDa;
		dsSoTietKiem = new SoTietKiem[soLuongSoToiDa];
		soLuongSoHienTai = 0;
	}

	public String getMaKH() {
		return maKH;
	}

	public String getHoTenKH() {
		return hoTenKH;
	}

	public SoTietKiem[] getDsSoTietKiem() {
		return dsSoTietKiem;
	}

	public int getSoLuongSoHienCo() {
		return soLuongSoHienCo;
	}

	public int getSoLuongSoToiDa() {
		return soLuongSoToiDa;
	}
	
	public void setHoTenKH(String hoTenKH) {
		this.hoTenKH = hoTenKH;
	}
	
	public boolean themSoTietKiem(SoTietKiem soTietKiemMoi) throws Exception {
		if (soLuongSoHienTai < soLuongSoToiDa) {
			dsSoTietKiem[soLuongSoHienTai] = soTietKiemMoi;
			soLuongSoHienTai++;
			return true;
		} else {
			throw new Exception("Số lượng sổ của người này đã đạt giới hạn!");
		}
	}

	@Override
	public String toString() {
		String result = "";
		
		result += String.format("Khách hàng: %s - %s\n" , this.maKH, this.hoTenKH);
		for (int i = 0; i < soLuongSoHienTai; i++) {
			result += dsSoTietKiem[i] + "\n";
		}
		return result;
	}
}
