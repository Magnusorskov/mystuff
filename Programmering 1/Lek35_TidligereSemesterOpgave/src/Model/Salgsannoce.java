package Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Salgsannoce {
    private static int antalAnnoncer;
    private int annonceNummer;
    private boolean aktiv;
    private LocalDate udløbsdato;
    private Sælger sælger;
    private ArrayList<Vare> varer;

    public Salgsannoce(Sælger sælger) {
        this.annonceNummer = antalAnnoncer;
        antalAnnoncer++;
        this.aktiv = true;
        this.udløbsdato = LocalDate.now().plusMonths(1);
        this.sælger = sælger;
        sælger.addSalgsAnnonce(this);
        this.varer = new ArrayList<>();
    }

    public Sælger getSælger() {
        return sælger;
    }

    public ArrayList<Vare> getVarer() {
        return new ArrayList<>(varer);
    }

    public static int getAntalAnnoncer() {
        return antalAnnoncer;
    }

    public static void setAntalAnnoncer(int antalAnnoncer) {
        Salgsannoce.antalAnnoncer = antalAnnoncer;
    }

    public int getAnnonceNummer() {
        return annonceNummer;
    }

    public void setAnnonceNummer(int annonceNummer) {
        this.annonceNummer = annonceNummer;
    }

    public boolean isAktiv() {
        return aktiv;
    }

    public void setAktiv(boolean aktiv) {
        this.aktiv = aktiv;
    }

    public LocalDate getUdløbsdato() {
        return udløbsdato;
    }

    public void setUdløbsdato(LocalDate udløbsdato) {
        this.udløbsdato = udløbsdato;
    }

    public void addVare(Vare vare) {
        if (!varer.contains(vare)) {
            varer.add(vare);
            vare.setSalgsannoce(this);
        }
    }

    public void removeVare(Vare vare) {
        if (varer.contains(vare)) {
            varer.remove(vare);
            vare.setSalgsannoce(null);
        }
    }

    public int samletAnnonceUdbud() {
        int sum = 0;

        for (Vare vare : varer) {
            sum += vare.getUdbudspris();
        }
        return sum;
    }

    public void opdatereAktivStatus() {
        if (LocalDate.now().isAfter(udløbsdato)) {
            this.aktiv = false;
        }
        if (aktiv) {
            int i = 0;
            boolean skalDeaktiveres = true;
            while (skalDeaktiveres && i < varer.size()) {
                if (!varer.get(i).isSolgt()) {
                    skalDeaktiveres = false;
                } else {
                    i++;
                }
            }
        }
    }
}
