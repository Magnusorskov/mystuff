package carRental;

public class Car {

    private String license;
    private double pricePerDay;
    private int purchaseYear;

    Car(String license, int purchaseYear) {
        this.license = license;
        this.purchaseYear = purchaseYear;
    }

    public void setDayPrice(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public double dayPrice() {
        return pricePerDay;
    }

    public String getLicense() {
        return license;
    }

    public int getPurchaseYear() {
        return purchaseYear;
    }
}
