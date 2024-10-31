package com.dtanh.bird.model;

import com.dtanh.bird.controller.ItemsManager;
import com.dtanh.bird.ui.GUI;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by doant on 4/3/2017.
 */
public class Bird extends Item {
    public static final int DIR_LEFT = 0;
    public static final int DIR_RIGHT = 1;

    //private int direction;
    private boolean isDead;
    private int speed;

    public Bird(Image img, int x, int y, int size, int delay) {
        super(img, x, y, size, delay);
        this.img = Images.getImage(Images.ID_BIRD_RIGHT);
        //direction = DIR_RIGHT;
        isDead = false;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isDead() {
        return isDead;
    }

    public void move(int times, ItemsManager itemsManager) {
        if (times % delay == 0) {
            if (speed < 0) {
                x += speed;
                this.img = Images.getImage(Images.ID_BIRD_LEFT);
                if (x <= -size) {
                    x = GUI.WIDTH - 1;
                }
            } else if(speed > 0) {
                x += speed;
                this.img = Images.getImage(Images.ID_BIRD_RIGHT);
                if (x >= GUI.WIDTH) {
                    x = 1 - size;
                }
            }
        }

        Rectangle rect = new Rectangle(x, y, size, size);
        ArrayList<Item> items = itemsManager.getListItem();
        for (int i = 0; i < items.size(); i++) {
            Rectangle r = new Rectangle(items.get(i).getX(), items.get(i).getY(), items.get(i).getSize(), items.get(i).getSize());
            if (rect.intersects(r)) {
                if (items.get(i) instanceof Bomb) {
                    isDead = true;
                    return;
                } else if (items.get(i) instanceof Orange) {
                    itemsManager.setScore(itemsManager.getScore() + 5);
                    itemsManager.removeItem(i);
                } else {
                    itemsManager.setScore(itemsManager.getScore() + 3);
                    itemsManager.removeItem(i);
                }
            }
        }
    }
}
