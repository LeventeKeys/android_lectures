package com.somniatores.lesson6.views;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.graphics.Color;

import com.somniatores.lesson6.Application;
import com.somniatores.lesson6.BR;
import com.somniatores.models.DictionaryTest;
import com.somniatores.services.DictionaryTestService;

/**
 * Created by locisvv on 09.11.2016.
 */

public class DictionaryTestRowView extends BaseObservable {
    private static DictionaryTestService testService = Application.testService;

    private DictionaryTest test;
    private int color = Color.BLACK;

    public DictionaryTestRowView(DictionaryTest test) {
        this.test = test;
    }

    @Bindable
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        if (Color.BLACK != this.color) return;

        this.color = color;
        notifyPropertyChanged(BR.color);
    }

    public void checkAnswer(int actualAnswer) {
        if (testService.checkAnswer(test, test.getPossibleAnswers().get(actualAnswer))) {
            setColor(Color.parseColor("#64DD17"));
        } else {
            setColor(Color.parseColor("#D84315"));
        }
    }
}
