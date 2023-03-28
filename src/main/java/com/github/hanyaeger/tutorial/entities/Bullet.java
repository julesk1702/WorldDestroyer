package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Bullet extends DynamicSpriteEntity implements Collider {
    boolean keyPressed = false;
    private List<Bullet> bullets = new ArrayList<>();
    private boolean isPlayerBullet;

    public Bullet(String resource , Coordinate2D initialLocation, boolean isPlayerBullet) {
        super(resource, initialLocation, new Size(30, 30));
        var shootingSound = new SoundClip("audio/shooting.mp3");
        shootingSound.play();
        this.isPlayerBullet = isPlayerBullet;
        if (!isPlayerBullet) {
            setMotion(5, 0d);
        } else {
            setMotion(5, 180d);
        }
        bullets.add(this);

    }

    public boolean getIsPlayerBullet() {
        return isPlayerBullet;
    }


}
