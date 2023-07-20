package tuan04_24_JTreeWithCustomData;

import java.util.ArrayList;

public class Lop {
	private String maLop, tenLop;
	private int siSo;
	private ArrayList<SinhVien> svArray;
	
	public Lop(String maLop, String tenLop, int siSo) {
		super();
		this.maLop = maLop;
		this.tenLop = tenLop;
		this.siSo = siSo;
		svArray = new ArrayList<SinhVien>();
	}
	public Lop() {
		super();
	}
	public String getMaLop() {
		return maLop;
	}
	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}
	public String getTenLop() {
		return tenLop;
	}
	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}
	public int getSiSo() {
		return siSo;
	}
	public void setSiSo(int siSo) {
		this.siSo = siSo;
	}
	public void addSinhVien (String ma, String ht, boolean gt)
	{		
		svArray.add(new SinhVien (ma,  ht, gt));
	}
	public void addSinhVien (SinhVien r)
	{		
		svArray.add(r);
	}	
	public SinhVien getElement(int index)
	{
		if(index<0 || index>=svArray.size())
			return null;		
		return (SinhVien)svArray.get(index);
	}
	
	public int getSize()
	{		
		return svArray.size();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maLop == null) ? 0 : maLop.hashCode());
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
		final Lop other = (Lop) obj;
		if (maLop == null) {
			if (other.maLop != null)
				return false;
		} else if (!maLop.equals(other.maLop))
			return false;
		return true;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return maLop;
	}
	
}
