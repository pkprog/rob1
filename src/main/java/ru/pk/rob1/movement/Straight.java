package ru.pk.rob1.movement;

import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.Robot;

import java.util.concurrent.atomic.AtomicBoolean;

public class Straight implements Movable {
    private Robot robot;

    public Straight(Robot robot) {
        this.robot = robot;
    }

    private AtomicBoolean isHitByBullet = new AtomicBoolean(false);


    @Override
    public void move() {
        robot.ahead(100);
    }

    @Override
    public void moveFromLineOfFire(double bearing) {
        //this.isHitByBullet.set(true);
        robot.stop();
        if (PositionUtils.hasLocationAtRight(robot)) {
            robot.turnRight(bearing + 90);
        } else if (PositionUtils.hasLocationAtLeft(robot)) {
            robot.turnLeft(bearing + 90);
        } else {
            if (PositionUtils.hasLocationAtFront(robot)) {
                robot.ahead(50);
            } else if (PositionUtils.hasLocationAtBack(robot)) {
                robot.back(50);
            } else {
                //none
            }
        }
        robot.resume();
/*
        robot.stop();
        if (event.getBearing() > 0) {
            robot.turnLeft(60);
        } else {
            robot.turnRight(60);
        }
*/
//        double bulletHeading = event.getHeading();
//        Logger.debug("bulletHeading={}, robHeading={}", bulletHeading, robot.getHeading());
//        robot.turnLeft(bulletHeading + 30);
    }

    @Override
    public void onHitWall(HitWallEvent event) {
        if (isHitByBullet.get()) {
            return;
        }

        robot.stop();
        if (event.getBearing() > 0) {
            robot.turnLeft(90);
        } else {
            robot.turnRight(90);
        }
    }

    @Override
    public void onHitRobot(HitRobotEvent event) {
        robot.turnLeft(50);
    }

}
