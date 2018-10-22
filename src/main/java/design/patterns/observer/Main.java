package design.patterns.observer;

import design.patterns.observer.i.Observer;
import design.patterns.observer.implemtation.IncomeObserver;
import design.patterns.observer.implemtation.StockDataSubject;

public class Main {
    public static void main(String[] args) {
        StockDataSubject subject = new StockDataSubject();

        Observer observer1 = new IncomeObserver(subject);
        Observer observer2 = new IncomeObserver(subject);

        System.out.println("state change 1: $ 123 100");
        subject.setStockData("$", 123f, 100);

        ((IncomeObserver) observer1).unObserve();

        System.out.println("state change 2: ¢ 321 500");
        subject.setStockData("¢", 321f, 500);
    }
}