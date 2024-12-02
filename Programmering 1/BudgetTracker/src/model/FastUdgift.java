package model;

import java.time.LocalDate;

public class FastUdgift extends Transaktion{
    private LocalDate forfaldsDato;
    private int frekvens;

    public FastUdgift(String beskrivelse, double beløb, LocalDate dato, int frekvens, LocalDate forfaldsDato) {
        super(beskrivelse, beløb, dato);
        this.frekvens = frekvens;
        this.forfaldsDato = forfaldsDato;
    }

    public LocalDate getForfaldsDato() {
        return forfaldsDato;
    }

    public void setForfaldsDato(LocalDate forfaldsDato) {
        this.forfaldsDato = forfaldsDato;
    }

    public int getFrekvens() {
        return frekvens;
    }

    public void setFrekvens(int frekvens) {
        this.frekvens = frekvens;
    }
}

