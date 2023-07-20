package hoangkhang.tuan6.quanlisach;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

public class SachThamKhao extends Sach{
	private double thue;
	
	public SachThamKhao() {
		// TODO Auto-generated constructor stub
	}

	public SachThamKhao(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXuatBan, double thue) {
		super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
		this.thue = thue;
	}

	double getThue() {
		return thue;
	}

	void setThue(double thue) {
		this.thue = thue;
	}
	
	@Override
	public double getThanhTien() {
		return (soLuong * donGia + thue);
	}
	
	@Override
	public String toString() {
		String result = super.toString();
		NumberFormat vnd = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
		result += String.format("%15s %20s", vnd.format(thue), vnd.format(getThanhTien()));
		return result;
	}
}
