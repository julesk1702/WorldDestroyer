package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.tutorial.entities.text.ScoreText;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class Tank extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Collided {

    public Tank(Coordinate2D location) {
        super("sprites/tank.gif", location, new Size(80, 100), 1, 2);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.LEFT)) {
            setMotion(3, 270d);
            setCurrentFrameIndex(2);
        } else if (pressedKeys.contains(KeyCode.RIGHT)) {
            setMotion(3, 90d);
            setCurrentFrameIndex(1);
        } else if (pressedKeys.isEmpty()){
            setSpeed(0);
        }
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        if (border.equals(SceneBorder.LEFT)) {
            setSpeed(0);
            setCurrentFrameIndex(1);
        }
        if (border.equals(SceneBorder.RIGHT)) {
            setSpeed(0);
            setCurrentFrameIndex(2);

        }
    }

    public Coordinate2D getAnchorLocation(){
        return getLocationInScene();
    }

    @Override
    public void onCollision(Collider collidingObject) {
        //System.out.println("Collision");
    }
}
