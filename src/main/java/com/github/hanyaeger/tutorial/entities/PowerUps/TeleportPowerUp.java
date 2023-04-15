package com.github.hanyaeger.tutorial.entities.PowerUps;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.tutorial.entities.Bullet;
import com.github.hanyaeger.tutorial.entities.Tank;

public class TeleportPowerUp extends DynamicSpriteEntity implements PowerUp, Collided {

    private int boost;
    private Tank tank;

    public TeleportPowerUp(int boost, Tank tank, Coordinate2D initialLocation) {
        super("sprites/boost.png", initialLocation, new Size(50, 50));
        this.boost = boost;
        this.tank = tank;
    }

    @Override
    public void setBoost(int boost) {
        this.boost = boost;
    }

    @Override
    public void activate(Bullet bullet) {
        if (bullet.getKeyUnlocked()){
            tank.setKeyCollect(bullet.getKeyUnlocked());
        }
    }

    @Override
    public void onCollision(Collider collider) {
        boolean checkBoolean = false;
        var explosion = new SoundClip("audio/explosion3.mp3");
        var sound = new SoundClip("audio/voice_line_3.mp3");
        if (collider instanceof Bullet bullet) {
            checkBoolean = bullet.getIsPlayerBullet();
            bullet.setKeyUnlocked(true);
            if (checkBoolean) {
                explosion.play();
                bullet.remove();
                remove();
                sound.play();
                activate(bullet);
            }
        }
    }
}
