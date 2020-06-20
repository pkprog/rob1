package ru.pk.rob1.movement;

import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.Robot;
import ru.pk.rob1.logger.Logger;

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
        robot.turnRight(bearing);
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
