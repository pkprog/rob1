package ru.pk.rob1.events;

import robocode.ScannedRobotEvent;
import ru.pk.rob1.BaseBot;

public class OnScannedRobotEventProcessor implements EventProcessor<ScannedRobotEvent> {
    private EventHandler eventHandler;
    private BaseBot robot;

    public OnScannedRobotEventProcessor(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
        this.robot = eventHandler.getRobot();
    }

    @Override
    public void process(ScannedRobotEvent event) {
        robot.getGunMovable().moveToScannedRobot(event);
        robot.getFiriable().fire();
    }
}
