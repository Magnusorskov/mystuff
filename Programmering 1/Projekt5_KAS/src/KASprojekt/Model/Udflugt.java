package KASprojekt.Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Udflugt {
    private String navn;
    private double pris;
    private LocalDate dato;

    private ArrayList<Tilmelding> tilmeldinger;

    Udflugt(String navn, double pris, LocalDate dato) {
        this.navn = navn;
        this.pris = pris;
        this.dato = dato;
        tilmeldinger = new ArrayList<>();
    }

    public void addTilmelding(Tilmelding tilmelding) {
        if (!tilmeldinger.contains(tilmelding)) {
            tilmeldinger.add(tilmelding);
        }
    }

    public String getNavn() {
        return navn;
    }

    public double getPris() {
        return pris;
    }

    public LocalDate getDato() {
        return dato;
    }

    public ArrayList<Tilmelding> getTilmeldinger() {
        return new ArrayList<>(tilmeldinger);
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    @Override
    public String toString() {
        return navn + "(" + pris + ",- " + dato + ")";
    }
}
