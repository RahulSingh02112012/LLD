package LowLevelDesigns.SingletonPattern;

public class LazyInitialization {

    private static LazyInitialization obj ;

    private LazyInitialization() {

    }

    public static LazyInitialization getInstance() {
        if(obj == null) {
            obj = new LazyInitialization();
        }
        return obj;
    }
}
