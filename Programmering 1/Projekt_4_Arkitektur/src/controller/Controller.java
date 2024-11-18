package controller;

import model.*;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {
    public static Forestilling createForestilling(String navn, LocalDate startDato, LocalDate slutDato) {
        Forestilling forestilling = new Forestilling(navn, startDato, slutDato);
        Storage.addForestilling(forestilling);
        return forestilling;
    }

    public static Kunde createKunde(String navn, String mobil) {
        Kunde kunde = new Kunde(navn, mobil);
        Storage.addKunde(kunde);
        return kunde;
    }

    public static Plads createPlads(int række, int nr, int pris, PladsType pladsType) {
        Plads plads = new Plads(række, nr, pris, pladsType);
        Storage.addPlads(plads);
        return plads;
    }

    public static ArrayList<Forestilling> getForestillinger() {
        return Storage.getForestillinger();
    }

    public static ArrayList<Kunde> getKunder() {
        return Storage.getKunder();
    }

    public static ArrayList<Plads> getPladser() {
        return Storage.getPladser();
    }

    public static Bestilling opretBestillingMedPladser(
            Forestilling forestilling, Kunde kunde,
            LocalDate dato, ArrayList<Plads> pladser) {

        Bestilling result = null;
        if (!dato.isBefore(forestilling.getStartDato()) && !dato.isAfter(forestilling.getSlutDato())) {
            boolean pladserErLedig = true;
            int i = 0;
            while (pladserErLedig && i < pladser.size()) {
                Plads plads = pladser.get(i);
                if (!forestilling.erPladsLedig(plads.getRække(), plads.getNr(), dato)) {
                    pladserErLedig = false;
                }
                i++;
            }
            if (pladserErLedig) {
                result = forestilling.createBestilling(dato, kunde);
                for (Plads plads : pladser) {
                    result.addPlads(plads);
                }
            }
        }
        return result;
    }

}
