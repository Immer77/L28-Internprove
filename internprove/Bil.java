package internprove;

public class Bil {
    private String regNr;
    private Bilmærke bilmærke;

    public Bil(String regNr){
        this.regNr = regNr;
    }

    public String getRegNr() {
        return regNr;
    }

    public Bilmærke getBilmærke() {
        return bilmærke;
    }

    public void setBilmærke(Bilmærke bilmærke) {
        this.bilmærke = bilmærke;
    }
    @Override
    public String toString(){
        return regNr + " " + bilmærke;
    }
}
