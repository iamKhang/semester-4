package tuan02_24_ThongTinNhanVien;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;

import tuan04_24_QuanLySachDefaultTable.Sach;

public class DanhSachNhanVien implements Serializable {
	ArrayList<NhanVien> list;

	public DanhSachNhanVien() {
		list = new ArrayList<NhanVien>();
	}

	public int size() {
		return this.list.size();
	}

	public boolean them(NhanVien nhanVien) {
		if (list.contains(nhanVien)) {
			return false;
		}
		list.add(nhanVien);
		return true;
	}
	
	

	public ArrayList<NhanVien> getList() {
		return list;
	}
	
	public boolean updateNhanVien(NhanVien nv) {
		int index = list.indexOf(nv);
		if(index>=0) {
			list.set(index, nv);
			return true;		
		}
		return false;
	}

	public boolean xoaNhanVien(NhanVien nv) {
		int index = list.indexOf(nv);
		if(index>=0) {
			list.remove(index);
			return true;		
		}
		return false;
		
	}

	public void sort() {
		Collections.sort(list, new Comparator<NhanVien>() {
			@Override
			public int compare(NhanVien o1, NhanVien o2) {
				return ((String) o1.getMaNV()).compareTo((String) o2.getMaNV());
			}
		});
	}

	public NhanVien timKiem(String maNV) {
		NhanVien nv = new NhanVien(maNV);
		if (list.contains(nv))
			return list.get(list.indexOf(nv));
		return null;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		return "DanhSachNhanVien [list=" + list + "]";
	}

}
