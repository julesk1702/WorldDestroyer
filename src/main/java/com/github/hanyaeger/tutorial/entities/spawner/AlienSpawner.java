package com.github.hanyaeger.tutorial.entities.spawner;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.tutorial.WorldDestroyers;
import com.github.hanyaeger.tutorial.entities.Enemies.AlienEnemy;
import com.github.hanyaeger.tutorial.entities.Enemies.Enemy;
import com.github.hanyaeger.tutorial.entities.Enemies.StrongEnemy;

import java.util.Random;

public class AlienSpawner extends EntitySpawner {
    private double sceneWidth;
    private double sceneHeight;
    private int maxAliens;
    private int maxTankAliens;
    private int tankAliens = 0;
    private int alienCount = 0;
    private WorldDestroyers worldDestroyers;
    public AlienSpawner(double sceneWidth, double sceneHeight, WorldDestroyers worldDestroyers) {
        super(1);
        Random random = new Random();
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
        this.worldDestroyers = worldDestroyers;
        maxAliens = 15;
        maxTankAliens = 5;
    }
    @Override
    protected void spawnEntities() {
        if (alienCount < maxAliens) {
            Coordinate2D newLocation;
            do {
                newLocation = new Coordinate2D(randomXlocation(), randomYlocation());
            } while (isTooCloseToanotherAlien(newLocation));

            Enemy normalEnemy = new AlienEnemy(newLocation, worldDestroyers);

            normalEnemy.setHealth(2);
            spawn(normalEnemy);
            alienCount++;
        }
        if (tankAliens < maxTankAliens){
            Coordinate2D newLocation;
            do {
                newLocation = new Coordinate2D(randomXlocation(), randomYlocation());
            } while (isTooCloseToanotherAlien(newLocation));

            Enemy strongEnemy = new StrongEnemy(newLocation, worldDestroyers);

            strongEnemy.setHealth(4);
            spawn(strongEnemy);
            tankAliens++;
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
