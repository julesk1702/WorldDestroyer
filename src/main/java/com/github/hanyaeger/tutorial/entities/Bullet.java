package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.tutorial.entities.text.ScoreText;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Bullet extends DynamicSpriteEntity implements Collider {
    public static final int WIDTH = 30;
    public static final int HEIGHT = 30;
    public static final int SPEED = 5;
    public static final double DIRECTION_DOWN = 0d;
    public static final double DIRECTION_UP = 180d;
    boolean keyPressed = false;
    private List<Bullet> bullets = new ArrayList<>();
    private boolean isPlayerBullet;


    public Bullet(String resource , Coordinate2D initialLocation, boolean isPlayerBullet) {
        super(resource, initialLocation, new Size(WIDTH, HEIGHT));
        var shootingSound = new SoundClip("audio/shooting.mp3");
        shootingSound.play();
        this.isPlayerBullet = isPlayerBullet;
        if (!isPlayerBullet) {
            setMotion(SPEED, DIRECTION_DOWN);
        } else {
            setMotion(SPEED, DIRECTION_UP);
        }
        bullets.add(this);

    }

    public boolean getIsPlayerBullet() {
        return isPlayerBullet;
    }

}

