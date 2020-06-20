package ru.pk.rob1;

import robocode.*;
import ru.pk.rob1.events.EventHandler;
import ru.pk.rob1.firing.Firiable;
import ru.pk.rob1.firing.SimpleFire;
import ru.pk.rob1.gunmoving.GunMovable;
import ru.pk.rob1.gunmoving.SimpleGunMove;
import ru.pk.rob1.movement.Movable;
import ru.pk.rob1.movement.Straight;
import ru.pk.rob1.scanning.Scan360;
import ru.pk.rob1.scanning.Scanner;

//@SuppressWarnings("unused")
public class BaseBot extends Robot {
    private Movable movable;
    private Firiable firiable;
    private GunMovable gunMovable;
    private Scanner scanner;
    private EventHandler eventHandler;

    @Override
    public String getName() {
        return "pk-BaseBot1";
    }

    private void preRunInitialize() {
        this.gunMovable.initialize();
        this.scanner.initialize();
    }

    @Override
    public void run() {
        preRunInitialize();
        while(true) {
            scanner.scan();
            movable.move();
        }
    }

    public BaseBot() {
        this.movable = new Straight(this);
        this.firiable = new SimpleFire(this);
        this.gunMovable = new SimpleGunMove(this);
        this.scanner = new Scan360(this);
        this.eventHandler = new EventHandler(this);
    }

    @Override
    public void onHitWall(HitWallEvent event) {
        eventHandler.handle(event);
    }

    @Override
    public void onHitRobot(HitRobotEvent event) {
        eventHandler.handle(event);
    }

    @Override
    public void onHitByBullet(HitByBulletEvent event) {
        eventHandler.handle(event);
    }

    @Override
    public void onScannedRobot(ScannedRobotEvent event) {
        //eventHandler.handle(event);
    }

    public Movable getMovable() {
        return movable;
    }

    public Firiable getFiriable() {
        return firiable;
    }

    public GunMovable getGunMovable() {
        return gunMovable;
    }

    public EventHandler getEventHandler() {
        return eventHandler;
    }
}
