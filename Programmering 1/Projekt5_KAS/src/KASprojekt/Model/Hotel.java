package KASprojekt.Model;

import java.util.ArrayList;

public class Hotel {
    private double prisEnkelt;
    private double prisDobbelt;
    private String navn;

    private ArrayList<Service> services;
    private ArrayList<Tilmelding> tilmeldinger;

    public Hotel(double prisEnkelt, double prisDobbelt, String navn) {
        this.prisEnkelt = prisEnkelt;
        this.prisDobbelt = prisDobbelt;
        this.navn = navn;
        services = new ArrayList<>();
        tilmeldinger = new ArrayList<>();
    }

    public Service createService(String beskrivelse, double pris){
        Service service = new Service(beskrivelse,pris);
        services.add(service);
        return service;
    }

    public void addTilmelding(Tilmelding tilmelding){
        if (!tilmeldinger.contains(tilmelding)) {
            tilmeldinger.add(tilmelding);
            tilmelding.setHotel(this);
        }
    }

    public void removeTilmelding(Tilmelding tilmelding) {
        if (tilmeldinger.contains(tilmelding)) {
            tilmeldinger.remove(tilmelding);
            tilmelding.setHotel(null);
        }
    }

    public double getPrisEnkelt() {
        return prisEnkelt;
    }

    public double getPrisDobbelt() {
        return prisDobbelt;
    }

    public String getNavn() {
        return navn;
    }

    public ArrayList<Service> getServices() {
        return new ArrayList<>(services);
    }

    public ArrayList<Tilmelding> getTilmeldinger() {
        return new ArrayList<>(tilmeldinger);
    }

    @Override
    public String toString() {
        return navn + ": " + "Enkelt/Dobbelt pris " + prisEnkelt + "/" + prisDobbelt;
    }
}
