package ChainOfResponsibility;

public class Main {

    public static void main(String[] args) {
        LogProcesser logProcesserObj = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));

        logProcesserObj.log(LogProcesser.ERROR, "");
        logProcesserObj.log(LogProcesser.INFO, "");
        logProcesserObj.log(LogProcesser.DEBUG, "");
    }
}
