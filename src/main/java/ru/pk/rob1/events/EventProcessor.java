package ru.pk.rob1.events;


import robocode.Event;

public interface EventProcessor<T extends Event> {
    void process(T event);
}
