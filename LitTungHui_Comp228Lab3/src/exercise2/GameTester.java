package exercise2;

public abstract class GameTester {
    // 2 instance variables
    private String name;
    protected boolean isFullTime;

    // constructor
    public GameTester(String name) {
        this.name = name;
    }

    // 2 getters
    public String getName() {
        return name;
    }
    public boolean getIsFullTime() {
        return isFullTime;
    }

    // 1 abstract method
    abstract double calculateSalary();

    // override toString which used in subclass
    @Override
    public String toString() {
        String result = "Name: " + getName() + "\n";
        result += getIsFullTime() ? "Status: Full time" : "Status: Part time";
        result += "\nSalary: $" + calculateSalary();
        return result;
    }
}
