package LowLevelDesigns.StrategyPattern;

import LowLevelDesigns.StrategyPattern.Strategy.NormalDriveStrategy;
import LowLevelDesigns.StrategyPattern.Strategy.SpecialDriveStrategy;

public class Main {
    public static void main(String[] args) {

        BaseVehicle vehicle = new BaseVehicle(new NormalDriveStrategy());
        BaseVehicle specialVehicle = new BaseVehicle(new SpecialDriveStrategy());

        vehicle.drive();
        specialVehicle.drive();
    }
}
