package br.pucpr.sample;

import br.pucpr.annotations.Column;
import br.pucpr.annotations.Header;

public class Dog {
	@Header()
	@Column(order=2, format="%-20s")
	private String name;
	private Race race;

	@Column(format="%02d ", order=1)
	@Header
	private int age;

	@Column(format="%7.2f")
	private double price;
	private boolean diseased = false;
	
	public Dog(String name, Race race, int age, double price) {
		super();
		this.name = name;
		this.race = race;
		this.age = age;
		this.price = price;
	}
	
	public Dog(String name, Race race, int age) {
		super();
		this.name = name;
		this.race = race;
		this.age = age;
		this.price = 0;
		this.diseased = true;
	}	
	
}
