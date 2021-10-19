package com.hangman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CategoryScreenPanel extends JPanel implements ActionListener {

    final String[] categoryButtonsText = {"Film", "Music", "Random"};
    private CategoryButton[] categoryButtons = new CategoryButton[3];
    private BackButton backButton;
    private MainGamePanel mainGamePanel;
    private Words words;

    public CategoryScreenPanel(int WIDTH, int HEIGHT, ImageIcon backgroundImg, JPanel container, CardLayout cardLayout, MainGamePanel mainGamePanel, Words words) {
        this.mainGamePanel = mainGamePanel;
        this.words = words;

        JLabel categoryScreenBg = new JLabel(backgroundImg);

        this.setLayout(new BorderLayout());
        this.add(categoryScreenBg);

        categoryScreenBg.setLayout(null);

        JPanel buttonsPanel = new JPanel();
        int buttonsPanelWidth = 500;
        int buttonsPanelHeight = 50;
        int buttonsPanelX = (WIDTH / 2) - (buttonsPanelWidth / 2);
        int buttonsPanelY = HEIGHT - (buttonsPanelHeight * 3);
        buttonsPanel.setBounds(buttonsPanelX, buttonsPanelY, buttonsPanelWidth, buttonsPanelHeight);
        buttonsPanel.setLayout(new GridLayout());

        categoryScreenBg.add(buttonsPanel);

        for (int i=0; i<this.categoryButtonsText.length; i++) {
            CategoryButton categoryButton = new CategoryButton(this.categoryButtonsText[i], container, cardLayout);
            categoryButton.setCategory(this.categoryButtonsText[i].toLowerCase());
            this.categoryButtons[i] = categoryButton;
            categoryButton.addActionListener(this);
            buttonsPanel.add(categoryButton);
        }

        String backButtonText = "BACK";
        this.backButton = new BackButton(backButtonText, container, cardLayout);
        this.backButton.addActionListener(this);
        buttonsPanel.add(this.backButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

         for (CategoryButton categoryButton : this.categoryButtons) {
             if (e.getSource() == categoryButton) {
                 categoryButton.swapCard(this.words, this.mainGamePanel);
             }
         }

         if (e.getSource() == this.backButton) {
             this.backButton.swapCard("1");
         }
    }
}
