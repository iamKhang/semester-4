package tuan04_24_JTreeQuanLyPhongBan;

import java.util.ArrayList;

public class DanhSachPhongBan {
	ArrayList<PhongBan> dsPhongBan;

	public DanhSachPhongBan() {
		dsPhongBan = new ArrayList<>();
	}
	
	public boolean themPhongBan(PhongBan phongBan) {
		if(dsPhongBan.contains(phongBan))
			return false;
		dsPhongBan.add(phongBan);
		return true;
	}
	
	
	public boolean xoaPhongBan(PhongBan phongBan) {
		int index = dsPhongBan.indexOf(phongBan);
		if(index>=0) {
			dsPhongBan.remove(index);
			return true;
		}
		return false;
	}

	public ArrayList<PhongBan> getDsPhongBan() {
		return dsPhongBan;
	}

	public void setDsPhongBan(ArrayList<PhongBan> dsPhongBan) {
		this.dsPhongBan = dsPhongBan;
	}
	
}
