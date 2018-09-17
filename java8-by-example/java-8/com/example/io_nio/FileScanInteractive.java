package com.example.io_nio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileScanInteractive {

	
	public int countTokens(String file, String search) throws IOException{
		int instanceCount = 0;
		try(BufferedReader in = new BufferedReader(new FileReader(file))) {
			String line = "";
			while( (line = in.readLine()) != null) {				
				String lineArr[] = line.split(" ");
				int instance = 0;
				if(lineArr != null && lineArr.length > 0) {					
					for(int i = 0; i < lineArr.length; i++) {
						instance = lineArr[i].indexOf(search);
						if(instance > -1) {
							instanceCount++;
						}
					}
				} else {
					instance = line.indexOf(search);
					if(instance > -1) {
						instanceCount++;
					}
				}
			}
		}catch(IOException e) {
			throw(e);
		}
		return instanceCount;
	}
}
