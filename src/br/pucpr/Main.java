package br.pucpr;

import java.util.ArrayList;
import java.util.List;

import br.pucpr.annotations.Table;
import br.pucpr.sample.Dog;
import br.pucpr.sample.Planet;
import br.pucpr.sample.Race;

public class Main {
	public static List<Dog> createDogs() {
		List<Dog> dogs = new ArrayList<>();
		dogs.add(new Dog("Margarida", Race.Labrador, 7, 234.54));
		dogs.add(new Dog("Vitoria", Race.Mixed, 5, 80.54));
		dogs.add(new Dog("Pretinha", Race.Mixed, 3, 50.00));
		dogs.add(new Dog("Laka", Race.Mixed, 3, 50.00));
		dogs.add(new Dog("Lola", Race.Basset, 12, 150.00));
		dogs.add(new Dog("Belinha", Race.Cocker, 6, 150.00));
		dogs.add(new Dog("Pink", Race.Pinscher, 16, 180.00));
		dogs.add(new Dog("Gohan", Race.Beagle, 9));
		return dogs;
	}

	public static List<Planet> createPlanets() {
		List<Planet> planets = new ArrayList<>();
		planets.add(new Planet("Mercurio", 0.06, 0.38));
		planets.add(new Planet("Venus", 0.81, 0.95));
		planets.add(new Planet("Terra", 1, 1));
		planets.add(new Planet("Marte", 0.14, 0.53));
		planets.add(new Planet("Jupiter", 318, 10.97));
		planets.add(new Planet("Saturno", 95.2, 9.14));
		planets.add(new Planet("Urano", 14.5, 3.98));
		planets.add(new Planet("Netuno", 17.10, 3.87));


		return planets;
	}

	public static void main(String[] args) {
		new Table()
			.print(createDogs());

		System.out.println();
		System.out.println();

		new Table()
			.setHeaderSeparator("-------+--------+------------|")
			.setColumnSeparator(" | ")
			.print(createPlanets());
	}
}
