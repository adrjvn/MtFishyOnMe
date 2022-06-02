package me.adrjan.mtbot.captcha;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.adrjan.mtbot.bot.BotFrame;
import me.adrjan.mtbot.bot.BotRobot;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Optional;

@Getter
@AllArgsConstructor
public abstract class DetectorWrapper implements Detector {

    private final BotFrame frame;
    private final BotRobot robot;


    public abstract Optional<BufferedImage> resolve(BufferedImage input);

    @Override
    public Optional<BufferedImage> isCaptcha() {
        Rectangle rectangle = new Rectangle(getFrame().getX(), getFrame().getY(), getFrame().getWidth(), getFrame().getHeight());
        BufferedImage bufferedImage = getRobot().createScreenCapture(rectangle);
        return this.resolve(bufferedImage);
    }
}