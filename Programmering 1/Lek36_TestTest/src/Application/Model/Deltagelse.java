package Application.Model;

public class Deltagelse {

    private DeltagerStatus status;
    private boolean registreret;
    private Lektion lektion;
    private Studerende studerende;

    Deltagelse(Lektion lektion, Studerende studerende) {
        this.registreret = false;
        this.status = DeltagerStatus.TILSTEDE;
        this.lektion = lektion;
        this.studerende = studerende;
    }

    public DeltagerStatus getStatus() {
        return status;
    }

    public Studerende getStuderende() {
        return studerende;
    }

    public Lektion getLektion() {
        return lektion;
    }

    public boolean isRegistreret() {
        return registreret;
    }

    public boolean erRegistreretFraværende() {
        boolean fraværende = false;
        if (status != DeltagerStatus.TILSTEDE && registreret) {
            fraværende = true;
        }
        return fraværende;
    }

    public void setStatus(DeltagerStatus status) {
        this.status = status;
    }

    public void setRegistreret(boolean registreret) {
        this.registreret = registreret;
    }

    @Override
    public String toString() {
        return studerende.getNavn() + " " + registreret + " " + status;
    }
}
