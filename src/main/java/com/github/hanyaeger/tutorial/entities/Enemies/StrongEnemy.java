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

public class StrongEnemy extends Enemy implements Collided {
    public static final int WIDTH = 60;
    public static final int HEIGHT = 70;
    private boolean isPlayerBullet = false;
    public int DEAD = 0;
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
        
        //System.out.println("Collision alien");
        var explosion = new SoundClip("audio/explosion2.mp3");
        if (collidingObject instanceof Bullet bullet) {
            isPlayerBullet = bullet.getIsPlayerBullet();
            if (isPlayerBullet) {
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
            worldDestroyers.setActiveScene(3);
        }
    }
}
