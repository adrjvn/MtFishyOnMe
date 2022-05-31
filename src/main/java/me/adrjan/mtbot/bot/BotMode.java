package me.adrjan.mtbot.bot;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BotMode {

    ALUNE(150, 100),
    PANGEA(67, 67);

    int width, height;
}