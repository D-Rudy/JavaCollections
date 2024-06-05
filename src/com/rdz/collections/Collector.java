package com.rdz.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Collector {

	public static void main(String[] args) {
		
		Collection<Person> collection = new ArrayList<Person>();

		collection.add(new Person("Austin", Person.Gender.MALE, 26, "Seattle"));
		collection.add(new Person("Bert", Person.Gender.MALE, 42, "New York"));
		collection.add(new Person("Carla", Person.Gender.FEMALE, 35, "San Francisco"));
		collection.add(new Person("Desmond", Person.Gender.MALE, 32, "San Jose"));
		collection.add(new Person("Emily", Person.Gender.FEMALE, 24, "Salt Lake City"));
		collection.add(new Person("Fred", Person.Gender.MALE, 45, "Boston"));
		collection.add(new Person("Greg", Person.Gender.MALE, 39, "New York"));
		collection.add(new Person("Harold", Person.Gender.MALE, 25, "Seattle"));
		collection.add(new Person("Irene", Person.Gender.FEMALE, 43, "Boston"));
		collection.add(new Person("Julie", Person.Gender.FEMALE, 29, "New York"));

		
		List<String> citiesList = collection.stream()
											.filter(person -> person.getGender() == Person.Gender.MALE)
											.map(p -> p.getCity())
											.collect(Collectors.toList());
		
		System.out.println("\nListe des ville (hommes): " + citiesList);
		
		Set<String> citiesSet = collection.stream()
										  .filter(person -> person.getGender() == Person.Gender.MALE)
										  .map(p -> p.getCity())
										  .collect(Collectors.toSet());

		System.out.println("\nSet des ville (hommes): " + citiesSet);
	
	
		Set<String> citiesTreeSet = collection.stream()
											  .filter(person -> person.getGender() == Person.Gender.MALE)
											  .map(p -> p.getCity())
											  .collect(Collectors.toCollection(TreeSet::new));

		System.out.println("\nTreeSet des ville (hommes): " + citiesTreeSet);
		
		String nameString = collection.stream()
									  .filter(person -> person.getGender() == Person.Gender.FEMALE)
									  .map(Person::getName)
									  .collect(Collectors.joining(", "));
		
		System.out.println("\nNoms séparés par des virgules: " + nameString);
		
		double averageAge = collection.stream()
									  .filter(person -> person.getGender() == Person.Gender.FEMALE)
									  .collect(Collectors.averagingInt(Person::getAge));
		
		System.out.println("\nAge moyen des femmes: " + averageAge);
		
		IntSummaryStatistics summaryStatistics = collection.stream()
												     	   .filter(person -> person.getGender() == Person.Gender.FEMALE)
												     	   .collect(Collectors.summarizingInt(Person::getAge));
		
		System.out.println("\nSummaryStatistics pour les femmes: " + summaryStatistics);
		
		List<String> citiesArray = collection.stream()
											 .filter(person -> person.getGender() == Person.Gender.MALE)
											 .map(p -> p.getCity())
											 .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);// 3 param, creation, ajout, et addAll pour les flux paralleles
		
		System.out.println("\nListe des villes des hommes" + citiesArray);
		
		citiesSet = collection.stream()
							  .filter(person -> person.getGender() == Person.Gender.MALE)
							  .map(p -> p.getCity())
							  .collect(HashSet::new, HashSet::add, HashSet::addAll);

		System.out.println("\nListe des villes des hommes" + citiesSet);
	}

}
