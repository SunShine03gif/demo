package com.dtanh.bird.model;

import javax.swing.*;
import java.awt.*;

/**
 * Created by doant on 4/3/2017.
 */
public class Images {
    public static final int ID_BIRD_LEFT = 0;
    public static final int ID_BIRD_RIGHT = 1;
    public static final int ID_BOMB = 2;
    public static final int ID_ORANGE = 3;
    public static final int ID_STAWBERRY = 4;
    public static final int ID_BACKGROUND = 5;

    private static final Image BIRD_LEFT = new ImageIcon(Image.class.getResource("/rec/bird_left.png")).getImage();
    private static final Image BIRD_RIGHT = new ImageIcon(Image.class.getResource("/rec/bird_right.png")).getImage();
    private static final Image BOMB = new ImageIcon(Image.class.getResource("/rec/bomb.png")).getImage();
    private static final Image ORANGE = new ImageIcon(Image.class.getResource("/rec/orange.png")).getImage();
    private static final Image STRAWBERRY = new ImageIcon(Image.class.getResource("/rec/strawberry.png")).getImage();
    private static final Image BACKGROUND = new ImageIcon(Image.class.getResource("/rec/bg.png")).getImage();

    public static Image getImage(int id) {
        switch (id) {
            case ID_BIRD_LEFT:
                return BIRD_LEFT;
            case ID_BIRD_RIGHT:
                return BIRD_RIGHT;
            case ID_BOMB:
                return BOMB;
            case ID_ORANGE:
                return ORANGE;
            case ID_STAWBERRY:
                return STRAWBERRY;
            case ID_BACKGROUND:
                return BACKGROUND;
            default:
                return null;
        }
    }
}
