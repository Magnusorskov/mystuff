package Rental;

import java.time.LocalDate;

public class Rental {
    private int number;
    private int days;
    private LocalDate startDate;

    double price;

    public Rental(int number, int days, int price, LocalDate startDate) {
        this.number = number;
        this.days = days;
        this.price = price;
        this.startDate = startDate;
    }

    public double getPrice() {
        return price;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return startDate.plusDays(days);
    }

    public double totalPrice() {
        return price * days;
    }

}
