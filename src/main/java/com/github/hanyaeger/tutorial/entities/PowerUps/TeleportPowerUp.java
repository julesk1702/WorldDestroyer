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
    private Tank tank;

    public TeleportPowerUp(Tank tank, Coordinate2D initialLocation) {
        super("sprites/key.png", initialLocation, new Size(60, 60));
        this.tank = tank;
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
