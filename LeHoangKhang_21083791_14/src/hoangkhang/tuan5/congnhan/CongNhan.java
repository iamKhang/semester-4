package hoangkhang.tuan5.congnhan;

public class CongNhan {
	private String mHo;
	private String mTen;
	private int mSoSP;
	
	public CongNhan() {
		// TODO Auto-generated constructor stub
	}

	public CongNhan(String mHo, String mTen, int mSoSP) throws Exception {
		super();
		this.mHo = mHo;
		this.mTen = mTen;
		setmSoSP(mSoSP);
	}

	public String getmHo() {
		return mHo;
	}

	public void setmHo(String mHo) {
		this.mHo = mHo;
	}

	public String getmTen() {
		return mTen;
	}

	public void setmTen(String mTen) {
		this.mTen = mTen;
	}

	public int getmSoSP() {
		return mSoSP;
	}

	public void setmSoSP(int mSoSP) throws Exception {
		if (mSoSP < 0) throw new Exception("So san pham phai lon hon 0");
		this.mSoSP = mSoSP;
	}
	
	public double tinhLuong() {
		if (mSoSP < 200) return (mSoSP*.5);
		else if (mSoSP < 400) return (199*0.5 + (mSoSP-199)*0.55);
		else if (mSoSP < 600) return (199*0.5 + 399*0.55 + (mSoSP-399)*0.6);
		else return (199*0.5 + 399*0.55 + 599*0.6 + (mSoSP-599)*0.6);
	}

	@Override
	public String toString() {
		return "CongNhan [mHo=" + mHo + ", mTen=" + mTen + ", mSoSP=" + mSoSP + ", tinhLuong()=" + tinhLuong() + "]";
	}
}
