package Application.Application.Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Konference {
    private String navn;
    private LocalDate start;
    private LocalDate slut;
    private String sted;
    private double afgift;

    private ArrayList<Tilmelding> tilmeldinger;
    private Deltager konferenceArrangør;
    private ArrayList<Udflugt> udflugter;
    private ArrayList<Hotel> hoteller;

    public Konference(double afgift, LocalDate slut, LocalDate start, String navn, String sted) {
        this.afgift = afgift;
        this.slut = slut;
        this.start = start;
        this.navn = navn;
        this.sted = sted;

        tilmeldinger = new ArrayList<>();
        udflugter = new ArrayList<>();
        hoteller = new ArrayList<>();
    }

    public String getNavn() {
        return navn;
    }

    public ArrayList<Hotel> getHoteller() {
        return new ArrayList<>(hoteller);
    }

    public ArrayList<Udflugt> getUdflugter() {
        return new ArrayList<>(udflugter);
    }

    public Deltager getKonferenceArrangør() {
        return konferenceArrangør;
    }

    public ArrayList<Tilmelding> getTilmeldinger() {
        return new ArrayList<>(tilmeldinger);
    }

    public double getAfgift() {
        return afgift;
    }

    public String getSted() {
        return sted;
    }

    public LocalDate getSlut() {
        return slut;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setSlut(LocalDate slut) {
        this.slut = slut;
    }

    public void setSted(String sted) {
        this.sted = sted;
    }

    public void setAfgift(double afgift) {
        this.afgift = afgift;
    }

    public Tilmelding createTilmelding(LocalDate ankomstDato, LocalDate afrejseDato, boolean foredragsStatus, String ledsagerNavn, Deltager deltager, Hotel hotel, ArrayList<Udflugt> udflugter, ArrayList<Service> services) {
        Tilmelding tilmelding = new Tilmelding(ankomstDato, afrejseDato, foredragsStatus, ledsagerNavn, this, deltager, hotel, udflugter, services);
        hotel.addTilmelding(tilmelding);
        tilmeldinger.add(tilmelding);
        return tilmelding;
    }

    public Udflugt createUdflugt(String navn, double pris, LocalDate dato) {
        Udflugt udflugt = new Udflugt(navn, pris, dato, this);
        udflugter.add(udflugt);
        return udflugt;
    }

    public void addHotel(Hotel hotel) {
        if (!hoteller.contains(hotel)) {
            hoteller.add(hotel);
        }
    }

    public void setKonferenceArrangør(Deltager konferenceArrangør) {
        this.konferenceArrangør = konferenceArrangør;
    }
}