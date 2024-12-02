package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Indkøb extends Transaktion{

    private ArrayList<VareMængde> varer;

    public Indkøb(String beskrivelse, double beløb, LocalDate dato, ArrayList<VareMængde> varer) {
        super(beskrivelse, beløb, dato);
        this.varer = varer;
    }

    private double pris(ArrayList<VareMængde> varer) {
        double sum = 0;
        for (VareMængde vare : varer) {
            sum += vare.getPris();
        }
        return sum;
    }

    public ArrayList<VareMængde> getVarer() {
        return new ArrayList<>(varer);
    }
}
