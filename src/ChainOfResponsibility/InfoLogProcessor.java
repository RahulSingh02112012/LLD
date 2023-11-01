package ChainOfResponsibility;

public class InfoLogProcessor extends LogProcesser{

    public InfoLogProcessor(LogProcesser nextLogProcessor) {
        super(nextLogProcessor);
    }

    public void log(int logLevel, String msg) {
        if(logLevel == INFO) {
            System.out.println("ERROR: " + msg);
        } else {
            super.log(logLevel,msg);
        }
    }
}
