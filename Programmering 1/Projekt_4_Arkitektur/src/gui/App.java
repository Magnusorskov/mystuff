package gui;

import controller.Controller;
import javafx.application.Application;
import model.Forestilling;
import model.Kunde;
import model.Plads;
import model.PladsType;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        initStorage();
        testPrint();
        Application.launch(StartWindow.class);

    }

    private static void initStorage() {
        Controller.createForestilling("Evita", LocalDate.of(2023, 8, 10), LocalDate.of(2023, 8, 20));
        Controller.createForestilling("Lykke Per", LocalDate.of(2023, 9, 1), LocalDate.of(2023, 9, 10));
        Controller.createForestilling("Chess", LocalDate.of(2023, 8, 21), LocalDate.of(2023, 8, 30));

        Controller.createKunde("Anders Hansen", "11223344");
        Controller.createKunde("Peter Jensen", "12345678");
        Controller.createKunde("Niels Madsen", "12341234");

        for (int i = 1; i < 16; i++) {
            for (int j = 1; j < 21; j++) {
                int pris = 400;
                PladsType pladsType = PladsType.STANDARD;

                if (i < 6) {
                    if (j < 3 || j > 18) {
                        pris = 450;
                    } else {
                        pris = 500;
                    }
                } else if (i < 11) {
                    if (j < 3 || j > 18) {
                        pris = 400;
                    } else if (j > 7 && j < 13 && i == 10) {
                        pris = 450;
                        pladsType = PladsType.KØRESTOL;
                    } else {
                        pris = 450;
                    }
                } else if (i == 11 && j > 7 && j < 13) {
                    pladsType = PladsType.EKSTRABEN;
                }
                Controller.createPlads(i, j, pris, pladsType);
            }
        }
    }

    private static void testPrint() {
        ArrayList<Forestilling> forestillinger = Controller.getForestillinger();
        ArrayList<Kunde> Kunder = Controller.getKunder();
        ArrayList<Plads> Pladser = Controller.getPladser();

        System.out.println("---------- Forestillinger ----------");
        for (Forestilling f : forestillinger) {
            System.out.println("Name: " + f.getNavn() + " Start date: " + f.getStartDato() + " End date: " + f.getSlutDato());
        }
        System.out.println("---------- Kunder ----------");
        for (Kunde k : Kunder) {
            System.out.println("Name: " + k.getNavn() + " Mobil: " + k.getMobil());
        }
        System.out.println("---------- Pladser ----------");
        for (Plads p : Pladser) {
            System.out.println("Række: " + p.getRække() + " Nr.: " + p.getNr() + " Price: " + p.getPris() + " Plads type: " + p.getPladsType());
        }
    }
}
