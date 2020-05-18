package samochod.model;


public class Main {

    public static void main(String[] args) {

        Komponent test_komp = new Komponent("test", 1, 1);
        Sprzeglo test_sprzeglo = new Sprzeglo("tt",1,1,1);
        SkrzyniaBiegow test_skrzynia = new SkrzyniaBiegow("qq",2,200,1,8,1f,test_sprzeglo);
        Silnik test_silnik = new Silnik("ss",4,300,1800,5500);
        Samochod test_samochod = new Samochod("a","qwe23","eee","qwee",250,test_skrzynia,test_silnik);

/*
        Thread t1 = new Thread(test_silnik);
        test_silnik.uruchom();
        t1.start();
*/

        //System.out.println(test_samochod.obliczWage());

// assertEquals - testy Add Junit4 to Classpath
// Gdy sprzeglo nie jest nacisniete to wyjatek









    }
}
