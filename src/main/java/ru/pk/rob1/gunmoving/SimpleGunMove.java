package ru.pk.rob1.gunmoving;

import robocode.HitByBulletEvent;
import robocode.ScannedRobotEvent;
import ru.pk.rob1.BaseBot;

public class SimpleGunMove implements GunMovable {
    private BaseBot robot;

    public SimpleGunMove(BaseBot robot) {
        this.robot = robot;
    }

    @Override
    public void initialize() {
        robot.setAdjustGunForRobotTurn(true);
    }

    @Override
    public void moveToEnemyBullet(HitByBulletEvent event) {
        double bearingTarget = event.getBearing();
        double headingGun = robot.getGunHeading();
        double headingRobot = robot.getHeading();
        double correction = calcCorrection(headingRobot, headingGun);
        robot.turnGunRight(bearingTarget + correction);
    }

    @Override
    public void moveToScannedRobot(ScannedRobotEvent event) {
        double bearingTarget = event.getBearing();
        double headingGun = robot.getGunHeading();
        double headingRobot = robot.getHeading();
        double correction = calcCorrection(headingRobot, headingGun);
        robot.turnGunRight(bearingTarget + correction);
    }

    private double calcCorrection(double headingRobot, double headingGun) {
        double correction = 0;
        if (Math.floor(headingGun * 100)/100 != Math.floor(headingRobot * 100)/100) {
            double r = headingRobot > 180 ? -(360-headingRobot) : headingRobot;
            double g = headingGun > 180 ? -(360-headingGun) : headingGun;
            double result = r - g; //Повернуть пушку вправо на эту величину для выравнивания пушки по корпусу
            correction = result;
        }

        return correction;
    }
}
