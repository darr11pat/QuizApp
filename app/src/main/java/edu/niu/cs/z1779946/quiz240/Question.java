package edu.niu.cs.z1779946.quiz240;

/**
 * Created by DARSHAN on 4/30/2017.
 */

public class Question {
    private int id, quizNo;
    private String question, options, answer;

    public Question(int id, int quizNo, String question, String options, String answer) {
        this.id = id;
        this.quizNo = quizNo;
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuizNo() {
        return quizNo;
    }

    public void setQuizNo(int quizNo) {
        this.quizNo = quizNo;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
