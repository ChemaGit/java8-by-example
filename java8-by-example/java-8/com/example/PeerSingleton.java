package com.example;

public class PeerSingleton {

	private static final PeerSingleton instance = new PeerSingleton();;
	private static String hostname;
	private static int port;
	
	static {
		System.out.println("Initializing......");
		PeerSingleton.hostname = "prometeo.internal.net";
		PeerSingleton.port = 90;
	}
	
	private PeerSingleton() {
		
	}
	
	public static PeerSingleton getInstance(){
		return PeerSingleton.instance;
	}

	/**
	 * @return the hostname
	 */
	public String getHostname() {
		return hostname;
	}

	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}
	
}
