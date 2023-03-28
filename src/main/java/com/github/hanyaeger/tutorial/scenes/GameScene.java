package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.tutorial.entities.AlienEnemy;
import com.github.hanyaeger.tutorial.entities.Bullet;
import com.github.hanyaeger.tutorial.entities.Tank;
import com.github.hanyaeger.tutorial.entities.spawner.AlienSpawner;
import com.github.hanyaeger.tutorial.entities.spawner.BulletSpawner;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class GameScene extends DynamicScene implements EntitySpawnerContainer, KeyListener {

    Tank tank;

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/gameMusic.mp3");
        setBackgroundImage("backgrounds/backgroundGame.png");
    }

    @Override
    public void setupEntities() {
        tank = new Tank("sprites/tank.gif", new Coordinate2D(100, 510), new Size(40, 60));
        addEntity(tank);

        for (AlienEnemy alien : AlienEnemy.getAliens()) {
            addEntity(alien);
        }
        AlienEnemy alien = new AlienEnemy(new Coordinate2D(100, 100));
        addEntity(alien);
    }



    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new BulletSpawner(100, 510));
        addEntitySpawner(new AlienSpawner(800, 600));
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.SPACE)) {
            addEntity(new Bullet(new Coordinate2D(tank.getAnchorLocation())));
        }
    }
}
