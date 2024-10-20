package exercise1;

import java.util.Scanner;

public class Runnable {
    public static void main(String[] args) {
        // create array to store insurances
        Insurance[] insurances = new Insurance[3];
        Insurance insurance;

        // to store user input
        int userInput;
        Scanner scanner = new Scanner(System.in);

        // loop according to the length insurances array
        for (int i = 0; i < insurances.length; i++) {
            System.out.println("Please enter the type: 1.Health, 2.Life");
            userInput = scanner.nextInt();

            // check what user has input and create correct object
            if(userInput == 1) {
                insurance = new Health();
            }else{
                insurance = new Life();
            }

            // enter monthly fee
            System.out.println("Please enter the monthly fee: ");
            insurance.setInsuranceCost(scanner.nextDouble());

            // assign the object into array
            insurances[i] = insurance;
        }

        // for display information
        for(Insurance insu: insurances){
            insu.displayInfo();
        }

        scanner.close();
    }
}
