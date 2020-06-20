package ru.pk.rob1.events;

import robocode.HitWallEvent;

public class OnHitWallEventProcessor implements EventProcessor<HitWallEvent> {
    private EventHandler eventHandler;

    public OnHitWallEventProcessor(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    @Override
    public void process(HitWallEvent event) {
        eventHandler.getRobot().getMovable().onHitWall(event);
    }

}
