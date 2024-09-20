package exercise2;

import javax.swing.*;

public class Runnable {
    public static void main(String[] args) {
        Lotto lotto = new Lotto();
        int userChoice;
        int count = 5;
        int sumOfLotto = 0;
        // calculate sum of lotto numbers
        for(int num: lotto.getRandomNumbers()){
            sumOfLotto += num;
        }

        // total 5 times
        while(count > 0){
            // prompt the user
            userChoice = Integer.parseInt(
                    JOptionPane.showInputDialog("Enter a number between 3 and 27: ")
            );

            // compare input with sum
            if (userChoice == sumOfLotto){
                JOptionPane.showMessageDialog(null, "You win!");
                break;
            } else {
                if (count == 1){
                    // already last try. So the user lose
                    JOptionPane.showMessageDialog(null, "You lose!");
                    break;
                }

                // count down and show message
                JOptionPane.showMessageDialog(null, "You have " + --count + " times to try.", "Wrong", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
