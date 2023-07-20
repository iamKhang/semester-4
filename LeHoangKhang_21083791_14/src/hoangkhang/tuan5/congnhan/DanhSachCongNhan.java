package hoangkhang.tuan5.congnhan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DanhSachCongNhan {
	ArrayList<CongNhan> list;
	private int maxSize;
	
	public DanhSachCongNhan(int n) {
		list = new ArrayList<CongNhan>();
		maxSize = n;
	}
	
	public int size() {
		return this.list.size();
	}
	
	public boolean them(CongNhan newCongNhan) throws Exception {
		if (list.size() < maxSize) {
			list.add(newCongNhan);
			return true;
		}
		
		throw new Exception("Danh sách đã đầy");
	}

	public ArrayList<CongNhan> getList() {
		return list;
	}
	
	public void xoaCongNhan(int index) {
		list.remove(index);
	}
	
	public ArrayList<CongNhan> getListCongNhanTren200() {
		ArrayList<CongNhan> temp = new ArrayList<CongNhan>();
		
		for (CongNhan item : list) {
			if (item.getmSoSP() > 200) temp.add(item);
		}
		
		return temp;
	}
	
	public void sort() {
		Collections.sort(list, new Comparator<CongNhan>() {
			@Override
			public int compare(CongNhan o1, CongNhan o2) {
				return ((Integer)o1.getmSoSP()).compareTo((Integer)o2.getmSoSP());
			}
		});
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
