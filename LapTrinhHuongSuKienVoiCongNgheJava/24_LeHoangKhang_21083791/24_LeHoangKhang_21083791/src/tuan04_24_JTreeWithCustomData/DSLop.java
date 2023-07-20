package tuan04_24_JTreeWithCustomData;

import java.util.ArrayList;

public class DSLop {
	private ArrayList<Lop> lopArray;

	public DSLop() {
		lopArray = new ArrayList<Lop>();
	}
	public void addLop (String maLop, String tenLop, int siSo)
	{		
		lopArray.add(new Lop (maLop,  tenLop, siSo));
	}
	public void addLop (Lop l)
	{		
		lopArray.add(l);
	}	
	public Lop getElement(int index)
	{
		if(index<0 || index>=lopArray.size())
			return null;		
		return lopArray.get(index);
	}
	public Lop getElement(String malop)
	{
		Lop l=new Lop(malop,"",0);
		if (lopArray.contains(l))
			return lopArray.get(lopArray.indexOf(l));
		else
			return null;		
	}
	public int getSize()
	{		
		return lopArray.size();
	}
}
