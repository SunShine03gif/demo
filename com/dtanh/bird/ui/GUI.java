package com.dtanh.bird.ui;

import com.dtanh.bird.model.Images;

import javax.swing.*;
import java.awt.*;

/**
 * Created by doant on 4/3/2017.
 */
public class GUI extends JFrame {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    private GamePanel gamePanel;

    public GUI() {
        init();
        initComponents();
    }

    private void init() {
        setTitle("Bird 1.0");
        setSize(WIDTH + 6, HEIGHT + 29);
        setResizable(false);
        setIconImage(Images.getImage(Images.ID_BIRD_RIGHT));
        setLocationRelativeTo(null);
        setLayout(new CardLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initComponents() {
        gamePanel = new GamePanel();
        add(gamePanel);
        addKeyListener(gamePanel);
    }
}
