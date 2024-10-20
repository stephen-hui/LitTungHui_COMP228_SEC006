package exercise3;

public class PersonalMortgage extends Mortgage {
    public PersonalMortgage(String mortgageNumber, String mortgageName, double amount, double interestRate, int term) {
        super(mortgageNumber, mortgageName, amount, interestRate + 2.0, term);
    }
}
