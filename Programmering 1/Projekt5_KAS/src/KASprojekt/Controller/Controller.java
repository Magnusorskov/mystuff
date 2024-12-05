package KASprojekt.Controller;

import KASprojekt.Model.*;
import KASprojekt.Storage.Storage;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Controller {

    public static Konference createKonference(double afgift, LocalDate slut, LocalDate start, String navn, String sted, String konferenceArrangør) {
        Konference konference = new Konference(afgift, slut, start, navn, sted, konferenceArrangør);
        Storage.addKonference(konference);
        return konference;
    }

    public static Hotel createHotel(double prisEnkelt, double prisDobbelt, String navn) {
        Hotel hotel = new Hotel(prisEnkelt, prisDobbelt, navn);
        Storage.addHotel(hotel);
        return hotel;
    }

    public static Service createService(String beskrivelse, double pris, Hotel hotel) {
        return hotel.createService(beskrivelse, pris);
    }

    public static Tilmelding createTilmelding(LocalDate ankomstDato, LocalDate afrejseDato, boolean foredragsStatus, String ledsagerNavn, Deltager deltager, Hotel hotel, ArrayList<Udflugt> udflugter, ArrayList<Service> services, Konference konference) {
        return konference.createTilmelding(ankomstDato, afrejseDato, foredragsStatus, ledsagerNavn, deltager, hotel, udflugter, services);
    }

    public static Udflugt createUdflugt(String navn, double pris, LocalDate dato, Konference konference) {
        return konference.createUdflugt(navn, pris, dato);
    }

    public static Deltager createDeltager(String navn, String adresse, String landBy, String firmaNr, String firmaNavn, String tlfNr) {
        Deltager deltager = new Deltager(navn, adresse, landBy, firmaNr, firmaNavn, tlfNr);
        Storage.addDeltager(deltager);
        return deltager;
    }

    public Deltager findDeltager(String navn) {
        ArrayList<Deltager> deltagere = new ArrayList<>(Storage.getDeltagere());
        boolean found = false;
        int i = 0;
        Deltager deltager = null;
        while (!found && i < deltagere.size()) {
            if (deltagere.get(i).getNavn().equalsIgnoreCase(navn)) {
                found = true;
                deltager = deltagere.get(i);
            } else {
                i++;
            }
        }
        return deltager;
    }

    public static void eksporterUdflugter(Konference konference) {
        String fileName = konference.getNavn() + " udflugter.txt";
        try {
            PrintWriter printWriter = new PrintWriter(fileName);
            ArrayList<Udflugt> udflugter = konference.getUdflugter();
            printWriter.println(konference.getNavn());

            for (Udflugt udflugt : udflugter) {
                printWriter.println("\n" + udflugt.getNavn() + ": " + udflugt.getPris() + ",-" + " Dato: " + udflugt.getDato());
                for (Tilmelding tilmelding : udflugt.getTilmeldinger()) {
                    printWriter.println(tilmelding.getLedsagerNavn() + "(" + tilmelding.getDeltager() + "), ");
                }
                printWriter.print("------------------\n");
            }
            printWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void eksporterHoteller() {
        String fileName = "hoteller.txt";
        try {
            PrintWriter printWriter = new PrintWriter(fileName);
            ArrayList<Hotel> hoteller = Storage.getHoteller();

            for (Hotel hotel : hoteller) {
                printWriter.print(hotel);
                if (hotel.getServices() != null) {
                    printWriter.print(" Services <");
                    for (Service service : hotel.getServices()) {
                        printWriter.print(" " + service + " ");
                    }
                    printWriter.print(">");
                }
                for (Tilmelding tilmelding : hotel.getTilmeldinger()) {
                    printWriter.println("\n" + tilmelding.getDeltager());
                    if (tilmelding.hasLedsager()) {
                        printWriter.print(" - Ledsager: " + tilmelding.getLedsagerNavn());
                    }
                    if (tilmelding.getServices() != null) {
                        for (Service service : tilmelding.getServices()) {
                            printWriter.print(" - " + service);
                        }
                    }
                    printWriter.print(" - (Ankomst: " + tilmelding.getAnkomstDato() + " Afrejse: " + tilmelding.getAfrejseDato() + ")\n");
                }
                printWriter.print("\n------------------\n");
            }
            printWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
