package com.collections;

import java.util.HashMap;
import java.util.Map;

public class TestCollections {

	public static void main(String[] args) {
		Map<String, String> productNames = new HashMap<String, String> ();
		productNames.put("1S01", "Blue Polo Shirt");
		productNames.put("1S02", "Black Polo Shirt");
		productNames.put("1H01", "Red Ball Cap");
		productNames.put("1M02", "Duke Mug");		
		int lenArray = 0;
		String[] parts = null;
		
		do {
			lenArray = (int)(200 * Math.random());
			if(lenArray >= 10) {
				parts = new String[lenArray];
				for(int i = 0;i < lenArray;i++) {
					int prod = (int)(4 * Math.random());
					switch(prod){
						case 0:
							parts[i] = "1S01";
							break;
						case 1:
							parts[i] = "1S02";
							break;
						case 2:
							parts[i] = "1H01";
							break;
						case 3:
							parts[i] = "1M02";
							break;
						default:
							System.out.println("This shouldn't happen.....");
							break;
					}
				}				
			}					
		}while(lenArray < 10);
		
		/*for(String part : parts) {
			System.out.println(part);
		}*/
		
		ProductCounter pc1 = new ProductCounter(productNames);
		pc1.processList(parts);
		pc1.printReport();
	}

}
