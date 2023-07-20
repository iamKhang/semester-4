package hoangkhang.tuan3.account_array;

public class AccountList {
	private Account[] list;
	public int soLuongHT = 0;
	
	public AccountList(int soLuong) {
		this.list = new Account[soLuong];
	}
	
	public void tangKichThuoc() {
		Account[] temp = new Account[list.length*2];
		
		System.arraycopy(list, 0, temp, 0, list.length);
		
		list = temp;
	}
	
	public int timKiem(long accountNumber) {
		for (int i = 0; i < this.soLuongHT; i++) {
			if (list[i].getAccountNumber() == accountNumber) return i;
		}
		
		return -1;
	}
	
	public void doiVT(int a, int b) {
		Account temp = list[a];
		list[a] = list[b];
		list[b] = temp;
	}
	
	public void themTaiKhoan(Account newAccount) throws Exception{
		int index = this.timKiem(newAccount.getAccountNumber());
		if (index != -1) throw new Exception("ERR: Không thể thêm, số tài khoản đã tồn tại");
		
		if (soLuongHT == list.length) tangKichThuoc();
		
		int existIndex = timKiem(newAccount.getAccountNumber());
		
		if (existIndex == -1) {
			list[soLuongHT] = newAccount;
			soLuongHT++;
		} else {
			throw new Exception("ERR: Không thể thêm, số tài khoản đã tồn tại!");
		}
	}
	
	public void xoaTaiKhoan(long accountNumber) {
		int delIndex = timKiem(accountNumber);
		
		if (delIndex != -1) {
			soLuongHT--;
			for (int i = delIndex; i < soLuongHT; i++) {
				list[i] = list[i+1];
			}
		}
	}
	
	public void suaTaiKhoan(int index, Account modifyAccount) throws Exception {
		if (this.timKiem(modifyAccount.getAccountNumber()) != -1) throw new Exception("Không thể sửa, số tài khoản bị trùng");
		if (index != -1 && modifyAccount != null) {
			list[index] = modifyAccount;
		}
	}
	
	public void sapXep() {
		for (int i = soLuongHT-1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				int condition = list[j].compareTo(list[j+1]);
				if (condition > 0) {
					doiVT(j, j+1);
				}
			}
		}
	}
	
	public void sapXepTheoTien() {
		for (int i = soLuongHT-1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				boolean condition = list[j].getAccountAmount() < list[j+1].getAccountAmount();
				if (condition) {
					doiVT(j, j+1);
				}
			}
		}
	}
	
	public Account[] getList() {
		return list;
	}
}
