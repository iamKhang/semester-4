package hoangkhang.tuan6.quanlisach;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

public abstract class Sach {
	protected String maSach;
	protected LocalDate ngayNhap;
	protected double donGia;
	protected int soLuong;
	protected String nhaXuatBan;
	
	public Sach() {
		// TODO Auto-generated constructor stub
	}

	public Sach(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXuatBan) {
		super();
		this.maSach = maSach;
		this.ngayNhap = ngayNhap;
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.nhaXuatBan = nhaXuatBan;
	}

	String getMaSach() {
		return maSach;
	}

	void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	LocalDate getNgayNhap() {
		return ngayNhap;
	}

	void setNgayNhap(LocalDate ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	double getDonGia() {
		return donGia;
	}

	void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	int getSoLuong() {
		return soLuong;
	}

	void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	String getNhaXuatBan() {
		return nhaXuatBan;
	}

	void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}
	
	public abstract double getThanhTien();
	
	@Override
	public int hashCode() {
		return Objects.hash(maSach);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sach other = (Sach) obj;
		return Objects.equals(maSach, other.maSach);
	}

	@Override
	public String toString() { 
		NumberFormat vnd = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
		DateTimeFormatter d = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String result = String.format("%-15s %-15s %15s %10d %-20s ", maSach, d.format(ngayNhap), vnd.format(donGia), soLuong, nhaXuatBan);
		return result;
	}
}
