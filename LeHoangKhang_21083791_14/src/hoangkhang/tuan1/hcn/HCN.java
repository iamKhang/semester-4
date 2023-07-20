package hoangkhang.tuan1.hcn;

public class HCN {
	private double chieuRong;
	private double chieuDai;
	
	public HCN() {}
	
	public HCN(double chieuRong, double chieuDai) {
		this.chieuRong = chieuRong;
		this.chieuDai = chieuDai;
	}

	public double getChieuRong() {
		return chieuRong;
	}
	
	public void setChieuRong(double chieuRong) {
		this.chieuRong = chieuRong;
	}
	
	public double getChieuDai() {
		return chieuDai;
	}
	
	public void setChieuDai(double chieuDai) {
		this.chieuDai = chieuDai;
	}
	
	public double tinhDienTich() {
		return (this.chieuDai*this.chieuRong);
	}
	
	public double tinhChuVi() {
		return (this.chieuDai+this.chieuRong)*2;
	}

	@Override
	public String toString() {
		String result =  "HCN co chieu dai: " + this.chieuDai + ", chieu rong: " + this.chieuRong;
		result +=  "\n=> Dien Tich: " + this.tinhDienTich();
		result += "\n=> Chu Vi: " + this.tinhChuVi();
		
		return result;
	}
}
