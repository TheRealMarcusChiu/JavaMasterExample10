package design.patterns.behavioral.observer.implemtation;

import design.patterns.behavioral.observer.i.Observer;
import design.patterns.behavioral.observer.i.Subject;

public class IncomeObserver implements Observer {
    private Subject stockData;

    public IncomeObserver(Subject stockData) {
        this.stockData = stockData;
        stockData.addObserver(this);
    }

    public void unObserve() {
        this.stockData.removeObserver(this);
    }

    @Override
    public void update(String stockSymbol, Float stockValue, Integer stockUnits) {
        System.out.println("IncomeObserver received changes: " + stockSymbol + " " + stockValue + " " + stockUnits);
    }
}