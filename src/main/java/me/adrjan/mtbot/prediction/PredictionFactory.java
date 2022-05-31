package me.adrjan.mtbot.prediction;

import me.adrjan.mtbot.bot.BotMode;
import me.adrjan.mtbot.prediction.impl.AlunePrediction;

public class PredictionFactory {

    public Prediction get(BotMode botMode) {
        Prediction prediction = null;
        switch (botMode) {
            case ALUNE -> prediction = new AlunePrediction();
        }
        return prediction;
    }
}