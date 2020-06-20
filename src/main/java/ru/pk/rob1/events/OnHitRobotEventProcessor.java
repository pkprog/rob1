package ru.pk.rob1.events;

import robocode.HitRobotEvent;

public class OnHitRobotEventProcessor implements EventProcessor<HitRobotEvent> {
    private EventHandler eventHandler;

    public OnHitRobotEventProcessor(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    @Override
    public void process(HitRobotEvent event) {
        eventHandler.getRobot().getMovable().onHitRobot(event);
        eventHandler.getRobot().getFiriable().fire();
    }
}
