package LowLevelDesigns.ObserverPattern.Observer;

import LowLevelDesigns.ObserverPattern.Observable.StockObservable;

public class EmailAlertObserverImpl implements StockObserver{
    String emailId;
    StockObservable observer;

    public EmailAlertObserverImpl(String emailId, StockObservable observable) {
        this.emailId = emailId;
        this.observer = observable;
    }

    @Override
    public void update() {
        sendMobileAlerts(emailId, "");
    }

    private void sendMobileAlerts(String emailId, String msg) {
        System.out.println("Email sent to: " + emailId);
    }
}
