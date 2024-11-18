package Opgave5;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Kollegie {
    private String name;
    private String adresse;
    private ArrayList<Bolig> boliger;

    public Kollegie(String name, String adresse) {
        this.name = name;
        this.adresse = adresse;
        this.boliger = new ArrayList<>();
    }

    public Bolig createBolig(int kvm, String adresse, int prisPrMaaned) {
        Bolig bolig = new Bolig(kvm, adresse, prisPrMaaned, this);
        addBolig(bolig);
        return bolig;
    }

    public void addBolig(Bolig bolig) {
        if (!boliger.contains(bolig)) {
            boliger.add(bolig);
            bolig.setKollegie(this);
        }
    }

    public String getName() {
        return name;
    }

    public String getAdresse() {
        return adresse;
    }

    public ArrayList<Bolig> getBoliger() {
        return boliger;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void removeBolig(Bolig bolig) {
        if (boliger.contains(bolig)) {
            boliger.remove(bolig);
        }
    }

    public int antalLejeaftaler() {
        int antalLejeaftaler = 0;
        for (Bolig bolig : boliger) {
            antalLejeaftaler += bolig.getLejeaftaler().size();
            }
        return antalLejeaftaler;
    }

    public double gennemsnitligAntalDage() {
        double antalLejeaftaler = 0;
        int dageCount = 0;
        for (Bolig bolig : boliger) {
            for (Lejeaftale lejeaftale : bolig.getLejeaftaler()) {
                if (lejeaftale.getTilDato() != null) {
                    antalLejeaftaler++;
                    dageCount += (int) ChronoUnit.DAYS.between(lejeaftale.getFraDato(), lejeaftale.getTilDato());
                }
            }
        }
        return dageCount / antalLejeaftaler;
    }
}
