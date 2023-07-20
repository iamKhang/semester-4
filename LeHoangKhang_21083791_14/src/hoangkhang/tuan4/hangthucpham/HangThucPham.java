package hoangkhang.tuan4.hangthucpham;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

public class HangThucPham {
	private String maHang;
	private String tenHang;
	private double donGia;
	private GregorianCalendar ngaySanXuat;
	private GregorianCalendar ngayHetHan;
	public SimpleDateFormat dateFm = new SimpleDateFormat("dd/MM/yyyy");
	public NumberFormat vnd = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
	public DecimalFormat dfm = new DecimalFormat("#,##0.00");
	
	public HangThucPham() {
		// TODO Auto-generated constructor stub
	}

	public HangThucPham(String maHang, String tenHang, double donGia, GregorianCalendar ngaySanXuat,
			GregorianCalendar ngayHetHan) throws Exception {
		super();
		if (maHang.isBlank()) throw new Exception("Mã hàng không được rỗng");
		this.maHang = maHang;
		setTenHang(tenHang);
		setDonGia(donGia);
		setNgaySanXuat(ngaySanXuat);
		setNgayHetHan(ngayHetHan);
	}
	
	public HangThucPham(String maHang, String tenHang, double donGia, String ngaySanXuat,
			String ngayHetHan) throws Exception {
		super();
		if (maHang.isBlank()) throw new Exception("Mã hàng không được rỗng");
		this.maHang = maHang;
		setTenHang(tenHang);
		setDonGia(donGia);
		setNgaySanXuat(ngaySanXuat);
		setNgayHetHan(ngayHetHan);
	}

	String getMaHang() {
		return maHang;
	}

	String getTenHang() {
		return tenHang;
	}

	void setTenHang(String tenHang) throws Exception {
		if (tenHang.isBlank()) {
			this.maHang = "xxx";
			throw new Exception("Tên hàng không được rỗng");
		}
		this.tenHang = tenHang;
	}

	double getDonGia() {
		return donGia;
	}

	void setDonGia(double donGia) throws Exception {
		if (donGia < 0) {
			this.donGia = 0;
			throw new Exception("Đơn giá phải lớn hơn 0");
		}
		this.donGia = donGia;
	}

	GregorianCalendar getNgaySanXuat() {
		return ngaySanXuat;
	}

	void setNgaySanXuat(GregorianCalendar ngaySanXuat) throws Exception {
		GregorianCalendar today = new GregorianCalendar();
		if (ngaySanXuat.compareTo(today) > 0) {
			this.ngaySanXuat = today; // cài về ngày hiên tại
			throw new Exception("Ngày sản xuất không được SAU ngày hiện tại");
		}
		this.ngaySanXuat = ngaySanXuat;
	}
	
	void setNgaySanXuat(String ngaySanXuatS) throws Exception {
		GregorianCalendar newNgaySanXuat = new GregorianCalendar();
		newNgaySanXuat.setTime(dateFm.parse(ngaySanXuatS));
		
		setNgaySanXuat(newNgaySanXuat);
	}

	GregorianCalendar getNgayHetHan() {
		return ngayHetHan;
	}

	void setNgayHetHan(GregorianCalendar ngayHetHan) throws Exception {
		if (this.ngaySanXuat == null) throw new Exception("Bạn phải nhập ngày sản xuất trước khi có ngày hết hạn");
		
		if (ngayHetHan.compareTo(this.ngaySanXuat) < 0) {
			this.ngayHetHan = (GregorianCalendar) ngaySanXuat.clone();
			throw new Exception("Ngày hết hạn không được trước ngày sản xuất");
		}
		this.ngayHetHan = ngayHetHan;
	}
	
	void setNgayHetHan(String ngayHetHangS) throws Exception {
		GregorianCalendar newNgayHetHan = new GregorianCalendar();
		newNgayHetHan.setTime(dateFm.parse(ngayHetHangS));
		
		setNgayHetHan(newNgayHetHan);
	}
	
	boolean kiemTraHetHan() {
		return (ngayHetHan.before(new GregorianCalendar()) ? true : false);
	}
	
	int soNgayConLai() {
		final long msInOneDay = 86400000;
		
		GregorianCalendar today = new GregorianCalendar();
		long restTime = (ngayHetHan.getTimeInMillis() - today.getTimeInMillis()) / msInOneDay;
		
		return (int)restTime;
	}
	
	/**
	 * Vì chương trình không tác động đến thời gian nên thời gian luôn là 0h00
	 * Vì vậy khi lấy today so sánh với ngày hết hạn (cùng 1 ngày) thì today sẽ lớn hơn (vì nó lấy cả giờ hiện tại)
	 */

	@Override
	public String toString() {
		String ghiChu = "";
		if (kiemTraHetHan() == true) ghiChu = "Hàng hết hạng";
		else {
			int restDay = this.soNgayConLai();
			if (restDay == 0) ghiChu = "Chỉ còn hôm nay";
			else ghiChu = "Còn lại " + restDay + " ngày";
		}
		
		String result = String.format("%-10s %-20s %20s  %-15s %-15s %-20s", maHang, tenHang, dfm.format(donGia) + "VND", dateFm.format(this.ngaySanXuat.getTime()), dateFm.format(this.ngayHetHan.getTime()), ghiChu);
		return result;
	}
}