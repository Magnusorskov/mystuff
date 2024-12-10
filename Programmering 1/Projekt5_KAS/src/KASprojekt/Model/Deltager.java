package KASprojekt.Model;

import java.util.ArrayList;

public class Deltager {
    private String navn, adresse,landBy,firmaNr, firmaNavn,tlfNr;
    private ArrayList<Tilmelding> tilmeldinger;

    public Deltager(String navn, String adresse, String landBy, String firmaNr, String firmaNavn, String tlfNr) {
        this.navn = navn;
        this.adresse = adresse;
        this.landBy = landBy;
        this.firmaNr = firmaNr;
        this.firmaNavn = firmaNavn;
        this.tlfNr = tlfNr;
        tilmeldinger = new ArrayList<>();
    }

    public String getNavn() {
        return navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getLandBy() {
        return landBy;
    }

    public String getFirmaNr() {
        return firmaNr;
    }

    public String getFirmaNavn() {
        return firmaNavn;
    }

    public String getTlfNr() {
        return tlfNr;
    }

    public ArrayList<Tilmelding> getTilmeldinger() {
        return new ArrayList<>(tilmeldinger);
    }

    public void addTilmelding(Tilmelding tilmelding) {
        if (!tilmeldinger.contains(tilmelding)) {
            tilmeldinger.add(tilmelding);
            tilmelding.setDeltager(this);
        }
    }

    public String toString() {
        return navn + "  Tlfnr: " + tlfNr;
    }

    public double sumAfTilmeldinger(Deltager deltager) {
        ArrayList<Tilmelding> tilmeldinger = deltager.getTilmeldinger();
        double result = 0;

        for (Tilmelding tilmelding : tilmeldinger) {
            result += tilmelding.getPrice();
        }
        return result;
    }
}
