package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class Bullet extends DynamicSpriteEntity implements Collider {
    boolean keyPressed = false;
    public Bullet(Coordinate2D initialLocation) {
        super("sprites/bullet.png", initialLocation, new Size(30, 30));
        setMotion(5, 180d);
        var shootingSound = new SoundClip("audio/shooting.mp3");
        shootingSound.play();

    }
}
