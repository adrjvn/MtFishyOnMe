package me.adrjan.mtbot.captcha.impl;

import me.adrjan.mtbot.bot.BotFrame;
import me.adrjan.mtbot.bot.BotRobot;
import me.adrjan.mtbot.captcha.DetectorWrapper;
import me.adrjan.mtbot.util.ColorUtil;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Optional;

public class AluneDetector extends DetectorWrapper {

    private final Color COLOR = new Color(23, 147, 140, 255);

    public AluneDetector(BotFrame frame, BotRobot robot) {
        super(frame, robot);
    }

    @Override
    public Optional<BufferedImage> resolve(BufferedImage bufferedImage) {
        int count = ColorUtil.countColor(bufferedImage, COLOR);
        return count > 30 ? Optional.of(bufferedImage) : Optional.empty();
    }
}