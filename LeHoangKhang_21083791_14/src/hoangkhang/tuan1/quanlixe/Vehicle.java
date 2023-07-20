package hoangkhang.tuan1.quanlixe;

public class Vehicle {
	private String ownerName;
	private String vehicleName;
	private int xylanh;
	private float price;
	
	public Vehicle() {
		// TODO Auto-generated constructor stub
	}
		
	public Vehicle(String ownerName, String carName, int xylanh, float price) {
		super();
		this.ownerName = ownerName;
		this.vehicleName = carName;
		this.xylanh = xylanh;
		this.price = price;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getCarName() {
		return vehicleName;
	}

	public void setVehicleName(String carName) {
		this.vehicleName = carName;
	}

	public int getXylanh() {
		return xylanh;
	}

	public void setXylanh(int xylanh) {
		this.xylanh = xylanh;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float calculatorTax() {
		float percent = 1;
		if (percent >= 100 && percent <= 200) percent = 3;
		else if (percent > 200) percent = 5;
		
		return (price / 100 * percent);
	}

	@Override
	public String toString() {
		String result = String.format("%-30s\t%-20s\t%10d\t%10.2f\t%10.2f", this.ownerName, this.vehicleName, this.xylanh, this.price, this.calculatorTax());
		
		return result;
	}
	

}

