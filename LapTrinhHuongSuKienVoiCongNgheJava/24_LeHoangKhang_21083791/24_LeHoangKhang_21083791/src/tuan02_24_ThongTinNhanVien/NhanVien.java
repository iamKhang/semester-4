package tuan02_24_ThongTinNhanVien;

import java.io.Serializable;
import java.util.Objects;

public class NhanVien  implements Serializable{
	private String maNV, hoNV, tenNV;
	private int tuoiNV;
	private boolean phai;
	private double tienLuong;

	public NhanVien() {
	}
	
	public NhanVien(String maNV) {
		super();
		this.maNV = maNV;
	}


	public NhanVien(String maNV, String hoNV, String tenNV, int tuoiNV, boolean phai, double tienLuong)
			throws Exception {
		setMaNV(maNV);
		setHoNV(hoNV);
		setTenNV(tenNV);
		setPhai(phai);
		setTuoiNV(tuoiNV);
		setTienLuong(tienLuong);
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) throws Exception {
		if (maNV.trim().equals("")) {
			throw new Exception("Phải nhập mã nhân viên!");
		} else
			this.maNV = maNV;
	}

	public String getHoNV() {
		return hoNV;
	}

	public void setHoNV(String hoNV) throws Exception {
		if (hoNV.trim().equals(""))
			throw new Exception("Họ không được rỗng!");
		else
			this.hoNV = hoNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) throws Exception {
		if (tenNV.trim().equals(""))
			throw new Exception("Tên không được rỗng!");
		else
			this.tenNV = tenNV;
	}

	public int getTuoiNV() {
		return tuoiNV;
	}

	public void setTuoiNV(int tuoiNV) throws Exception {
		if (tuoiNV < 0)
			throw new Exception("Tuổi phải là số nguyên dương!");
		else
			this.tuoiNV = tuoiNV;
	}

	public boolean isPhai() {
		return phai;
	}

	public void setPhai(boolean phai) {
		this.phai = phai;
	}

	public double getTienLuong() {
		return tienLuong;
	}

	public void setTienLuong(double tienLuong) throws Exception {
		if (tienLuong < 0)
			throw new Exception("Lương phải là số dương!");
		else
			this.tienLuong = tienLuong;
	}

	public Object[] getRow() {
		Object[] obj = new Object[6];
		obj[0] = maNV;
		obj[1] = hoNV;
		obj[2] = tenNV;
		obj[3] = phai ? "Nam" : "Nữ";
		obj[4] = tuoiNV;
		obj[5] = tienLuong;
		return obj;
	}
	
	

	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", hoNV=" + hoNV + ", tenNV=" + tenNV + ", tuoiNV=" + tuoiNV + ", phai="
				+ phai + ", tienLuong=" + tienLuong + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(maNV);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(maNV, other.maNV);
	}

}
