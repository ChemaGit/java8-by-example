package com;

import java.util.Scanner;

public class Chatbot {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // instatiate a Scanner object
        System.out.println("Hi, I'm Rock, the chatbot you programmed");
        System.out.println("May I know your name?");

        String name = scanner.nextLine();

        System.out.println("Nice to meet you, " + name + "!");

        // age % 5
        // age % 7
        // age % 9
        System.out.println("I'm going to try to guess your age.");
        System.out.println("May I know the remainder of your age divided by 5?");
        int ageMod5 = scanner.nextInt();

        System.out.println("Thank you, May I know the remainder of your age divided by 7?");
        int ageMod7 = scanner.nextInt();

        System.out.println("Thank you, May I know the remainder of your age divided by 9?");
        int ageMod9 = scanner.nextInt();

        System.out.println("You wrote " + ageMod5 + ", " + ageMod7 + " and " + ageMod9);

        // deduce the age
    }
}
