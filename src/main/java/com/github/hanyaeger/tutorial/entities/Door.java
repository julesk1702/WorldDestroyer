package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.tutorial.WorldDestroyers;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Door extends DynamicSpriteEntity implements KeyListener, Collided {
    private WorldDestroyers worldDestroyers;
    private List<Door> doors = new ArrayList<>();
    private List<Coordinate2D> listLocation = new ArrayList<>();

    Boolean doorState = false;
    private int id;

    public Door(Coordinate2D location, int id) {
        super("sprites/door.png", location, new Size(30, 200));
        this.id = id;
        listLocation.add(location);
        doors.add(this);
    }

    public List<Door> getDoors(){
        return doors;
    }

    @Override
    public void onCollision(Collider collidingObject) {
        Coordinate2D coordinate1 = new Coordinate2D(650, 510);
        Coordinate2D coordinate2 = new Coordinate2D(100, 510);
        if (collidingObject instanceof Tank tank) {
            if (id == 1) {
                tank.setAnchorLocation(coordinate1);
            } else if (id == 2) {
                tank.setAnchorLocation(coordinate2);
            }
        }
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
//        if (pressedKeys.contains(KeyCode.E) && !doorState) {
//            setMotion(3, 180);
////            if (coordinate2D.y <= -200) {
////                setSpeed(0);
////                doorState = true;
////            }
//        } else {
//            setMotion(3, 0);
////            if (coordinate2D.y >= 300) {
////                setSpeed(0);
////                doorState = false;
////            }
//        }
    }

    public Coordinate2D getLocation(){
        return getAnchorLocation();
    }
}

