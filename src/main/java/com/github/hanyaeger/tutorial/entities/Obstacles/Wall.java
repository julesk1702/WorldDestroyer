package com.github.hanyaeger.tutorial.entities.Obstacles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.tutorial.WorldDestroyers;
import com.github.hanyaeger.tutorial.entities.Bullet;

import java.util.ArrayList;
import java.util.List;

public class Wall extends DynamicSpriteEntity implements Collided, UpdateExposer {
    private int health = 4;
    private int remainingTime = 0;
    boolean shootThroughWalls = false;
    private static List<Wall> walls = new ArrayList<>();

    public Wall(Coordinate2D location) {
        super("sprites/walls.png", location, new Size(100, 120));
        walls.add(this);
    }

    @Override
    public void onCollision(Collider collidingObject) {
        if (collidingObject instanceof Bullet bullet) {
            if (bullet.getIsPlayerBullet() && isShootThroughWallActive()) {
                System.out.println("Shoot through wall");
            } else {
                System.out.println(bullet.getShootThroughWall());
                health = health - 1;
                bullet.remove();
                if (health <= 0) {
                    remove();
                }
            }
        }
    }

    public static List<Wall> getWalls() {
        return walls;
    }

    public void setShootThroughWall(boolean shootThroughWall, int durationInMs) {
        shootThroughWalls = shootThroughWall;
        remainingTime = durationInMs;
    }

    public boolean isShootThroughWallActive() {
        return shootThroughWalls && remainingTime > 0;
    }

    @Override
    public void explicitUpdate(long l) {
        if (remainingTime > 0) {
            remainingTime--;
            System.out.println(remainingTime);
        }
    }
}

