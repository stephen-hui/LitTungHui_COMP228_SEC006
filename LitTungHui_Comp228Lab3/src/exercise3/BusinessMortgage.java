package exercise3;

public class BusinessMortgage extends Mortgage {
    public BusinessMortgage(String mortgageNumber, String mortgageName, double amount, double interestRate, int term) {
        super(mortgageNumber, mortgageName, amount, interestRate + 1.0, term);
    }
}
