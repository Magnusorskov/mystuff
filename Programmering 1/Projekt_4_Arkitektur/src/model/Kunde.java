package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Kunde {
    private String navn;
    private String mobil;
    private ArrayList<Bestilling> bestillinger = new ArrayList<>();

    public Kunde(String navn, String mobil) {
        this.navn = navn;
        this.mobil = mobil;
    }

    public String getNavn() {
        return navn;
    }

    public String getMobil() {
        return mobil;
    }

    public Bestilling addBestilling(Bestilling bestilling) {
        if (!bestillinger.contains(bestilling)) {
            bestillinger.add(bestilling);
        }
        return bestilling;
    }

    public void removeBestilling(Bestilling bestilling) {
        if (bestillinger.contains(bestilling)) {
            bestillinger.remove(bestilling);
        }
    }

    public ArrayList<Bestilling> getBestillinger() {
        return new ArrayList<>(bestillinger);
    }

    @Override
    public String toString() {
        return navn + "(" + mobil + ")";
    }

    public ArrayList<Plads> bestiltePladserTilForestilling(Forestilling forestilling, LocalDate dato) {
        ArrayList<Plads> pladser = new ArrayList<>();
        for (Bestilling bestilling : bestillinger) {
            if (dato.equals(bestilling.getDato()) && forestilling == bestilling.getForestilling()) {
                pladser.addAll(bestilling.getPladser());
            }
        }
        return pladser;
    }
}
