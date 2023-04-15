package com.github.hanyaeger.tutorial.entities.PowerUps;

import com.github.hanyaeger.tutorial.entities.Bullet;

public interface PowerUp {
    public void setBoost(int boost);

    public void activate(Bullet bullet);
}
