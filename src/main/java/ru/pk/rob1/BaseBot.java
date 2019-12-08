package ru.pk.rob1;

import robocode.HitWallEvent;
import robocode.Robot;
import ru.pk.rob1.movement.Movable;
import ru.pk.rob1.movement.Straight;

public class BaseBot extends Robot {
    private Movable movable;

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
    }

    @Override
    public void onHitWall(HitWallEvent event) {
        movable.onHitWall(event);
    }
}
