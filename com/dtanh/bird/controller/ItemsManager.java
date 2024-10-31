package com.dtanh.bird.controller;

import com.dtanh.bird.model.*;
import com.dtanh.bird.ui.GUI;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by doant on 4/3/2017.
 */
public class ItemsManager {
    public static int count;

    private ArrayList<Item> listItem;
    private int itemNumber;
    private Bird bird;
    private int delayOrange;
    private int delayStaw;
    private int delayBomb;
    private int score;

    public ItemsManager() {
        bird = new Bird(Images.getImage(Images.ID_BIRD_RIGHT), 300, GUI.HEIGHT - 50, 50, 2);
        delayBomb = 5;
        delayOrange = 4;
        delayStaw = 4;
        count = 0;
        itemNumber = 15;
        initItem();
    }

    public Bird getBird() {
        return bird;
    }

    public ArrayList<Item> getListItem() {
        return listItem;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private void initItem() {
        listItem = new ArrayList<>();
        Random rd = new Random();
        int sizeItem = 40;
        for (int i = 0; i < 15; i++) {
            Item item;
            int x = rd.nextInt(GUI.WIDTH - sizeItem);
            int a = rd.nextInt(3);
            switch (a) {
                case 0:
                    item = new Bomb(Images.getImage(Images.ID_BOMB), x, -(i * sizeItem), sizeItem, delayBomb);
                    listItem.add(item);
                    break;
                case 1:
                    item = new Orange(Images.getImage(Images.ID_ORANGE), x, -(i * sizeItem), sizeItem, delayOrange);
                    listItem.add(item);
                    break;
                case 2:
                    item = new Stawberry(Images.getImage(Images.ID_STAWBERRY), x, -(i * sizeItem), sizeItem, delayStaw);
                    listItem.add(item);
                    break;
            }
        }
    }

    public void drawAll(Graphics2D g2d) {
        bird.draw(g2d);

        for (int i = 0; i < listItem.size(); i++) {
            listItem.get(i).draw(g2d);
        }
    }

    public void move(int count) {
        if (count >= Integer.MAX_VALUE) {
            count = 0;
        }

        bird.move(count, this);

        for (int i = 0; i < listItem.size(); i++) {
            listItem.get(i).move(count);
            if (listItem.get(i).getY() >= GUI.HEIGHT) {
                removeItem(i);
            }
        }

        if(score > 150) {
            delayStaw = 1;
            delayOrange = 1;
            delayBomb = 1;
            for(int i = 0; i < listItem.size(); i++) {
                if(listItem.get(i) instanceof Bomb) {
                    listItem.get(i).setDelay(delayBomb);
                } else if(listItem.get(i) instanceof Stawberry) {
                    listItem.get(i).setDelay(delayStaw);
                } else {
                    listItem.get(i).setDelay(delayOrange);
                }
            }
        } else if(score > 100) {
            delayStaw = 3;
            delayOrange = 2;
            delayBomb = 2;
            for(int i = 0; i < listItem.size(); i++) {
                if(listItem.get(i) instanceof Bomb) {
                    listItem.get(i).setDelay(delayBomb);
                } else if(listItem.get(i) instanceof Stawberry) {
                    listItem.get(i).setDelay(delayStaw);
                } else {
                    listItem.get(i).setDelay(delayOrange);
                }
            }
        } else if(score > 50) {
            delayStaw = 4;
            delayOrange = 3;
            delayBomb = 3;
            for(int i = 0; i < listItem.size(); i++) {
                if(listItem.get(i) instanceof Bomb) {
                    listItem.get(i).setDelay(delayBomb);
                } else if(listItem.get(i) instanceof Stawberry) {
                    listItem.get(i).setDelay(delayStaw);
                } else {
                    listItem.get(i).setDelay(delayOrange);
                }
            }
        }
    }

    public void removeItem(int i) {
        listItem.remove(i);
        Random rd = new Random();
        Item item;
        int sizeItem = 40;
        int x = rd.nextInt(GUI.WIDTH - sizeItem);
        int a = rd.nextInt(3);
        switch (a) {
            case 0:
                item = new Bomb(Images.getImage(Images.ID_BOMB), x, -(i * sizeItem), sizeItem, delayBomb);
                listItem.add(item);
                break;
            case 1:
                item = new Orange(Images.getImage(Images.ID_ORANGE), x, -(i * sizeItem), sizeItem, delayOrange);
                listItem.add(item);
                break;
            case 2:
                item = new Stawberry(Images.getImage(Images.ID_STAWBERRY), x, -(i * sizeItem), sizeItem, delayStaw);
                listItem.add(item);
                break;
        }
    }

    public boolean isOver() {
        return bird.isDead();
    }
}
