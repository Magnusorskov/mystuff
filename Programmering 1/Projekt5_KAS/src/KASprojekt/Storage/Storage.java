package KASprojekt.Storage;

import KASprojekt.Model.Deltager;
import KASprojekt.Model.Hotel;
import KASprojekt.Model.Konference;

import java.util.ArrayList;

public class Storage {

    private static ArrayList<Konference> konferencer = new ArrayList<>();
    private static ArrayList<Deltager> deltagere = new ArrayList<>();
    private static ArrayList<Hotel> hoteller = new ArrayList<>();

    public static ArrayList<Konference> getKonferencer() {
        return new ArrayList<>(konferencer);
    }

    public static ArrayList<Deltager> getDeltagere() {
        return new ArrayList<>(deltagere);
    }

    public static ArrayList<Hotel> getHoteller() {
        return new ArrayList<>(hoteller);
    }

    public static void addKonference(Konference konference) {
        if (!konferencer.contains(konference)) {
            konferencer.add(konference);
        }
    }

    public static void addDeltager(Deltager deltager) {
        if (!deltagere.contains(deltager)) {
            deltagere.add(deltager);
        }
    }

    public static void addHotel(Hotel hotel) {
        if (!hoteller.contains(hotel)) {
            hoteller.add(hotel);
        }
    }
}
