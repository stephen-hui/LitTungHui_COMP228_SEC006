package exercise2;

import java.util.Random;

public class Lotto {
    private int[] randomNumbers;
    private Random rand;

    public Lotto() {
        this.randomNumbers = new int[3];
        for (int i = 0; i < this.randomNumbers.length; i++) {
            // nextInt range start from 0
            // add 1 to get the range from 1 to 9
            this.randomNumbers[i] = new Random().nextInt(9) + 1;
        }
    }

    // getter
    public int[] getRandomNumbers() {
        return this.randomNumbers;
    }
}
