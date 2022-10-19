package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.scenes.DynamicScene;

public class GameScene extends DynamicScene {
    @Override
    public void setupScene() {
        setBackgroundAudio("audio/gameMusic.mp3");
        setBackgroundImage("backgrounds/background1.gif");
    }

    @Override
    public void setupEntities() {

    }
}
