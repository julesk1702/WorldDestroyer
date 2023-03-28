package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.YaegerGame;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.WorldDestroyers;

public class GameOverScene extends StaticScene {
    public GameOverScene(WorldDestroyers worldDestroyers) {

    }

    @Override
    public void setupScene() {
        setBackgroundAudio("gameFiles/titlescene.mp3");
        setBackgroundImage("backgrounds/background1.gif");
    }

    @Override
    public void setupEntities() {

    }
}
