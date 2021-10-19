package com.hangman;

import javax.swing.*;

public class QwertyButton extends JButton {
    private char value;

    public QwertyButton(char value) {
        this.value = value;

        this.setFocusable(false);
        this.setText(String.valueOf(this.value).toUpperCase());
    }

    public char getValue() {
        return this.value;
    }
}
