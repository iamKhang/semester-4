package hoangkhang.tuan4.sotietkiem;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class SoTietKiem {
	private String maSo;
	private LocalDate ngayMoSo;
	private double soTienGoi;
	private int kyHan;
	private float laiSuat;
	
	public SoTietKiem(String maSo, LocalDate ngayMoSo, double soTienGoi, int kyHan, float laiSuat) {
		super();
		this.maSo = maSo;
		this.ngayMoSo = ngayMoSo;
		this.soTienGoi = soTienGoi;
		this.kyHan = kyHan;
		this.laiSuat = laiSuat;
	}

	public String getMaSo() {
		return maSo;
	}

	public void setMaSo(String maSo) {
		this.maSo = maSo;
	}

	public LocalDate getNgayMoSo() {
		return ngayMoSo;
	}

	public void setNgayMoSo(LocalDate ngayMoSo) {
		this.ngayMoSo = ngayMoSo;
	}

	public double getSoTienGoi() {
		return soTienGoi;
	}

	public void setSoTienGoi(double soTienGoi) {
		this.soTienGoi = soTienGoi;
	}

	public int getKyHan() {
		return kyHan;
	}

	public void setKyHan(int kyHan) {
		this.kyHan = kyHan;
	}

	public float getLaiSuat() {
		return laiSuat;
	}

	public void setLaiSuat(float laiSuat) {
		this.laiSuat = laiSuat;
	}
	
	public int tinhSoThangGoiThuc() {
		long months = ChronoUnit.MONTHS.between(this.ngayMoSo, LocalDate.now());
		
		return (int)(months/kyHan * kyHan);
	}
	
	public double tinhTienLai() {
		return (soTienGoi * laiSuat * tinhSoThangGoiThuc());
	}
	
	@Override
	public String toString() {
		DecimalFormat fm = new DecimalFormat("#,##0.00");
		DateTimeFormatter dateFm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String result = String.format("STK %s[%s-%s]KH %d tháng, số tháng tính lãi: %d, ls %.3f, số tiền: %s --> Tiền lãi: %s", this.maSo, dateFm.format(ngayMoSo), dateFm.format(LocalDate.now()), this.kyHan, tinhSoThangGoiThuc(), laiSuat, fm.format(soTienGoi), fm.format(tinhTienLai()));
		return result;
	}
}
