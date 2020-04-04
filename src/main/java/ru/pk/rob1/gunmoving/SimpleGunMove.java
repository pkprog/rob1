package ru.pk.rob1.gunmoving;

import robocode.HitByBulletEvent;
import robocode.Robot;

public class SimpleGunMove implements GunMovable {
    private Robot robot;

    public SimpleGunMove(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void moveToEnemyBullet(HitByBulletEvent event) {
        //robot.turnRight(event.getBearing());

        /*double gunCurrentBearing = (robot.getHeading() > 180 ? robot.getHeading() - 360 : robot.getHeading()) -
                (robot.getGunHeading() > 180 ? robot.getGunHeading() - 360 : robot.getGunHeading());
        double gunTargetBearing = gunCurrentBearing - event.getBearing();
        if (gunCurrentBearing > 0) {
            robot.turnGunRight(gunTargetBearing);
        } else {
            robot.turnGunLeft(gunTargetBearing);
        }*/
    }

}
