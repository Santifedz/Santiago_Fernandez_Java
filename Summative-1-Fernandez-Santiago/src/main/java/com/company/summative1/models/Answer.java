package com.company.summative1.models;

import java.util.Objects;

public class Answer {
    private int id;
    private String question;
    private String answer;

    public Answer(){}

    public Answer(int id, String question, String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Answer otherAns = (Answer) other;
        return id == otherAns.id && Objects.equals(question, otherAns.question) && Objects.equals(answer, otherAns.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, answer);
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + this.id +
                ", question='" + this.question + '\'' +
                ", answer='" + this.answer + '\'' +
                '}';
    }

}



