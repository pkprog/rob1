package ru.pk.rob1.movement;

import robocode.HitRobotEvent;
import robocode.HitWallEvent;

public interface Movable {
    void move();

    /**
     * Уехать с линии огня
     * @param bearing Напревление вражеского огня
     */
    void moveFromLineOfFire(double bearing);
    void onHitWall(HitWallEvent event);
    void onHitRobot(HitRobotEvent event);
}
