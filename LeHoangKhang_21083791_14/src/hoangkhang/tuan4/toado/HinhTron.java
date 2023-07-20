package hoangkhang.tuan4.toado;

public class HinhTron {
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
	public String toString() {
		return String.format("Diện tích và chu vi hình tròn tâm %s có bán kính %.2f m là %.2f và %.2f", tam, banKinh, tinhDienTich(), tinhChuVi());
	}
}
