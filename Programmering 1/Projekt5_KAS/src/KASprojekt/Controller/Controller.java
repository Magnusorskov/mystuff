package KASprojekt.Controller;

import KASprojekt.Model.*;
import KASprojekt.Storage.Storage;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    public static Konference createKonference(double afgift, LocalDate slut, LocalDate start, String navn, String sted, String konferenceArrangør) {
        Konference konference = new Konference(afgift, slut, start, navn, sted, konferenceArrangør);
        Storage.addKonference(konference);
        return konference;
    }

    public static Hotel createHotel(double prisEnkelt, double prisDobbelt, String navn) {
        Hotel hotel = new Hotel(prisEnkelt, prisDobbelt, navn);
        Storage.addHotel(hotel);
        return hotel;
    }

    public static Service createService(String beskrivelse, double pris, Hotel hotel) {
        return hotel.createService(beskrivelse, pris);
    }

    public static Tilmelding createTilmelding(LocalDate ankomstDato, LocalDate afrejseDato, boolean foredragsStatus, String ledsagerNavn, Deltager deltager, Hotel hotel, ArrayList<Udflugt> udflugter, ArrayList<Service> services, Konference konference) {
        return konference.createTilmelding(ankomstDato, afrejseDato, foredragsStatus, ledsagerNavn, deltager, hotel, udflugter, services);
    }

    public static Udflugt createUdflugt(String navn, double pris, LocalDate dato, Konference konference) {
        return konference.createUdflugt(navn, pris, dato);
    }

    public static Deltager createDeltager(String navn, String adresse, String landBy, String firmaNr, String firmaNavn, String tlfNr) {
        Deltager deltager = new Deltager(navn, adresse, landBy, firmaNr, firmaNavn, tlfNr);
        Storage.addDeltager(deltager);
        return deltager;
    }

    public static Deltager findDeltager(String navn) {
        ArrayList<Deltager> deltagere = new ArrayList<>(Storage.getDeltagere());
        boolean found = false;
        int i = 0;
        Deltager deltager = null;
        while (!found && i < deltagere.size()) {
            if (deltagere.get(i).getNavn().equalsIgnoreCase(navn)) {
                found = true;
                deltager = deltagere.get(i);
            } else {
                i++;
            }
        }
        return deltager;
    }

    public static void eksporterUdflugter(Konference konference) {
        String fileName = konference.getNavn() + " udflugter.txt";
        try {
            PrintWriter printWriter = new PrintWriter(fileName);
            printWriter.print(Controller.stringBuilderUdflugtsOversigt(konference));
            printWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void eksporterHoteller() {
        String fileName = "hoteller.txt";
        try {
            PrintWriter printWriter = new PrintWriter(fileName);
            printWriter.print(Controller.stringBuilderHotelOversigt());
            printWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Konference> getKonferencer() {
        return Storage.getKonferencer();
    }

    public static ArrayList<Hotel> getHoteller() {
        return Storage.getHoteller();
    }

    public static ArrayList<Deltager> getDeltagere() {
        return Storage.getDeltagere();
    }

    public static Tilmelding[] sorterDeltagere(Konference konference) {
        Tilmelding[] tilmeldinger = new Tilmelding[konference.getTilmeldinger().size()];
        for (int i = 0; i < tilmeldinger.length; i++) {
            tilmeldinger[i] = konference.getTilmeldinger().get(i);
        }

        for (int i = 1; i < tilmeldinger.length; i++) {
            Tilmelding next = tilmeldinger[i];
            int j = i;
            boolean found = false;
            while (!found && j > 0) {
                if (next.getDeltager().getNavn().compareTo(tilmeldinger[j - 1].getDeltager().getNavn()) > 0) {
                    found = true;
                } else {
                    tilmeldinger[j] = tilmeldinger[j - 1];
                    j--;
                }
            }
            tilmeldinger[j] = next;
        }
        return tilmeldinger;
    }

    public static StringBuilder stringBuilderDeltagerOversigt(Tilmelding[] tilmeldinger) {
        StringBuilder sb = new StringBuilder();
        for (Tilmelding tilmelding : tilmeldinger) {
            Deltager deltager = tilmelding.getDeltager();

            sb.append("Deltager: " + deltager.getNavn() + "( " + deltager.getTlfNr() + " )" + "\nAnkomst/afrejse dato: " +
                    tilmelding.getAnkomstDato() + " / " + tilmelding.getAfrejseDato());
            if (tilmelding.isForedragsStatus()) {
                sb.append("\nForedragsholder");
            }
            if (deltager.getFirmaNavn() != (null)) {
                sb.append("\nFirma: " + deltager.getFirmaNavn() + " (" + deltager.getFirmaNr() + ")");
            }
            sb.append("\n\n------------------\n\n");
        }
        return sb;
    }

    public static StringBuilder stringBuilderDeltagerTilmeldinger(Deltager deltager) {
        StringBuilder sb = new StringBuilder();
        for (Tilmelding tilmelding : deltager.getTilmeldinger()) {
            Konference konference = tilmelding.getKonference();
            sb.append(konference.getNavn() + "\n   Pris: " + konference.getAfgift()
                    + ",-\n   Ankomst/Afrejse: " + tilmelding.getAnkomstDato() + " / " + tilmelding.getAfrejseDato());
            if (tilmelding.getHotel() != null) {
                sb.append("\n   Hotel: " + tilmelding.getHotel().getNavn());
                if (tilmelding.getHotel().getServices() != null) {
                    for (Service service : tilmelding.getHotel().getServices()) {
                        sb.append(", " + service.getBeskrivelse());
                    }
                }
            }
            if (tilmelding.hasLedsager()) {
                sb.append("\n   Ledsager: " + tilmelding.getLedsagerNavn());
                if (tilmelding.getUdflugter() != null) {
                    sb.append("\n   Udflugter: ");
                    for (Udflugt udflugt : tilmelding.getUdflugter()) {
                        sb.append("\n       " + udflugt);
                    }
                }
            }
            if (deltager.getFirmaNavn() != (null)) {
                sb.append("\n   Firma: " + deltager.getFirmaNavn() + " (" + deltager.getFirmaNr() + ")");
            }
            sb.append("\n\n-----------------\n\n");
        }
        return sb;
    }

    public static StringBuilder stringBuilderHotelOversigt() {
        StringBuilder sb = new StringBuilder();
        ArrayList<Hotel> hoteller = Controller.getHoteller();
        for (Hotel hotel : hoteller) {
            sb.append(hotel);
            if (hotel.getServices() != null) {
                sb.append("\nServices <");
                for (Service service : hotel.getServices()) {
                    sb.append(" " + service + " ");
                }
                sb.append(">");
            }
            for (Tilmelding tilmelding : hotel.getTilmeldinger()) {
                sb.append("\n" + tilmelding.getDeltager());
                if (tilmelding.hasLedsager()) {
                    sb.append(" - Ledsager: " + tilmelding.getLedsagerNavn());
                }
                if (tilmelding.getServices() != null) {
                    for (Service service : tilmelding.getServices()) {
                        sb.append(" - " + service);
                    }
                }
                sb.append(" - (Ankomst: " + tilmelding.getAnkomstDato() + " Afrejse: " + tilmelding.getAfrejseDato() + ")\n");
            }
            sb.append("\n------------------\n");
        }
        return sb;
    }

    public static StringBuilder stringBuilderUdflugtsOversigt(Konference konference) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Udflugt> udflugter = konference.getUdflugter();

        for (Udflugt udflugt : udflugter) {
            sb.append(udflugt.getNavn() + ": " + udflugt.getPris() + ",-" + "   Dato: " + udflugt.getDato());
            for (Tilmelding tilmelding : udflugt.getTilmeldinger()) {
                sb.append("\n   " + tilmelding.getLedsagerNavn() + " ( " + tilmelding.getDeltager() + " ) ");
            }
            sb.append("\n\n------------------\n\n");
        }
        return sb;
    }

    public static StringBuilder stringBuilderTilmeldingsOversigt(Tilmelding tilmelding) {
        StringBuilder sb = new StringBuilder();

        Konference konference = tilmelding.getKonference();
        sb.append(konference.getNavn() + "\n   Ankomst/Afrejse: " + tilmelding.getAnkomstDato() + " / " + tilmelding.getAfrejseDato());
        if (tilmelding.getHotel() != null) {
            sb.append("\n   Hotel: " + tilmelding.getHotel().getNavn());
            if (tilmelding.getHotel().getServices() != null) {
                for (Service service : tilmelding.getHotel().getServices()) {
                    sb.append(", " + service.getBeskrivelse());
                }
            }
        }
        if (tilmelding.hasLedsager()) {
            sb.append("\n   Ledsager: " + tilmelding.getLedsagerNavn());
            if (tilmelding.getUdflugter() != null) {
                sb.append("\n   Udflugter: ");
                for (Udflugt udflugt : tilmelding.getUdflugter()) {
                    sb.append("\n       " + udflugt);
                }
            }
        }
        if (tilmelding.getDeltager().getFirmaNavn() != (null)) {
            sb.append("\n   Firma: " + tilmelding.getDeltager().getFirmaNavn() + " (" + tilmelding.getDeltager().getFirmaNr() + ")");
        }
        sb.append("\nTotal pris: " + tilmelding.getPrice());
        return sb;
    }
}
