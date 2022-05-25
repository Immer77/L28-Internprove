package internprove;

import java.time.LocalTime;
import java.util.ArrayList;

public class Parkeringshus {
    private String adresse;
    private final ArrayList<Parkeringsplads> parkeringspladser = new ArrayList<>();
    private final ArrayList<Invalideplads> invalidepladser = new ArrayList<>();
    private double saldo;

    public Parkeringshus(String adresse){
        this.adresse = adresse;
    }

    public String getAdresse() {
        return adresse;
    }
    public ArrayList<Parkeringsplads> getParkeringspladser(){
        return new ArrayList<>(parkeringspladser);
    }
    public Parkeringsplads createParkeringsPlads(int nummer){
        Parkeringsplads parkeringsplads = new Parkeringsplads(nummer, this);
        parkeringspladser.add(parkeringsplads);
        return parkeringsplads;
    }

    public Invalideplads createInvalidPlads(int nummer, int areal){
        Invalideplads invalideplads = new Invalideplads(nummer,this,areal);
        invalidepladser.add(invalideplads);
        return invalideplads;
    }
    public void removeParkeringsplads(Parkeringsplads parkeringsplads){
        if(parkeringspladser.contains(parkeringsplads)){
            parkeringspladser.remove(parkeringsplads);
        }
    }

    // Opgave 2
    public int antalLedigePladser(ArrayList<Parkeringsplads> pladser){
        int amountAvaiblePSpots = 0;
        for (Parkeringsplads p : pladser){
            if(p.getBil() == null){
                amountAvaiblePSpots++;
            }
        }
        return amountAvaiblePSpots;
    }

    public int findPladsMedBil(String regNummer){
        int indeks = -1;
        int i = 0;
        while (indeks == -1 && i < parkeringspladser.size()){
            String k = parkeringspladser.get(i).getBil().getRegNr();
            if(k.equals(regNummer)){
                indeks = i;
            }else{
                i++;
            }

        }
        return indeks;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo += saldo;
    }

    public int findAntalBiler(Bilmærke bilmærke){
        int counter = 0;
        for(Parkeringsplads p : parkeringspladser){
            if(p.getBil().getBilmærke().equals(bilmærke)){
                counter++;
            }
        }
        return counter;
    }

    public ArrayList<String> optagnePladser(){
        ArrayList<String> optagetPladser = new ArrayList<>();
        for(Parkeringsplads p : parkeringspladser){
            if(p.getBil() != null){
                optagetPladser.add(p.getBil().getRegNr());
            }
        }
        return optagetPladser;
    }

}
