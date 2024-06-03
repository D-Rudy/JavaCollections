package com.rdz.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.IntBinaryOperator;

public class TerminalOperation {

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

		
		double averageAgeOfMales = collection.stream()
									.filter(person -> person.getGender() == Person.Gender.MALE)
									.mapToInt(p-> p.getAge())
									.average() //fonction reductrice
									.getAsDouble();
		System.out.println("Age moyen des hommes: " + averageAgeOfMales);
		
		double maxFemaleAge = collection.stream()
									.filter(person -> person.getGender() == Person.Gender.FEMALE)
									.mapToInt(p-> p.getAge())
									.max()
									.getAsInt();
		System.out.println("L'age max des femmes: " + maxFemaleAge);
		
		double maxMaleAge = collection.stream()
									.filter(person -> person.getGender() == Person.Gender.MALE)
									.mapToInt(p-> p.getAge())
									.min()
									.getAsInt();
		System.out.println("L'age min des hommes: " + maxMaleAge);
		
		double sumFemaleAge = collection.stream()
									.filter(person -> person.getGender() == Person.Gender.FEMALE)
									.mapToInt(p -> p.getAge())
									.sum();//fonction terminale
		System.out.println("La somme de l'age des femmes: " + sumFemaleAge);
		
		double maxAgeFemale = collection.stream()
									.filter(person -> person.getGender() == Person.Gender.FEMALE)
									.mapToInt(p->p.getAge())
									.reduce(0,  new IntBinaryOperator() {
										
										@Override
										public int applyAsInt(int left, int right) {
											if(left >= right) {
												return left;
											}
											return right;
										}
									});
		System.out.println("Age max des femmes: " + maxAgeFemale);
		
		double minAgeMale = collection.stream()
									.filter(person -> person.getGender() == Person.Gender.MALE)
									.mapToInt(p -> p.getAge())
									.reduce(Integer.MAX_VALUE, (left, right) -> left <= right? left : right);
		System.out.println("Age min des hommes: " + minAgeMale);
		
		double sumFemaleAge2 = collection.stream()
									.filter(person -> person.getGender() == Person.Gender.FEMALE)
									.mapToInt(p -> p.getAge())
									.reduce(0, (left, right) -> left + right);
		System.out.println("La somme de l'age des femmes: " + sumFemaleAge2);
	}

}
