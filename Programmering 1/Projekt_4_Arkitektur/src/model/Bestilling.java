package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bestilling {
    private LocalDate dato;
    private Forestilling forestilling;
    private Kunde kunde;
    private ArrayList<Plads> pladser = new ArrayList<>();

    Bestilling(LocalDate dato, Forestilling forestilling, Kunde kunde) {
        this.dato = dato;
        this.forestilling = forestilling;
        this.kunde = kunde;

    }

    public LocalDate getDato() {
        return dato;
    }

    public Forestilling getForestilling() {
        return forestilling;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public Plads addPlads(Plads plads) {
        if (!pladser.contains(plads)) {
            pladser.add(plads);
        }
        return plads;
    }

    public void removePlads(Plads plads) {
        if (pladser.contains(plads)) {
            pladser.remove(plads);
        }
    }

    public ArrayList<Plads> getPladser() {
        return new ArrayList<>(pladser);
    }

    @Override
    public String toString() {
        return "Bestilling{" +
                "dato=" + dato +
                ", forestilling=" + forestilling +
                ", kunde=" + kunde +
                ", pladser=" + pladser +
                '}';
    }

    public int samletPris() {
        int sum = 0;
        for (Plads plads : pladser) {
            sum += plads.getPris();
        }
        return sum;
    }


}
