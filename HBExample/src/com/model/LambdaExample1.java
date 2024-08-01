package com.model;

import java.util.Arrays;
import java.util.List;

public class LambdaExample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> li=Arrays.asList("Karur","Trichy","Coimbatore","Chennai");
		//for(String s:li) {Syste.out.println(s));
		
		//new way1
		//li.forEach(s -> System.out.println(s));
		//li.forEach(System.out::println(s));
		 
		//new way2
		li.stream()
		.filter(s ->s.startsWith("C"))
		.map(s ->s.toUpperCase())
		.forEach(System.out::println);
		

	}

}