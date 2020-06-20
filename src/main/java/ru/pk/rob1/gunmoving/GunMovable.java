package ru.pk.rob1.gunmoving;

import robocode.HitByBulletEvent;
import robocode.ScannedRobotEvent;

public interface GunMovable {
    void initialize();
    void moveToEnemyBullet(HitByBulletEvent event);
    void moveToScannedRobot(ScannedRobotEvent event);
}
