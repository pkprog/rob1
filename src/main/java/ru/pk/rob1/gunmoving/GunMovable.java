package ru.pk.rob1.gunmoving;

import robocode.HitByBulletEvent;

public interface GunMovable {
    void moveToEnemyBullet(HitByBulletEvent event);
}
