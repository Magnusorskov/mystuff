package KASprojekt.Gui;

import KASprojekt.Controller.Controller;
import KASprojekt.Model.*;
import javafx.application.Application;

import java.time.LocalDate;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        initStorage();
        Application.launch(StartWindow.class);
    }
    /**
     * Initializes the storage with some objects.
     */
    public static void initStorage() {
        Konference k1 = Controller.createKonference(1500, LocalDate.of(2024, 12, 20), LocalDate.of(2024, 12, 18), "Hav og Himmel",
                "Odense Universitet", "Arrangør");

        Deltager d1 = Controller.createDeltager("Finn Madsen", "blob", "blob", "304452", "VelByg", "22243532");
        Deltager d2 = Controller.createDeltager("Niels Petersen", "blob", "blob", null, null, "93857229");
        Deltager d3 = Controller.createDeltager("Peter Sommer", "blob", "blob", null, null, "39284993");
        Deltager d4 = Controller.createDeltager("Lone Jensen", "blob", "blob", null, null, "32423444");
        Hotel h1 = Controller.createHotel(1050, 1250, "Den Hvide Svane");
        Controller.createService("Wifi", 50, h1);

        ArrayList<Service> h1Services = new ArrayList<>(h1.getServices());


        Udflugt u1 = Controller.createUdflugt("Egeskov", 75, LocalDate.of(2024, 12, 19), k1);
        Udflugt u2 = Controller.createUdflugt("Trapholt Museum, Kolding", 200, LocalDate.of(2024, 12, 20), k1);
        ArrayList<Udflugt> test = new ArrayList<>();

        Udflugt u3 = Controller.createUdflugt("Byrundtur, Odense", 125, LocalDate.of(2024, 12, 18), k1);
        test.add(u1);
        test.add(u2);
        test.add(u3);


        Controller.createTilmelding(LocalDate.of(2024, 12, 18),
                LocalDate.of(2024, 12, 20), false, "Karsten Jensen", d1, null, test, new ArrayList<>(), k1);
        Controller.createTilmelding(LocalDate.of(2024, 12, 18),
                LocalDate.of(2024, 12, 20), false, "Magnus Ørskov", d2, h1, test, new ArrayList<>(), k1);

        Controller.createTilmelding(LocalDate.of(2024, 12, 18),
                LocalDate.of(2024, 12, 20), false, "Mie Sommer", d3, h1, test, h1Services, k1);

        Controller.createTilmelding(LocalDate.of(2024, 12, 18),
                LocalDate.of(2024, 12, 20), true, "Jan Madsen", d4, h1, test, h1Services, k1);

        Konference k2 = Controller.createKonference(2000, LocalDate.of(2025, 1, 10), LocalDate.of(2025, 1, 8), "Softwareudvikling",
                "Aarhus Universitet", "IT-foreningen");

        Deltager d5 = Controller.createDeltager("Anna Nielsen", "adresse1", "by1", "12345678", "Firma A", "11111111");
        Deltager d6 = Controller.createDeltager("Bo Jensen", "adresse2", "by2", "87654321", "Firma B", "22222222");
        Deltager d7 = Controller.createDeltager("Carla Hansen", "adresse3", "by3", "null", "null", "33333333");

        Hotel h2 = Controller.createHotel(900, 1100, "Hotel Central");
        Controller.createService("Morgenmad", 100, h2);
        ArrayList<Service> h2Services = new ArrayList<>(h2.getServices());

        Udflugt u4 = Controller.createUdflugt("Aros Kunstmuseum", 50, LocalDate.of(2025, 1, 9), k2);
        Udflugt u5 = Controller.createUdflugt("Den Gamle By", 150, LocalDate.of(2025, 1, 10), k2);
        ArrayList<Udflugt> test2 = new ArrayList<>();
        test2.add(u4);
        test2.add(u5);

        Controller.createTilmelding(LocalDate.of(2025, 1, 8),
                LocalDate.of(2025, 1, 10), true, "Jens Jensen", d5, h2, test2, h2Services, k2);
        Controller.createTilmelding(LocalDate.of(2025, 1, 8),
                LocalDate.of(2025, 1, 9), false, "Lars Larsen", d6, null, new ArrayList<>(), new ArrayList<>(), k2);
        Controller.createTilmelding(LocalDate.of(2025, 1, 9),
                LocalDate.of(2025, 1, 10), false, "Peter Petersen", d7, h2, test2, new ArrayList<>(), k2);

        Konference k3 = Controller.createKonference(1000, LocalDate.of(2024, 11, 15), LocalDate.of(2024, 11, 13), "Cybersikkerhed",
                "København", "Security Group");

        Deltager d8 = Controller.createDeltager("David Olsen", "adresse4", "by4", "45678901", "Firma C", "44444444");
        Deltager d9 = Controller.createDeltager("Eva Madsen", "adresse5", "by5", "null", "null", "55555555");

        Hotel h3 = Controller.createHotel(1200, 1400, "Grand Hotel");
        Controller.createService("Spa", 200, h3);
        Controller.createService("Massage", 300, h3);
        ArrayList<Service> h3Services = new ArrayList<>(h3.getServices());

        Udflugt u6 = Controller.createUdflugt("Tivoli", 100, LocalDate.of(2024, 11, 14), k3);
        ArrayList<Udflugt> test3 = new ArrayList<>();
        test3.add(u6);

        Controller.createTilmelding(LocalDate.of(2024, 11, 13),
                LocalDate.of(2024, 11, 15), false, "Pia Petersen", d8, h3, test3, h3Services, k3);
        Controller.createTilmelding(LocalDate.of(2024, 11, 14),
                LocalDate.of(2024, 11, 15), true, "Charlie charliesen", d9, null, new ArrayList<>(), new ArrayList<>(), k3);
    }
}
