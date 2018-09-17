package com.exception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainException {
	public static String file;
	public static void main(String args[]) {
		try{
			file = args[0];
			//file = "pepito.txt";
			System.out.println("Reading for file: " + file);			
			BufferedReader b = new BufferedReader(new FileReader(file));
			String s = null;
			while( (s = b.readLine()) != null) {
				System.out.println(s);
			}
		}catch(ArrayIndexOutOfBoundsException aio) {
			System.out.println(aio.getMessage() + ": No file specified, quitting.");
			System.exit(1);
		} catch (FileNotFoundException fnt) {
			System.out.println(fnt.getMessage() + ": File not found: " + file);
			System.exit(1);
		} catch (IOException io) {
			System.out.println(io.getMessage() + ": Error reading File.");
			System.exit(1);						
		}
	}

}
