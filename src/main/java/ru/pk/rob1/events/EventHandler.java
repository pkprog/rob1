package ru.pk.rob1.events;

import robocode.*;
import ru.pk.rob1.BaseBot;

public class EventHandler {
    private BaseBot robot;
    private OnHitWallEventProcessor onHitWall;
    private OnHitRobotEventProcessor onHitRobot;
    private OnHitByBulletEventProcessor onHitByBullet;
    private OnScannedRobotEventProcessor onScannedRobot;

    public EventHandler(BaseBot robot) {
        this.robot = robot;
        onHitWall = new OnHitWallEventProcessor(this);
        onHitRobot = new OnHitRobotEventProcessor(this);
        onHitByBullet = new OnHitByBulletEventProcessor(this);
        onScannedRobot = new OnScannedRobotEventProcessor(this);
    }

    public void handle(Event event) {
        if (event instanceof HitWallEvent) {
            onHitWall.process((HitWallEvent) event);
        } else if (event instanceof HitRobotEvent) {
            onHitRobot.process((HitRobotEvent) event);
        } else if (event instanceof HitByBulletEvent) {
            onHitByBullet.process((HitByBulletEvent) event);
        } else if (event instanceof ScannedRobotEvent) {
            onScannedRobot.process((ScannedRobotEvent) event);
        }
    }

    public BaseBot getRobot() {
        return robot;
    }
}
