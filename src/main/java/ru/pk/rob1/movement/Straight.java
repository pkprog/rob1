package ru.pk.rob1.movement;

import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.Robot;

public class Straight implements Movable {
    private Robot robot;

    public Straight(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void move() {
        robot.ahead(80);
    }

    @Override
    public void onHitWall(HitWallEvent event) {
        robot.turnLeft(25);
    }

    @Override
    public void onHitRobot(HitRobotEvent event) {
        robot.turnLeft(25);
    }

    @Override
    public void onHitByBullet(HitByBulletEvent event) {
        robot.stop();
        robot.turnLeft(360-event.getHeading() + 45);
    }

}
