package LowLevelDesigns.StrategyPattern;

import LowLevelDesigns.StrategyPattern.Strategy.DriveStrategyProvider;

public class BaseVehicle {

    DriveStrategyProvider driveStrategyProvider;

    BaseVehicle(DriveStrategyProvider driveStrategyProvider) {
        this.driveStrategyProvider = driveStrategyProvider;
    }

    public void drive() {
        driveStrategyProvider.drive();
    }
}
