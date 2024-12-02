package Application.Application.Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Tilmelding {
    private LocalDate ankomstDato;
    private LocalDate afrejseDato;
    private boolean foredragsStatus;
    private String ledsagerNavn = null;
    private Deltager deltager;

    private ArrayList<Udflugt> udflugter;
    private ArrayList<Service> services;
    private Konference konference;
    private Hotel hotel;

    Tilmelding(LocalDate ankomstDato, LocalDate afrejseDato, boolean foredragsStatus, String ledsagerNavn, Konference konference, Deltager deltager, Hotel hotel, ArrayList<Udflugt> udflugter, ArrayList<Service> services) {
        this.ankomstDato = ankomstDato;
        this.afrejseDato = afrejseDato;
        this.foredragsStatus = foredragsStatus;
        this.ledsagerNavn = ledsagerNavn;
        setHotel(hotel);
        setDeltager(deltager);
        this.udflugter = udflugter;
        this.services = services;
    }

    public void setUdflugter(ArrayList<Udflugt> udflugter) {
        this.udflugter = udflugter;
        for (Udflugt udflugt : udflugter) {
            udflugt.addTilmelding(this);
        }
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
        hotel.addTilmelding(this);
    }

    public void setServices(ArrayList<Service> services) {
        this.services = services;
    }

    public boolean hasLedsager() {
        boolean hasLedsager = true;
        if (ledsagerNavn == null) {
            hasLedsager = false;
        }
        return hasLedsager;
    }

    public double getPrice() {
        double price = 0;
        if (hotel != null) {
            if (hasLedsager()) {
                price += hotel.getPrisDobbelt();
            } else {
                price += hotel.getPrisEnkelt();
            }
            for (Service service : services) {
                price += service.getPris();
            }
        }
        if (hasLedsager()) {
            for (Udflugt udflugt : udflugter) {
                price += udflugt.getPris();
            }
        }
        price += this.konference.getAfgift() * (getAntalDage() + 1);

        return price;
    }

    public int getAntalDage() {
        return afrejseDato.compareTo(ankomstDato);
    }

    public void setDeltager(Deltager deltager) {
        this.deltager = deltager;
        deltager.addTilmelding(this);
    }

}
