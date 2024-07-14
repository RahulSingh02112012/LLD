package LowLevelDesigns.StrategyPattern;

import LowLevelDesigns.StrategyPattern.Strategy.DriveStrategyProvider;
import LowLevelDesigns.StrategyPattern.Strategy.SpecialDriveStrategy;

public class SportsVehicle extends BaseVehicle {

    SportsVehicle() {
        super(new SpecialDriveStrategy());
    }
}
