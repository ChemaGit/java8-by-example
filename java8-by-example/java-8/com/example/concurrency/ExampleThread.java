package com.example.concurrency;

public class ExampleThread extends Thread{
	
	@Override
	public void run() {
		int count = 0;
		while(true) {			
			System.out.println("count: " + count);
			count++;
		}
	}

}
