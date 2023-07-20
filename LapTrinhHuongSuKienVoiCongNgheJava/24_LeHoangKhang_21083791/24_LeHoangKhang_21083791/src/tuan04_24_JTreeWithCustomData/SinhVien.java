package tuan04_24_JTreeWithCustomData;
public class SinhVien {
	
	private String MaSV;
	private String HoTen;
	private boolean GioiTinh;	

	public SinhVien(String ma, String ht, boolean gt) {
		MaSV = ma;
		HoTen = ht;
		GioiTinh = gt;		
	}
	public SinhVien(){
		this("","",false);
	}
	
	public String getMaSV() {
		return MaSV;
	}
	public void setMaSV(String maSV) {
		MaSV = maSV;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public boolean getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(boolean gt) {
		GioiTinh = gt;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((MaSV == null) ? 0 : MaSV.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
		return true;
		if (obj == null)
		return false;
		if (getClass() != obj.getClass())
		return false;
		SinhVien other = (SinhVien) obj;
		if (MaSV == null) {
		if (other.MaSV != null)
		return false;
		} else if (!MaSV.equals(other.MaSV))
		return false;
		return true;
	}

	@Override
	public String toString() {
		String gt;
		if (GioiTinh) gt = "Nam";
		else
			gt="Nu";
		return MaSV + " - " + HoTen + " - " + gt ;
	}
}