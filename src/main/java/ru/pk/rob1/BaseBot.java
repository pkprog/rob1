package ru.pk.rob1;

import robocode.*;
import ru.pk.rob1.firing.Firiable;
import ru.pk.rob1.firing.SimpleFire;
import ru.pk.rob1.movement.Movable;
import ru.pk.rob1.movement.Straight;

public class BaseBot extends Robot {
    private Movable movable;
    private Firiable firiable;

    @Override
    public String getName() {
        return "pk-BaseBot1";
    }


    @Override
    public void run() {
        while(true) {
            movable.move();
        }
    }

    public BaseBot() {
        this.movable = new Straight(this);
        this.firiable = new SimpleFire(this);
    }

    @Override
    public void onHitWall(HitWallEvent event) {
        movable.onHitWall(event);
    }

    @Override
    public void onHitRobot(HitRobotEvent event) {
        movable.onHitRobot(event);
        firiable.fire();
    }

    @Override
    public void onHitByBullet(HitByBulletEvent event) {
        movable.onHitByBullet(event);
    }
}
