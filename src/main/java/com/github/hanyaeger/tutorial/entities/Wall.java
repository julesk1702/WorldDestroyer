package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.tutorial.WorldDestroyers;

public class Wall extends DynamicSpriteEntity implements Collided {
    private WorldDestroyers worldDestroyers;

    private int health = 4;

    boolean checkBoolean = false;

    public Wall(Coordinate2D location) {

        super("sprites/walls.png", location, new Size(100, 120));

    }

    @Override
    public void onCollision(Collider collidingObject) {
        if (collidingObject instanceof Bullet bullet) {
            health = health - 1;
            bullet.remove();
            if (health <= 0) {
               remove();
            }
        }
    }
}
