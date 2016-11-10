package com.somniatores.lesson6.view.test;

import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.graphics.Color;

import com.somniatores.lesson6.BR;


/**
 * Created by locisvv on 09.11.2016.
 */

public class TestRowView extends BaseObservable {

    private Test test;
    private int color = Color.BLACK;

    public TestRowView(Test test) {
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

    public void checkAnswer(int answer) {
        String actual = test.getAnswers().get(answer);
        if (test.getExpectedAnswer().equals(actual)) {
            setColor(Color.parseColor("#64DD17"));
        } else {
            setColor(Color.parseColor("#D84315"));
        }
    }
}
