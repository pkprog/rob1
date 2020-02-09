package ru.pk.rob1.movement;

import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.Robot;
import ru.pk.rob1.logger.Logger;

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

    @Override
    public void onHitByBullet(HitByBulletEvent event) {
        robot.stop();
        if (event.getBearing() > 0) {
            robot.turnLeft(60);
        } else {
            robot.turnRight(60);
        }
//        double bulletHeading = event.getHeading();
//        Logger.debug("bulletHeading={}, robHeading={}", bulletHeading, robot.getHeading());
//        robot.turnLeft(bulletHeading + 30);
    }

}
