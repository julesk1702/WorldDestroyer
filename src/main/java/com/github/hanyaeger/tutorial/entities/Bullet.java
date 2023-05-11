package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;

import java.util.ArrayList;
import java.util.List;

public class Bullet extends DynamicSpriteEntity implements Collider {
    private static final int WIDTH = 30;
    private static final int HEIGHT = 30;
    private final int SPEED = 5;
    private final double DIRECTION_DOWN = 0d;
    private final double DIRECTION_UP = 180d;
    private List<Bullet> bullets = new ArrayList<>();
    private boolean isPlayerBullet;
    private boolean keyUnlocked;
    private boolean shootThroughWall;


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

    public void setKeyUnlocked(boolean keyUnlocked) {
        this.keyUnlocked = keyUnlocked;
    }

    public boolean getKeyUnlocked() {
        return keyUnlocked;
    }

    public void setShootThroughWall(boolean shootThroughWall) {
        this.shootThroughWall = shootThroughWall;
    }

    public boolean getShootThroughWall() {
        return shootThroughWall;
    }

}

