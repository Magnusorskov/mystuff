package storage;

import model.Forestilling;
import model.Kunde;
import model.Plads;

import java.util.ArrayList;

public class Storage {

    private static ArrayList<Forestilling> forestillinger = new ArrayList<>();
    private static ArrayList<Kunde> kunder = new ArrayList<>();
    private static ArrayList<Plads> pladser = new ArrayList<>();

    public static ArrayList<Forestilling> getForestillinger() {
        return new ArrayList<>(forestillinger);
    }

    public static ArrayList<Kunde> getKunder() {
        return new ArrayList<>(kunder);
    }

    public static ArrayList<Plads> getPladser() {
        return new ArrayList<>(pladser);
    }

    public static Forestilling addForestilling(Forestilling forestilling) {
        if (!forestillinger.contains(forestilling)) {
            forestillinger.add(forestilling);
        }
        return forestilling;
    }

    public static Kunde addKunde(Kunde kunde) {
        if (!kunder.contains(kunde)) {
            kunder.add(kunde);
        }
        return kunde;
    }

    public static Plads addPlads(Plads plads) {
        if (!pladser.contains(plads)) {
            pladser.add(plads);
        }
        return plads;
    }
}
