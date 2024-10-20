package exercise2;

import java.util.Scanner;

public class Runnable {
    public static void main(String[] args) {
        // create variables
        GameTester gameTester;
        String name;
        String input;
        Scanner scanner = new Scanner(System.in);

        // prompt user for information
        System.out.println("What is your name: ");
        name = scanner.nextLine();
        System.out.println("Are you a full time game tester: Y/N");
        input = scanner.nextLine().toUpperCase();

        // check is full-time or part-time
        if (input.equals("Y")) {
            gameTester = new FullTimeGameTester(name);
            System.out.println(gameTester.toString());

        } else if (input.equals("N")) {
            // ask part-time user to input extra parameter for calculate salary
            System.out.println("Please enter the number of hours: ");
            double hours = scanner.nextDouble();
            gameTester = new PartTimeGameTester(name, hours);
            System.out.println(gameTester.toString());

        }else{
            // if input some weired input
            System.out.println("Please enter a valid choice");
        }

        scanner.close();
    }
}
