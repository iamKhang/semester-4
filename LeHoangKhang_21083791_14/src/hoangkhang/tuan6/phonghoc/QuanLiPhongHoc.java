package hoangkhang.tuan6.phonghoc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class QuanLiPhongHoc {
	ArrayList<PhongHoc> list;
	
	public QuanLiPhongHoc() {
		list = new ArrayList<PhongHoc>();
	}
	
	public boolean themPhong(PhongHoc phongMoi) throws Exception {
		if (!list.contains(phongMoi)) {
			list.add(phongMoi);
			return true;
		}
		
		throw new Exception("Mã phòng đã tồn tại!");
	}
	
	public PhongHoc timPhong(String maPhong) {
		for (PhongHoc phong : list) {
			if (phong.getMaPhong().equalsIgnoreCase(maPhong)) {
				return phong;
			}
		}
		
		return null;
	}
	
	public ArrayList<PhongHoc> getListPhongDatChuan() {
		ArrayList<PhongHoc> listDatChuan = new ArrayList<PhongHoc>();
		
		for (PhongHoc phong : list) {
			if (phong.isDatChuan()) listDatChuan.add(phong);
		}
		
		return listDatChuan;
	}
	
	public ArrayList<PhongHoc> getListPhongLyThuyet() {
		ArrayList<PhongHoc> temp = new ArrayList<PhongHoc>();
		
		for (PhongHoc phong : list) {
			if (phong instanceof PhongLyThuyet) temp.add(phong);
		}
		
		return temp;
	}
	
	public ArrayList<PhongHoc> getListPhongMayTinh() {
		ArrayList<PhongHoc> temp = new ArrayList<PhongHoc>();
		
		for (PhongHoc phong : list) {
			if (phong instanceof PhongMayTinh) temp.add(phong);
		}
		
		return temp;
	}
	
	public ArrayList<PhongHoc> getListPhongThiNghiem() {
		ArrayList<PhongHoc> temp = new ArrayList<PhongHoc>();
		
		for (PhongHoc phong : list) {
			if (phong instanceof PhongThiNghiem) temp.add(phong);
		}
		
		return temp;
	}
	
	public void sortTheoDayNha() {
		Collections.sort(list, new Comparator<PhongHoc>() {
			
			@Override
			public int compare(PhongHoc o1, PhongHoc o2) {
				return (o1.getDayNha().compareTo(o2.getDayNha()));
			}
			
		});
	}
	
	public void sortTheoDienTich() {
		Collections.sort(list, new Comparator<PhongHoc>() {
			
			@Override
			public int compare(PhongHoc o1, PhongHoc o2) {
				return ((Double)o1.getDienTich()).compareTo((Double)o2.getDienTich());
			}
			
		});
	}
	
	public void sortTheoSoBongDen() {
		Collections.sort(list, new Comparator<PhongHoc>() {

			@Override
			public int compare(PhongHoc o1, PhongHoc o2) {
				return ((Integer)o1.getSoBongDen()).compareTo((Integer)o2.getSoBongDen());
			}
		
		});
	}
	
	public void sort3Truong() {
		Collections.sort(list, new Comparator<PhongHoc>() {

			@Override
			public int compare(PhongHoc o1, PhongHoc o2) {
				if (o1.getDayNha().equalsIgnoreCase(o2.getDayNha())) {
					if (o1.getDienTich() == o2.getDienTich()) {
						return ((Integer)o1.getSoBongDen()).compareTo((Integer)o2.getSoBongDen());
					} else return ((Double)o1.getDienTich()).compareTo((Double)o2.getDienTich());
				} else return (o1.getDayNha().compareTo(o2.getDayNha()));
			}
			
		});
	}
	
	public boolean capNhatSoMay(String maPhong, int soMayTinh) throws Exception {
		PhongHoc phong = timPhong(maPhong);
		
		if (phong instanceof PhongMayTinh) {
			((PhongMayTinh) phong).setSoMayTinh(soMayTinh);
			return true;
		}
		
		throw new Exception("Đây không phải phòng máy tính");
	}
	
	
	public boolean xoaPhong(String maPhong) throws Exception {
		PhongHoc phongMuonXoa = timPhong(maPhong);
		if (phongMuonXoa == null) throw new Exception("Không tồn tại mã phòng");
		
		list.remove(phongMuonXoa);
		return true;
	}
	
	public int tongSoPhong() {
		return list.size();
	}
	
	public ArrayList<PhongHoc> listPhongMayCo60May() {
		ArrayList<PhongHoc> temp = new ArrayList<PhongHoc>();
		
		for (PhongHoc phong : list) {
			if (phong instanceof PhongMayTinh) {
				if (((PhongMayTinh)phong).getSoMayTinh() == 60) temp.add(phong);
			}
		}
		
		return temp;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
