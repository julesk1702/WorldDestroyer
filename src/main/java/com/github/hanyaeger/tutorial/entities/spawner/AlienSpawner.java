package com.github.hanyaeger.tutorial.entities.spawner;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.tutorial.WorldDestroyers;
import com.github.hanyaeger.tutorial.entities.AlienEnemy;
import com.github.hanyaeger.tutorial.entities.text.ScoreText;

import java.util.Random;

public class AlienSpawner extends EntitySpawner {
    private double sceneWidth;
    private double sceneHeight;

    private final int MAX_ALIENS = 20;
    private int alienCount = 0;
    private WorldDestroyers worldDestroyers;

    public AlienSpawner(double sceneWidth, double sceneHeight, WorldDestroyers worldDestroyers) {
        super(1);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
        this.worldDestroyers = worldDestroyers;
    }
    @Override
    protected void spawnEntities() {
        if (alienCount < MAX_ALIENS) {
            Coordinate2D newLocation;
            do {
                newLocation = new Coordinate2D(randomXlocation(), randomYlocation());
            } while (isTooCloseToanotherAlien(newLocation));

            spawn(new AlienEnemy(newLocation, worldDestroyers, new ScoreText(new Coordinate2D(100, 100))));
            alienCount++;
        }
    }

    private boolean isTooCloseToanotherAlien(Coordinate2D newLocation) {
        for (AlienEnemy alien : AlienEnemy.getAliens()) {
            if (alien.getAnchorLocation().distance(newLocation) < 60) {
                return true;
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
