package com.example.io_nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializeTest {

	public static void main(String[] args) {
		
		ShoppingCart sCart1 = new ShoppingCart(1, "Motorola G4", "Mobile Phone", 175);
		ShoppingCart sCart2 = new ShoppingCart(2, "Tablet Samsung", "Tablet Device", 450);
		ShoppingCart sCart3 = new ShoppingCart(3, "Laptop Lenovo", "Computer Laptop", 1275);
		ShoppingCart sCart4 = new ShoppingCart(4, "PC Asus", "WorkStation Quad", 2100);
		
		List<ShoppingCart> items = new ArrayList<ShoppingCart>();
		items.add(sCart1);
		items.add(sCart2);
		items.add(sCart3);
		items.add(sCart4);
		
		
		try (FileOutputStream fos = new FileOutputStream(args[0]); ObjectOutputStream out = new ObjectOutputStream(fos)) {
			System.out.println("Open file: " + args[0]);			
			for(ShoppingCart s : items) {
				out.writeObject(s);				
				System.out.println("Sucessfully serialized: " + s.toString());
			}	
		} catch(IOException e) {
			System.out.println("Exception serializing " + args[0] + ": " + e);
		}

	}

}
