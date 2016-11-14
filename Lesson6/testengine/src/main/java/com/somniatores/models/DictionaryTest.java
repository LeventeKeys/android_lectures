package com.somniatores.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by locisvv on 08.11.2016.
 */
public class DictionaryTest implements Test<String> {
    private String translationWord;
    private String answer;
    private List<String> possibleAnswers = new ArrayList<>();

    public DictionaryTest(String translationWord, String answer, List<String> possibleAnswers) {
        this.translationWord = translationWord;
        this.answer = answer;
        this.possibleAnswers = possibleAnswers;
    }

    public List<String> getPossibleAnswers() {
        return possibleAnswers;
    }

    public void setPossibleAnswers(List<String> possibleAnswers) {
        this.possibleAnswers = possibleAnswers;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getTranslationWord() {
        return translationWord;
    }

    public void setTranslationWord(String translationWord) {
        this.translationWord = translationWord;
    }
}
