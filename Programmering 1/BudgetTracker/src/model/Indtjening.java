package model;

import java.time.LocalDate;

public class Indtjening extends Transaktion{

    private boolean gentagende;
    private Bruger bruger;

    public Indtjening(String beskrivelse, double beløb, LocalDate dato, boolean gentagende, Bruger bruger) {
        super(beskrivelse, beløb, dato);
        this.gentagende = gentagende;
        this.bruger = bruger;
    }

    public boolean isGentagende() {
        return gentagende;
    }

    public void setGentagende(boolean gentagende) {
        this.gentagende = gentagende;
    }

    public Bruger getBruger() {
        return bruger;
    }

    public void setBruger(Bruger bruger) {
        this.bruger = bruger;
    }
}
