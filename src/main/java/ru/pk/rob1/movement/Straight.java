package ru.pk.rob1.movement;

import robocode.HitWallEvent;
import robocode.Robot;

public class Straight implements Movable {
    private Robot robot;

    public Straight(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void move() {
        robot.ahead(100);
    }

    @Override
    public void onHitWall(HitWallEvent event) {
        robot.turnLeft(30);
    }
}
