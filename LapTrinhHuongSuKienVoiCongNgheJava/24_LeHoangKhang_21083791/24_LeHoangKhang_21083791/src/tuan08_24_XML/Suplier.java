package tuan08_24_XML;

public class Suplier {
	private String supName;
	private String website;
	private String country;
	
	
	public Suplier() {
		super();
	}
	public Suplier(String supName) {
		super();
		this.supName = supName;
	}
	public Suplier(String supName, String website, String country) {
		super();
		this.supName = supName;
		this.website = website;
		this.country = country;
	}
	public String getSupName() {
		return supName;
	}
	public void setSupName(String supName) {
		this.supName = supName;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "suplier [supName=" + supName + ", website=" + website + ", country=" + country + "]";
	}
	
	
	
}
