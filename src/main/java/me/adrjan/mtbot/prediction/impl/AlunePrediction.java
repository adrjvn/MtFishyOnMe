package me.adrjan.mtbot.prediction.impl;

import lombok.SneakyThrows;
import me.adrjan.mtbot.prediction.Prediction;
import me.adrjan.mtbot.util.ImagePHash;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.stream.IntStream;

public class AlunePrediction implements Prediction {

    private final BufferedImage[] numbers;
    private final ImagePHash imagePHash;

    public AlunePrediction() {
        this.numbers = new BufferedImage[5];
        this.imagePHash = new ImagePHash();
        IntStream.range(1, 6).forEach(
                i -> {
                    try {
                        this.numbers[i - 1] = ImageIO.read(new FileInputStream("resources/alune/" + i + ".png"));
                    } catch (IOException ignore) {
                    }
                });
    }

    @SneakyThrows
    @Override
    public int predict(BufferedImage image) {
        double distance = 2137;
        int result = 1;
        for (int i = 0; i < this.numbers.length; i++) {
            double imagePHashDistance = this.imagePHash.distance(this.numbers[i], image);
            if (imagePHashDistance < distance) {
                distance = imagePHashDistance;
                result = i;
            }
        }
        return result + 1;
    }
}