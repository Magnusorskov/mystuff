package Opgave5;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
      Lejer lejer = new Lejer("Magnus","blabla");
      Kollegie kollegie = new Kollegie("Bla","Bla");
      Bolig bolig1 = kollegie.createBolig(30,"bla",30);
      Lejeaftale lejeaftale1 = bolig1.createLejeaftale(LocalDate.of(2023,1,1));
      lejeaftale1.setTilDato(LocalDate.of(2023,1,10));
      Lejeaftale lejeaftale2 = bolig1.createLejeaftale(LocalDate.of(2023,1,1));
      lejeaftale2.setTilDato(LocalDate.of(2023,1,10));
      System.out.println(kollegie.antalLejeaftaler());
        System.out.println(kollegie.gennemsnitligAntalDage());

    }
}
