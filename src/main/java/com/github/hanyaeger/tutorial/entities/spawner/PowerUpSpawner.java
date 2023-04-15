package com.github.hanyaeger.tutorial.entities.spawner;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.tutorial.entities.Enemies.AlienEnemy;
import com.github.hanyaeger.tutorial.entities.PowerUps.ShootThroughWallBoost;
import com.github.hanyaeger.tutorial.entities.Enemies.StrongEnemy;

import java.util.Random;

public class PowerUpSpawner extends EntitySpawner {
    private final int MAX_POWERUPS = 3;
    private int powerUps = 0;
    public PowerUpSpawner() {
        super(10000);
    }

    @Override
    protected void spawnEntities() {
        if (powerUps < MAX_POWERUPS) {
            Coordinate2D newLocation;
            do {
                newLocation = new Coordinate2D(randomXlocation(), randomYlocation());
            } while (isTooCloseToanotherAlien(newLocation));

            spawn(new ShootThroughWallBoost(new Coordinate2D(randomXlocation(), randomYlocation())));
            powerUps++;
        }
    }

    private boolean isTooCloseToanotherAlien(Coordinate2D newLocation) {
        for (AlienEnemy alien : AlienEnemy.getAliens()) {
            for (StrongEnemy strongEnemy : StrongEnemy.getAliens()) {
                if (alien.getAnchorLocation().distance(newLocation) < 60 || strongEnemy.getAnchorLocation().distance(newLocation) < 60) {
                    return true;
                }
            }
        }
        return false;
    }

    private double randomXlocation() {
        double x = new Random().nextInt(601) + 100;
        return x;
    }

    private double randomYlocation(){
        double y = new Random().nextInt(201) + 100;
        return y;
    }
}
