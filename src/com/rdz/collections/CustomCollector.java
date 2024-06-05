package com.rdz.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class CustomCollector {

	private static class Averager {
		
		private int total = 0;
		private int count = 0;

		public double average() {
			return count > 0 ? ((double) total) / count : 0;
		}

		public void accumulate(int i) {
			total += i;
			count++;

		}

		public void combine(Averager other) {
			total += other.total;
			count += other.count;
		}
	}
	
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
		
		Averager averageCollect = collection.stream()
											.filter(person -> person.getGender() == Person.Gender.MALE)
											.map(p -> p.getAge())
											.collect(Averager::new, Averager::accumulate, Averager::combine);
		System.out.println("\nMoyenne d'age: " + averageCollect.average());
		
		
		Map<Person.Gender, List<Person>> genderMap = collection.stream()
															   .collect(Collectors.groupingBy(Person::getGender));
		
		for(Entry<Person.Gender, List<Person>> entry : genderMap.entrySet()) {
			System.out.println(entry);
			
			
		Map<String, List<Person>> citiesMap = collection.stream()
					   								    .collect(Collectors.groupingBy(Person::getCity));
		
		for(Entry<String, List<Person>> citiesEntry : citiesMap.entrySet()) {
				System.out.println(citiesEntry);
			}
		
		Map<String, Double> cityAverageMap = collection.stream()
											 .collect(Collectors.groupingBy(Person::getCity, Collectors.averagingInt(Person::getAge)));
		
		for(Entry <String, Double> entryCityAverageMap : cityAverageMap.entrySet()) {
			System.out.println(entryCityAverageMap);
			}
		
		collection.parallelStream()
			.filter(person -> person.getGender() == Person.Gender.FEMALE)
			.map(p -> p.getName() + ", " + p.getCity())
			.map(s -> s.toUpperCase())
			.forEach(s -> System.out.println(s));
		}
	}
}
