package controller;

import internprove.Bil;
import internprove.Invalideplads;
import internprove.Parkeringshus;
import internprove.Parkeringsplads;
import storage.Storage;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Controller {

    public static Parkeringshus createParkeringshus(String adresse) {
        Parkeringshus parkeringshus = new Parkeringshus(adresse);
        Storage.addParkeringshus(parkeringshus);
        return parkeringshus;
    }

    public static ArrayList<Parkeringshus> getParkeringshuse(){
        return Storage.getParkeringshuse();
    }


    public static Bil createBil(String regnr){
        Bil bil = new Bil(regnr);
        Storage.addBil(bil);
        return bil;
    }

    public static ArrayList<Bil> getBiler(){
        return Storage.getBiler();
    }



    public static void initStorage(){
        Bil bil = createBil("AB 11 222");
        Bil bil2 = createBil("EF 33 444");
        Bil bil3 = createBil("BD 55 666");
        Parkeringshus parkeringshus = createParkeringshus("Havengade 12, 8000 Aarhus");
        Parkeringsplads p1 = parkeringshus.createParkeringsPlads(1);
        Parkeringsplads p2 = parkeringshus.createParkeringsPlads(2);
        Parkeringsplads p3 = parkeringshus.createParkeringsPlads(3);
        p1.setBil(bil);
        p2.setBil(bil2);
        p3.setBil(bil3);

        parkeringshus.createInvalidPlads(110,18);

    }
    public static void init(){
        initStorage();
    }
}
