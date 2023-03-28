package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;

import java.util.ArrayList;
import java.util.List;

public class AlienEnemy extends DynamicSpriteEntity implements Collided {

    private static List<AlienEnemy> aliens = new ArrayList<>();
    public AlienEnemy(Coordinate2D initialLocation) {
        super("sprites/alien.png", initialLocation, new Size(50, 60));
    }

    public static List<AlienEnemy> getAliens() {
        return aliens;
    }

    @Override
    public void onCollision(Collider collidingObject) {
        //System.out.println("Collision alien");
        var explosion = new SoundClip("audio/explosion2.mp3");
        explosion.play();
        remove();
    }
}
