package com.github.hanyaeger.tutorial.entities.spawner;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.tutorial.entities.Bullet;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class BulletSpawner extends EntitySpawner{
    private double sceneWidth;
    private double sceneHeight;
    private boolean keyPressed = false;

    public BulletSpawner(double sceneWidth, double sceneHeight) {
        super(1000);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
    }

    @Override
    protected void spawnEntities() {
        //spawn(new Bullet(new Coordinate2D(100, 510)));
    }
}

