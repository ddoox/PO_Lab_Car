package samochod.model;

public class Komponent{


   private String nazwa;
   private int waga;
   private int cena;


   public Komponent(String _nazwa, int _waga, int _cena)
   {
       cena = _cena;
       waga = _waga;
       nazwa = _nazwa;
   }


    public String getNazwa()
    {
        return this.nazwa;
    }

    public int getWaga()
    {
        return this.waga;
    }

    public int getCena()
    {
        return this.cena;
    }


}

    /*
    1.

+   <-- oznacza public
atrybuty prywatne

2. Utworzyć dwa obiekty

3. Obliczyć wagę

     */
