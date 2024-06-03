package com.rdz.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Function;

public class MappingAPredicate {

	public static void main(String[] args) {
		Collection<Person> collection = new ArrayList<Person>();
		
		collection.add(new Person("Austin", Person.Gender.MALE, 26, "Seattle"));
		collection.add(new Person("Bert", Person.Gender.MALE, 42, "New York"));
		collection.add(new Person("Carla", Person.Gender.FEMALE, 35, "San Francisco"));
		collection.add(new Person("Desmond", Person.Gender.MALE, 32, "San Jose"));
		collection.add(new Person("Emily", Person.Gender.FEMALE, 24, "Salt Lake City"));
		collection.add(new Person("Fred", Person.Gender.MALE, 45, "Boston"));
		
		System.out.println("HOMMES: \n");
		collection.stream()
			.filter(person -> person.getGender() == Person.Gender.MALE)
			.map(new Function<Person, String>(){
				
				@Override
				public String apply(Person p ) {
					return p.getName() + ", " + p.getCity();
				}
			})
			.forEach(new Consumer<String>() {
				
				@Override
				public void accept(String t) {
					System.out.println(t);
				}
			});
		
		System.out.println("\n\nFEMMES:\n");
		collection.stream()
			.filter(person -> person.getGender() == Person.Gender.FEMALE)
			.map(p -> p.getName() + ", " + p.getCity())
			.forEach(p -> System.out.println(p));
		
		System.out.println("\n\nVILLES: \n");
		collection.stream()
			.map(p -> p.getCity())
			//.map(s -> s.toUpperCase())
			.map(String::toUpperCase)
			.forEach(s -> System.out.println(s));
		
		System.out.println("\n\nAge: \n");
		collection.stream()	
			.mapToInt(p -> p.getAge())
			.forEach(s -> System.out.println(s));
	}
}
