package exercise1;

public class Question {
    private String question;
    private String[] options;
    private int answerIndex;

    public Question(String question, String[] options, int answerIndex) {
        this.question = question;
        this.options = options;
        this.answerIndex = answerIndex;
    }
    public String getQuestion() {
        return this.question;
    }

    public String[] getOptions() {
        return this.options;
    }

    public int getAnswerIndex() {
        return this.answerIndex;
    }
}

