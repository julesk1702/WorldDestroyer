package com.github.hanyaeger.tutorial.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ScoreText extends TextEntity {
    public ScoreText(Coordinate2D initialLocation) {
        super(initialLocation);

        setFont(Font.font("Arial", FontWeight.NORMAL, 20));
        setFill(Color.WHITE);
    }

    public void setScore(int score) {
        setText("Score: " + score);
    }
}
