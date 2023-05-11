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
import javafx.scene.input.KeyCode;

import java.util.Set;

public class Tank extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Collided, Collider {
    private final double DIRECTION_RIGHT = 90d;
    private final double DIRECTION_LEFT = 270d;
    private final int SPEED = 3;
    private WorldDestroyers worldDestroyers;
    private HealthText healthText;
    boolean isBulletPlayer = false;
    boolean keyUnlocked = false;
    private int health = 7;
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
            setMotion(SPEED, DIRECTION_LEFT);
            setCurrentFrameIndex(2);
        } else if (pressedKeys.contains(KeyCode.RIGHT)) {
            setMotion(SPEED, DIRECTION_RIGHT);
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
        var explosion = new SoundClip("audio/explosion.mp3");
        if (collidingObject instanceof Bullet bullet) {
            isBulletPlayer = bullet.getIsPlayerBullet();
            if (!isBulletPlayer) {
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
