package model;


import java.time.LocalDate;
import java.util.Date;

public class Transaktion {
    private LocalDate dato;
    private double beløb;
    private String beskrivelse;

    Transaktion(String beskrivelse, double beløb, LocalDate dato) {
        this.beskrivelse = beskrivelse;
        this.beløb = beløb;
        this.dato = dato;
    }

    public LocalDate getDato() {
        return dato;
    }

    public double getBeløb() {
        return beløb;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }
}
