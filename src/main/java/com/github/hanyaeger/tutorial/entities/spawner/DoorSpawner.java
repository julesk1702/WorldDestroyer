package com.github.hanyaeger.tutorial.entities.spawner;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.tutorial.entities.Obstacles.Door;

public class DoorSpawner extends EntitySpawner {
    private int MAX_DOORS = 0;
    private double startX = 0;

    public DoorSpawner() {
        super(1);
    }
    @Override
    protected void spawnEntities() {
        for (int i = 1; i < 3; i++) {
            if (MAX_DOORS < 2) {
                spawn(new Door(new Coordinate2D(randomXlocation(), 510), i));
                MAX_DOORS++;
            }
        }
    }

    private double randomXlocation() {
        double result = startX;
        startX += 770;
        return result;
    }
}
