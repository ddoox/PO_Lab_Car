package samochod.model;

import java.util.Random;

public class Silnik extends Komponent implements Runnable,Obserwowany{

    private int Obroty;
    private int MaxObroty;
    boolean working;

    private Obserwator obserwator;


    public Silnik(String _nazwa, int _waga, int _cena, int _obroty, int _MaxObroty)
    {
        super( _nazwa,  _waga,  _cena);
        Obroty = _obroty;
        MaxObroty = _MaxObroty;
    }


    public void uruchom()
    {
        working = true;
        zmniejszObroty(10000);
    }

    public void zatrzymaj()
    {
        working = false;
        zmniejszObroty(10000);
    }

    public int getMaxObroty() { return this.MaxObroty; }

    public int getObroty() { return this.Obroty; }

    public void zmniejszObroty(int zmiana)
    {
        if (Obroty - zmiana >= 0 && working == true)
        {
            Obroty -= zmiana;
        }
        else
        {
            Obroty = 0;
        }
    }

    public void zwiekszObroty(int zmiana)
    {
        if (zmiana + Obroty < MaxObroty && working == true)
        {
            Obroty += zmiana;
        }
        else if ( working == true)
        {
            Obroty = MaxObroty;
        }
    }

    public void run()
    {

        while(true)
        {
            Random rand = new Random();
            int zmiana_random = 5 - (rand.nextInt(9) + 1);

            if(working)
            {
                if(Obroty + zmiana_random < MaxObroty && Obroty + zmiana_random > 0)
                    Obroty += zmiana_random;
                else if (Obroty + zmiana_random <= 0)
                    Obroty = 0;
                else if (Obroty + zmiana_random >= MaxObroty)
                    Obroty = MaxObroty;


                try { Thread.sleep(100);} catch (InterruptedException e) { }
                obserwator.inform();
            }

        }
    }
    // obserwowany

    public void subskrybuj(Obserwator o)
    {
        obserwator = o;
    }

    public void odsubskrybuj(Obserwator o)
    {
        if (obserwator == o)
        {
            obserwator = null;
        }
    }

    public void inform() {obserwator.inform();}


}