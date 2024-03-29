package SingletonPattern;

public class DoubleCheckLocking {

    private static volatile DoubleCheckLocking obj ;

    private DoubleCheckLocking() {

    }

    public static DoubleCheckLocking getInstance() {
        if(obj == null) {
            synchronized (DoubleCheckLocking.class) {
                if(obj == null) {
                    obj = new DoubleCheckLocking();
                }
            }

        }
        return obj;
    }
}
