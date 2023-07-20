package tuan09_24_OnTapCuoiKiJDBC;


public class VanDongVien {
	private String maVDV;
	private String tenVDV;
	private int tuoi;
	private CauLacBo clb;

	public VanDongVien(String maVDV, String tenVDV, int tuoi, CauLacBo clb) {
		super();
		this.maVDV = maVDV;
		this.tenVDV = tenVDV;
		this.tuoi = tuoi;
		this.clb = clb;
	}

	public VanDongVien(String maVDV) {
		super();
		this.maVDV = maVDV;
	}

	public VanDongVien() {
		// TODO Auto-generated constructor stub
	}

	public String getMaVDV() {
		return maVDV;
	}

	public void setMaVDV(String maVDV) {
		this.maVDV = maVDV;
	}

	public String getTenVDV() {
		return tenVDV;
	}

	public void setTenVDV(String tenVDV) {
		this.tenVDV = tenVDV;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public CauLacBo getClb() {
		return clb;
	}

	public void setClb(CauLacBo clb) {
		this.clb = clb;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maVDV == null) ? 0 : maVDV.hashCode());
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
		VanDongVien other = (VanDongVien) obj;
		if (maVDV == null) {
			if (other.maVDV != null)
				return false;
		} else if (!maVDV.equals(other.maVDV))
			return false;
		return true;
	}

}
