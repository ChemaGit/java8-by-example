package com.example.io_nio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WorkingWithFiles {

	public static void main(String[] args) {
		Path path = Paths.get("C:\\Temp\\Files\\hamlet.txt");
		//Leemos un fichero
		System.out.println("**********BUFFERED READER*******************************");
		p01BufferedReader(path);
		//Leemos un fichero con NIO
		System.out.println("**********NIO FILE STREAM*******************************");
		p02NioRead(path);
		System.out.println("**********READ THE CONTENTS OF THE FILE INTO ARRAYLIST**");
		p03NioReadAll(path);
		System.out.println("**********READ THE CONTENTS OF THE FILE INTO ARRAYLIST**");
		p04NioReadAll(path);
	}
	
	private static void p01BufferedReader(Path path) {		
		try(BufferedReader bufInput = new BufferedReader(new FileReader(path.toString()))) {
			Stream<String> lines = bufInput.lines();			
			lines.forEach(line -> System.out.println(line));
		} catch (FileNotFoundException e) {			
			System.out.println("File not found: " + e);
		} catch (IOException e) {			
			System.out.println("Exception: " + e);
		}
	}
	
	private static void p02NioRead(Path path) {
		try(Stream<String> lines = Files.lines(path)) {
			lines.forEach(line -> System.out.println(line));
		}catch(UncheckedIOException e){
			System.out.println(e.getMessage());				
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}		
	}
	
	private static void p03NioReadAll(Path path) {
		Predicate<String> myPredicate = p -> p.contains("CLAUDIO");
		Predicate<String> myPredicateB = p -> p.contains("HAMLET");
		try(Stream<String> lines = Files.lines(path)) {			
			ArrayList<String> myList = (ArrayList<String>) lines.collect(Collectors.toList());
			myList.stream().filter(myPredicate).forEach(line -> System.out.println(line));
			System.out.println();
			myList.stream().filter(myPredicateB).forEach(line -> System.out.println(line));
		}catch(UncheckedIOException e){
			System.out.println(e.getMessage());				
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}				
	}
	
	private static void p04NioReadAll(Path path) {
		Predicate<String> myPredicate = p -> p.contains("CLAUDIO");
		Predicate<String> myPredicateB = p -> p.contains("HAMLET");		
		try(Stream<String> lines = Files.lines(path)) {			
			ArrayList<String> myList = (ArrayList<String>) lines.collect(Collectors.toList());
			myList.stream().filter(myPredicate).forEach(line -> System.out.println("CLAUDIO"));
			System.out.println("Word CLAUDIO count: " + myList.stream().filter(myPredicate).count());
			System.out.println();
			myList.stream().filter(myPredicateB).forEach(line -> System.out.println("HAMLET"));
			System.out.println("Word HAMLET count: " + myList.stream().filter(myPredicateB).count());	
			
		}catch(UncheckedIOException e){
			System.out.println(e.getMessage());				
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}					
	}

}
