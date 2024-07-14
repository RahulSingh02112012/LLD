package LowLevelDesigns.StrategyPattern.Strategy;

public class NormalDriveStrategy implements DriveStrategyProvider{

    @Override
    public void drive() {
        System.out.println("Normal Strategy");
    }
}
