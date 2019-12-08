package ru.pk.rob1.firing;

import robocode.Robot;
import robocode.Rules;

public class SimpleFire implements Firiable {
    private Robot robot;

    @Override
    public void fire() {
        robot.fire(Rules.MAX_BULLET_POWER);
    }

    public SimpleFire(Robot robot) {
        this.robot = robot;
    }
}
