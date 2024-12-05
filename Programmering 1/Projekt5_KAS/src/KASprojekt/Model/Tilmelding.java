package KASprojekt.Model;

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

    Tilmelding(LocalDate ankomstDato, LocalDate afrejseDato, boolean foredragsStatus, String ledsagerNavn, Konference konference, Deltager deltager, Hotel hotel,ArrayList<Udflugt> udflugter, ArrayList<Service> services) {
        this.ankomstDato = ankomstDato;
        this.afrejseDato = afrejseDato;
        this.foredragsStatus = foredragsStatus;
        this.ledsagerNavn = ledsagerNavn;
        setHotel(hotel);
        setDeltager(deltager);
        initUdflugter(udflugter);
        initService(services);
        this.konference = konference;

    }

    public void initUdflugter(ArrayList<Udflugt> udflugter) {
        this.udflugter = new ArrayList<>();
        for (Udflugt udflugt : udflugter) {
            addUdluft(udflugt);
        }

    }

    public void setHotel(Hotel hotel) {
        if (hotel != null) {
            this.hotel = hotel;
        }
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
        int antalDage = getAntalDage();
        if (hotel != null) {
            if (hasLedsager()) {
                price += hotel.getPrisDobbelt() * antalDage;
            } else {
                price += hotel.getPrisEnkelt() * antalDage;
            }
            for (Service service : services) {
                price += service.getPris() * antalDage;
            }
        }
        if (hasLedsager()) {
            for (Udflugt udflugt : udflugter) {
                price += udflugt.getPris();
            }
        }
        if (!foredragsStatus) {
            price += this.konference.getAfgift() * (antalDage + 1);
        }

        return price;
    }

    public int getAntalDage() {
        return afrejseDato.compareTo(ankomstDato);
    }

    public void setDeltager(Deltager deltager) {
        this.deltager = deltager;
        deltager.addTilmelding(this);
    }
    public void addService (Service service) {
        if (!services.contains(service)) {
            services.add(service);
        }
    }

    public void addUdluft (Udflugt udflugt) {
        if (!udflugter.contains(udflugt)) {
            udflugter.add(udflugt);
            udflugt.addTilmelding(this);
        }
    }
    private void initService(ArrayList<Service> services) {
        this.services = new ArrayList<>();
        for (Service service : services) {
            addService(service);
        }
    }

    public Deltager getDeltager() {
        return deltager;
    }

    public String getLedsagerNavn() {
        return ledsagerNavn;
    }

    public ArrayList<Service> getServices() {
        return new ArrayList<>(services);
    }

    public LocalDate getAnkomstDato() {
        return ankomstDato;
    }

    public LocalDate getAfrejseDato() {
        return afrejseDato;
    }
}
