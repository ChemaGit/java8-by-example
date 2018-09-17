package com.example.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {

	public static void main(String[] args) {
		ExampleThread thread = new ExampleThread();
		thread.start();
		ExampleRunnable runnable = new ExampleRunnable("Julia Ann");
		runnable.run();
	}

}
