package Application.Model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Lektion {

    private LocalDate dato;
    private LocalTime startTid;
    private String lokale;
    private ArrayList<Deltagelse> deltagelser;

    public Lektion(LocalDate dato, LocalTime startTid, String lokale, Fag fag) {
        this.dato = dato;
        this.startTid = startTid;
        this.lokale = lokale;
        this.deltagelser = new ArrayList<>();
        fag.addLektion(this);
    }

    public LocalDate getDato() {
        return dato;
    }

    public LocalTime getStartTid() {
        return startTid;
    }

    public String getLokale() {
        return lokale;
    }


    public Deltagelse createDeltagelse(Studerende studerende) {
        Deltagelse deltagelse = new Deltagelse(this, studerende);
        this.deltagelser.add(deltagelse);
        studerende.addDeltagelse(deltagelse);
        return deltagelse;
    }


    public ArrayList<Deltagelse> getDeltagelser() {
        return new ArrayList<>(deltagelser);
    }

    @Override
    public String toString() {
        return dato + " " + startTid + " " + lokale;
    }
}
