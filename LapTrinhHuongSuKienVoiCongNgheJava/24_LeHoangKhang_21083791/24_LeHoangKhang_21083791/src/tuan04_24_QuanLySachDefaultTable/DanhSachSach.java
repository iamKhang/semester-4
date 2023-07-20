package tuan04_24_QuanLySachDefaultTable;

import java.util.ArrayList;

public class DanhSachSach {
	ArrayList<Sach> dsSach = new ArrayList<Sach>();
	
	
	
	
	public DanhSachSach() {
		super();
	}

	public DanhSachSach(ArrayList<Sach> dsSach) {
		super();
		this.dsSach = dsSach;
	}

	public int count() {
		return dsSach.size();
	}

	public boolean themSach(Sach sach) {
		if (dsSach.contains(sach)) {
			return false;
		}
		dsSach.add(sach);
		return true;
	}

	public boolean xoaSach(int index) {
		if(index >= 0 && index < dsSach.size()){
			dsSach.remove(index);
			return true;
		}
		return false;
	}

	public boolean suaSach(Sach sach) {
		int index = dsSach.indexOf(sach);
		if (index >= 0) {
			dsSach.set(index, sach);
			return true;
		}
		return false;
	}

	public Sach timKiem(String maSach) {
		Sach sach = new Sach(maSach);
		if(dsSach.contains(sach)) {
			return dsSach.get(dsSach.indexOf(sach));
		}
		return null;
	}

	public ArrayList<Sach> getDsSach() {
		return dsSach;
	}

	public void setDsSach(ArrayList<Sach> dsSach) {
		this.dsSach = dsSach;
	}

}
