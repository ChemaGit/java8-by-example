package com.collections;

import java.util.List;
import java.util.function.Predicate;

public class RoboCallTest {

	public static void main(String[] args) {
		List<Person> pl = Person.createShortList(); 
		Predicate<Person> allPilots = p -> p.getAge() >= 23 && p.getAge() <= 65;
		pl.stream().filter(allPilots).forEach(p -> System.out.println(p));		
		System.out.println("===Print List===");
		pl.forEach(p -> System.out.println(p)); 
		
	}

}
