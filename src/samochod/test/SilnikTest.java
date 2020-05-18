package samochod.test;

import org.junit.Test;
import samochod.model.Silnik;

import static org.junit.Assert.*;

public class SilnikTest {

    @Test
    public void uruchom() {
        Silnik test = new Silnik("na",1,1,1500,3000);


        assertEquals(1500, test.getObroty());

        test.zatrzymaj();
        assertEquals(0, test.getObroty());

        test.uruchom();
        assertEquals(0, test.getObroty());


    }

    @Test
    public void ZmniejszObroty() {
        Silnik test = new Silnik("na",1,1,1500,3000);

        test.uruchom();
        assertEquals(0, test.getObroty());

        test.zwiekszObroty(1500);
        test.zmniejszObroty(500);
        assertEquals(1000, test.getObroty());

        test.zmniejszObroty(5000);
        assertEquals(0, test.getObroty());


    }

    @Test
    public void ZwiekszObroty() {
        Silnik test = new Silnik("na",1,1,1500,3000);

        test.uruchom();
        assertEquals(0, test.getObroty());

        test.zwiekszObroty(1500);
        assertEquals(1500, test.getObroty());

        test.zwiekszObroty(5000);
        assertEquals(3000, test.getObroty());


    }
}