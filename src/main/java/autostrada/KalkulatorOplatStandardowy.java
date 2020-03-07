package autostrada;

public class KalkulatorOplatStandardowy implements KalkulatorOplat {
    private final int oplata;

    public KalkulatorOplatStandardowy(int oplata) {
        this.oplata = oplata;
    }


    public int obliczOplate(Pojazd pojazd) {
        return oplata;
    }
}
