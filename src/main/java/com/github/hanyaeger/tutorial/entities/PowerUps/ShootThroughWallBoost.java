package com.github.hanyaeger.tutorial.entities.PowerUps;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.tutorial.entities.Bullet;
import com.github.hanyaeger.tutorial.entities.Obstacles.Wall;

public class ShootThroughWallBoost extends DynamicSpriteEntity implements Collided, PowerUp {
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;
    private final int DURATION = 500;
    private boolean isPlayerBullet = false;

    public ShootThroughWallBoost(Coordinate2D initialLocation) {
        super("sprites/boost.png", initialLocation, new Size(WIDTH, HEIGHT));
    }

    @Override
    public void activate(Bullet bullet){
        if (bullet.getShootThroughWall()){
            for (Wall wall : Wall.getWalls()){
                wall.setShootThroughWall(true, DURATION);
            }
            bullet.setShootThroughWall(false);
        }
    }

    @Override
    public void onCollision(Collider collidingObject) {

        var explosion = new SoundClip("audio/explosion3.mp3");
        if (collidingObject instanceof Bullet bullet) {
            isPlayerBullet = bullet.getIsPlayerBullet();
            bullet.setShootThroughWall(true);
            if (isPlayerBullet) {
                explosion.play();
                bullet.remove();
                remove();
                activate(bullet);
            }
        }
    }
}
