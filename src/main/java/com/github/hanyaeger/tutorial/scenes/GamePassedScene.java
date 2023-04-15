package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.WorldDestroyers;
import com.github.hanyaeger.tutorial.buttons.HomeButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GamePassedScene extends StaticScene {
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
        int xPositie = 100;
        int yPositie = 100;
        var endGame = new TextEntity(
                new Coordinate2D(5, 200),
                "Congratulations! You have destroyed the invasion!"
        );
        endGame.setFill(Color.WHITE);
        endGame.setFont(Font.font("Roboto", FontWeight.BOLD, 30));
        addEntity(endGame);
        var GoToHomeButton = new HomeButton(
                new Coordinate2D(getWidth() / 2 - xPositie, getHeight() / 2 + yPositie), worldDestroyers
        );
        addEntity(GoToHomeButton);
    }
}
