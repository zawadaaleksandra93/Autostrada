package autostrada;

public abstract class Pojazd {
    private int masa;
    private String vin;
    private String marka;
    private String model;
    private Silnik silnik;

    public int getMasa() {
        return masa;
    }

    public void setMasa(int masa) {
        this.masa = masa;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Silnik getSilnik() {
        return silnik;
    }

    public void setSilnik(Silnik silnik) {
        this.silnik = silnik;
    }

    public Pojazd(int masa, String vin, String marka, String model, Silnik silnik) {
        this.masa = masa;
        this.vin = vin;
        this.marka = marka;
        this.model = model;
        this.silnik = silnik;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pojazd pojazd = (Pojazd) o;

        return vin.equals(pojazd.vin);
    }

    @Override
    public int hashCode() {
        return vin.hashCode();
    }

    @Override
    public String toString() {
        return "Pojazd{" +
                "masa=" + masa +
                ", vin='" + vin + '\'' +
                ", marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", silnik=" + silnik +
                '}';
    }
}
