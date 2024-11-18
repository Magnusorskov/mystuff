package Opgave5;

import java.time.LocalDate;

public class Lejeaftale {
    private LocalDate fraDato;
    private LocalDate tilDato;
    private Lejer lejer1;
    private Lejer lejer2;
    private Bolig bolig;

    Lejeaftale(LocalDate fraDato, Bolig bolig) {
        this.fraDato = fraDato;
        this.bolig = bolig;
    }

    public LocalDate getFraDato() {
        return fraDato;
    }

    public LocalDate getTilDato() {
        return tilDato;
    }

    public Lejer getLejer1() {
        return lejer1;
    }

    public Lejer getLejer2() {
        return lejer2;
    }

    public Bolig getBolig() {
        return bolig;
    }


    public void setTilDato(LocalDate tilDato) {
        this.tilDato = tilDato;
    }

    public void setFraDato(LocalDate fraDato) {
        this.fraDato = fraDato;
    }

    public void setLejer1(Lejer lejer1) {
        if (lejer1 == null) {
            this.lejer1 = this.lejer2;
            this.lejer2 = null;
        }
        else if (getLejer2() != lejer1) {
            this.lejer1 = lejer1;
        }
    }

    public void setLejer2(Lejer lejer2) {
        if (getLejer1() == null) {
            this.lejer1 = lejer2;
        } else if (getLejer1() != lejer2) {
            this.lejer2 = lejer2;
            }
        }


}

