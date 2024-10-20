package exercise1;

public class Life extends Insurance {
    // override 2 abstract methods
    @Override
    void setInsuranceCost(double cost) {
        this.monthlyCost = cost;
    }

    @Override
    void displayInfo() {
        System.out.printf("Type: %s%n",this.getType());
        System.out.printf("Monthly Cost: $%.2f%n",this.getMonthlyCost());
    }

    // constructor and assign type
    Life(){
        this.type = "Life";
    }
}
