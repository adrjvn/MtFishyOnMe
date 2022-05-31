package me.adrjan.mtbot.captcha;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.adrjan.mtbot.bot.BotFrame;
import me.adrjan.mtbot.bot.BotRobot;

@Getter
@AllArgsConstructor
public abstract class DetectorWrapper implements Detector {

    private final BotFrame frame;
    private final BotRobot robot;
}