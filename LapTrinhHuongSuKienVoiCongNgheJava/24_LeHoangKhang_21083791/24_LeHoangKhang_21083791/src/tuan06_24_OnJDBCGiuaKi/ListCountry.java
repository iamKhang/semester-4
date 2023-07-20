package tuan06_24_OnJDBCGiuaKi;

import java.util.ArrayList;

public class ListCountry {
	private ArrayList<Country> list;

	public ListCountry() {
		list = new ArrayList<>();
	}

	public ArrayList<Country> getList() {
		return list;
	}

	public void setList(ArrayList<Country> list) {
		this.list = list;
	}
	
	public boolean addCountry(Country c) {
		if(list.contains(c))
			return false;
		list.add(c);
		return true;
	}
	
	public boolean deleteCountry(Country c) {
		int index = list.indexOf(c);
		if(index==-1)
			return false;
		list.remove(index);
		return true;
	}
	
	public boolean updateCountry(Country c) {
		int index = list.indexOf(c);
		if(index==-1)
			return false;
		list.set(index, c);
		return true;
	}
	
	
}
