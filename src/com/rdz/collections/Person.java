package com.rdz.collections;

public class Person {

	public enum Gender {
		FEMALE, MALE
	}

	private String name;
	private Gender gender;
	private int age;
	private String city;

	
	public Person(String name, Gender gender, int age, String city) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public Gender getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}

	public String getCity() {
		return city;
	}

	@Override
	public String toString() {
		return "\nname: " + name + ", \ngender: " + gender + ", \nage: " + age + ", \ncity: " + city + "\n\n----------------";
	}

	
}
