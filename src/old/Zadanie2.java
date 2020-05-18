package old; /**
 * Created by Norbi on 2016-10-11.
 */
import java.util.Random;

public class Zadanie2 {
    public static void main(String[] args) {

        Animal a;
        Bird b = new Bird();
        Parrot p = new Parrot();
/*
        a = b;
        System.out.println(a.getName());

        a = p;
        System.out.println(a.getName());

        b = p;
        b.fly();

        p.live(); //dziedziczone!

        Husky test = new Husky();
        test.woof();
*/
        Animal tablica[] = new Animal[100]; //tablica 100 zwierzat

        Random rand = new Random();
        int  n = rand.nextInt(6) + 1;


        for(int i = 0; i  < 100; i++ )
        {
            n = rand.nextInt(6) + 1;  //losowanie nr nowego zwierzecia

            switch (n) {                    //wybor zwierzecia
                case 1:
                    tablica[i] = new Bird();
                    break;
                case 2:
                    tablica[i] = new Parrot();
                    break;
                case 3:
                    tablica[i] = new Snake();
                    break;
                case 4:
                    tablica[i] = new Cow();
                    break;
                case 5:
                    tablica[i] = new Husky();
                    break;
                case 6:
                    tablica[i] = new Tiger();
                    break;
            }
        }

        //tablica[34].live();

        for(int l = 0; l  < 100; l++ )
        {
            System.out.println(tablica[l].getName());
        }


        //---dodaj klasy 2 nowych zwierzar
        //--dodaj losowo różne zwierzęta do tablicy
        //--wykorzystaj funkcję Random z pakietu java.util
        //--wypisz w pętli nazwy wszystkich zwierząt

    }
}