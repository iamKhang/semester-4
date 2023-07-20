package hoangkhang.tuan6.quanlisach;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

public class SachGiaoKhoa extends Sach {
	private boolean tinhTrang;
	
	public SachGiaoKhoa() {
		
	}

	public SachGiaoKhoa(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXuatBan, boolean tinhTrang) {
		super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
		this.tinhTrang = tinhTrang;
	}

	boolean getTinhTrang() {
		return tinhTrang;
	}

	void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	
	@Override
	public double getThanhTien() {
		double thanhTien = soLuong*donGia;
		
		if (!tinhTrang) thanhTien *= 0.5;
		
		return thanhTien;
	}
	
	@Override
	public String toString() {
		String result = super.toString();
		NumberFormat vnd = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
		result += String.format("%-10s %20s", (tinhTrang? "Mới" : "Cũ"), vnd.format(getThanhTien()));
		return result;
	}
}
