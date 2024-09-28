package exercise1;

import java.util.Random;
import javax.swing.JOptionPane;

public class Test {
    // to store all the questions
    private Question[] questions;

    // to store results
    private int correctAnswers = 0;
    private int wrongAnswers = 0;

    // all responses for correct answer
    private String[] correctResponse = {
            "Excellent!" , "Good!", "Keep up the good work!", "Nice work!"
    };

    // all responses for incorrectResponse answer
    private String[] incorrectResponse = {
            "No. Please try again", "Wrong. Try once more", "Don't give up", "No. Keep trying.."
    };

    private Random randomObject = new Random();

    public Test(){
        // add questions to the Array
        this.questions = new Question[5];
        this.questions[0] = new Question("Converting an argument’s value, if possible, to the type that the method expects to receive in its corresponding parameter is called ____________________",new String[] {"argument truncation","type casting","argument conversion","argument promotion"},3);
        this.questions[1] = new Question("Which of the following processes is typically used by JVM to execute bytecode?", new String[] {"A combination of interpretation and just-in-time (JIT) compilation", "Interpretation", "Just-in-time (JIT) compilation", "Regular time compilation only"}, 0);
        this.questions[2] = new Question("Which one of the following symbols indicates a single line comment in Java application source code?", new String[] {"//", "\\\\", "##", "#!"}, 0);
        this.questions[3] = new Question("Which of the following components does a Java application need to have at least one of?", new String[] {"Instance variable", "Local variable", "Class", "Non-static Method"}, 2);
        this.questions[4] = new Question("Class variables must be declared as___________.", new String[]{"final","static","const","var"},1);
    }

    public int simulateQuestion(int questionIndex){
        // display popup and return user choice
        return JOptionPane.showOptionDialog(
                null,
                this.questions[questionIndex].getQuestion(),
                "Question",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                this.questions[questionIndex].getOptions(),
                null
        );
    }

    public boolean checkAnswer(int questionIndex, int choice){
        // input user choice to compare with the answer in Question
        return choice == this.questions[questionIndex].getAnswerIndex();
    }

    public String generateMessage(boolean correct){
        if(correct){
            // generate random message for correct answer
            return correctResponse[randomObject.nextInt(4)];
        }else{
            // generate random message for incorrect answer
            return incorrectResponse[randomObject.nextInt(4)];
        }
    }

    public void inputAnswer(){
        // to store user's choice and display message
        int choice;
        String message;
        float percentage;

        for(int i=0; i<questions.length; i++){
            choice = simulateQuestion(i);

            if(checkAnswer(i,choice)){
                // if answer is correct
                message = generateMessage(true);
                JOptionPane.showMessageDialog(null,  message, "Correct",
                        JOptionPane.INFORMATION_MESSAGE);
                correctAnswers++;
            }else{
                // wrong answer
                message = generateMessage(false);
                JOptionPane.showMessageDialog(null,  message, "Incorrect",
                        JOptionPane.INFORMATION_MESSAGE);
                wrongAnswers++;
            }
        }

        // final message for user
        percentage = (float)correctAnswers/ ((float)wrongAnswers + (float)correctAnswers);
        message = "Correct answers: " + correctAnswers + ", Wrong answers: " + wrongAnswers + ". The percentage of correct answers: " + percentage * 100 + "%" ;

        // show the message
        JOptionPane.showMessageDialog(null,  message, "Result",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
