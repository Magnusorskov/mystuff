package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Konto {
    private String navn;
    private double saldo = 0;
    private ArrayList<Transaktion> transaktioner;

    Konto(String navn, double saldo) {
        this.navn = navn;
        this.saldo = saldo;
    }

//    private Transaktion createTransaktion(String beskrivelse, double beløb, LocalDate dato) {
//
//    }

}
