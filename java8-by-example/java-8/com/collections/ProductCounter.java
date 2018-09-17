package com.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ProductCounter {
	
	private Map <String, Long> productCountMap = new HashMap<String, Long>(); 
	private Map<String, String> productNames = new TreeMap<String, String>();
	
	public ProductCounter(Map productNames) {
		this.productNames = productNames;
	}
	
	public void processList(String[] list) {
		for(String key : list) {
			String value = this.productNames.get(key);
			if(productCountMap.containsKey(value)) {
				Long count = productCountMap.get(value);
				productCountMap.put(value, ++count);
			} else {
				productCountMap.put(value, new Long(1));
			}
		}
	}
	
	public void printReport() {
		System.out.println("===PRODUCT REPORT===");
		Set<String> keys = productCountMap.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println("Name: " + key + "      Count: " + productCountMap.get(key).longValue());
		}
	}
}
