package internprove;

import controller.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        Bil bil = new Bil("1512");
        Bil bil1 = new Bil("1515");
        Parkeringshus parkeringshus = new Parkeringshus("Sønderhøj");
        Parkeringsplads parkeringsplads = new Parkeringsplads(14,parkeringshus);
        Invalideplads invalideplads = new Invalideplads(14,parkeringshus,20.0);

        parkeringshus.createParkeringsPlads(15);
        parkeringsplads.setBil(bil);
        System.out.println(parkeringsplads.getAnkomst());

        Parkeringsplads parkeringsplads1 = new Parkeringsplads(14,parkeringshus);
        Parkeringsplads parkeringsplads2 = new Parkeringsplads(14,parkeringshus);
        Parkeringsplads parkeringsplads3 = new Parkeringsplads(14,parkeringshus);
        ArrayList<Parkeringsplads> parkeringsplads4 = new ArrayList<>(Arrays.asList(parkeringsplads1,parkeringsplads2,parkeringsplads3,parkeringsplads));

        System.out.println(parkeringshus.antalLedigePladser(parkeringsplads4));

        System.out.println(parkeringsplads.beregnPPris(LocalTime.of(15,10)));
        parkeringsplads.hentBil(LocalTime.of(15,10));
        System.out.println(parkeringshus.getSaldo());

        parkeringsplads1.setBil(bil1);
        parkeringsplads1.hentBil(LocalTime.of(17,10));
        System.out.println(parkeringshus.getSaldo());
        System.out.println(parkeringshus.optagnePladser());

        Controller.init();
    }
}
