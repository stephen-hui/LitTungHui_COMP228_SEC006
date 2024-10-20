package exercise3;

import java.util.Scanner;

public class ProcessMortgage {
    public static void main(String[] args) {
        // create 3 mortgage objects
        Mortgage[] mortgages = new Mortgage[3];
        Mortgage mortgage;

        // to store variables
        int type;
        String mortgageNumber;
        String mortgageName;
        double amount;
        double interestRate;
        int term;

        Scanner sc = new Scanner(System.in);

        // prompt user for interest rate
        System.out.println("Enter the current interest rate(%): ");
        interestRate = sc.nextDouble();

        for (int i = 0; i < mortgages.length; i++) {
            System.out.println("Choose the mortgage type: 1.Business Mortgage, 2.Personal Mortgage");
            type = sc.nextInt();

            // make sure input 1 or 2
            while (type != 1 && type != 2) {
                System.out.println("Invalid mortgage type");
                System.out.println("Choose the mortgage type: 1.Business Mortgage, 2.Personal Mortgage");
                type = sc.nextInt();
            }

            System.out.println("Enter the mortgage name: ");
            mortgageName = sc.nextLine();

            System.out.println("Enter the mortgage number: ");
            mortgageNumber = sc.nextLine();

            System.out.println("Enter the amount: ");
            amount = sc.nextDouble();

            System.out.println("Enter the term: 1.Short Term, 3.Medium Term, 5.Long Term");
            term = sc.nextInt();

            // make sure input valid term
            while (term != 1 && term != 3 && term != 5) {
                System.out.println("Invalid mortgage term");
                System.out.println("Enter the term: 1.Short Term, 3.Medium Term, 5.Long Term");
                term = sc.nextInt();
            }

            // create object
            if (type == 1) {
                mortgage = new BusinessMortgage(mortgageNumber, mortgageName, amount, interestRate, term);
            }else{
                mortgage = new PersonalMortgage(mortgageNumber,mortgageName,amount,interestRate,term);
            }

            // assign the mortgage to array
            mortgages[i] = mortgage;
        }

        // display all mortgages
        for(Mortgage mortgage1 : mortgages) {
            System.out.println("--------------------------");
            mortgage1.getMortgageInfo();
        }

        sc.close();
    }
}
