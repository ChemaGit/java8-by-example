package com.example.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorExample {

	public static void main(String[] args) {
		//int cpuCount = Runtime.getRuntime().availableProcessors();
		//ExecutorService es2 = Executors.newFixedThreadPool(cpuCount);		
		//the java.util.concurrent package
		ExecutorService es = Executors.newCachedThreadPool();
		es.execute(new ExampleRunnable("Dillion Harper"));
		es.execute(new ExampleRunnable("Kendra Lust"));
		es.execute(new ExampleRunnable("Julia Ann"));
		es.shutdown();
		//Shutting down an ExecutorService
		try {
			es.awaitTermination(5, TimeUnit.SECONDS);
		} catch(InterruptedException ex) {
			System.out.println("Stopped waiting early: " + ex.getMessage());
		}
		
		
	}

}
