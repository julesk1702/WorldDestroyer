package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Enemy extends DynamicSpriteEntity {

    protected Enemy(String resource, Coordinate2D initialLocation , Size size) {
        super(resource, initialLocation, size);
    }

    public void setHealth(int health) {
    }
}
