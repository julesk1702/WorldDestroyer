package com.github.hanyaeger.tutorial.entities.spawner;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.tutorial.entities.AlienEnemy;
import com.github.hanyaeger.tutorial.entities.Bullet;
import javafx.scene.input.KeyCode;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class BulletSpawner extends EntitySpawner{
    private double sceneWidth;
    private double sceneHeight;
    private boolean keyPressed = false;
    private int amountOfBullets = 0;
    private long previousTime;
    private boolean shootBullet = false;
    public BulletSpawner(double sceneWidth, double sceneHeight) {
        super(2000);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
        previousTime = this.getIntervalInMs();

    }

    @Override
    protected void spawnEntities() {
        setShootBullet();
        List<AlienEnemy> aliens = AlienEnemy.getAliens();
        if (!aliens.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(aliens.size());
            AlienEnemy alien = aliens.get(randomIndex);
            if (shootBullet) {
                spawn(new Bullet("sprites/bullet2.png", alien.getAnchorLocation(), false)); // spawn a bullet
                shootBullet = false; // increase the amount of bullets
            }
        }
    }

    public void setShootBullet() {
        if (shootBullet) {
            shootBullet = false;
        } else if (!shootBullet) {
            shootBullet = true;
        }
    }
}

