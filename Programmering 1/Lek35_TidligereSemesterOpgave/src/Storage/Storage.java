package Storage;

import Model.Salg;
import Model.Sælger;
import Model.Vare;

import java.util.ArrayList;

public class Storage {

    private static ArrayList<Sælger> sælgere = new ArrayList<>();
    private static ArrayList<Vare> varer = new ArrayList<>();
    private static ArrayList<Salg> salg = new ArrayList<>();

    public static ArrayList<Sælger> getSælgere() {
        return new ArrayList<>(sælgere);
    }

    public static ArrayList<Vare> getVarer() {
        return new ArrayList<>(varer);
    }

    public static ArrayList<Salg> getSalg() {
        return new ArrayList<>(salg);
    }

    public static void addSælger(Sælger sælger) {
        if (!sælgere.contains(sælger)) {
            sælgere.add(sælger);
        }
    }

    public static void addVare(Vare vare) {
        if (!varer.contains(vare)) {
            varer.add(vare);
        }
    }

    public static void addSalg(Salg nytSalg) {
        if(!salg.contains(nytSalg)) {
            salg.add(nytSalg);
        }
    }
}
