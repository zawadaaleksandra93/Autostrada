package autostrada;

import autostrada.Motocykl;
import autostrada.Pojazd;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Application {
    public static void main(String[] args) {
        Queue<Pojazd> kolejkaPojazdow = new ArrayBlockingQueue<Pojazd>(100);
        Pojazd motocykl = new Motocykl(200,"QWE12346", "Yamaha", "R1", Silnik.SPALINOWY);
        Pojazd motocykl1 = new Motocykl(200,"SBA12347", "Yamaha", "R1", Silnik.SPALINOWY);
        Pojazd motocykl2 = new Motocykl(200,"DEF12348", "Yamaha", "R1", Silnik.SPALINOWY);
        kolejkaPojazdow.add(motocykl);
        kolejkaPojazdow.add(motocykl1);
        kolejkaPojazdow.add(motocykl2);

        Pojazd samochod = new Samochod(3500, "SB157382", "Toyota", "Corolla", Silnik.SPALINOWY);
        Pojazd samochod1 = new Samochod(3600, "SBA57845", "Toyota", "Corolla", Silnik.SPALINOWY);
        Pojazd samochod2 = new Samochod(3500, "SB157383", "Tesla", "X", Silnik.ELEKTRYCZNY);
        kolejkaPojazdow.add(samochod);
        kolejkaPojazdow.add(samochod1);
        kolejkaPojazdow.add(samochod2);
        /* System.out.println(kolejkaPojazdow);
        for (Pojazd pojazd : kolejkaPojazdow) {
            System.out.println(pojazd);
        }*/
        int oplata = 200;
        KalkulatorOplat kalkulatorStandardowy = new KalkulatorOplatStandardowy(oplata);
        KalkulatorOplat kalkulatorDlaElektrycznych = new KalkulatorOplatDlaPojazdowElektrycznych();
        KalkulatorOplat kalkulatorDlaLekklich = new KalkulatorDlaPojazdowLekkich(oplata);
        Bramka bramka = new Bramka(oplata, kalkulatorStandardowy);
        for (Pojazd pojazd : kolejkaPojazdow) {

            int nowaOplata;
            if(Silnik.ELEKTRYCZNY.equals(pojazd.getSilnik())) {
               bramka.setKalkulator(kalkulatorDlaElektrycznych);
            } else if (pojazd.getMasa()<= 3_500){
                bramka.setKalkulator(kalkulatorDlaLekklich);
            }
            else {
                bramka.setKalkulator(kalkulatorStandardowy);
            }
            bramka.obsluzPojazd(pojazd);
        }


    }
}
