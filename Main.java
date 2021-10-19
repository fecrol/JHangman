package com.hangman;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        final int WIDTH = 800;
        final int HEIGHT = 600;
        final String TITLE = "Hangman (Java Edition)";
        final ImageIcon backgroundImg = new ImageIcon("img\\start_screen_bg.gif");



        JFrame screen = new JFrame();
        CardLayout cardLayout = new CardLayout();
        screen.setSize(new Dimension(WIDTH, HEIGHT));
        screen.setTitle(TITLE);
        screen.setLocationRelativeTo(null);
        screen.setResizable(false);
        screen.setDefaultCloseOperation(screen.EXIT_ON_CLOSE);

        JPanel container = new JPanel();
        container.setLayout(cardLayout);
        screen.add(container);

        Words words = new Words();

        StartScreenPanel startScreenPanel = new StartScreenPanel(WIDTH, HEIGHT, backgroundImg, container, cardLayout);
        MainGamePanel mainGamePanel = new MainGamePanel(WIDTH, HEIGHT, container, cardLayout, words);
        CategoryScreenPanel categoryScreenPanel = new CategoryScreenPanel(WIDTH, HEIGHT, backgroundImg, container, cardLayout, mainGamePanel, words);

        container.add(startScreenPanel, "1");
        container.add(categoryScreenPanel, "2");
        container.add(mainGamePanel, "3");

        screen.setVisible(true);
    }
}
