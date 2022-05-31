package me.adrjan.mtbot.captcha;

import lombok.AllArgsConstructor;
import me.adrjan.mtbot.bot.BotFrame;
import me.adrjan.mtbot.bot.BotMode;
import me.adrjan.mtbot.bot.BotRobot;
import me.adrjan.mtbot.captcha.impl.AluneDetector;

@AllArgsConstructor
public class DetectorFactory {

    private final BotRobot botRobot;
    private final BotFrame botFrame;

    public Detector get(BotMode botMode) {
        Detector detector = null;
        switch (botMode) {
            case ALUNE -> detector = new AluneDetector(this.botFrame, this.botRobot);
        }
        return detector;
    }
}
