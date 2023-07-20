package tuan05_24_UsingJtableComponent;

import java.util.Objects;

public class Country {
	private String country;
	private String capital;
	private double population;
	private boolean democrecy;
	
	public Country() {
		super();
	}
	
	public Country(String country, String capital, double population, boolean democrecy) {
		super();
		this.country = country;
		this.capital = capital;
		this.population = population;
		this.democrecy = democrecy;
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public double getPopulation() {
		return population;
	}
	public void setPopulation(double population) {
		this.population = population;
	}
	public boolean isDemocrecy() {
		return democrecy;
	}
	public void setDemocrecy(boolean democrecy) {
		this.democrecy = democrecy;
	}
	public Object[] getRow() {
		Object[] obj= new Object[4];
		obj[0] = country;
		obj[1] = capital;
		obj[2] = population;
		obj[3] = democrecy;
		return obj;
	}

	@Override
	public int hashCode() {
		return Objects.hash(capital, country, democrecy, population);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		return Objects.equals(capital, other.capital) && Objects.equals(country, other.country)
				&& democrecy == other.democrecy
				&& Double.doubleToLongBits(population) == Double.doubleToLongBits(other.population);
	}
	
	
}
