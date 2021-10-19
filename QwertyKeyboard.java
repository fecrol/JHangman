package com.hangman;

import javax.swing.*;

public class QwertyKeyboard extends JButton {

    private char[] letters = {
            'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p',
            'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l',
            'z', 'x', 'c', 'v', 'b', 'n', 'm'
    };
    private QwertyButton[] buttons = new QwertyButton[26];

    public QwertyKeyboard() {

        for (int i=0; i<this.letters.length; i++) {
            this.buttons[i] = new QwertyButton(this.letters[i]);
        }
    }

    public void displayButtons(JPanel keyboardPanel) {

        for (QwertyButton button : this.buttons) {
            keyboardPanel.add(button);
        }
    }

    public void resetKeyboard() {

        for (QwertyButton button : this.buttons) {
            button.setEnabled(true);
            button.setBackground(null);
        }
    }

    public void disableKeyboard() {

        for (int i=0; i<this.buttons.length; i++) {
            this.buttons[i].setEnabled(false);
        }
    }

    public QwertyButton[] getButtons() {

        return this.buttons;
    }
}
