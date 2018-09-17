package com.example;

public class MainSingleton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("IMPLEMENTS A SINGLETON PATTERN\n");
		
		PeerSingleton peerList01 = PeerSingleton.getInstance();		
		System.out.println("HOSTNAME: " + peerList01.getHostname());
		System.out.print("PORT: " + peerList01.getPort());
		
		System.out.println("\n");
		
		PeerSingleton peerList02 = PeerSingleton.getInstance();		
		System.out.println("HOSTNAME: " + peerList02.getHostname());
		System.out.print("PORT: " + peerList02.getPort());	
		
		System.out.println("\n");
		
		PeerSingleton peerList03 = PeerSingleton.getInstance();
		System.out.println("HOSTNAME: " + peerList03.getHostname());
		System.out.print("PORT: " + peerList03.getPort());		
		
		System.out.println("\n\nEND IMPLEMENTS A SINGLETON PATTERN\n");
	}

}
