package tuan06_24_OnJDBCGiuaKi;

import java.util.Objects;

public class Country {
	private String country;
	private String capital;
	private int population;
	private boolean democracy;

	public Country() {
		super();
	}

	public Country(String country, String capital, int population, boolean democracy) {
		super();
		this.country = country;
		this.capital = capital;
		this.population = population;
		this.democracy = democracy;
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

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public boolean isDemocracy() {
		return democracy;
	}

	public void setDemocracy(boolean democracy) {
		this.democracy = democracy;
	}

	@Override
	public int hashCode() {
		return Objects.hash(capital);
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
		return Objects.equals(capital, other.capital);
	}
	
	public Object[] getRow() {
		Object[] obj = new Object[4];
		obj[0] = country;
		obj[1] = capital;
		obj[2] = population;
		obj[3] = democracy;
		return obj;
	}

}
