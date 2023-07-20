package hoangkhang.tuan1.quanlisinhvien;

class SinhVien {
	private int mssv;
	private String hoTen;
	private float diemLT;
	private float diemTH;
	
	public SinhVien() {
		super();
		mssv = 0;
		hoTen = "";
		diemLT = 0;
		diemTH = 0;
	}

	public SinhVien(int mssv, String hoTen, float diemLT, float diemTH) {
		super();
		this.mssv = mssv;
		this.hoTen = hoTen;
		this.diemLT = diemLT;
		this.diemTH = diemTH;
	}

	public int getMssv() {
		return mssv;
	}

	public void setMssv(int mssv) {
		this.mssv = mssv;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public float getDiemLT() {
		return diemLT;
	}

	public void setDiemLT(float diemLT) {
		if (diemLT >= 0 && diemLT <= 10)
			this.diemLT = diemLT;
		else  System.out.println("WARN: Diem khong hop le!");
	}

	public float getDiemTH() {
		return diemTH;
	}

	public void setDiemTH(float diemTH) {
		if (diemTH >= 0 && diemTH <= 10)
			this.diemTH = diemTH;
		else  System.out.println("WARN: Diem khong hop le!");
	}
	
	@Override
	public String toString() {
		String result = String.format("\n%8d\t%-30s\t%5.2f\t%5.2f\t%5.2f", mssv, hoTen, diemLT, diemTH, tinhDiemTB());
		return result;
	}

	public float tinhDiemTB() {
		float dtb = (diemTH + diemLT)/2;
		return dtb;
	}
}