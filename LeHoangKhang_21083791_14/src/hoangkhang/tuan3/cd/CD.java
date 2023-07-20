package hoangkhang.tuan3.cd;

import java.text.NumberFormat;
import java.util.Locale;

public class CD implements Comparable<CD>{
	private int maCD;
	private String tuaCD;
	private String caSy;
	private int soBaiHat;
	private double giaThanh;

	public CD() {
	}
	
	public CD(int maCD, String tuaCD, String caSy, int soBaiHat, double giaThanh) {
		super();
		this.setMaCD(maCD);
		this.setTuaCD(tuaCD);
		this.caSy = caSy;
		this.setSoBaiHat(soBaiHat);
		this.setGiaThanh(giaThanh);
	}

	public int getMaCD() {
		return maCD;
	}

	public void setMaCD(int maCD) {
		if (maCD > 0) {			
			this.maCD = maCD;
		} else {
			this.maCD = 999999;
		}
	}

	public String getTuaCD() {
		return tuaCD;
	}

	public void setTuaCD(String tuaCD) {
		if (tuaCD.isBlank()) {
			this.tuaCD = "Chưa xác định";
		} else {			
			this.tuaCD = tuaCD;
		}
	}

	public String getCaSy() {
		return caSy;
	}

	public void setCaSy(String caSy) {
		this.caSy = caSy;
	}

	public int getSoBaiHat() {
		return soBaiHat;
	}

	public void setSoBaiHat(int soBaiHat) {
		if (soBaiHat > 0) {
			this.soBaiHat = soBaiHat;
		} else {
			this.soBaiHat = 0;
		}
	}

	public double getGiaThanh() {
		return giaThanh;
	}

	public void setGiaThanh(double giaThanh) {
		if (giaThanh > 0) {			
			this.giaThanh = giaThanh;
		} else {
			this.giaThanh = 0;
		}
	}

	@Override
	public String toString() {
		Locale vn = new Locale("vi", "VN");
		NumberFormat vnd = NumberFormat.getCurrencyInstance(vn);

		String result = String.format("%6d %-30s %-30s %3d %15s", this.maCD, this.tuaCD, this.caSy, this.soBaiHat, vnd.format(this.giaThanh));
		
		return result;
	}
	
	@Override 
	public int compareTo(CD other) {
		if (this.tuaCD.equalsIgnoreCase(other.tuaCD)) {
			return -((Double)this.giaThanh).compareTo((Double)other.giaThanh);
		}
		
		return this.tuaCD.compareToIgnoreCase(other.tuaCD);
	}
}
