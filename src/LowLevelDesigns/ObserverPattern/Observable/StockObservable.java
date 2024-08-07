package LowLevelDesigns.ObserverPattern.Observable;

import LowLevelDesigns.ObserverPattern.Observer.StockObserver;

public interface StockObservable {
    void add(StockObserver observer);
    void remove(StockObserver observer);
    void notifySubscribers();
    void setStockCount(int newStocks);
    int getStockCount();
}
