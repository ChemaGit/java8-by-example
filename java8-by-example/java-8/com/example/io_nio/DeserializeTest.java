package com.example.io_nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class DeserializeTest {

	public static void main(String[] args) {
		List<ShoppingCart> items = new ArrayList<ShoppingCart>();
		
		try(FileInputStream fis = new FileInputStream(args[0]);ObjectInputStream in = new ObjectInputStream(fis)) {
			
			for(int i = 0;i < 4; i++) {
				ShoppingCart s = (ShoppingCart)in.readObject();
				items.add(s);
			}
			
			for(ShoppingCart p : items) {
				System.out.println(p.toString());
			}
		} catch(ClassNotFoundException | IOException e) {
			System.out.println("Exception reading in ShoppingCart: " + e);
		}

	}

}
