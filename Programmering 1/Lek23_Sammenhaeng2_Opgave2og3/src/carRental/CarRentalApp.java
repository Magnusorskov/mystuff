package carRental;

public class CarRentalApp {
    public static void main(String[] args) {
        Car car1 = new Car("ABC123", 2018);
        car1.setDayPrice(45.0);

        Car car2 = new Car("DEF456", 2020);
        car2.setDayPrice(50.0);

        Car car3 = new Car("GHI789", 2015);
        car3.setDayPrice(40.0);

        Car car4 = new Car("JKL012", 2019);
        car4.setDayPrice(47.5);

        Car car5 = new Car("MNO345", 2021);
        car5.setDayPrice(55.0);

        Rental r1 = new Rental(1,"04/11/2024",50);
        Rental r2 = new Rental(2,"01/11/2024",10);

        r1.addCar(car1);
        r1.addCar(car2);
        r1.addCar(car3);
        r1.addCar(car4);
        r1.addCar(car5);

        r2.addCar(car1);
        r2.addCar(car2);
        r2.addCar(car3);
        r2.addCar(car4);
        r2.addCar(car5);

        System.out.println(r2.getPrice());
    }
}
