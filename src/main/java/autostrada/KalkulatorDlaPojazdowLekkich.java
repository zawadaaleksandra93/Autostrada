package autostrada;

public class KalkulatorDlaPojazdowLekkich extends KalkulatorOplatStandardowy{

    public KalkulatorDlaPojazdowLekkich(int oplata) {
        super(oplata);
    }

    @Override
    public int obliczOplate(Pojazd pojazd) {
        return (int) (super.obliczOplate(pojazd) *0.5);
    }
}
