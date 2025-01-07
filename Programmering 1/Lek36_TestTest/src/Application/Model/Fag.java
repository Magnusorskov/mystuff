package Application.Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Fag {

    private String navn;
    private String klasse;
    private ArrayList<Lektion> lektioner;

    public Fag(String navn, String klasse) {
        this.navn = navn;
        this.klasse = klasse;
        lektioner = new ArrayList<>();
    }

    public String getNavn() {
        return navn;
    }

    public String getKlasse() {
        return klasse;
    }

    public ArrayList<Lektion> getLektioner() {
        return new ArrayList<>(lektioner);
    }

    public void addLektion(Lektion lektion) {
        if (!lektioner.contains(lektion)) {
            lektioner.add(lektion);
        }
    }

    public void removeLektion(Lektion lektion) {
        if (lektioner.contains(lektion)) {
            lektioner.remove(lektion);
        }
    }

    //antaget at lektioner er sorteret efter dato, så når jeg laver nye lektioner skal de faktisk sorteres, det skulle bare have været et for each loop
    public ArrayList<Studerende> sygdomPåDato(LocalDate dato) {
        ArrayList<Studerende> sygeStuderende = new ArrayList<>();
        Lektion lektion = null;

        int i = 0;
        LocalDate tempDate = lektioner.get(i).getDato();
        while (!tempDate.isAfter(dato) && i < lektioner.size()) {
            if (lektioner.get(i).getDato().equals(dato)) {
                ArrayList<Deltagelse> deltagelser = new ArrayList<>(lektioner.get(i).getDeltagelser());
                for (Deltagelse deltagelse : deltagelser) {
                    if (deltagelse.getStatus().equals(DeltagerStatus.SYG) && !sygeStuderende.contains(deltagelse.getStuderende())) {
                        sygeStuderende.add(deltagelse.getStuderende());
                    } else {
                        i++;
                    }
                }
            }
        }
        return sygeStuderende;
    }

    public Lektion mestFravær() {
        Lektion lektion = null;
        int maxFraværsSum = 0;

        for (Lektion lektion1 : lektioner) {
            int fraværsSum = 0;
            for (Deltagelse deltagelse : lektion1.getDeltagelser()) {
                if (deltagelse.erRegistreretFraværende()) {
                    fraværsSum++;
                }
            }
            if (fraværsSum > maxFraværsSum) {
                lektion = lektion1;
            }
        }
        return lektion;
    }

    @Override
    public String toString() {
        return navn + " " + klasse;
    }
}
