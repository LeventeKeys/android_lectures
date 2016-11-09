package com.somniatores.lesson6;

/**
 * Created by locisvv on 01.11.2016.
 */

public class Card {
    private String title;
    private String text;
    private String image;

    public String getTitle() {
        return title;
    }

    public Card setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getText() {
        return text;
    }

    public Card setText(String text) {
        this.text = text;
        return this;
    }

    public String getImage() {
        return image;
    }

    public Card setImage(String image) {
        this.image = image;
        return this;
    }
}
