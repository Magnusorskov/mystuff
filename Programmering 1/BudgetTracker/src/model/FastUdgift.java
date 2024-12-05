package model;

import java.time.LocalDate;

public class FastUdgift extends Transaktion{
    private LocalDate forfaldsDato;
    private int betalingsFrekvens;

    public FastUdgift(String beskrivelse, double beløb, LocalDate dato, int betalingsFrekvens, LocalDate forfaldsDato) {
        super(beskrivelse, beløb, dato);
        this.betalingsFrekvens = betalingsFrekvens;
        this.forfaldsDato = forfaldsDato;
    }

    public LocalDate getForfaldsDato() {
        return forfaldsDato;
    }

    public void setForfaldsDato(LocalDate forfaldsDato) {
        this.forfaldsDato = forfaldsDato;
    }

    public int getBetalingsFrekvens() {
        return betalingsFrekvens;
    }

    public void setBetalingsFrekvens(int betalingsFrekvens) {
        this.betalingsFrekvens = betalingsFrekvens;
    }

}

