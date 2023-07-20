package tuan04_24_JTreeQuanLyPhongBan;

import java.util.ArrayList;
import java.util.Objects;

public class PhongBan {
	private String maPhongBan;
	private String tenPhongBan;
	private DanhSachNhanVien dsNhanVien;

	public PhongBan() {
		super();
	}

	public PhongBan(String maPhongBan, String tenPhongBan) {
		super();
		this.maPhongBan = maPhongBan;
		this.tenPhongBan = tenPhongBan;
		dsNhanVien = new DanhSachNhanVien();
	}


	public PhongBan(String maPhongBan, String tenPhongBan, DanhSachNhanVien dsNhanVien) {
		super();
		this.maPhongBan = maPhongBan;
		this.tenPhongBan = tenPhongBan;
		this.dsNhanVien = dsNhanVien;
	}

	public String getMaPhongBan() {
		return maPhongBan;
	}

	public void setMaPhongBan(String maPhongBan) {
		this.maPhongBan = maPhongBan;
	}

	public String getTenPhongBan() {
		return tenPhongBan;
	}

	public void setTenPhongBan(String tenPhongBan) {
		this.tenPhongBan = tenPhongBan;
	}

	public DanhSachNhanVien getDsNhanVien() {
		return dsNhanVien;
	}

	public void setDsNhanVien(DanhSachNhanVien dsNhanVien) {
		this.dsNhanVien = dsNhanVien;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maPhongBan);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhongBan other = (PhongBan) obj;
		return Objects.equals(maPhongBan, other.maPhongBan);
	}

	@Override
	public String toString() {
		return tenPhongBan;
	}
	
	

}
