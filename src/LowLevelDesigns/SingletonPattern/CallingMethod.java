package LowLevelDesigns.SingletonPattern;

public class CallingMethod {
    public static void main(String[] args) {
        EagerInitialization obj = EagerInitialization.getInstance();
        EnumSingleton.INSTANCE.someMethod();
    }
}
