package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;

public class DamageBoost extends DynamicSpriteEntity implements Collided, PowerUp {
    public static final int WIDTH = 50;
    public static final int HEIGHT = 50;
    int damage = 0;
    public DamageBoost(Coordinate2D initialLocation) {
        super("sprites/boost.png", initialLocation, new Size(WIDTH, HEIGHT));
        setBoost(2);
    }

    @Override
    public void onCollision(Collider collidingObject) {
        boolean checkBoolean = false;
        var explosion = new SoundClip("audio/explosion3.mp3");
        if (collidingObject instanceof Bullet bullet) {
            checkBoolean = bullet.getIsPlayerBullet();
            if (checkBoolean) {
                explosion.play();
                bullet.remove();
                remove();
            }
        }
    }

    @Override
    public void setBoost(int boost) {
        damage = boost;
    }

    public int getBoost(){
        return damage;
    }
}
