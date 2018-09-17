package com.example.io_nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class WorkingWithDirectories {
	public static void main(String args[]) {
		Path path = Paths.get("C:\\Users\\chema\\WorkspaceNeon\\documents\\Oracle\\J2SE");
		System.out.println("****LIST THE CONTENTS OF A DIRECTORY****");	
		try(Stream<Path> files = Files.list(path)) {
			files.forEach(line -> System.out.println(line));
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		
		System.out.println();
		System.out.println("****WALK THE DIRECTORY STRUCTURE****");	
		Path path2 = Paths.get("C:\\Users\\chema\\WorkspaceNeon\\documents");
		try(Stream<Path> files = Files.walk(path2)) {
			files.forEach(line -> System.out.println(line));
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}	
		
		System.out.println();
		System.out.println("****WALK THE DIRECTORY STRUCTURE AND FILTER RESULTS****");	
		Path path3 = Paths.get("C:\\Users\\chema\\WorkspaceNeon\\documents");
		try(Stream<Path> files = Files.walk(path3)) {
			files.filter(p -> p.toString().endsWith(".epub")).forEach(line -> System.out.println(line));
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}			
			
	}
}
