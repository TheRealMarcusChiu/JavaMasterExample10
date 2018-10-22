package design.patterns.observer.i;

public interface Observer {
    void update(String stockSymbol, Float stockValue, Integer stockUnits);
}
