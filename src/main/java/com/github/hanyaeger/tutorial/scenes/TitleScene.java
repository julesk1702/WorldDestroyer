package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.WorldDestroyers;
import com.github.hanyaeger.tutorial.buttons.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TitleScene extends StaticScene {

    private final WorldDestroyers worldDestroyers;

    public TitleScene(WorldDestroyers worldDestroyers){
        this.worldDestroyers = worldDestroyers;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("gameFiles/titlescene.mp3");
        setBackgroundImage("backgrounds/background1.gif");
    }

    @Override
    public void setupEntities() {
        var worldDestroyerTitle = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 2),
                "World Destroyers"
        );
        worldDestroyerTitle.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        worldDestroyerTitle.setFill(Color.WHITE);
        worldDestroyerTitle.setFont(Font.font("Roboto", FontWeight.BOLD, 60));
        addEntity(worldDestroyerTitle);

        int yPositionButton = 50;
        int xPositionButton = 30;
        var startButton = new Button(
                new Coordinate2D(getWidth() / 2 - xPositionButton, getHeight() / 2 + yPositionButton), worldDestroyers, "Start Game", 1
        );
        addEntity(startButton);
    }
}
