package Opgaver_02;

public class AverageSpeedInMiles {
    public static void main (String[] args) {
        System.out.println("First we convert kilometers to miles by dividing by 1.64");
        System.out.println(15 / 1.6);
        System.out.println("Then we calculate how many hours 50 minutes and 30 seconds are");
        System.out.println(50.5 / 60);
        System.out.println("Then we divide miles with hours spent running");
        System.out.println((15 / 1.6) / (50.5 / 60));
    }
}
