package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.tutorial.WorldDestroyers;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class Exit extends DynamicSpriteEntity implements Collider {

    public Exit(Coordinate2D location) {
        super("sprites/exit.png", location, new Size(30, 200));
    }

    public Coordinate2D getAnchorLocation(){
        return getLocationInScene();
    }
}
