package SingletonPattern;

public class SynchronizedMethod {
    private static SynchronizedMethod obj ;

    private SynchronizedMethod() {

    }

    public synchronized static SynchronizedMethod getInstance() {
        if(obj == null) {
            obj = new SynchronizedMethod();
        }
        return obj;
    }
}
