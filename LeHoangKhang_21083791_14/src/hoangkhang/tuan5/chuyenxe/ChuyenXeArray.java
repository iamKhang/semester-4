package hoangkhang.tuan5.chuyenxe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ChuyenXeArray {
	private ArrayList<ChuyenXe> list;
	
	// Constructor
	public ChuyenXeArray() {
		this.list = new ArrayList<ChuyenXe>();
	}
	
	// Getter
	public ArrayList<ChuyenXe> getList() {
		return this.list;
	}
	
	public ArrayList<ChuyenXe> getListNoiThanh() {
		ArrayList<ChuyenXe> noiThanh = new ArrayList<ChuyenXe>();
		
		for (ChuyenXe item : list) {
			if (item instanceof ChuyenXeNoiThanh) noiThanh.add(item); 
		}
		
		return noiThanh;
	}
	
	public ArrayList<ChuyenXe> getListNgoaiThanh() {
		ArrayList<ChuyenXe> ngoaiThanh = new ArrayList<ChuyenXe>();
		
		for (ChuyenXe item : list) {
			if (item instanceof ChuyenXeNgoaiThanh) ngoaiThanh.add(item); 
		}
		
		return ngoaiThanh;
	}
	
	// Behavior
	public int timKiemViTri(ChuyenXe key) {
		return list.indexOf(key);
	}
	
	public int timKiemViTri(String maSoChuyen) {
		return list.indexOf(timKiem(maSoChuyen)); 
	}
	
	public ChuyenXe timKiem(String maSoChuyen) {
		for (ChuyenXe item : list) {
			if (item.getMaSo().equalsIgnoreCase(maSoChuyen)) return item;
		}
		
		return null;
	}
	
	public boolean them(ChuyenXe chuyenXeMoi) throws Exception {
		if (!list.contains(chuyenXeMoi)) {
			list.add(chuyenXeMoi);
			return true;
		}
		
		throw new Exception("Chuyến xe này đã tồn tại");
	}
	
	public void sua(ChuyenXe chuyenXeDaSua) {
		int index = list.indexOf(chuyenXeDaSua);
		list.set(index, chuyenXeDaSua);
	}
	
	public void xoa(int index) {
		list.remove(index);
	}
	
	public void xoa(ChuyenXe key) {
		list.remove(key);
	}
	
	public void sortTheoTenTaiXe() {
		Collections.sort(list, new Comparator<ChuyenXe>() {
			@Override
			public int compare(ChuyenXe o1, ChuyenXe o2) {
				String[] temp = (o1.getHoTenTaiXe().trim()).split(" ");
				String ten1 = temp[temp.length-1];
				
				temp = (o2.getHoTenTaiXe().trim()).split(" ");
				String ten2 = temp[temp.length-1];
				return ten1.compareTo(ten2);
			}
		});
	}
	
	public void sortTheoDoanhThu() {
		Collections.sort(list, new Comparator<ChuyenXe>() {
			@Override
			public int compare(ChuyenXe o1, ChuyenXe o2) {
				return ((Double)o1.getDoanhThu()).compareTo((Double)o2.getDoanhThu());
			}
		});
	}
	
	public void sortTheo2Truong() {
		Collections.sort(list, new Comparator<ChuyenXe>() {
			@Override
			public int compare(ChuyenXe o1, ChuyenXe o2) {
				if (o1.getHoTenTaiXe().equalsIgnoreCase(o2.getHoTenTaiXe())) {
					return ((Double)o1.getDoanhThu()).compareTo((Double)o2.getDoanhThu());
				} else {
					String[] temp = (o1.getHoTenTaiXe().trim()).split(" ");
					String ten1 = temp[temp.length-1];
					
					temp = (o2.getHoTenTaiXe().trim()).split(" ");
					String ten2 = temp[temp.length-1];
					return ten1.compareTo(ten2);
				}
			}
		});
	}
	
	public double tinhDoanhThu() {
		double doanhThu = 0;
		for (ChuyenXe item : list) {
			doanhThu += item.doanhThu;
		}
		
		return doanhThu;
	}
	
	public double tinhDoanhThuNoiThanh() {
		double doanhThu = 0;
		for (ChuyenXe item : list) {
			if (item instanceof ChuyenXeNoiThanh) doanhThu += item.doanhThu;
		}
		
		return doanhThu;
	}
	
	public double tinhDoanhThuNgoaiThanh() {
		double doanhThu = 0;
		for (ChuyenXe item : list) {
			if (item instanceof ChuyenXeNgoaiThanh) doanhThu += item.doanhThu;
		}
		
		return doanhThu;
	}
}
