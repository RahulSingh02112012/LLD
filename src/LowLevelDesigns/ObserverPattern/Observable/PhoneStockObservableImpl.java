package LowLevelDesigns.ObserverPattern.Observable;

import LowLevelDesigns.ObserverPattern.Observer.StockObserver;

import java.util.ArrayList;
import java.util.List;

public class PhoneStockObservableImpl implements StockObservable{

    List<StockObserver> list = new ArrayList<>();
    int count =0;
    @Override
    public void add(StockObserver observer) {
        list.add(observer);
    }

    @Override
    public void remove(StockObserver observer) {
        list.remove(observer);
    }

    @Override
    public void notifySubscribers() {
        list.stream().forEach(StockObserver::update);
    }

    @Override
    public void setStockCount(int newStocks) {
        if(this.count == 0) {
            notifySubscribers();
        }
        count = count + newStocks;
    }


    @Override
    public int getStockCount() {
        return this.count;
    }
}
