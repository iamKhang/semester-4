package hoangkhang.tuan5.chuyenxe;

import java.text.NumberFormat;
import java.util.Locale;

public class ChuyenXeNgoaiThanh extends ChuyenXe{
	private String noiDen;
	private int soNgayDiDuoc;
	
	// Constructor
	public ChuyenXeNgoaiThanh() {
		// TODO Auto-generated constructor stub
	}

	public ChuyenXeNgoaiThanh(String maSo, String hoTenTaiXe, int soXe, double doanhThu) {
		super(maSo, hoTenTaiXe, soXe, doanhThu);
		// TODO Auto-generated constructor stub
	}

	public ChuyenXeNgoaiThanh(String maSo, String hoTenTaiXe, int soXe, double doanhThu, String noiDen, int soNgayDiDuoc) {
		super(maSo, hoTenTaiXe, soXe, doanhThu);
		this.noiDen = noiDen;
		this.soNgayDiDuoc = soNgayDiDuoc;
	}
	
	// Getter, Setter
	String getNoiDen() {
		return noiDen;
	}

	void setNoiDen(String noiDen) {
		this.noiDen = noiDen;
	}

	int getSoNgayDiDuoc() {
		return soNgayDiDuoc;
	}

	void setSoNgayDiDuoc(int soNgayDiDuoc) {
		this.soNgayDiDuoc = soNgayDiDuoc;
	}
	
	// To String
	@Override
	public String toString() {
		NumberFormat vnd = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
		return super.toString() + String.format("%-20s %10d %20s", noiDen, soNgayDiDuoc, vnd.format(doanhThu));
	}
}
