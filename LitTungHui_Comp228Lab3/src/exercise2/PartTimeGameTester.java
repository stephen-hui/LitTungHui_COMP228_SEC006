package exercise2;

public class PartTimeGameTester extends GameTester {
    // working hours variable only for part-time
    private double workingHours;

    // constructor with extra working hours parameter
    public PartTimeGameTester(String name, double workingHours) {
        super(name);
        this.isFullTime = false;
        this.workingHours = workingHours;
    }

    // override abstract method
    @Override
    public double calculateSalary(){
        return workingHours * 20;
    }
}
