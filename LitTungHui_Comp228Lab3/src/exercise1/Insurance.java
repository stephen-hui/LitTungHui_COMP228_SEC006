package exercise1;

public abstract class Insurance {
    // 2 instance variables
    protected String type;
    protected double monthlyCost;

    // 2 methods
    String getType() {
        return type;
    };
    double getMonthlyCost() {
        return monthlyCost;
    }

    // 2 abstract methods
    // needs 1 param to calculate cost
    abstract void setInsuranceCost(double cost);
    abstract void displayInfo();
}
