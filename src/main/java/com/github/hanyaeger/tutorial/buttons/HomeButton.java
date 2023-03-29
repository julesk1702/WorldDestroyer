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

public class HomeButton extends TextEntity implements MouseEnterListener, MouseExitListener, MouseButtonPressedListener {

    public static final int SIZE = 30;
    public static final int ID = 0;
    private WorldDestroyers worldDestroyers;


    public HomeButton(Coordinate2D initialLocation, WorldDestroyers worldDestroyers) {
        super(initialLocation, "Go to Home");
        setFill(Color.WHITE);
        setFont(Font.font("Roboto", FontWeight.BOLD, SIZE));

        this.worldDestroyers = worldDestroyers;
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
        worldDestroyers.setActiveScene(ID);
    }
}
