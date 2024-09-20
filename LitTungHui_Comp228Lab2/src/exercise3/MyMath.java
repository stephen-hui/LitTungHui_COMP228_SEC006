package exercise3;

public class MyMath {
    // get 2 integers and return an integer
    public static int multiply(int a, int b) {
        return a * b;
    }

    // get 2 String and return an integer
    public static int multiply(String a, String b) {
        return Integer.parseInt(a) * Integer.parseInt(b);
    }

    // get 3 integers and return an integer
    public  static int multiply(int a, int b, int c) {
        return a * b * c;
    }

    // get 3 String and return an integer
    public static int multiply(String a, String b, String c) {
        return Integer.parseInt(a) * Integer.parseInt(b) * Integer.parseInt(c);
    }
}
