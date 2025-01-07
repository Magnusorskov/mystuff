package Controller;

import Model.*;
import Storage.Storage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;

public class Controller {

    public static Salg createSalg(String købersNavn, int aftaltSamletPris, ArrayList<Vare> varer) {
        Salg salg = new Salg(købersNavn, aftaltSamletPris, varer);
        Storage.addSalg(salg);
        return salg;
    }

    public static Salgsannoce createSalgsAnnonce(Sælger sælger) {
        return new Salgsannoce(sælger);
    }

    public static Sælger createSælger (String navn, int studiekortNummer, String mobil) {
        Sælger sælger = new Sælger(navn, studiekortNummer, mobil);
        Storage.addSælger(sælger);
        return sælger;
    }

    public static Vare createVare (Varekategori kategori, String navn, int udbudspris) {
        Vare vare = new Vare(kategori, navn, udbudspris);
        Storage.addVare(vare);
        return vare;
    }

    public static void salgTilFil(String filNavn) {
        try {
            PrintWriter printWriter = new PrintWriter(filNavn);
            ArrayList<Salg> salgListe = Storage.getSalg();
            salgListe.sort(Comparator.comparing(Salg::getKøbersNavn));

            for (Salg salg : salgListe) {
                printWriter.println(salg.getKøbersNavn() + ":");
                int sum = 0;
                for (Vare vare : salg.getVarer()) {
                    printWriter.println(vare.getNavn() + "  " + vare.getUdbudspris());
                    sum += vare.getUdbudspris();
                }
                printWriter.println("Aftalt pris: " + salg.getAftaltSamletPris() + "   " + "rabat er: " + (sum - salg.getAftaltSamletPris()) + "\n");
            }
            printWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public static void initStorage() {
        Sælger viktor = Controller.createSælger("Viktor",23,"45344247");
        Sælger gustav = Controller.createSælger("Gustav",35,"56124522");
        Vare iPhone = Controller.createVare(Varekategori.MOBILTELEFON,"Iphone",2000);
        Vare samsungMobil = Controller.createVare(Varekategori.MOBILTELEFON,"Samsung mobil",1200);
        Vare java = Controller.createVare(Varekategori.STUDIEBOG,"Java",400);
        Vare android = Controller.createVare(Varekategori.STUDIEBOG,"Android",300);
        Vare Python = Controller.createVare(Varekategori.STUDIEBOG,"Python",200);
        Vare regnjakke = Controller.createVare(Varekategori.TØJ,"Regnjakke",100);
        Vare regnbukser = Controller.createVare(Varekategori.TØJ,"Regnbukser",80);
        Salgsannoce salgsannoceV1 = Controller.createSalgsAnnonce(viktor);
        salgsannoceV1.addVare(samsungMobil);
        Salgsannoce salgsannoceV2 = Controller.createSalgsAnnonce(viktor);
        salgsannoceV2.addVare(java);
        salgsannoceV2.addVare(android);
        salgsannoceV2.addVare(Python);
        Salgsannoce salgsannoceG1 = Controller.createSalgsAnnonce(gustav);
        salgsannoceG1.addVare(iPhone);
        Salgsannoce salgsannoceG2 = Controller.createSalgsAnnonce(gustav);
        salgsannoceG2.addVare(regnbukser);
        salgsannoceG2.addVare(regnjakke);
        ArrayList<Vare> stinesKøb = new ArrayList<>();
        stinesKøb.add(android);
        stinesKøb.add(Python);
        ArrayList<Vare> laurasKøb = new ArrayList<>();
        laurasKøb.add(regnjakke);
        laurasKøb.add(regnbukser);

        Controller.createSalg("Stine",450,stinesKøb);
        Controller.createSalg("Laura",120,laurasKøb);


    }
}

