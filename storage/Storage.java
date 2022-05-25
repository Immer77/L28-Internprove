package storage;

import internprove.Bil;
import internprove.Parkeringshus;

import java.util.ArrayList;

public class Storage {
    private static ArrayList<Parkeringshus> parkeringshuses = new ArrayList<>();
    private static ArrayList<Bil> biler = new ArrayList<>();

    public static ArrayList<Parkeringshus> getParkeringshuse(){
        return new ArrayList<>(parkeringshuses);
    }
    public static void addParkeringshus(Parkeringshus parkeringshus){
        parkeringshuses.add(parkeringshus);
    }

    //_______________________________________

    public static ArrayList<Bil> getBiler(){
        return new ArrayList<>(biler);
    }

    public static void addBil(Bil bil){
        biler.add(bil);
    }
}
