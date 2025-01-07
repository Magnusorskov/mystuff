package Application.Model;

import java.util.ArrayList;

public class Studerende {
    private String navn;
    private String email;
    private ArrayList<Deltagelse> deltagelser;

    public Studerende(String navn, String email) {
        this.navn = navn;
        this.email = email;
        this.deltagelser = new ArrayList<>();
    }

    public String getNavn() {
        return navn;
    }

    public String getEmail() {
        return email;
    }

    public void addDeltagelse(Deltagelse deltagelse) {
        if (!deltagelser.contains(deltagelse)) {
            deltagelser.add(deltagelse);
        }
    }

    public int antalFraværsLektioner() {
        int sum = 0;
        for (Deltagelse deltagelse : deltagelser) {
            if (deltagelse.erRegistreretFraværende()) {
                sum++;
            }
        }
        return sum;
    }
}
