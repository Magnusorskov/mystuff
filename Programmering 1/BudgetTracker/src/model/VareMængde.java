package model;

public class VareMængde {
    private int antal;
    private double kilo;
    private double kiloPris;
    private Vare vare;
    private boolean økologisk;
    private double pris;

    public VareMængde(int antal, double kilo, Vare vare, boolean økologisk, double pris) {
        this.antal = antal;
        this.kilo = kilo;
        this.vare = vare;
        this.økologisk = økologisk;
        this.pris = pris;
        this.kiloPris = pris / kilo;
    }

    public int getAntal() {
        return antal;
    }

    public double getKilo() {
        return kilo;
    }

    public double getKiloPris() {
        return kiloPris;
    }

    public Vare getVare() {
        return vare;
    }

    public boolean isØkologisk() {
        return økologisk;
    }

    public double getPris() {
        return pris;
    }

    public void setVare(Vare vare) {
        this.vare = vare;
    }

    public void setAntal(int antal) {
        this.antal = antal;
    }

    public void setKilo(double kilo) {
        this.kilo = kilo;
    }

    public void setØkologisk(boolean økologisk) {
        this.økologisk = økologisk;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }
}
