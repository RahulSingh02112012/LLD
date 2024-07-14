package LowLevelDesigns.ObserverPattern.Observer;

import LowLevelDesigns.ObserverPattern.Observable.StockObservable;

public class MobileAlertObserverImpl implements StockObserver{

    String mobileId;
    StockObservable observer;

    public MobileAlertObserverImpl(String mobileId, StockObservable observer) {
        this.mobileId = mobileId;
        this.observer = observer;
    }

    @Override
    public void update() {
        sendMobileAlerts(mobileId, "");
    }

    private void sendMobileAlerts(String mobileId, String msg) {
        System.out.println("alert sent to: " + mobileId);
    }
}
