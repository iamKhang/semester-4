package tuan04_24_JTreeQuanLyPhongBan;

import java.util.ArrayList;

public class DanhSachNhanVien {
	private ArrayList<NhanVien> dsNhanVien = new ArrayList<>();

	public DanhSachNhanVien() {
		super();
	}

	public DanhSachNhanVien(ArrayList<NhanVien> dsNhanVien) {
		super();
		this.dsNhanVien = dsNhanVien;
	}

	public ArrayList<NhanVien> getDsNhanVien() {
		return dsNhanVien;
	}

	public void setDsNhanVien(ArrayList<NhanVien> dsNhanVien) {
		this.dsNhanVien = dsNhanVien;
	}

	public boolean themNhanVien(NhanVien nv) {
		if (dsNhanVien.contains(nv))
			return false;
		dsNhanVien.add(nv);
		return true;
	}

	public boolean xoaNhanVien(NhanVien nv) {
		if (dsNhanVien.contains(nv)) {
			dsNhanVien.remove(dsNhanVien.indexOf(nv));
			return true;
		}
		return false;
	}

	public boolean capNhatNhanVien(NhanVien nv) {
		if (dsNhanVien.contains(nv)) {
			dsNhanVien.set(dsNhanVien.indexOf(nv), nv);
			return true;
		}
		return false;
	}
	

}
