package ru.pk.rob1.events;

import robocode.HitByBulletEvent;
import ru.pk.rob1.BaseBot;

public class OnHitByBulletEventProcessor implements EventProcessor<HitByBulletEvent> {
    private EventHandler eventHandler;
    private BaseBot robot;

    public OnHitByBulletEventProcessor(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
        this.robot = eventHandler.getRobot();
    }

    @Override
    public void process(HitByBulletEvent event) {
//        robot.getGunMovable().moveToEnemyBullet(event);
//        robot.getFiriable().fire();
        robot.getMovable().moveFromLineOfFire(event.getBearing());
    }
}
