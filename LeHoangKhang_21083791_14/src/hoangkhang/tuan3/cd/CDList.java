package hoangkhang.tuan3.cd;

public class CDList {
	private CD list[];
	public int soLuongHT = 0;

	public CDList(int soLuong) {
		super();
		this.list = new CD[soLuong];
	}
	
	public void tangKichThuoc() {
		CD[] temp = new CD[list.length * 2];
		
		System.arraycopy(list, 0, temp, 0, list.length);
		
		list = temp;
	}
	
	public int timKiem(int maCD) {
		for (int i = 0; i < this.soLuongHT; i++) {
			if (list[i].getMaCD() == maCD) {
				return i;
			}
		}
		
		return -1;
	}
	
	public void themCD(CD newCD) throws Exception {
		if (this.soLuongHT == list.length) {
			this.tangKichThuoc();
		} else {
			int vt = this.timKiem(newCD.getMaCD());
			
			if (vt != -1) {
				throw new Exception("CD đã tồn tại (Trùng mã)");
			} else {
				list[soLuongHT] = newCD;
				soLuongHT++;
			}
		}
	}
	
	public void xoaCD(int maCD) throws Exception {
		int index = this.timKiem(maCD);
		
		if (index == -1) {
			throw new Exception("Không tìm thấy mã CD " + maCD);
		} else {
			this.soLuongHT--;
			for (int i = index; i < this.soLuongHT; i++) {
				list[i] = list[i+1]; // Đẩy mảng xuống 1 đơn vị để lấp chỗ vừa xóa
			}
		}
	}
	
	public void suaCD(CD modifyCD) throws Exception {
		int index = this.timKiem(modifyCD.getMaCD());
		
		if (index != -1) {
			this.list[index] = modifyCD;
		} else {
			throw new Exception("Không tìm thấy CD có ID: " + modifyCD.getMaCD());
		}
	}
	
	public int soLuongCD() {
		return this.soLuongHT;
	}
	
	public double tongGiaThanh() {
		double sum = 0;
		for (int i = 0; i < this.soLuongHT; i++) {
			sum += list[i].getGiaThanh();
		}
		
		return sum;
	}
	
	public void doiVT(int a, int b) {
		CD temp = list[a];
		list[a] = list[b];
		list[b] = temp;
	}
	
	public void sapXepTheoGiaGiam() {
		for (int i = this.soLuongHT-1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				boolean condition = list[j].getGiaThanh() < list[j+1].getGiaThanh();
				if (condition) {
					this.doiVT(j, j+1);
				}
			}
		}
	}
	
	public void sapXepTheoTuaCD() {
		for (int i = this.soLuongHT-1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				int condition = list[j].getTuaCD().compareTo(list[j+1].getTuaCD());
				
				if (condition > 0) {
					this.doiVT(j, j+1);
				}
			}
		}
	}
	
	public void sapXep() {
		for (int i = this.soLuongHT-1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				int condition = list[j].compareTo(list[j+1]);
				
				if (condition > 0) {
					this.doiVT(j, j+1);
				}
			}
		}
	}
	
	public CD[] getList() {
		return this.list;
	}
}
