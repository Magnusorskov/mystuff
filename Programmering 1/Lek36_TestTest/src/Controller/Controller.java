package Controller;

import Application.Model.*;
import Storage.Storage;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Controller {

    public static Studerende createStuderende(String navn, String email) {
        Studerende studerende = new Studerende(navn, email);
        Storage.addStuderende(studerende);
        return studerende;
    }

    public static Fag createFag(String navn, String klasse) {
        Fag fag = new Fag(navn, klasse);
        Storage.addFag(fag);
        return fag;
    }

    public static Lektion createLektion(LocalDate dato, LocalTime startTid, String lokale, Fag fag) {
        return new Lektion(dato, startTid, lokale, fag);
    }

    public static void opretDeltagelse(Fag fag, Studerende studerende) {
        for (Lektion lektion : fag.getLektioner()) {
            lektion.createDeltagelse(studerende);
        }
    }

    public static ArrayList<Studerende> studerendeTilObservation(int grænse) {
        ArrayList<Studerende> studerende = new ArrayList<>();
        for (Studerende studerende1 : Storage.getStuderende()) {
            if (studerende1.antalFraværsLektioner() > grænse) {
                studerende.add(studerende1);
            }
        }

        for (int i = 1; i < studerende.size(); i++) {
            Studerende next = studerende.get(i);
            int j = i;
            boolean found = false;
            while (!found && j > 0) {
                if (next.getNavn().compareTo(studerende.get(j - 1).getNavn()) > 0) {
                    found = true;
                } else {
                    studerende.set(j, studerende.get(j - 1));
                    j--;
                }
            }
            studerende.set(j, next);
        }
        return studerende;
    }

    public static void fraværOmgængere(String[] omgængere, ArrayList<Studerende> megetFravær, String filNavn) {
        try {
            PrintWriter printWriter = new PrintWriter(filNavn);
            int i1 = 0;
            int i2 = 0;

            while (i1 < omgængere.length && i2 < megetFravær.size()) {
                Studerende studerende = megetFravær.get(i2);
                if (omgængere[i1].compareTo(studerende.getNavn()) < 0)
                    i1++;
                else if (omgængere[i1].compareTo(studerende.getNavn()) > 0)
                    i2++;
                else {
                    printWriter.println(studerende.getNavn() + "Antal fraværslektioner: " + studerende.antalFraværsLektioner());
                    i1++;
                    i2++;
                }
            }
            printWriter.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Fag> getFag() {
        return Storage.getFag();
    }

    public static ArrayList<Lektion> getLektioner(Fag fag) {
        return fag.getLektioner();
    }

    public static ArrayList<Deltagelse> getDeltagelser(Lektion lektion) {
        return lektion.getDeltagelser();
    }

    public static void setFravær(Deltagelse deltagelse, DeltagerStatus deltagerStatus) {
        deltagelse.setStatus(deltagerStatus);
        deltagelse.setRegistreret(true);
    }


    public static void initStorage() {
        Studerende peterHansen = createStuderende("Peter Hansen", "ph@stud.dk");
        Studerende tinaJensen = createStuderende("Tina Jensen", "tj@stud.dk");
        Studerende saschaPetersen = createStuderende("Sascha Petersen", "sp@stud.dk");

        Fag pro1 = createFag("PRO1", "20s");
        Fag pro2 = createFag("PRO1", "20T");
        Fag su1 = createFag("SU1", "20s");

        createLektion(LocalDate.of(2021, 2, 1), LocalTime.of(8, 30), "A1.32", pro1);
        createLektion(LocalDate.of(2021, 2, 1), LocalTime.of(10, 30), "A1.32", pro1);
        createLektion(LocalDate.of(2021, 2, 3), LocalTime.of(8, 30), "A1.32", pro1);
        createLektion(LocalDate.of(2021, 2, 3), LocalTime.of(10, 30), "A1.32", pro1);

        opretDeltagelse(pro1, peterHansen);
        opretDeltagelse(pro1, tinaJensen);
        opretDeltagelse(pro1, saschaPetersen);
    }
}
