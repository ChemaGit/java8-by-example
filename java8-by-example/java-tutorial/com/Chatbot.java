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
        int age = 0;
        int potenciaAge = 1;

        while (potenciaAge <= 120) {
            if(potenciaAge % 5 == ageMod5 &&
                    potenciaAge % 7 == ageMod7 &&
            potenciaAge % 9 == ageMod9) {
                age = potenciaAge;
            }
            potenciaAge++;
        }
        if(age == 0) {
            System.out.println("Error: I couldn't identify your age. Most likely your numbers are incorrect.");
        } else {
            System.out.println("I've deduced that your age is " + age + ": perfect  time to learn Java.");
        }

        System.out.println("I can count really fast! Wanna see? Give me a number.");
        int limit = scanner.nextInt();
        for(int counter = 1;counter <= limit;counter++) {
            System.out.println(counter);
        }
        System.out.println("Done! See how fast I was? Going to end the chat now. Have fun!");
    }
}

/**
 * Packing and Run the application
 *
 * Menu File ==> Project Structure ==> Artifacts ==> Jar ==> From modules with dependencies
 * Choose a Main class
 * Check: copy to the output directory and link via manifest and hit OK
 * Hit Apply and then OK
 *
 * Menu Build ==> Build Artifacts ==> Build
 *
 * Navigate to this directory:
 * $ cd .../java-output/artifacts/java8_by_example_jar/java8_by_example.jar
 * Run the .jar
 * $ java -jar java8-by-example.jar
 */
