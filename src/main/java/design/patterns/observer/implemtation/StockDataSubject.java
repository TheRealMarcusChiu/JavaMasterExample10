package design.patterns.observer.implemtation;

import design.patterns.observer.i.Observer;
import design.patterns.observer.i.Subject;

import java.util.ArrayList;
import java.util.List;

public class StockDataSubject implements Subject {

    private List<Observer> observers;

    private String stockSymbol;
    private Float stockValue;
    private Integer stockUnits;

    public StockDataSubject() {
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(Observer o: observers) {
            o.update(stockSymbol, stockValue, stockUnits);
        }
    }

    public void setStockData(String stockSymbol, Float stockValue, Integer stockUnits) {
        // In real-time, this method might be invoked with values from a live web service at regular intervals.
        this.stockSymbol = stockSymbol;
        this.stockValue = stockValue;
        this.stockUnits = stockUnits;
        notifyObservers();
    }
}
