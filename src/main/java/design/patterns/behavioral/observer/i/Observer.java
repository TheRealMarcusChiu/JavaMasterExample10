package design.patterns.behavioral.observer.i;

public interface Observer {
    void update(String stockSymbol, Float stockValue, Integer stockUnits);
}
