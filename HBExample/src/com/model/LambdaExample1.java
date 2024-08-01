package com.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaExample1 {

    public static void main(String[] args) {
        // List of strings
        List<String> li = Arrays.asList("Karur", "Trichy", "Coimbatore", "Chennai");

        // Filter and print strings starting with "C" in uppercase
        li.stream()
          .filter(s -> s.startsWith("C"))
          .map(String::toUpperCase)
          .forEach(System.out::println);

        // List of integers
        List<Integer> li1 = Arrays.asList(10, 8, 15, 19, 22, 78, 18);

        // Find all even numbers
        List<Integer> evenNumbers = li1.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even numbers: " + evenNumbers);

        // Print all integers that start with 1
        List<Integer> startWithOne = li1.stream()
                .filter(n -> Integer.toString(n).startsWith("1"))
                .collect(Collectors.toList());
        System.out.println("Integers starting with 1: " + startWithOne);

        // Print number of integers
        long count = li1.stream().count();
        System.out.println("Number of integers: " + count);

        // Print first element
        Integer firstElement = li1.get(0);
        System.out.println("First element: " + firstElement);

        // Find the maximum element
        Integer maxElement = li1.stream().max(Integer::compare).orElse(null);
        System.out.println("Maximum element: " + maxElement);

        // Find the minimum element
        Integer minElement = li1.stream().min(Integer::compare).orElse(null);
        System.out.println("Minimum element: " + minElement);

        // Sum of all elements
        int sum = li1.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum of all elements: " + sum);
    }
}
