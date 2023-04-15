package com.github.hanyaeger.tutorial.entities.Obstacles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.tutorial.WorldDestroyers;
import com.github.hanyaeger.tutorial.entities.Tank;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Door extends DynamicSpriteEntity implements Collided {
    private WorldDestroyers worldDestroyers;
    private List<Door> doors = new ArrayList<>();
    private List<String> sounds = new ArrayList<>();
    private List<Coordinate2D> listLocation = new ArrayList<>();

    private int id;

    public Door(Coordinate2D location, int id) {
        super("sprites/door.png", location, new Size(30, 200));
        this.id = id;
        listLocation.add(location);
        doors.add(this);
        sounds.add("audio/voice_line_1.mp3");
        sounds.add("audio/voice_line_2.mp3");
    }

    public List<Door> getDoors(){
        return doors;
    }

    @Override
    public void onCollision(Collider collidingObject) {
        Coordinate2D coordinate1 = new Coordinate2D(650, 510);
        Coordinate2D coordinate2 = new Coordinate2D(100, 510);
        if (collidingObject instanceof Tank tank) {
                System.out.println("has not touched");
                if (tank.getKeyCollect()){
                    if (id == 1) {
                        tank.setAnchorLocation(coordinate1);
                    } else if (id == 2) {
                        tank.setAnchorLocation(coordinate2);
                    }
                }
            }
        }

    public Coordinate2D getLocation(){
        return getAnchorLocation();
    }
}

