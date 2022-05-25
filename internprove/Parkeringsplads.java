package internprove;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Parkeringsplads {
    private int nummer;
    private LocalTime ankomst;
    private Bil bil;
    private Parkeringshus parkeringshus;

    public Parkeringsplads(int nummer, Parkeringshus parkeringshus){
        this.nummer = nummer;
        ankomst = null;
        this.parkeringshus = parkeringshus;
    }

    public int getNummer() {
        return nummer;
    }

    public LocalTime getAnkomst() {
        return ankomst;
    }

    public Bil getBil() {
        return bil;
    }
    public void setBil(Bil bil){
        if(this.bil != bil){
            this.bil = bil;
            this.ankomst = LocalTime.now();
        }
    }

    public Parkeringshus getParkeringshus() {
        return parkeringshus;
    }

    public double beregnPPris(LocalTime afgang){
        double prisForParkering = 0.0;
        final int tiMinPris = 6;
        long minutes = 0;
        if(this.ankomst.isBefore(afgang)){
            minutes = ChronoUnit.MINUTES.between(this.ankomst,afgang);
        }

        return (minutes/10) * tiMinPris;
    }
    public void hentBil(LocalTime afgangstidspunkt){
        double pris = beregnPPris(afgangstidspunkt);
        this.bil = null;
        parkeringshus.setSaldo(pris);
    }
}
