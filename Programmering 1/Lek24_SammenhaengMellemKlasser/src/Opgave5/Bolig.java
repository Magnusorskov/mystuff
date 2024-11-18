package Opgave5;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bolig {
    private int kvm;
    private String adresse;
    private int prisPrMaaned;
    private ArrayList<Lejeaftale> lejeaftaler;
    private Kollegie kollegie;

    public Bolig(int kvm, String adresse, int prisPrMaaned, Kollegie kollegie) {
        this.kvm = kvm;
        this.adresse = adresse;
        this.prisPrMaaned = prisPrMaaned;
        this.lejeaftaler = new ArrayList<>();
        setKollegie(kollegie);
    }

    public Lejeaftale createLejeaftale(LocalDate fraDato) {
        Lejeaftale lejeaftale = new Lejeaftale(fraDato,this);
        lejeaftaler.add(lejeaftale);
        return lejeaftale;
    }

    public int getKvm() {
        return kvm;
    }

    public Kollegie getKollegie() {
        return kollegie;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getPrisPrMaaned() {
        return prisPrMaaned;
    }

    public ArrayList<Lejeaftale> getLejeaftaler() {
        return new ArrayList<>(lejeaftaler);
    }

    public void setPrisPrMaaned(int prisPrMaaned) {
        this.prisPrMaaned = prisPrMaaned;
    }

    public void removeLejeaftale(Lejeaftale lejeaftale) {
        if (lejeaftaler.contains(lejeaftale)) {
            lejeaftaler.remove(lejeaftale);
        }
    }

    public void setKollegie(Kollegie kollegie) {
        if (this.kollegie != kollegie) {
            Kollegie oldKollegie = this.kollegie;
            if (oldKollegie != null) {
                oldKollegie.removeBolig(this);
            }
            this.kollegie = kollegie;
            if (kollegie != null) {
                this.kollegie.addBolig(this);
            }
        }
    }
}
