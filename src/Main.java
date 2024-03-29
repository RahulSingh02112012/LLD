import SingletonPattern.EnumSingleton;

public class Main {
    public static void main(String[] args) {
        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;

        System.out.println("Hello world!");
    }
}