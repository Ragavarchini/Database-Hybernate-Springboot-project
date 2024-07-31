package com.model;



import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamIntermediateOperationExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//List of lists of names
		List<List<String>> listOfLists = Arrays.asList(
				Arrays.asList("Reflection","Collection","Stream"),
				Arrays.asList("Structure","State","Flow"),
				Arrays.asList("Sorting","Mapping","Reduction","Stream")
				);
		
		//create a set to hold intermediate results
		Set<String> intermediateResults = new HashSet<>();
		
		//Stream pipeline demonstrating various intermediate operations
		List<String> result = listOfLists.stream().flatMap(List::stream)  //Flatten the list of lists into a single stream
		.filter(s -> s.startsWith("S"))  //Filter elements starting with "S"
		.map(String::toUpperCase)  //Transform each element to UpperCase
		.distinct()  //Remove duplicate elements
		.sorted()  //Sort elements
		.peek(s -> intermediateResults.add(s))  //Perform to action(add to set)on each element
		.collect(Collectors.toList());  //Collect the final result into a list
		
		//print the intermediate results
		System.out.println("Final Result:");
		result.forEach(System.out::println);

	}

}