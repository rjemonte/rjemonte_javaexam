package src.weather.weatherclasses;

public class Location {
	private String city;
	private String country;
	private String unit = "Metric";
	
	public Location(String city, String country)
	{
		setCity(city);
		setCountry(country);
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Location [city=" + city + ", country=" + country + ", unit=" + unit + ", getCountry()=" + getCountry() + ", getCity()=" + getCity() + "]";
	}
}
