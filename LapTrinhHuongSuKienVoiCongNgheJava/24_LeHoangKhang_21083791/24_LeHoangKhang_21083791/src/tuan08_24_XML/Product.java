package tuan08_24_XML;

public class Product {
	private String productID;
	private String name;
	private String manufacture;
	private String description;

	private Suplier suplier;
	private double price;

	public Product() {
		super();
	}

	public Product(String productID) {
		super();
		this.productID = productID;
	}

	public Product(String productID, String name, String manufacture, String description, Suplier suplier,
			double price) {
		super();
		this.productID = productID;
		this.name = name;
		this.manufacture = manufacture;
		this.description = description;
		this.suplier = suplier;
		this.price = price;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManufacture() {
		return manufacture;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Suplier getSuplier() {
		return suplier;
	}

	public void setSuplier(Suplier suplier) {
		this.suplier = suplier;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
