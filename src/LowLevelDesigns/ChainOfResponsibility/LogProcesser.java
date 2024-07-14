package LowLevelDesigns.ChainOfResponsibility;

public abstract class LogProcesser {

    public static int INFO =1;
    public static int DEBUG =2;
    public static int ERROR =3;

    LogProcesser nextLogProcessor;

    public LogProcesser(LogProcesser nextLogProcessor) {
        this.nextLogProcessor = nextLogProcessor;
    }

    public void log(int logLevel, String msg) {
        if(nextLogProcessor != null) {
            nextLogProcessor.log(logLevel,msg);
        }
    }

}
