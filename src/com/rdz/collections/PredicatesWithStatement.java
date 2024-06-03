package com.rdz.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public class PredicatesWithStatement {

	public static void main(String[] args) {
		Integer[] intArray = new Integer[] { 13, 34, 56, 21, 78, 82, 48, 100, 165, 934, 23, 78 };

		Collection<Integer> collection = Arrays.asList(intArray);

		// Récupèration d'un stream d'entier inférieur a 100(filtre le stream des
		// nombres < 1OO)
		Stream<Integer> lessThan100Stream = collection.stream()
													.filter(t -> t < 100);
		System.out.println("Nombres inférieurs a 100: " + Arrays.toString(lessThan100Stream.toArray()));

		long lessThan100DistinctCount = collection.stream()
												.filter(t -> t < 100) 	//pipeline
												.distinct()				//pipeline
												.count();				//sortie
		System.out.println("Total de nombre distinct < 100: " + lessThan100DistinctCount);
	}
}
