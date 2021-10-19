package com.hangman;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {

    private String text;
    private int x;
    private int y;
    private int width;
    private int height;

    public Button(String text, int x, int y, int width, int height) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        this.setBounds(this.x, this.y, this.width, this.height);
        this.setText(this.text);
        this.setFocusable(false);
    }

    public Button(String text) {
        this.text = text;

        this.setText(this.text);
        this.setFocusable(false);
    }
}

class PlayButton extends Button {

    private JPanel container;
    private CardLayout cardLayout;

    public PlayButton(String text, int x, int y, int width, int height, JPanel container, CardLayout cardLayout) {
        super(text, x, y, width, height);
        this.container = container;
        this.cardLayout = cardLayout;
    }

    public void swapCard(String cardNum) {
        this.cardLayout.show(this.container, cardNum);
    }
}

class ExitButton extends Button {

    public ExitButton(String text, int x, int y, int width, int height) {
        super(text, x, y, width, height);
    }

}

class BackButton extends Button {

    private JPanel container;
    private CardLayout cardLayout;

    public BackButton(String text, int x, int y, int width, int height, JPanel container, CardLayout cardLayout) {
        super(text, x, y, width, height);
        this.container = container;
        this.cardLayout = cardLayout;
    }

    public BackButton(String text, JPanel container, CardLayout cardLayout) {
        super(text);
        this.container = container;
        this.cardLayout = cardLayout;
    }

    public void swapCard(String cardNum) {
        this.cardLayout.show(this.container, cardNum);
    }
}

class CategoryButton extends Button {

    private String category;
    private JPanel container;
    private CardLayout cardLayout;

    public CategoryButton(String text, JPanel container, CardLayout cardLayout) {
        super(text);
        this.container = container;
        this.cardLayout = cardLayout;
    }

    private void createListOfWords(Words words) {
        words.addWordsToListOfWords(this.getCategory());
    }

    public void swapCard(Words words, MainGamePanel mainGamePanel) {
        this.createListOfWords(words);
        Word word = words.selectRandomWord();
        word.splitWordToLetters();
        mainGamePanel.setRandomWord(word);
        mainGamePanel.setGuessedLetters(word);
        this.cardLayout.show(this.container, "3");
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

class NewButton extends Button {

    public NewButton(String text, int x, int y, int width, int height) {
        super(text, x, y, width, height);
    }
}
