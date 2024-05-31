package com.rdz.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public class AggregationOperations {

	public static void main(String[] args) {
		Integer[] intArray = new Integer[] { 13, 34, 56, 21, 78, 82, 48, 100, 165, 934, 23, 78 };

		Collection<Integer> collection = Arrays.asList(intArray);
		Stream<Integer> stream = collection.stream();

		System.out.println("\nNombre d'élément dans le stream: " + stream.count());

		// System.out.println("\nNombre d'élément distinct dans le stream: " +
		// stream.distinct()); => Flux fermé par count() au dessus, donc il y a erreur

		// Méthodes renvoyant des streams:
		Stream<Integer> distinctStream = collection.stream().distinct();
		System.out.println("\nNombre d'élément distinct dans le stream: " + distinctStream.count());

		Stream<Integer> limitStream = collection.stream().limit(5);
		System.out.println("\nNombre d'élément limité dans le stream: " + limitStream.count());

		Stream<Integer> skipStream = collection.stream().skip(10);
		System.out.println("\nNombre d'élément restant après skip de 10 dans le stream: " + skipStream.count());

		Stream<Integer> sortedStream = collection.stream().sorted();
		System.out.println("\nStream trié: : " + Arrays.toString(sortedStream.toArray()));
	}
}
