package com.somniatores.lesson6.view.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by locisvv on 08.11.2016.
 */

public class Test {
    private List<String> answers = new ArrayList<>();
    private String expectedAnswer;
    private String actualWord;

    public Test(String actualWord, String expectedAnswer, List<String> answers) {
        this.answers = new ArrayList<>(new HashSet<>(answers));
        this.expectedAnswer = expectedAnswer;
        this.actualWord = actualWord;

        this.answers.add(expectedAnswer);

        if (answers.size() > 4) {
            throw new IllegalArgumentException("Too much answers");
        }
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public String getExpectedAnswer() {
        return expectedAnswer;
    }

    public void setExpectedAnswer(String expectedAnswer) {
        this.expectedAnswer = expectedAnswer;
    }

    public String getActualWord() {
        return actualWord;
    }

    public void setActualWord(String actualWord) {
        this.actualWord = actualWord;
    }
}
