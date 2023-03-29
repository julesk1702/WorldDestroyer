package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.tutorial.WorldDestroyers;
import com.github.hanyaeger.tutorial.entities.text.ScoreText;

import java.util.ArrayList;
import java.util.List;

public class StrongEnemy extends Enemy implements Collided {
    public static final int WIDTH = 60;
    public static final int HEIGHT = 70;
    public static final int DEAD = 0;
    public static final int ID = 2;
    private int health;
    private WorldDestroyers worldDestroyers;

    private static List<StrongEnemy> alienList = new ArrayList<>();
    public StrongEnemy(Coordinate2D initialLocation, WorldDestroyers worldDestroyers) {
        super("sprites/notAlien.png", initialLocation, new Size(WIDTH, HEIGHT));
        alienList.add(this);
        this.worldDestroyers = worldDestroyers;
    }

    public static List<StrongEnemy> getAliens() {
        return alienList;
    }

    public void setHealth(int health) {
        this.health = health;
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
                    alienList.remove(this);
                    goToGameOverScene();
                }
            }
        }
    }

    public Coordinate2D getAnchorLocation(){
        return getLocationInScene();
    }

    public void goToGameOverScene() {
        if (StrongEnemy.getAliens().isEmpty() && AlienEnemy.getAliens().isEmpty()) {
            worldDestroyers.setActiveScene(ID);
        }
    }
}
