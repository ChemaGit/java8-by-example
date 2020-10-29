package com;

public class Main {

    // method signature = access modifier + (static) + return type + method name + argument list
    public static void main(String[] args) {
        System.out.println("Hello Java 15");

        // variables
        int aNumber = 2;
        int anotherNumber = 40;
        int sum = aNumber + anotherNumber;
        System.out.println(sum);

        // primitives types
        int anInteger = 30; // integers = 4 bytes
        long aBigInteger = 6548965214878541L; // long 8 bytes
        float aSmallDecimal = 2.3F; // float = 4 bytes
        double aBigDecimal = 3.14; // double precision = 8 bytes
        double sStarsInTheUniverse = 1.1e21; // 1.1 * 10^21
        double hydrogenRadius = 5.3e-11; // 5.3 * 10^-11

        char aCharacter = 'a';
        char aDigitCharacter = '1'; // don't confuse '1' with 1

        boolean aTruthValue = true;
        boolean aBoolean = 7 > 3 ? true : false;

        // string
        // Strings are REFERENCE TYPES
        String aString = "I love Scala!";
        String str = 7 > 3 ? "greater" : "smaller";

        // expressions
        // math operations
        int multiplyInt = 2 * 3;
        int divide = 7 / 3; // only the quotient is kept for int division
        int reaminderInt = 7 % 3; // the remainder of the division

        // incrementing and decrementing
        aNumber++; // aNumber will become 3
        System.out.println(aNumber);
        ++aNumber; // aNumber will become 4
        System.out.println(aNumber);

        int someInteger = 4;
        int someInteger2 = someInteger++; // 4, AFTER WHICH someInteger become 5. posincrementing
        int someInteger3 = ++someInteger; // someInteger becomes 6, AFTER WHICH someInteger3 becomes 4. preincrementing
        System.out.println(someInteger);
        System.out.println(someInteger2);
        System.out.println(someInteger3);
        // same for -- (decrementing)

        // math operators on decimals
        double aDoubleSum = 2.3 + 4.5;
        double divideDouble = 7.0 / 3; // 2.3333....

        // character operations
        char aLetter = 'a';
        aLetter++; // ASCII code, aLetter becomes 'b'

        // special characters
        char aQuote = '\''; // escape sequence
        char doubleQuote = '\"'; // double "
        char newLine = '\n'; // new line
        char aTab = '\t'; // tab
        char backSlash = '\\';

        // boolean operations
        boolean numberIsTooBig = aNumber > 100; // evaluates to false
        boolean isLetterMyFavorite = aLetter == 't'; // means the COMPARISON EQUALITY operator
        boolean smallOddNumber = (aNumber < 10) && (aNumber % 2 == 0); // && for logical AND, || for logical OR
        boolean negate = !smallOddNumber;

        // String operations
        String concatenation = "I love " + "Scala"; // concatenates strings => "I love Scala"
        System.out.println(concatenation);

        // instructions
        aNumber = 45; // aNumber becomes 45
        aNumber = aNumber + 6; // aNumber becomes 51
        aNumber += 6; // equivalent
        // old variables don't update automatically
        System.out.println(sum);

        // control statements
        int age = 78;
        if(age < 30) { // if/else statement
            System.out.println("You're just getting started!");
            System.out.println("Something else");
        } else {
            System.out.println("Perfect time to start learning Java!");
            age += 1;
            System.out.println("Your age has become " + age);
        }

        // chain if-else structures
        int temperature = 22;
        if(temperature < 20) {
            System.out.println("Quite chill outside, maybe take a jacket.");
        } else if (temperature < 25) {
            System.out.println("Very pleasant outside, take a walk.");
        } else {
            System.out.println("It's getting hot, maybe take some water.");
        }

        // while loops - test condition, then execute
        System.out.println("Watch me count to 10!");
        int counter = 1;
        while(counter <= 10) {
            System.out.println(counter);
            counter++;
        }

        // do-while loops - execute, then test condition
        counter = 1;
        do {
            System.out.println(counter);
            counter++;
        } while(counter <= 10);

        // for loops
        for(counter = 1; counter <= 10; counter++) {
            System.out.println(counter);
        }
        /*
        for structure operation (pseudo-code)

        starting instruction;
        as long as (continuation condition) {
            run contents;
            instruction to execute after the contents
        }
         */

        // reference types
        String username1 = "Alice";
        int userAge1 = 25;
        String username2 = "Bob";
        int userAge2 = 24;
        System.out.println(username1 + " says to " + username2 + ": Happy birthday for turning " +
                userAge2 + "!");

        // instatiate = create an instance of a class
        Person alice = new Person("Alice", 22); // Alice is an INSTANCE of Person
        Person bob = new Person("Bob", 84);

        System.out.println("username: " + alice.username);
        System.out.println("age: " + alice.age);
        System.out.println("username: " + bob.username);
        System.out.println("age: " + bob.age);

        // Alice's birthday
        alice.age++;
        System.out.println(alice.username + " says: It's my birthday, I just turned " + alice.age);
        bob.age++;
        System.out.println(bob.username + " says: It's my birthday, I just turned " + bob.age);

        alice.celebrateBirthday();
        bob.celebrateBirthday();

        String alicesParty = alice.throwParty(20, "My house");
        System.out.println(alicesParty);

        // all reference types (classes) can have methods
        String aTestString = "I love Scala";
        System.out.println(aTestString.length()); // # of characters
        System.out.println(aTestString.startsWith("I love"));
        System.out.println(aTestString.substring(2, 7));

        // arrays
        Person charlie = new Person("Charlie", 34);
        // a million other people
        Person[] peopleCelebratingToday = new Person[3];
        peopleCelebratingToday[0] = alice;
        peopleCelebratingToday[1] = bob;
        peopleCelebratingToday[2] = charlie;

        // repeat over an array
        int personIndex = 0;
        while(personIndex < peopleCelebratingToday.length) {
            Person currentPerson = peopleCelebratingToday[personIndex];
            currentPerson.celebrateBirthday();
            String party = currentPerson.throwParty(25, "at my house");
            System.out.println(party);
            personIndex++;
        }

        System.out.println();

        // same thing in a for loop
        for(personIndex = 0; personIndex < peopleCelebratingToday.length; personIndex++) {
            Person currentPerson = peopleCelebratingToday[personIndex];
            currentPerson.celebrateBirthday();
            String party = currentPerson.throwParty(25, "at my house");
            System.out.println(party);
        }

        System.out.println();

        // foreach loop
        for(Person person : peopleCelebratingToday) {
            person.celebrateBirthday();
            String party = person.throwParty(25, "at my house");
            System.out.println(party);
        }

        System.out.println();

        // static members and methods
        boolean peopleCanFly = Person.canFly;

        System.out.println(Person.canFly);
        Person.canFly = true;
        System.out.println(Person.canFly);

        String peoplesProgrammingLanguage = Person.getFavoriteProgrammingLanguage();
        System.out.println(peoplesProgrammingLanguage);

        // access modifiers
        // System.out.println(alice.secret); // <-- compiler error
    }
}

class Person { // REFERENCE TYPE
    String username;
    int age;

    public static boolean canFly = false;
    // private ACCESS MODIFIER
    // other access modifiers: public, protected, (no modifier = access inside package)
    private String secret = "nobody needs to know this";

    // constructor - used to initialize fields
    public Person(String username, int age) {
        this.username = username;
        this.age = age;
    }

    // methods = pieces of CODE attached to a single type
    public void celebrateBirthday() {
        System.out.println(this.username + " says: It's my birthday, I just turned " + this.age);
    }

    public String throwParty(int nPeople, String favoritePlace) {
        String throwAParty = this.username + " says: I'm going to throw a party at " + favoritePlace;
        String invitePeople = " and I'm going to invite " + nPeople + " people!";

        return throwAParty + invitePeople;
    }
    /*
    returnType methodName(arguments) {
        any code

        return a single value
    }
     */

    public static String getFavoriteProgrammingLanguage() {

        return "Java";
    }
}