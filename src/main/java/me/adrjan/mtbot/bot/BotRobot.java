package me.adrjan.mtbot.bot;

import java.awt.*;
import java.awt.event.KeyEvent;

public class BotRobot extends Robot {

    public BotRobot() throws AWTException {
        super();
    }

    public void playReloadKeySequence() {
        pressKey(BotConstants.KEY_WORM);
        pressKey(KeyEvent.VK_SPACE);
    }

    public void playFishKeySequence(int j) {
        delay(50);
        for (int i = 0; i < j; i++) {
            pressKey(KeyEvent.VK_SPACE);
        }
    }

    private void pressKey(int key) {
        delay(25);
        keyPress(key);
        delay(25);
        keyRelease(key);
    }
}