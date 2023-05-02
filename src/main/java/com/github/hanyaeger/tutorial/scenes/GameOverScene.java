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

public class GameOverScene extends StaticScene {
    final int XPOSITIE = 100;
    final int YPOSITIE = 100;
    private WorldDestroyers worldDestroyers;

    public GameOverScene(WorldDestroyers worldDestroyers) {
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
                "Sadly you died. Try again later!"
        );
        endGame.setFill(Color.WHITE);
        endGame.setFont(Font.font("Roboto", FontWeight.BOLD, 30));
        endGame.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(endGame);
        var GoToHomeButton = new Button(
                new Coordinate2D(getWidth() / 2 - XPOSITIE, getHeight() / 2 + YPOSITIE), worldDestroyers, "Go to Home", 0
        );
        addEntity(GoToHomeButton);
    }
}
