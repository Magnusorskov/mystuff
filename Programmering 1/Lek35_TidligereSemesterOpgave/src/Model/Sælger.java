package Model;

import java.util.ArrayList;

public class Sælger {
    private String navn;
    private int studiekortNummer;
    private String mobil;
    private ArrayList<Salgsannoce> salgsAnnoncer;

    public Sælger(String navn, int studiekortNummer, String mobil) {
        this.navn = navn;
        this.studiekortNummer = studiekortNummer;
        this.mobil = mobil;
        this.salgsAnnoncer = new ArrayList<>();
    }

    public void setSalgsAnnoncer(ArrayList<Salgsannoce> salgsAnnoncer) {
        this.salgsAnnoncer = salgsAnnoncer;
    }

    public String getNavn() {
        return navn;
    }

    public int getStudiekortNummer() {
        return studiekortNummer;
    }

    public String getMobil() {
        return mobil;
    }

    public void addSalgsAnnonce(Salgsannoce salgsannoce) {
        if (!salgsAnnoncer.contains(salgsannoce)) {
            salgsAnnoncer.add(salgsannoce);
        }
    }

    public ArrayList<Salgsannoce> getSalgsAnnoncer() {
        return new ArrayList<>(salgsAnnoncer);
    }

    public ArrayList<Vare> alleIkkeSolgteVarerIKategori(Varekategori varekategori) {
        ArrayList<Vare> varer = new ArrayList<>();

        for (Salgsannoce salgsannoce : salgsAnnoncer) {
            for (Vare vare : salgsannoce.getVarer()) {
                if (vare.getKategori().equals(varekategori) && !vare.isSolgt()) {
                    varer.add(vare);
                }
            }
        }
        return varer;
    }
}
