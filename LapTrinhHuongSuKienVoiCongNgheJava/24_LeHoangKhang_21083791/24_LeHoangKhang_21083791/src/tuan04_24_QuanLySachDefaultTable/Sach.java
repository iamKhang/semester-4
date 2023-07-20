package tuan04_24_QuanLySachDefaultTable;

import java.util.Objects;

public class Sach {
	private String maSach, tuaSach, tacGia, nhaXuatBan, isbn;
	private int namXuatBan, soTrang;
	private double donGia;
	
	
	public Sach() {
		super();
	}


	public Sach(String maSach) {
		super();
		this.maSach = maSach;
	}


	public Sach(String maSach, String tuaSach, String tacGia, int namXuatBan,String nhaXuatBan, int trang,double donGia,String isbn) {
		super();
		this.maSach = maSach;
		this.tuaSach = tuaSach;
		this.tacGia = tacGia;
		this.nhaXuatBan = nhaXuatBan;
		this.isbn = isbn;
		this.namXuatBan = namXuatBan;
		this.soTrang = trang;
		this.donGia = donGia;
	}


	public String getMaSach() {
		return maSach;
	}


	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}


	public String getTuaSach() {
		return tuaSach;
	}


	public void setTuaSach(String tuaSach) {
		this.tuaSach = tuaSach;
	}


	public String getTacGia() {
		return tacGia;
	}


	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}


	public String getNhaXuatBan() {
		return nhaXuatBan;
	}


	public void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public int getNamXuatBan() {
		return namXuatBan;
	}


	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}


	public int getSoTrang() {
		return soTrang;
	}


	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}


	public double getDonGia() {
		return donGia;
	}


	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	
	public Object[] getRow() {
		Object[] obj = new Object[8];
		obj[0] = maSach;
		obj[1] = tuaSach;
		obj[2] = tacGia;
		obj[3] = namXuatBan;
		obj[4] = nhaXuatBan;
		obj[5] = soTrang;
		obj[6] = donGia;
		obj[7] = isbn;
		return obj;
	}


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
	
	public String toString() {
		return maSach + ";" + tuaSach + ";"
				+ tacGia + ";" + namXuatBan + ";" + nhaXuatBan
				+ ";" + soTrang + ";" + donGia + ";"
				+ isbn ;
	}
	
	
}
