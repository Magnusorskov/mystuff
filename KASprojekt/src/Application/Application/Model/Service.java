package Application.Application.Model;

public class Service {
    private String beskrivelse;
    private double pris;


    Service(String beskrivelse, double pris) {
        this.beskrivelse = beskrivelse;
        this.pris = pris;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }
}
