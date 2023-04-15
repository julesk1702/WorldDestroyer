package com.github.hanyaeger.tutorial.entities.spawner;

import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.tutorial.entities.Enemies.AlienEnemy;
import com.github.hanyaeger.tutorial.entities.Bullet;

import java.util.List;
import java.util.Random;

public class BulletSpawner extends EntitySpawner{
    public static final int INTERVAL_IN_MS = 2000;
    private double sceneWidth;
    private double sceneHeight;
    private boolean keyPressed = false;
    private int amountOfBullets = 0;
    private long previousTime;
    private boolean shootBullet = false;

    public BulletSpawner(double sceneWidth, double sceneHeight ) {
        super(INTERVAL_IN_MS);
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

