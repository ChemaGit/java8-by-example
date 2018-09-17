package com.example.io_nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathInterface {
	// PATH INTERFACE
	public static void main(String[] args) {
		Path p1 = Paths.get(args[0]);
		Path p2 = p1.subpath(3, 6);
		System.out.format("getFileName: %s%n", p1.getFileName());
		System.out.format("getParent: %s%n", p1.getParent());
		System.out.format("getNameCount: %d%n", p1.getNameCount());
		System.out.format("getRoot: %s%n", p1.getRoot());
		System.out.format("isAbsolute: %b%n", p1.isAbsolute());
		System.out.format("toAbsolutePath: %s%n", p1.toAbsolutePath());
		System.out.format("toUri: %s%n", p1.toUri());
		System.out.println();
		System.out.println("PATH 2");
		System.out.println("PATH 2: " + p2.toString());
		System.out.format("toAbsolutePath: %s%n", p2.toAbsolutePath());
		System.out.format("getRoot: %s%n", p2.getRoot());
		System.out.format("toUri: %s%n", p2.toUri());
		System.out.format("getFileName: %s%n", p2.getFileName());
		System.out.format("isAbsolute: %b%n", p2.isAbsolute());
		System.out.format("getNameCount: %d%n", p2.getNameCount());
		System.out.format("getParent: %s%n", p2.getParent());
		
		//JOINING TWO PATHS
		System.out.println();
		System.out.println("JOINING TWO PATHS");		
		Path p3 = p2.resolve(p2);
		System.out.format("toAbsolutePath: %s%n", p3.toAbsolutePath());
		
		
	}

}
