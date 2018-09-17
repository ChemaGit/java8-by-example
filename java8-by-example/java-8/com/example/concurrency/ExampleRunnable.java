package com.example.concurrency;

public class ExampleRunnable implements Runnable{
	
	private final String name;
	
	public ExampleRunnable(String name) {
		this.name = name;
	}

	@Override
	public void run() {		
		int count = 0;
		for(count = 0;count < 1000;count++) {
			System.out.println(name + ": " + count);
			count++;
		}
	}

}
