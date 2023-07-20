package hoangkhang.tuan4.toado_array;

public class HinhTron implements Comparable<HinhTron> {
	private ToaDo tam;
	private double banKinh;
	private final double PI = 3.14;

	public HinhTron() {
		// TODO Auto-generated constructor stub
	}

	public HinhTron(ToaDo tam, double banKinh) {
		super();
		this.tam = tam;
		this.banKinh = banKinh;
	}

	public ToaDo getTam() {
		return tam;
	}

	public void setTam(ToaDo tam) {
		this.tam = tam;
	}

	public double getBanKinh() {
		return banKinh;
	}

	public void setBanKinh(double banKinh) {
		this.banKinh = banKinh;
	}

	public double tinhChuVi() {
		return 2 * PI * banKinh;
	}

	public double tinhDienTich() {
		return banKinh * banKinh * PI;
	}

	@Override
	public int compareTo(HinhTron o) {
		return this.tam.getTen().compareTo(o.tam.getTen());
	}

	@Override
	public String toString() {
		return String.format("%-20s %15.2f %15.2f %15.2f", tam, banKinh, tinhDienTich(), tinhChuVi());
	}
}
