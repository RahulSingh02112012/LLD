package LowLevelDesigns.StrategyPattern;

import LowLevelDesigns.StrategyPattern.Strategy.DriveStrategyProvider;
import LowLevelDesigns.StrategyPattern.Strategy.NormalDriveStrategy;

public class PassengerVehicle extends BaseVehicle {

    PassengerVehicle() {
        super(new NormalDriveStrategy());
    }
}
