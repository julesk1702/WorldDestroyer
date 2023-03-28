package com.github.hanyaeger.tutorial.entities.spawner;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.tutorial.entities.AlienEnemy;

import java.util.Random;

public class AlienSpawner extends EntitySpawner {
    private double sceneWidth;
    private double sceneHeight;

    public AlienSpawner(double sceneWidth, double sceneHeight) {
        super(500);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
    }
    @Override
    protected void spawnEntities() {
        spawn(new AlienEnemy(new Coordinate2D(randomXlocation(), randomYlocation())));
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
