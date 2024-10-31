package com.dtanh.bird.controller;

import com.dtanh.bird.ui.GamePanel;
import java.awt.event.KeyEvent;

/**
 * Created by doant on 4/3/2017.
 */
public class Controller {
    private GamePanel gamePanel;

    public Controller(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void keyPressed(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                if(!gamePanel.isRunning()) {
                    gamePanel.startGame();
                }
                gamePanel.getItemsManager().getBird().setSpeed(-1);
                break;
            case KeyEvent.VK_RIGHT:
                if(!gamePanel.isRunning()) {
                    gamePanel.startGame();
                }
                gamePanel.getItemsManager().getBird().setSpeed(1);
                break;
            case KeyEvent.VK_P:
                if(!gamePanel.isPause()) {
                    gamePanel.getThread().suspend();
                    gamePanel.setPause(true);
                } else {
                    gamePanel.getThread().resume();
                    gamePanel.setPause(false);
                }
                break;
        }
    }

    public void keyReleased(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                gamePanel.getItemsManager().getBird().setSpeed(0);
                break;
            case KeyEvent.VK_RIGHT:
                gamePanel.getItemsManager().getBird().setSpeed(0);
                break;
        }
    }
}
