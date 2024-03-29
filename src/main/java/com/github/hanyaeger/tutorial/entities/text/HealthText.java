package com.github.hanyaeger.tutorial.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class HealthText extends TextEntity {

    private final int FONT_SIZE = 20;

    public HealthText(Coordinate2D initialLocation) {
        super(initialLocation);

        setFont(Font.font("Arial", FontWeight.NORMAL, FONT_SIZE));
        setFill(Color.WHITE);
    }

    public void setHealth(int health) {
        setText("Health: " + health);
    }
}
