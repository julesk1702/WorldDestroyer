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


public class GamePassedScene extends StaticScene {
    private final int SIZE = 30;
    private final int Y_POSITIE = 100;
    private final int X_POSITIE = 100;
    private WorldDestroyers worldDestroyers;
    public GamePassedScene(WorldDestroyers worldDestroyers) {
        this.worldDestroyers = worldDestroyers;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("gameFiles/titlescene.mp3");
        setBackgroundImage("backgrounds/background1.gif");
    }

    @Override
    public void setupEntities() {
        var endGame = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 2),
                "Congratulations! You have destroyed the invasion!"
        );
        endGame.setFill(Color.WHITE);
        endGame.setFont(Font.font("Roboto", FontWeight.BOLD, SIZE));
        endGame.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(endGame);
        var GoToHomeButton = new Button(
                new Coordinate2D(getWidth() / 2 - X_POSITIE, getHeight() / 2 + Y_POSITIE), worldDestroyers, "Go to Home", 0
        );
        addEntity(GoToHomeButton);
    }
}
