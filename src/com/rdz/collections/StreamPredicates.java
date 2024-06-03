package com.rdz.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;

public class StreamPredicates {

	public static void main(String[] args) {
		Integer[] intArray = new Integer[] { 13, 34, 56, 21, 78, 82, 48, 100, 165, 934, 23, 78 };

		Collection<Integer> collection = Arrays.asList(intArray);

//		for (Integer num: collection) {
//			if(num > 50) {
//				System.out.println("il y a un nombre > 50");
//				break;
//			}
//		}

		boolean greaterThan50 = collection.stream().allMatch(new Predicate<Integer>() { // Predicat est un interface; Il
																						// est appliqué a chaque élément
																						// du stream
			@Override
			public boolean test(Integer t) {
				return t > 50;
			}
		});
		System.out.println("Tous les nombres sont > 50 ? : " + greaterThan50);

		boolean greaterThan0 = collection.stream().allMatch(new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
				return t > 0;
			}
		});

		System.out.println("Tous les nombres sont > 0?: " + greaterThan0);

		boolean anyLessThan0 = collection.stream().anyMatch(e -> e < 0); // fontion lambda qui tiens lieu de prédicat
																			// appliqué à tous les éléments du stream
		System.out.println("Il y a un nombre < 0?: " + anyLessThan0);

		boolean anyGreaterThan100 = collection.stream().anyMatch(e -> e > 100);
		System.out.println("Il y a un nombre > 100 ?: " + anyGreaterThan100);

		boolean noneLessThan0 = collection.stream().noneMatch(e -> e < 0);
		System.out.println("Il y a aucun nombre < 0 ?: " + noneLessThan0);

		boolean noneGreaterThan30 = collection.stream().noneMatch(e -> e > 30);
		System.out.println("Il n'y a aucun nombre > 30? : " + noneGreaterThan30);

	}

}
