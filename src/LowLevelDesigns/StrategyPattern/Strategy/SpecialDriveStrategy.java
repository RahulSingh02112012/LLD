package LowLevelDesigns.StrategyPattern.Strategy;

public class SpecialDriveStrategy implements DriveStrategyProvider {

    @Override
    public void drive() {
        System.out.println("Special Drive Capabilities Provided");
    }
}
