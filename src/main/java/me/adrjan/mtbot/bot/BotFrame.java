package me.adrjan.mtbot.bot;

import javax.swing.*;
import java.awt.*;

public class BotFrame extends JFrame {

    public BotFrame(BotMode botMode) {
        super("xd");
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(botMode.getWidth(), botMode.getHeight());
        setLocation(830, 300);
        setResizable(false);
        setVisible(true);
    }
}