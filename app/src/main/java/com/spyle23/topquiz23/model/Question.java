package com.spyle23.topquiz23.model;

import java.util.List;

public class Question {
    private final String question;
    private final List<String> choiceList;
    private final int answerIndex;

    public Question(String question, List<String> choiceList, int answerIndex) {
        this.choiceList = choiceList;
        this.question = question;
        this.answerIndex = answerIndex;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getChoiceList() {
        return choiceList;
    }

    public int getAnswerIndex() {
        return answerIndex;
    }
}
