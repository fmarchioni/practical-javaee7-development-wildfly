package com.itbuzzpress.chapter6.beans;

public class Country implements Comparable<Country> {

	public Country(String capital, String continent, String language, long population) {
		super();
		this.capital = capital;
		this.continent = continent;
		this.language = language;
		this.population = population;
	}

	private String capital;
	private String continent;
	private String language;
	private long population;

	public Country() {
	}

	@Override
	public int compareTo(Country c) {
		return 1;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}
}