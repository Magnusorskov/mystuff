package Model;

public class Vare {
    private Varekategori kategori;
    private String navn;
    private int udbudspris;
    private boolean solgt;
    private Salgsannoce salgsannoce;

    public Vare(Varekategori kategori, String navn, int udbudspris) {
        this.navn = navn;
        this.kategori = kategori;
        this.udbudspris = udbudspris;
        this.solgt = false;
    }


    public void setSalgsannoce(Salgsannoce salgsannoce) {
        if (salgsannoce != this.salgsannoce) {
            Salgsannoce oldSalgsAnnonce = this.salgsannoce;
            if (oldSalgsAnnonce != null) {
                oldSalgsAnnonce.removeVare(this);
            }
            this.salgsannoce = salgsannoce;
            if (salgsannoce != null) {
                salgsannoce.addVare(this);
            }
        }
    }

    public void setSolgt(boolean solgt) {
        this.solgt = solgt;
    }

    public Varekategori getKategori() {
        return kategori;
    }

    public String getNavn() {
        return navn;
    }

    public int getUdbudspris() {
        return udbudspris;
    }

    public boolean isSolgt() {
        return solgt;
    }

    public Salgsannoce getSalgsannoce() {
        return salgsannoce;
    }
}
