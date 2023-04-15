package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.tutorial.WorldDestroyers;
import com.github.hanyaeger.tutorial.entities.Obstacles.Exit;
import com.github.hanyaeger.tutorial.entities.text.HealthText;
import com.github.hanyaeger.tutorial.entities.text.ScoreText;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class Tank extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Collided, Collider {
    private WorldDestroyers worldDestroyers;
    private ScoreText scoreText;
    private HealthText healthText;
    boolean checkBoolean = false;
    boolean keyUnlocked = false;
    boolean gameOver = false;
    private int health = 7;
    private int score = 0;
    private Exit exit;
    boolean isOverExit = false;

    public Tank(Coordinate2D location, HealthText healthText, Exit exit, WorldDestroyers worldDestroyers) {
        super("sprites/tank.gif", location, new Size(80, 110), 1, 2);
        this.worldDestroyers = worldDestroyers;
        this.healthText = healthText;
        this.exit = exit;
        healthText.setHealth(health);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.LEFT)) {
            setMotion(3, 270d);
            setCurrentFrameIndex(2);
        } else if (pressedKeys.contains(KeyCode.RIGHT)) {
            setMotion(3, 90d);
            setCurrentFrameIndex(1);
        } else if (pressedKeys.isEmpty()){
            setSpeed(0);
        }
        if (pressedKeys.contains(KeyCode.G) && isOverExit) {
            goToGameOverScene();
            isOverExit = false;
        }
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        if (border.equals(SceneBorder.LEFT)) {
            setSpeed(0);
            setCurrentFrameIndex(1);
        }
        if (border.equals(SceneBorder.RIGHT)) {
            setSpeed(0);
            setCurrentFrameIndex(2);

        }
    }

    public void setKeyCollect(boolean keyCollect) {
        this.keyUnlocked = keyCollect;
    }

    public boolean getKeyCollect() {
        return keyUnlocked;
    }

    public Coordinate2D getAnchorLocation(){
        return getLocationInScene();
    }

    @Override
    public void onCollision(Collider collidingObject) {
        //System.out.println("Collision alien");
        var explosion = new SoundClip("audio/explosion.mp3");
        if (collidingObject instanceof Bullet bullet) {
            checkBoolean = bullet.getIsPlayerBullet();

            if (!checkBoolean) {
                healthText.setHealth(--health);
                explosion.play();
                bullet.remove();
                if (health == 0) {
                    remove();
                    goToGameOverScene();
                }
            }
        }
        if(collidingObject instanceof Exit exit) {
            isOverExit = true;
        }
    }


    public void goToGameOverScene() {
            worldDestroyers.setActiveScene(2);
    }
}
