package Rental;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class RentalApp {

    public static void main(String[] args) {
        Rental rent1 = new Rental(1,3,400, LocalDate.of(2024,11,1));
        Rental rent2 = new Rental(2,3,10000,LocalDate.now().plusMonths(10));

        System.out.println("Rental 1:");
        System.out.println(rent1.getPrice());
        System.out.println(rent1.getEndDate());
        System.out.println(rent1.getStartDate().minusDays(1));

        System.out.println();

        System.out.println("Rental 2:");
        System.out.println(rent2.getPrice());
        System.out.println(rent2.getEndDate());
        System.out.println(rent2.getStartDate().minusDays(1));

        LocalDate dat1 = rent1.getStartDate();
        LocalDate dat2 = rent2.getStartDate();
        Period per = dat1.until(dat2);
        long days = per.getDays();
        long months = per.getMonths();
        long years = per.getYears();

        System.out.println(per);
        System.out.println(
                "Fra " + dat1 + " til " + dat2 + " er der " + years + " år " + months + " måneder "
                        + days + " dage");
        days = ChronoUnit.DAYS.between(dat1, dat2);
        System.out.println(days);


    }
}
