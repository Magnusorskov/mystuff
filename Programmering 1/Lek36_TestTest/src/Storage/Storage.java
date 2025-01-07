package Storage;

import Application.Model.Fag;
import Application.Model.Studerende;

import java.util.ArrayList;

public class Storage {
    private static ArrayList<Fag> fag = new ArrayList<>();
    private static ArrayList<Studerende> studerende = new ArrayList<>();

    public static void addFag(Fag nytFag) {
        if (!fag.contains(nytFag)) {
            fag.add(nytFag);
        }
    }

    public static void addStuderende(Studerende nyStuderende) {
        if (!studerende.contains(nyStuderende)) {
            studerende.add(nyStuderende);
        }
    }

    public static ArrayList<Fag> getFag() {
        return new ArrayList<>(fag);
    }

    public static ArrayList<Studerende> getStuderende() {
        return new ArrayList<>(studerende);
    }
}
