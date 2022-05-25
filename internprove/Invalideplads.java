package internprove;

public class Invalideplads extends Parkeringsplads{
    private double areal;

    public Invalideplads(int nummer, Parkeringshus parkeringshus, double areal) {
        super(nummer, parkeringshus);
        this.areal = areal;
    }

//    public Invalideplads(int nummer, double areal) {
//        super(nummer);
//        this.areal = areal;
//    }

    public double getAreal() {
        return areal;
    }
}
