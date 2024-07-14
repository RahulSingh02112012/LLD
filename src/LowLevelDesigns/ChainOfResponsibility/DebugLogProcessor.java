package LowLevelDesigns.ChainOfResponsibility;

public class DebugLogProcessor extends LogProcesser{

    public DebugLogProcessor(LogProcesser nextLogProcessor) {
        super(nextLogProcessor);
    }

    public void log(int logLevel, String msg) {
        if(logLevel == DEBUG) {
            System.out.println("ERROR: " + msg);
        } else {
            super.log(logLevel,msg);
        }
    }
}
