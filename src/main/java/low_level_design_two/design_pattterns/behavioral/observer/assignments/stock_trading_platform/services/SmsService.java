package low_level_design_two.design_pattterns.behavioral.observer.assignments.stock_trading_platform.services;

import low_level_design_two.design_pattterns.behavioral.observer.assignments.stock_trading_platform.Observer;
import low_level_design_two.design_pattterns.behavioral.observer.assignments.stock_trading_platform.utils.NotificationUtils;

public class SmsService implements Observer {

    public void sendSMS(String stockName, double currentPrice) {
        String subject = "Price update for " + stockName;
        String message = "New price is " + currentPrice;
        NotificationUtils.sendSms(subject, message);
    }

    @Override
    public void updateStockPrice(String stockName, double newPrice) {
        sendSMS(stockName, newPrice);
    }
}