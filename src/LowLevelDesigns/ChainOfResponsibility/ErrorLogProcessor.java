package LowLevelDesigns.ChainOfResponsibility;

public class ErrorLogProcessor extends LogProcesser{

    public ErrorLogProcessor(LogProcesser nextLogProcessor) {
        super(nextLogProcessor);
    }

    public void log(int logLevel, String msg) {
        if(logLevel == ERROR) {
            System.out.println("ERROR: " + msg);
        } else {
            super.log(logLevel,msg);
        }
    }
}
