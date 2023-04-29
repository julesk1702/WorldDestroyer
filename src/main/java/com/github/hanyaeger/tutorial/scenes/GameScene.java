package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.tutorial.WorldDestroyers;
import com.github.hanyaeger.tutorial.entities.*;
import com.github.hanyaeger.tutorial.entities.Obstacles.Exit;
import com.github.hanyaeger.tutorial.entities.Obstacles.Wall;
import com.github.hanyaeger.tutorial.entities.PowerUps.TeleportPowerUp;
import com.github.hanyaeger.tutorial.entities.spawner.AlienSpawner;
import com.github.hanyaeger.tutorial.entities.spawner.BulletSpawner;
import com.github.hanyaeger.tutorial.entities.spawner.DoorSpawner;
import com.github.hanyaeger.tutorial.entities.spawner.PowerUpSpawner;
import com.github.hanyaeger.tutorial.entities.text.HealthText;
import com.github.hanyaeger.tutorial.entities.text.ScoreText;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GameScene extends DynamicScene implements EntitySpawnerContainer, KeyListener {
    Tank tank;
    private WorldDestroyers worldDestroyers;
    private ScoreText scoreText;

    public GameScene(WorldDestroyers worldDestroyers) {
       this.worldDestroyers = worldDestroyers;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/gameMusic.mp3");
        setBackgroundAudioVolume(0.1);
        setBackgroundImage("backgrounds/backgroundGame.png");
    }

    @Override
    public void setupEntities() {
        var health = new HealthText(new Coordinate2D(5, 10));
        addEntity(health);
        var objective = new TextEntity(
                new Coordinate2D(5, 30),
                "Objective: Destroy all aliens"
        );
        objective.setFill(Color.WHITE);
        objective.setFont(Font.font("Roboto", FontWeight.BOLD, 15));
        addEntity(objective);

        var exit = new Exit(new Coordinate2D(400, 510));
        addEntity(exit);

        tank = new Tank(new Coordinate2D(100, 510), health, exit, worldDestroyers);
        addEntity(tank);

        var teleportKey = new TeleportPowerUp(2, tank, new Coordinate2D(50, 150));
        addEntity(teleportKey);

        for (int i = 0; i < 3; i++) {
            List<Wall> walls = new ArrayList<>();
            walls.add(new Wall(new Coordinate2D(100, 400)));
            walls.add(new Wall(new Coordinate2D(350, 400)));
            walls.add(new Wall(new Coordinate2D(550, 400)));
            addEntity(walls.get(i));
        }
    }



    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new BulletSpawner(100, 510));
        addEntitySpawner(new AlienSpawner(800, 600, worldDestroyers));
        addEntitySpawner(new DoorSpawner());
        addEntitySpawner(new PowerUpSpawner());
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.SPACE)) {
            addEntity(new Bullet("sprites/bullet.png" , new Coordinate2D(tank.getAnchorLocation()), true));
        }
    }
}
