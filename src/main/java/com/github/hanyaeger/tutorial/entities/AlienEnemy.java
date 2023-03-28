package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.tutorial.WorldDestroyers;
import com.github.hanyaeger.tutorial.entities.text.ScoreText;

import java.util.ArrayList;
import java.util.List;

public class AlienEnemy extends DynamicSpriteEntity implements Collided {

    private static List<AlienEnemy> aliens = new ArrayList<>();
    private ScoreText scoreText;
    private int score = 0;
    private WorldDestroyers worldDestroyers;

    public AlienEnemy(Coordinate2D initialLocation, WorldDestroyers worldDestroyers, ScoreText scoreText) {
        super("sprites/alien.png", initialLocation, new Size(50, 60));
        aliens.add(this);
        this.worldDestroyers = worldDestroyers;
        this.scoreText = scoreText;
        scoreText.setScore(score);

    }

    public static List<AlienEnemy> getAliens() {
        return aliens;
    }

    @Override
    public void onCollision(Collider collidingObject) {
        boolean checkBoolean = false;
        //System.out.println("Collision alien");
        var explosion = new SoundClip("audio/explosion2.mp3");
        if (collidingObject instanceof Bullet) {
            Bullet bullet = (Bullet) collidingObject;
            checkBoolean = bullet.getIsPlayerBullet();

            if (checkBoolean) {
                explosion.play();
                remove();
                bullet.remove();
                aliens.remove(this);
                goToGameOverScene();
                score++;
                scoreText.setScore(score);
            }
        }
    }

    public Coordinate2D getAnchorLocation(){
        return getLocationInScene();
    }

    public void goToGameOverScene() {
        if (AlienEnemy.getAliens().isEmpty()) {
            worldDestroyers.setActiveScene(1);
        }
    }

    public int getScore(){
        return score;
    }
}

