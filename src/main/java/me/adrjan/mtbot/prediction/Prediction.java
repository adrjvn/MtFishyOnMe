package me.adrjan.mtbot.prediction;

import java.awt.image.BufferedImage;

public interface Prediction {

    int predict(BufferedImage bufferedImage);
}