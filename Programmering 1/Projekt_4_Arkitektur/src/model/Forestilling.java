package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Forestilling {
    private String navn;
    private LocalDate startDato;
    private LocalDate slutDato;
    private ArrayList<Bestilling> bestillinger = new ArrayList<>();

    public Forestilling(String navn, LocalDate startDato, LocalDate slutDato) {
        this.navn = navn;
        this.startDato = startDato;
        this.slutDato = slutDato;
    }

    public String getNavn() {
        return navn;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }

    public Bestilling createBestilling(LocalDate dato, Kunde kunde) {
        Bestilling bestilling = new Bestilling(dato, this, kunde);
        bestillinger.add(bestilling);
        kunde.addBestilling(bestilling);
        return bestilling;
    }

    public void removeBestilling(Bestilling bestilling) {
        if (bestillinger.contains(bestilling)) {
            bestillinger.remove(bestilling);
            bestilling.getKunde().removeBestilling(bestilling);
        }
    }

    public ArrayList<Bestilling> getBestillinger() {
        return new ArrayList<>(bestillinger);
    }

    @Override
    public String toString() {
        return navn + " (fra " + startDato + " til " + slutDato + ")";
    }

    public boolean erPladsLedig(int række, int nr, LocalDate dato) {
        boolean ledig = true;
        int i = 0;
        while (ledig && i < bestillinger.size()) {
            Bestilling bestilling = bestillinger.get(i);
            if (bestilling.getDato().equals(dato)) {
                int j = 0;
                while (j < bestilling.getPladser().size() && ledig) {
                    Plads plads = bestilling.getPladser().get(j);
                    if (plads.getRække() == række && plads.getNr() == nr) {
                        ledig = false;
                    }
                    j++;
                }
            }
            i++;
        }
        return ledig;
    }

    public int antalBestiltePladserPåDag(LocalDate dato) {
        int sum = 0;
        for (Bestilling bestilling : bestillinger) {
            if (bestilling.getDato().equals(dato)) {
                sum += bestilling.getPladser().size();
            }
        }
        return sum;
    }

    public LocalDate succesDato() {
        LocalDate dato = null;
        int sum = Integer.MIN_VALUE;
        long dageImellem = ChronoUnit.DAYS.between(startDato, slutDato);

        for (int i = 0; i <= dageImellem; i++) {
            if (antalBestiltePladserPåDag(startDato.plusDays(i)) > sum) {
                dato = startDato.plusDays(i);
                sum = antalBestiltePladserPåDag(startDato.plusDays(i));
            }
        }
        return dato;
    }
}
