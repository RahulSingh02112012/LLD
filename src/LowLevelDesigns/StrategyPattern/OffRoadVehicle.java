package LowLevelDesigns.StrategyPattern;

import LowLevelDesigns.StrategyPattern.Strategy.SpecialDriveStrategy;

public class OffRoadVehicle extends BaseVehicle {

    OffRoadVehicle() {
        super(new SpecialDriveStrategy());
    }
}
