package me.adrjan.mtbot.captcha;

import java.awt.image.BufferedImage;
import java.util.Optional;

public interface Detector {

    Optional<BufferedImage> isCaptcha();
}