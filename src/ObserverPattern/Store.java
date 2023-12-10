package ObserverPattern;

import ObserverPattern.Observable.PhoneStockObservableImpl;
import ObserverPattern.Observable.StockObservable;
import ObserverPattern.Observer.EmailAlertObserverImpl;
import ObserverPattern.Observer.MobileAlertObserverImpl;
import ObserverPattern.Observer.StockObserver;

public class Store {
    public static void main(String[] args) {
        StockObservable iphoneStockObservable = new PhoneStockObservableImpl();

        StockObserver observer1 = new EmailAlertObserverImpl("emailId@test.com", iphoneStockObservable);
        StockObserver observer2 = new MobileAlertObserverImpl("emailId@test.com", iphoneStockObservable);

        iphoneStockObservable.add(observer1);
        iphoneStockObservable.add(observer2);

        iphoneStockObservable.setStockCount(1);
        iphoneStockObservable.setStockCount(1);
    }
}
