package com.github.hanyaeger.tutorial.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import com.github.hanyaeger.tutorial.WorldDestroyers;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Button extends TextEntity implements MouseEnterListener, MouseExitListener, MouseButtonPressedListener {
    public final int SIZE = 20;
    private final WorldDestroyers worldDestroyers;
    private final int sceneID;

    public Button(Coordinate2D initialLocation, WorldDestroyers worldDestroyers, String text, int sceneID) {
        super(initialLocation, text);
        setFill(Color.WHITE);
        setFont(Font.font("Roboto", FontWeight.BOLD, SIZE));
        this.worldDestroyers = worldDestroyers;
        this.sceneID = sceneID;
    }

    @Override
    public void onMouseEntered() {
        setFill(Color.LIGHTGRAY);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setFill(Color.WHITE);
        setCursor(Cursor.DEFAULT);
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        worldDestroyers.setActiveScene(sceneID);
    }
}
