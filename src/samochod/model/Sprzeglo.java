package samochod.model;

public class Sprzeglo extends Komponent{

    private int stan;


    public Sprzeglo(String _nazwa, int _waga, int _cena, int _stansprzegla)
    {
        super( _nazwa,  _waga,  _cena);
        stan = _stansprzegla;
    }


    public int getStan()
    {
        return this.stan;
    }

    public void zalacz()
    {
        stan = 1;
    }

    public void rozlacz()
    {
        stan = 0;
    }


}