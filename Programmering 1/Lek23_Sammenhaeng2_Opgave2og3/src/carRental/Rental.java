package carRental;

import java.util.ArrayList;

public class Rental {

    private int number;
    private int days;
    private String date;
    private ArrayList<Car> cars;

    Rental(int number, String date, int days) {
        this.number = number;
        this.date = date;
        this.days = days;
        this.cars = new ArrayList<>();
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void addCar(Car car) {
        this.cars.add(car);
    }

    public double getPrice() {
        double sum = 0;
        for (Car car: cars) {
            sum += car.dayPrice();
        }
        return sum * days;
    }
}
