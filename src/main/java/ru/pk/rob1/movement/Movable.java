package ru.pk.rob1.movement;

import robocode.HitWallEvent;

public interface Movable {
    void move();
    void onHitWall(HitWallEvent event);
}
