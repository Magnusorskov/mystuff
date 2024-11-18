package Opgave1;

import java.util.ArrayList;

public class Car {

    private String license;
    private double pricePerDay;
    private int purchaseYear;
    private ArrayList<Rental> rentals;

    public Car(String license, int purchaseYear) {
        this.license = license;
        this.purchaseYear = purchaseYear;
        this.rentals = new ArrayList<>();
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

    public void addRental(Rental rental) {
        if (!rentals.contains(rental)) {
            this.rentals.add(rental);
            rental.addCar(this);
        }
    }

    public void removeRental(Rental rental) {
        if (rentals.contains(rental)) {
            this.rentals.remove(rental);
            rental.removeCar(this);
        }
    }

    public int maxDaysRented() {
        int maxDays = -1;
        for (Rental rental : rentals) {
            if (rental.getDays() > maxDays) {
                maxDays = rental.getDays();
            }
        }
        return maxDays;
    }

    public ArrayList<Rental> getRentals() {
        return new ArrayList<>(rentals);
    }
}
