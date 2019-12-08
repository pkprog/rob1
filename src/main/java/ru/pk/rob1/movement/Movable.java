package ru.pk.rob1.movement;

import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;

public interface Movable {
    void move();
    void onHitWall(HitWallEvent event);
    void onHitRobot(HitRobotEvent event);
    void onHitByBullet(HitByBulletEvent event);
}
