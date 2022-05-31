package me.adrjan.mtbot;

import lombok.SneakyThrows;
import me.adrjan.mtbot.bot.BotConstants;
import me.adrjan.mtbot.bot.BotFrame;
import me.adrjan.mtbot.bot.BotRobot;
import me.adrjan.mtbot.captcha.DetectionRunnable;
import me.adrjan.mtbot.captcha.Detector;
import me.adrjan.mtbot.captcha.DetectorFactory;
import me.adrjan.mtbot.prediction.Prediction;
import me.adrjan.mtbot.prediction.PredictionFactory;

import javax.swing.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Bot {

    public static Bot INSTANCE;

    private final ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());

    private final BotFrame frame;
    private final BotRobot robot;
    private final Prediction prediction;
    private final Detector detecttor;

    @SneakyThrows
    public Bot() {
        INSTANCE = this;
        JFrame.setDefaultLookAndFeelDecorated(true);
        this.robot = new BotRobot();
        this.frame = new BotFrame(BotConstants.MODE);
        this.prediction = new PredictionFactory().get(BotConstants.MODE);
        this.detecttor = new DetectorFactory(this.robot, this.frame).get(BotConstants.MODE);
        this.scheduledExecutor.scheduleAtFixedRate(new DetectionRunnable(this.detecttor, this.robot, this.prediction, this.scheduledExecutor), 300, 300, TimeUnit.MILLISECONDS);
    }
}