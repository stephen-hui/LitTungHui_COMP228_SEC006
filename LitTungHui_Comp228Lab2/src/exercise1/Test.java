package exercise1;

import java.util.Random;
import javax.swing.JOptionPane;

public class Test {
    // to store all the questions
    private Question[] questions;

    // the index question displaying
    private int questionIndex;

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

    public void simulateQuestion(){
        // generate random index within the questions
        questionIndex = randomObject.nextInt(questions.length);
    }

    public boolean checkAnswer(int choice){
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
        // init question
        simulateQuestion();

        // show dialog and get user input
        int choice = JOptionPane.showOptionDialog(
                null,
                this.questions[questionIndex].getQuestion(),
                "Question",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                this.questions[questionIndex].getOptions(),
                null
        );

        // check answer
        boolean result = this.checkAnswer(choice);

        String message = generateMessage(result);

        // show result
        JOptionPane.showMessageDialog(null,  message, result? "Correct" : "Incorrect",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
