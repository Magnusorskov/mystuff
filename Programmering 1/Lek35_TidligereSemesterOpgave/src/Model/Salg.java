package Model;

import java.util.ArrayList;

public class Salg {
    private String købersNavn;
    private int aftaltSamletPris;
    private ArrayList<Vare> varer;

    public Salg (String købersNavn, int aftaltSamletPris, ArrayList<Vare> varer) {
        this.købersNavn = købersNavn;
        this.aftaltSamletPris = aftaltSamletPris;
        this.varer = varer;
        for (Vare vare : varer) {
            vare.setSolgt(true);
        }
        varer.getFirst().getSalgsannoce().opdatereAktivStatus();
    }

    public String getKøbersNavn() {
        return købersNavn;
    }

    public int getAftaltSamletPris() {
        return aftaltSamletPris;
    }

    public ArrayList<Vare> getVarer() {
        return new ArrayList<>(varer);
    }

    @Override
    public String toString() {
        return "Salg{" +
                "aftaltSamletPris=" + aftaltSamletPris +
                ", varer=" + varer +
                '}';
    }
}
