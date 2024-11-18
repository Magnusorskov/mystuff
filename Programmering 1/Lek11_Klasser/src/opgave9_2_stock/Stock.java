package opgave9_2_stock;

public class Stock {
    private String symbol;
    private String name;
    private double previousClosingPrice;
    private double currentPrice;

    public Stock(String inputSymbol, String inputName, double inputCurrentPrice) {
        symbol = inputSymbol;
        name = inputName;
        currentPrice = inputCurrentPrice;
    }

    public double getChangePercent() {
        return (currentPrice - previousClosingPrice) / previousClosingPrice * 100;
    }

    public void setPrice(double inputCurrentPrice) {
        previousClosingPrice = currentPrice;
        currentPrice = inputCurrentPrice;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPreviousClosingPrice() {
        return previousClosingPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public String toString() {
        return "Symbol: " + symbol + "\nName: " + name + "\nPrevious Closing Price: " + previousClosingPrice +
                "\nCurrent Price: " + currentPrice + "\nChange in percent: " + getChangePercent();
    }
}
