package com.rdz.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

public class PersonStream {

	public static void main(String[] args) {
		Collection<Person> collection = new ArrayList<Person>();
		
		collection.add(new Person("Austin", Person.Gender.MALE, 26, "Seattle"));
		collection.add(new Person("Bert", Person.Gender.MALE, 42, "New York"));
		collection.add(new Person("Carla", Person.Gender.FEMALE, 35, "San Francisco"));
		collection.add(new Person("Desmond", Person.Gender.MALE, 32, "San Jose"));
		collection.add(new Person("Emily", Person.Gender.FEMALE, 24, "Salt Lake City"));
		collection.add(new Person("Fred", Person.Gender.MALE, 45, "Boston"));
	

	long numMales = collection.stream()
						.filter(person -> person.getGender() == Person.Gender.MALE)
						.count();
	
	System.out.println("Nombre d'hommes dans le stream: " + numMales);
	
	long numUnder30 = collection.stream()
							.filter(person -> person.getAge() < 30)
							.count();
	
	System.out.println("Nombre de personne de moins de 30 ans: " + numUnder30);
	
	System.out.println("Homme:");
	//Classe interne anonyme
	collection.stream()
		.filter(person -> person.getGender() == Person.Gender.MALE)
		.forEach(new Consumer<Person>() {
			
			@Override
			public void accept(Person t) {
				System.out.println(t);
			}
		});
	
	System.out.println("\n\nFemme:");
	
	//fonction lambda
	collection.stream()
		.filter(person -> person.getGender() == Person.Gender.FEMALE)
		.forEach( person -> System.out.println(person) );
	}
}