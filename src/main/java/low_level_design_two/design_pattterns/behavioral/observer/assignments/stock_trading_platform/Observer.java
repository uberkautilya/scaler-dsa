package low_level_design_two.design_pattterns.behavioral.observer.assignments.stock_trading_platform;

public interface Observer {
    public void updateStockPrice(String stockName, double newPrice);
}