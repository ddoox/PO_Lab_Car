package samochod.model;

public class SkrzyniaBiegow extends Komponent{

    private int aktualnyBieg;
    private int iloscBiegow;
    private float aktualnePrzelozenie;
    private Sprzeglo sprzeglo;


    public SkrzyniaBiegow(String _nazwa, int _waga, int _cena, int _AktualnyBieg, int _IloscBiegow, float _AktualnePrzelozenie, Sprzeglo _sprzeglo)
    {
        super( _nazwa,  _waga,  _cena);
        aktualnePrzelozenie = _AktualnePrzelozenie;
        iloscBiegow = _IloscBiegow;
        aktualnyBieg = _AktualnyBieg;
        sprzeglo = _sprzeglo;
    }


    public void zmienBieg(int nrBiegu) throws Blad {
        try {
            if (sprzeglo.getStan() != 1)
            {
                Blad test = new Blad();
                throw test;
            }

            if (nrBiegu > iloscBiegow) { aktualnyBieg = iloscBiegow;}
            else if (nrBiegu < 0) {aktualnyBieg = 1;}
            else aktualnyBieg = nrBiegu;

        } catch (Blad test)
            {
                System.out.println("Zalacz sprzeglo");
            }


    }



    /*
    1. cowa klasa wyjątku publica class Sprzadfg extends Exception
    2. Do metody dodać "throws Sprzadfg"
    3. if sth throw
    4. w teście try kod , catch(Sprzadfg e)




    Jtable na cały
    Jpanel - podzielic na 4 czesci

    prawy gorny - silnik:
        dwie czesci
            w pierwszy etykieta do lewej pole do prawej
            w drugirej buttony - dodaj obroty, zmniejsz obroty


    Jslider



*/

    public float obliczPrzelozenie()
    {
        return aktualnePrzelozenie;
    }

    public int iloscBiegow(){ return this.iloscBiegow; }

    public int wagaSprzegla()
    {
        return this.sprzeglo.getWaga();
    }

    public int getBieg()
    {
        return aktualnyBieg;
    }


}