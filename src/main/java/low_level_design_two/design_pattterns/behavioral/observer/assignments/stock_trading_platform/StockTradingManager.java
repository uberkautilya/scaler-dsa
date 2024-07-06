package low_level_design_two.design_pattterns.behavioral.observer.assignments.stock_trading_platform;

public class StockTradingManager extends Publisher {

    private String stockName;
    private double currentPrice;
    private double notificationThreshold;

    // DO NOT MODIFY THIS CONSTRUCTOR
    public StockTradingManager(String stockName, double initialPrice, double notificationThreshold) {
        this.stockName = stockName;
        this.currentPrice = initialPrice;
        this.notificationThreshold = notificationThreshold;
    }
    // DO NOT MODIFY THIS CONSTRUCTOR

    public void updateStockPrice(double newPrice) {
        currentPrice = newPrice;
        if (currentPrice > notificationThreshold) {
            notifyObservers(stockName, newPrice);
        }
    }

}