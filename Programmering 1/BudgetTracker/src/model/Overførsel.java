package model;

import java.time.LocalDate;

public class Overførsel extends Transaktion {
    private Konto modtagerKonto;

    Overførsel(String beskrivelse, double beløb, LocalDate dato, Konto modtagerKonto) {
        super(beskrivelse, beløb, dato);
        this.modtagerKonto = modtagerKonto;
    }
}
