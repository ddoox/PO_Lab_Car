package samochod.model;

public class Samochod {


    private String kolor;
    private String nrRejest;
    private String model;
    private String marka;
    private int  PredkoscMax;
    private SkrzyniaBiegow skrzynia;
    private Silnik silnik;


    public Samochod(String _kolor, String _NrRejest, String _model, String _marka, int _predkoscMax, SkrzyniaBiegow _skrzynia, Silnik _silnik)
    {
        nrRejest = _NrRejest;
        model = _model;
        marka = _marka;
        PredkoscMax = _predkoscMax;
        skrzynia = _skrzynia;
        silnik = _silnik;
        kolor = _kolor;
    }


    public int obliczWage()
    {
        return this.silnik.getWaga() + this.skrzynia.getWaga() + this.skrzynia.wagaSprzegla();
    }

    public void wlacz(){}

    public void wylacz(){}

    public void jazda(){}

    public int aktualnaPredkosc()
    {
        return 0;
    }

    public String getRejestracja() { return this.nrRejest; }

    public String getModel() { return this.model; }

    public String getMarka() { return this.marka; }

    public String getKolor() { return this.kolor; }




}
