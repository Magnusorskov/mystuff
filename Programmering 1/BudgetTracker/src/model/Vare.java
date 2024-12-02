package model;

public class Vare {
    private double typiskKGPris;
    private String navn;
    private VareType type;

    public Vare(double typiskKGPris, String navn) {
        this.typiskKGPris = typiskKGPris;
        this.navn = navn;
    }

    public double getTypiskKGPris() {
        return typiskKGPris;
    }

    public void setTypiskKGPris(double typiskKGPris) {
        this.typiskKGPris = typiskKGPris;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public VareType getType() {
        return type;
    }

    public void setType(VareType type) {
        this.type = type;
    }
}
