package me.adrjan.mtbot.captcha;

import lombok.RequiredArgsConstructor;
import me.adrjan.mtbot.bot.BotConstants;
import me.adrjan.mtbot.bot.BotRobot;
import me.adrjan.mtbot.prediction.Prediction;

import java.awt.image.BufferedImage;
import java.util.Optional;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
public class DetectionRunnable implements Runnable {

    private final Detector detector;
    private final BotRobot robot;
    private final Prediction prediction;
    private final ScheduledExecutorService executor;

    private ScheduledFuture<?> reloadSequence = null;

    @Override
    public void run() {
        Optional<BufferedImage> image = detector.isCaptcha();
        if (image.isEmpty()) return;
        if (reloadSequence == null || reloadSequence.isDone()) {
            robot.playFishKeySequence(prediction.predict(image.get()));
            reloadSequence = executor.schedule(robot::playReloadKeySequence, BotConstants.WORM_RELOAD, TimeUnit.MILLISECONDS);
        }
    }
}