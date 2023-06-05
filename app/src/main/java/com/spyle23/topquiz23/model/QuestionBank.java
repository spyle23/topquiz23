package com.spyle23.topquiz23.model;

import java.util.Collections;
import java.util.List;

public class QuestionBank {
    private List<Question> listQuestion;

    private int nextQuestionIndex;

    public QuestionBank( List<Question> listQuestion ){
        this.listQuestion = listQuestion;
        Collections.shuffle(this.listQuestion);
    }

    public Question getCurrentQuestion(){
        return this.listQuestion.get(this.nextQuestionIndex);
    }

    public Question getNextQuestion(){
        this.nextQuestionIndex++;
        return getCurrentQuestion();
    }
}
