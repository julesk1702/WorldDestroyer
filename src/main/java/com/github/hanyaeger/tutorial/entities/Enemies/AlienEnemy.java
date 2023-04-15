package com.github.hanyaeger.tutorial.entities.Enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.tutorial.WorldDestroyers;
import com.github.hanyaeger.tutorial.entities.Bullet;

import java.util.ArrayList;
import java.util.List;

public class AlienEnemy extends Enemy implements Collided {

    public static final int ID = 2;
    public static final int DEAD = 0;
    public static final int WIDTH = 50;
    public static final int HEIGHT = 60;
    private static List<AlienEnemy> aliens = new ArrayList<>();

    private WorldDestroyers worldDestroyers;

    private int health = 2;

    public AlienEnemy(Coordinate2D initialLocation, WorldDestroyers worldDestroyers) {
        super("sprites/alien.png", initialLocation, new Size(WIDTH, HEIGHT));
        aliens.add(this);
        this.worldDestroyers = worldDestroyers;
    }

    public static List<AlienEnemy> getAliens() {
        return aliens;
    }

    @Override
    public void onCollision(Collider collidingObject) {
        boolean checkBoolean = false;
        //System.out.println("Collision alien");
        var explosion = new SoundClip("audio/explosion2.mp3");
        if (collidingObject instanceof Bullet bullet) {
            checkBoolean = bullet.getIsPlayerBullet();

            if (checkBoolean) {
                health--;
                explosion.play();
                bullet.remove();
                if (health == DEAD) {
                    explosion.play();
                    remove();
                    bullet.remove();
                    aliens.remove(this);
                    goToGameOverScene();
                }
            }
        }
    }

    public Coordinate2D getAnchorLocation(){
        return getLocationInScene();
    }

    public void goToGameOverScene() {
        if (AlienEnemy.getAliens().isEmpty() && StrongEnemy.getAliens().isEmpty()) {
            worldDestroyers.setActiveScene(3);
        }
    }

    public void setHealth(int health) {
        this.health = health;
    }
}

