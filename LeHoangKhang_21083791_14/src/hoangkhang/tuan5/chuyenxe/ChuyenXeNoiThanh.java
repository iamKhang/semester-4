package hoangkhang.tuan5.chuyenxe;

import java.text.NumberFormat;
import java.util.Locale;

public class ChuyenXeNoiThanh extends ChuyenXe {
	private int soTuyen;
	private double soKmDiDuoc;
	
	// Constructor
	public ChuyenXeNoiThanh() {
		// TODO Auto-generated constructor stub
	}
	
	public ChuyenXeNoiThanh(String maSo, String hoTenTaiXe, int soXe, double doanhThu) {
		super(maSo, hoTenTaiXe, soXe, doanhThu);
	}

	public ChuyenXeNoiThanh(String maSo, String hoTenTaiXe, int soXe, double doanhThu, int soTuyen, double soKmDiDuoc) {
		super(maSo, hoTenTaiXe, soXe, doanhThu);
		this.doanhThu = doanhThu;
		this.soKmDiDuoc = soKmDiDuoc;
	}

	// Getter, Setter
	int getSoTuyen() {
		return soTuyen;
	}

	void setSoTuyen(int soTuyen) {
		this.soTuyen = soTuyen;
	}

	double getSoKmDiDuoc() {
		return soKmDiDuoc;
	}

	void setSoKmDiDuoc(double soKmDiDuoc) {
		this.soKmDiDuoc = soKmDiDuoc;
	}
	
	// To String
	@Override
	public String toString() {
		NumberFormat vnd = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
		return super.toString() + String.format("%10d %10.1f %20s", soTuyen, soKmDiDuoc, vnd.format(doanhThu));
	}
}
