package hoangkhang.tuan3.account_array;

import java.text.NumberFormat;
import java.util.Locale;

public class Account implements Comparable<Account>{
	private long accountNumber;
	private String accountName;
	private double accountAmount;
	private final double laiSuat = 0.035;
	private final double phiRut = 1000;
	private final double phiDuyTri = 50000;
	private NumberFormat vnd = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
	
	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	public Account(String accountName, long accountNumber) {
		this.accountName = accountName;
		this.accountNumber = accountNumber;
		this.accountAmount = 50000;
	}

	public Account(long accountNumber, String accountName, double accountAmount) {
		super();
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.accountAmount = accountAmount;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public double getAccountAmount() {
		return accountAmount;
	}

	public void setAccountAmount(double accountAmount) {
		this.accountAmount = accountAmount;
	}
	
	public boolean cashIn(double quantity) throws Exception {
		if (quantity > 0) {
			this.accountAmount += quantity;
			return true;
		}

		throw new Exception("*KHÔNG HỢP LỆ!");
	}
	
	public boolean cashOut(double quantity) throws Exception {
		double soTienCoTheRut = this.accountAmount - this.phiRut - this.phiDuyTri;
		if (soTienCoTheRut <= 0) {
			throw new Exception("*BẠN KHÔNG THỂ RÚT TIỀN");
		}
		
		if (quantity <= soTienCoTheRut) {
			this.accountAmount -= (this.phiRut + quantity);
			return true;
		}
		
		throw new Exception("*SỐ TIỀN BẠN CÓ THỂ RÚT <= " + vnd.format(soTienCoTheRut));
	}
	
	public void daoHan() {
		this.accountAmount += this.accountAmount*this.laiSuat;
	}
	
	public boolean transferTo(Account anotherAccount, double quantity) throws Exception {
		if (this.cashOut(quantity)) {
			anotherAccount.cashIn(quantity);
			return true;
		}
		
		return false;
	}

	@Override
	public String toString() {
		String money = vnd.format(this.accountAmount);
		
		String result = String.format("%-30s %10s %20s\n", this.accountName, this.accountNumber, money);
		
		return result;
	}

	@Override
	public int compareTo(Account o) {
		if (this.accountName.equalsIgnoreCase(o.accountName)) {
			// Dấu trừ để sắp xếp giảm
			return -((Double)this.accountAmount).compareTo(((Double)o.accountAmount));
		}
		
		return this.accountName.compareToIgnoreCase(o.accountName);
	}
}
