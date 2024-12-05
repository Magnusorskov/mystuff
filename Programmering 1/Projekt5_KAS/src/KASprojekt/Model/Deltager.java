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

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setFirmaNr(String firmaNr) {
        this.firmaNr = firmaNr;
    }

    public void setLandBy(String landBy) {
        this.landBy = landBy;
    }

    public void setFirmaNavn(String firmaNavn) {
        this.firmaNavn = firmaNavn;
    }

    public void setTlfNr(String tlfNr) {
        this.tlfNr = tlfNr;
    }

    public void addTilmelding(Tilmelding tilmelding) {
        if (!tilmeldinger.contains(tilmelding)) {
            tilmeldinger.add(tilmelding);
            tilmelding.setDeltager(this);
        }
    }

    public String toString() {
        return "Deltager: " + navn + " Tlfnr: " + tlfNr;
    }
}
