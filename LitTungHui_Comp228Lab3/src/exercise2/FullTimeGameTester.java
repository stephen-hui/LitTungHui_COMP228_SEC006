package exercise2;

public class FullTimeGameTester extends GameTester {
    // constructor
    FullTimeGameTester(String name) {
        super(name);
        this.isFullTime = true;
    }

    // override abstract method
    @Override
    public double calculateSalary() {
        return 3000;
    }

}
