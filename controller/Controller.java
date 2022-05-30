package controller;

import internprove.*;
import storage.Storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

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

    public static void writeOptagnePladser(Parkeringshus parkeringshus, String filnavn) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(filnavn);

        try {
            for (String p : parkeringshus.optagnePladser()){
                if(p != null){
                    out.println(p);
                }
            }
        } catch (InputMismatchException inputMismatchException){
            System.out.println(inputMismatchException.getMessage());
        } finally{
            out.close();
        }

    }



    public static void initStorage(){
        Bil bil = createBil("AB 11 222");
        Bil bil2 = createBil("EF 33 444");
        Bil bil3 = createBil("BD 55 666");
        bil.setBilmærke(Bilmærke.FERRARI);
        bil2.setBilmærke(Bilmærke.HYUNDAI);
        bil3.setBilmærke(Bilmærke.MASERATI);
        Parkeringshus parkeringshus = createParkeringshus("Havengade 12, 8000 Aarhus");
        Parkeringsplads p1 = parkeringshus.createParkeringsPlads(1);
        Parkeringsplads p2 = parkeringshus.createParkeringsPlads(2);
        Parkeringsplads p3 = parkeringshus.createParkeringsPlads(3);
        p1.setBil(bil);
        p2.setBil(bil2);
        p3.setBil(bil3);

        parkeringshus.createInvalidPlads(110,18);
        String filnavn = ".\\L28-InternProve\\src\\controller\\Bilinformation.txt";
        try {
            writeOptagnePladser(parkeringshus,filnavn);
        }catch (FileNotFoundException fe){
            //blabla
        }


    }
    public static void init(){
        initStorage();
    }
}
