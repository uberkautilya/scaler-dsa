package low_level_design_two.design_pattterns.behavioral.observer.assignments.stock_trading_platform;

import java.util.ArrayList;
import java.util.List;

public abstract class Publisher implements ObserverRegistry {
    List<Observer> observerList = new ArrayList<>();
    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers(String stockName, double currentPrice) {
        for (Observer observer : observerList) {
            observer.updateStockPrice(stockName, currentPrice);
        }
    }
}