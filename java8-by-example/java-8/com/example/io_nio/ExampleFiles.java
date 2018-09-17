package com.example.io_nio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.stream.Stream;

import static java.nio.file.StandardCopyOption.*;

public class ExampleFiles {

	public static void main(String[] args) {
		Path p1 = Paths.get(args[0]);
		Path p2 = p1.subpath(3, 6);
		p2 = p2.resolve("javanotes7.pdf");
		System.out.format("Path %s exists: %b%n", p1, Files.exists(p1, LinkOption.NOFOLLOW_LINKS));
		System.out.format("isReadable(%s): %b%n", p1, Files.isReadable(p1));
		System.out.format("isWritable(%s): %b%n", p1, Files.isWritable(p1));
		System.out.format("isExecutable(%s): %b%n", p1, Files.isExecutable(p1));
		try {
			System.out.format("isSameFile(%s %s): %b%n", p1,p2, Files.isSameFile(p1, p2));
		} catch (IOException e) {
			System.out.println(e.getMessage());		
		}
		
		System.out.println();
		System.out.println("CREATING FILES AND DIRECTORIES");
		Path p3 = Paths.get("C:\\Temp\\Files");
		Path p4 = Paths.get("C:\\Temp\\Files\\demo.dat");
		try {
			Files.createDirectory(p3);
			Files.createFile(p4);
		} catch (IOException e) {			
			System.out.println(e.getMessage());		
		}
		
		System.out.println();
		System.out.println("DELETING FILES OR DIRECTORIES");		
		
		try {
			Files.deleteIfExists(p4);
			System.out.println(p4.toAbsolutePath().toString());
		} catch (IOException e) {			
			System.out.println(e.getMessage());		
		}
		
		System.out.println();
		System.out.println("COPYING A FILE OR DIRECTORY");		
		try {
			Files.copy(p1, p4, REPLACE_EXISTING, COPY_ATTRIBUTES);
			System.out.println("COPYING FROM: " + p1.toAbsolutePath().toString() + " TO " + p4.toAbsolutePath().toString());
		} catch (IOException e) {
			System.out.println(e.getMessage());		
		}
		
		Path p5 = Paths.get("C:\\Users\\chema\\WorkspaceNeon\\documents\\Oracle\\J2SE\\javanotes7.pdf");
		Path p6 = Paths.get("C:\\Temp\\Files2\\javanotes7.pdf");
		
		System.out.println();
		System.out.println("MOVING A FILE OR DIRECTORY");
		//try {WARNING: borra la fuente
			//Files.move(p5, p6, REPLACE_EXISTING);
			System.out.println("MOVING FROM: " + p5.toAbsolutePath().toString() + " TO " + p6.toAbsolutePath().toString());
		//} catch (IOException e) {
			//System.out.println(e.getMessage());	
		//}
			
		System.out.println();
		System.out.println("LIST THE CONTENTS OF A DIRECTORY");	
		try(Stream<Path> files = Files.list(Paths.get("C:\\Users\\chema\\WorkspaceNeon\\documents\\Oracle\\J2SE"))) {
			files.forEach(line -> System.out.println(line));
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println();
		System.out.println("WALK THE DIRECTORY STRUCTURE");		
		try(Stream<Path> files = Files.walk(Paths.get("C:\\Users\\chema\\WorkspaceNeon\\documents\\Oracle"))) {
			files.forEach(line -> System.out.println(line));
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println();
		System.out.println("BUFFEREDREADER FILE STREAM");			
		try(BufferedReader bReader = new BufferedReader(new FileReader("C:\\Temp\\departure.dat"))) {
			bReader.lines().forEach(line -> System.out.println(line));
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println();
		System.out.println("NIO FILE STREAM");		
		try(Stream<String> lines = Files.lines(Paths.get("C:\\Temp\\departure.dat"))) {
			lines.forEach(line -> System.out.println(line));
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println();
		System.out.println("READ FILE INTO ARRAY LIST");		
		Path file = Paths.get("C:\\Temp\\departure.dat");
		List<String> fileArr;
		try {
			fileArr = Files.readAllLines(file);
			fileArr.stream().filter(line -> line.contains("bitch"))
			.forEach(line -> System.out.println(line));
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println();
		System.out.println("MANAGING METADATA");					
	    try {
			BasicFileAttributes attrs = Files.readAttributes(Paths.get("C:\\Temp\\departure.dat"), BasicFileAttributes.class);
			System.out.println(attrs.toString());
			System.out.println("Creation Time: " + attrs.creationTime().toString());
			//System.out.println("File Key: " + attrs.fileKey().toString());
			System.out.println("Is Directory: " + attrs.isDirectory());
			System.out.println("Is Other: " + attrs.isOther());
			System.out.println("Is Regular File: " + attrs.isRegularFile());
			System.out.println("Is SymbolicLink: " + attrs.isSymbolicLink());
			System.out.println("Last AccessTime: " + attrs.lastAccessTime().toString());
			System.out.println("Last Modified Time: " + attrs.lastModifiedTime().toString());	
			System.out.println("Size: " + attrs.size() + " bytes");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}


	}
}
