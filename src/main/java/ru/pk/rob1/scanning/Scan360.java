package ru.pk.rob1.scanning;

import ru.pk.rob1.BaseBot;

public class Scan360 implements Scanner {
    private BaseBot robot;

    public Scan360(BaseBot robot) {
        this.robot = robot;
    }

    @Override
    public void initialize() {
        robot.setAdjustRadarForGunTurn(true);
        robot.setAdjustRadarForRobotTurn(true);
    }

    @Override
    public void scan() {
        robot.turnRadarRight(360);
    }
}
