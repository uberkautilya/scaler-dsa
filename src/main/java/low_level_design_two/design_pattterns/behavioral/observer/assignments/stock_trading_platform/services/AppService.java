package low_level_design_two.design_pattterns.behavioral.observer.assignments.stock_trading_platform.services;

import low_level_design_two.design_pattterns.behavioral.observer.assignments.stock_trading_platform.Observer;
import low_level_design_two.design_pattterns.behavioral.observer.assignments.stock_trading_platform.utils.NotificationUtils;

public class AppService implements Observer {

    public void sendPush(String stockName, double currentPrice) {
        String subject = "Price update for " + stockName;
        String message = "New price is " + currentPrice;
        NotificationUtils.sendPush(subject, message);
    }

    @Override
    public void updateStockPrice(String stockName, double newPrice) {
        sendPush(stockName, newPrice);
    }
}
