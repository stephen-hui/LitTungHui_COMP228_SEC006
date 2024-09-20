package exercise3;

public class Runnable {
    public static void main(String[] args) {
        // get 2 integers and return an integer
        System.out.printf("Integer 2 * 4 = %d %n",MyMath.multiply(2,4));

        // get 2 String and return an integer
        System.out.printf("String 4 * 5 = %d %n",MyMath.multiply("4","5"));

        // get 3 integers and return an integer
        System.out.printf("Integer 2 * 3 * 4 = %d %n",MyMath.multiply(2,3,4));

        // get 3 String and return an integer
        System.out.printf("String 5 * 6 * 7 = %d %n",MyMath.multiply("5","6","7"));
    }
}
