

import java.util.*;


interface PriceObserver {
    void update(String stockName, double newPrice);
}


interface StockNotifier {
    void addSubscriber(PriceObserver observer);
    void removeSubscriber(PriceObserver observer);
    void notifySubscribers();
}


class StockMarket implements StockNotifier {
    List<PriceObserver> subscribers = new ArrayList<>();
    String stockSymbol;
    private double stockPrice;

    public StockMarket(String stockSymbol, double initialPrice) {
        this.stockSymbol = stockSymbol;
        this.stockPrice = initialPrice;
    }

    public void setPrice(double newPrice) {
        System.out.println("\n[Market] " + stockSymbol + " updated to INR" + newPrice);
        this.stockPrice = newPrice;
        notifySubscribers();
    }

    @Override
    public void addSubscriber(PriceObserver observer) {
        subscribers.add(observer);
    }

    @Override
    public void removeSubscriber(PriceObserver observer) {
        subscribers.remove(observer);
    }

    @Override
    public void notifySubscribers() {
        for (PriceObserver observer : subscribers) {
            observer.update(stockSymbol, stockPrice);
        }
    }
}

class MobileAppClient implements PriceObserver {
    String user;

    public MobileAppClient(String user) {
        this.user = user;
    }

    @Override
    public void update(String stockName, double newPrice) {
        System.out.println("[Mobile] Hey " + user + ", " + stockName + " is now INR" + newPrice);
    }
}


class WebAppClient implements PriceObserver {
    String sessionId;

    public WebAppClient(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public void update(String stockName, double newPrice) {
        System.out.println("[Web] Session " + sessionId + ": " + stockName + " updated to INR" + newPrice);
    }
}


public class StockObserverPattern {
    public static void main(String[] args) {
        
        StockMarket reliance = new StockMarket("RELIANCE", 2450.50);

        
        PriceObserver mobileUser = new MobileAppClient("Amit");
        PriceObserver webUser = new WebAppClient("WEB-101");

        
        reliance.addSubscriber(mobileUser);
        reliance.addSubscriber(webUser);

        
        reliance.setPrice(2480.75);
        reliance.setPrice(2510.25);

        
        reliance.removeSubscriber(webUser);

        
        reliance.setPrice(2550.00);
    }
}
