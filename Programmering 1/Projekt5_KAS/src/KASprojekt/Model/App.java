package KASprojekt.Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Konference havOgHimmel = new Konference
                (1500, LocalDate.of(2024,12,20), LocalDate.of(2024,12,18),"Hav og Himmel",
                       "Odense Universitet","Arrangør");
        Deltager d1 = new Deltager("Finn Madsen","blob","blob","null","null","null");
        Deltager d2 = new Deltager("Niels Petersen","blob","blob","null","null","null");
        Deltager d3 = new Deltager("Peter Sommer","blob","blob","null","null","null");
        Deltager d4 = new Deltager("Lone Jensen","blob","blob","null","null","null");
        Hotel h1 = new Hotel(1050,1250,"Den Hvide Svane");
        h1.createService("Wifi",50);
        ArrayList<Service> h1Services = new ArrayList<>(h1.getServices());


        havOgHimmel.createUdflugt("Egeskov",75,LocalDate.of(2024,12,19));
        havOgHimmel.createUdflugt("Trapholt Museum, Kolding",200,LocalDate.of(2024,12,20));
        ArrayList<Udflugt> d3Test = new ArrayList<>(havOgHimmel.getUdflugter());
        havOgHimmel.createUdflugt("Byrundtur, Odense",125,LocalDate.of(2024,12,18));
        ArrayList<Udflugt> d4Test = new ArrayList<>(havOgHimmel.getUdflugter());
        d4Test.remove(1);

        havOgHimmel.createTilmelding(LocalDate.of(2024,12,18),
                LocalDate.of(2024,12,20),false,null,d1,null,new ArrayList<>(),new ArrayList<>());
        havOgHimmel.createTilmelding(LocalDate.of(2024,12,18),
                LocalDate.of(2024,12,20),false,null,d2,h1,new ArrayList<>(),new ArrayList<>());

        havOgHimmel.createTilmelding(LocalDate.of(2024,12,18),
                LocalDate.of(2024,12,20),false,"Mie Sommer",d3,h1,d3Test,h1Services);

        havOgHimmel.createTilmelding(LocalDate.of(2024,12,18),
                LocalDate.of(2024,12,20),true,"Jan Madsen",d4,h1,d4Test,h1Services);

        for (Tilmelding tilmelding : havOgHimmel.getTilmeldinger()) {
            System.out.println(tilmelding.getPrice());
        }
    }
}
