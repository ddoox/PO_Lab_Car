package samochod.test;

import org.junit.Test;
import samochod.model.Blad;
import samochod.model.SkrzyniaBiegow;
import samochod.model.Sprzeglo;

import static org.junit.Assert.*;

public class SkrzyniaBiegowTest {

    @Test
    public void zmienBieg() throws Blad {
        Sprzeglo test = new Sprzeglo("na",1,1,1);
        SkrzyniaBiegow test_skrzynia = new SkrzyniaBiegow("test",1,1,1,5,1,test);

        test.rozlacz();
        //test.zalacz();
        test_skrzynia.zmienBieg(5);

        //assertEquals(5, test_skrzynia.getBieg());


        test.zalacz();
        test_skrzynia.zmienBieg(5);

        assertEquals(5, test_skrzynia.getBieg());


    }

    @Test
    public void zalacz() {
        Sprzeglo test = new Sprzeglo("na",1,1,1);
        SkrzyniaBiegow test_skrzynia = new SkrzyniaBiegow("test",1,1,1,5,1,test);

        assertEquals(1, test_skrzynia.getBieg());


        test.rozlacz();
        try {
            test_skrzynia.zmienBieg(5);
        } catch (Blad blad) {
            blad.printStackTrace();
        }
        assertEquals(1, test_skrzynia.getBieg());


        test.zalacz();
        try {

            test_skrzynia.zmienBieg(5);
            assertEquals(5, test_skrzynia.getBieg());

            test_skrzynia.zmienBieg(50);
            assertEquals(test_skrzynia.iloscBiegow(), test_skrzynia.getBieg());


            test_skrzynia.zmienBieg(-2);
            assertEquals(1, test_skrzynia.getBieg());

        } catch (Blad blad) {
            blad.printStackTrace();
        }


    }
}