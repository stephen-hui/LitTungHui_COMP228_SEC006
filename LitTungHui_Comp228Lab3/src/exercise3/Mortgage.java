package exercise3;

public abstract class Mortgage implements MortgageConstants {
    // basic information
    protected String mortgageNumber;
    protected String mortgageName;
    protected double amount;
    protected double interestRate;
    protected int term;

    public Mortgage(String mortgageNumber, String mortgageName, double amount, double interestRate, int term) {
        // assign variables
        this.mortgageNumber = mortgageNumber;
        this.mortgageName = mortgageName;
        this.interestRate = interestRate;

        // if amount higher than maximum, assign maximum
        if (amount > MAXIMUM_MORTGAGE_AMOUNT){
            this.amount = MAXIMUM_MORTGAGE_AMOUNT;
        }else{
            this.amount = amount;
        }

        // if term is not in these 3, assign short term
        if(term != SHORT_TERM && term != MEDIUM_TERM && term != LONG_TERM){
            this.term = SHORT_TERM;
        }else{
            this.term = term;
        }
    }

    // calculate total amount with interest rate and years
    public double getTotalAmount(){
        return amount + amount * interestRate / 100 * term;
    }

    // display information
    public void getMortgageInfo(){
        System.out.println("Mortgage Number: " + mortgageNumber + "\nMortgage Name: " + mortgageName + "\nInterest Rate: " + interestRate + "%\nTerm: " + term + "Amount: $" + amount + "\nTotal Amount owned: $" + getTotalAmount());
    }
}
