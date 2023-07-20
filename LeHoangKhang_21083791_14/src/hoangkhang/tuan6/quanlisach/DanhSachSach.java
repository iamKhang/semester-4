package hoangkhang.tuan6.quanlisach;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DanhSachSach {
	ArrayList<Sach> list;
	int count;
	
	public DanhSachSach() {
		list = new ArrayList<Sach>();
	}
	
	// Getter
	ArrayList<Sach> getList() {
		return list;
	}
	
	ArrayList<Sach> getListSachGiaoKhoa() {
		ArrayList<Sach> sachGiaoKhoa = new ArrayList<Sach>();
		for (Sach item: list) {
			if (item instanceof SachGiaoKhoa) sachGiaoKhoa.add(item);
		}
		
		return sachGiaoKhoa;
	}
	
	ArrayList<Sach> getListSachThamKhao() {
		ArrayList<Sach> sachThamKhao = new ArrayList<Sach>();
		for (Sach item: list) {
			if (item instanceof SachThamKhao) sachThamKhao.add(item);
		}
		
		return sachThamKhao;
	}

	int getCount() {
		return list.size();
	}
	
	// behavior
	public boolean them(Sach newSach) throws Exception{
		if (!list.contains(newSach)) {
			list.add(newSach);
			return true;
		}
		throw new Exception("Mã sách này đã tồn tại");
	}
	
	public void sua(int index, Sach sachSua) {
		list.set(index, sachSua);
	}
	
	public int timKiemViTri(String maSach) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getMaSach().equals(maSach)) {
				return i;
			}
		}
		
		return -1;
	}
	
	public Sach timKiem(String maSach) {
		return list.get(timKiemViTri(maSach));
	}
	
	public void xoa(int index) {
		list.remove(index);
	}
	
	public void sapXepTheoNgayNhap() {
		Collections.sort(list, new Comparator<Sach>() {
			@Override
			public int compare(Sach o1, Sach o2) {
				return o1.getNgayNhap().compareTo(o2.getNgayNhap());
			}
		});
	}
	
	public void sapXepTheoNXB() {
		Collections.sort(list, new Comparator<Sach>() {
			@Override
			public int compare(Sach o1, Sach o2) {
				return o1.getNhaXuatBan().compareToIgnoreCase(o2.getNhaXuatBan());
			}
		});
	}
	
	public void sapXepTheoDonGia() {
		Collections.sort(list, new Comparator <Sach>() {
			@Override
			public int compare(Sach o1, Sach o2) {
				return -((Double)o1.getThanhTien()).compareTo((Double)o2.getThanhTien());
			}
		});
	}
	
	public void sapXep() {
		Collections.sort(list, new Comparator<Sach>() {

			@Override
			public int compare(Sach o1, Sach o2) {
				if (o1.getNhaXuatBan().equalsIgnoreCase(o2.getNhaXuatBan())) {
					return -((Double)o1.getThanhTien()).compareTo((Double)o2.getThanhTien());
				} else {
					return o1.getNhaXuatBan().compareToIgnoreCase(o2.getNhaXuatBan());
				}
			}
			
		});
	}
	
	public double tinhTongThanhTienSGK() {
		double tongTien = 0;
		
		for (Sach item : getListSachGiaoKhoa()) {
			tongTien += item.getThanhTien();
		}
		
		return tongTien;
	}

	public double tinhTongThanhTienSTK() {
		double tongTien = 0;
		
		for (Sach item : getListSachThamKhao()) {
			tongTien += item.getThanhTien();
		}
		
		return tongTien;
	}
	
	public ArrayList<Sach> timSachGiaoKhoaTheoNXB(String nxb) {
		ArrayList<Sach> listSach = new ArrayList<Sach>();
		
		for (Sach item : list) {
			if (item.nhaXuatBan.equalsIgnoreCase(nxb)) listSach.add(item);
		}
		
		return listSach;
	}
	
	public double timThanhTienCaoNhat() {
		double caoNhat = list.get(0).getThanhTien();
		
		for (Sach item: list) {
			double temp = item.getThanhTien();
			
			if (caoNhat < temp) {
				caoNhat = temp;
			}
		}
		
		return caoNhat;
	}
}
