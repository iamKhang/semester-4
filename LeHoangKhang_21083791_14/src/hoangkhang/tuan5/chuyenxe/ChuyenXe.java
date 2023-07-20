package hoangkhang.tuan5.chuyenxe;

import java.util.Objects;

public class ChuyenXe {
	protected String maSo;
	protected String hoTenTaiXe;
	protected int soXe;
	protected double doanhThu;
	
	// Constructor
	public ChuyenXe() {
		// TODO Auto-generated constructor stub
	}
	
	public ChuyenXe(String maSo, String hoTenTaiXe, int soXe, double doanhThu) {
		super();
		this.maSo = maSo;
		this.hoTenTaiXe = hoTenTaiXe;
		this.soXe = soXe;
		this.doanhThu = doanhThu;
	}
	
	// Getter, Setter
	String getMaSo() {
		return maSo;
	}
	
	void setMaSo(String maSo) {
		this.maSo = maSo;
	}
	
	String getHoTenTaiXe() {
		return hoTenTaiXe;
	}
	
	void setHoTenTaiXe(String hoTenTaiXe) {
		this.hoTenTaiXe = hoTenTaiXe;
	}
	
	int getSoXe() {
		return soXe;
	}
	
	void setSoXe(int soXe) {
		this.soXe = soXe;
	}
	
	double getDoanhThu() {
		return doanhThu;
	}
	
	void setDoanhThu(double doanhThu) {
		this.doanhThu = doanhThu;
	}
	
	// Hascode & Equals
	@Override
	public int hashCode() {
		return Objects.hash(doanhThu, hoTenTaiXe, maSo, soXe);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChuyenXe other = (ChuyenXe) obj;
		
		return maSo.equalsIgnoreCase(other.maSo);
	}

	
	// To String
	@Override
	public String toString() {
		return String.format("%-15s %-30s %15d ", maSo, hoTenTaiXe, soXe);
	}
}
