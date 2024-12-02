package Application.Application.Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Udflugt {
    private String navn;
    private double pris;
    private LocalDate dato;

    private ArrayList<Tilmelding> tilmeldinger;

    public Udflugt(String navn, double pris, LocalDate dato, Konference konference) {
        this.navn = navn;
        this.pris = pris;
        this.dato = dato;
    }

    public void addTilmelding(Tilmelding tilmelding){
            tilmeldinger.add(tilmelding);
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
}
