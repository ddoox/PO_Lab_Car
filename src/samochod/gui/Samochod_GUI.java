package samochod.gui;

import samochod.model.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;
import java.lang.String;

public class Samochod_GUI implements Obserwator {
    private JPanel panel1;
    private JRadioButton załączoneRadioButton;
    private JRadioButton rozłączoneRadioButton;
    private JSlider SliderSkrzynia;
    private JTextField NazwaSprzeglo;
    private JButton zwiększButton2;
    private JButton zmniejszButton1;
    private JTextField AktualneObrotySilnik;
    private JTextField NazwaSilnik;
    private JTextField MaxObrotySilnik;
    private JTextField NazwaSkrzynia;
    private JTextField IloscBiegowSkrzynia;
    private JTextField WagaSamochod;
    private JTextField RejestracjaSamochod;
    private JTextField MarkaSamochod;
    private JTextField KolorSamochod;
    private JTextField ModelSamochod;
    private JButton inicjalizacjaButton;
    private JRadioButton uruchomionyRadioButton;
    private JRadioButton zatrzymanyRadioButton;
    private JTextField AktualnyBiegSkrzynia;

    private static Sprzeglo test_sprzeglo = new Sprzeglo("Sprzęgłov1",30,500,0);
    private static SkrzyniaBiegow test_skrzynia = new SkrzyniaBiegow("Skrzyniav1",80,1500,1,7,1f,test_sprzeglo);
    private static Silnik test_silnik = new Silnik("Silnikv1",200,5000,1800,6000);
    private static Samochod test_samochod = new Samochod("Czarny","RZE 0000","Modelv1","Markav1",250,test_skrzynia,test_silnik);

    private void refresh() {
            ModelSamochod.setText(test_samochod.getModel());
            RejestracjaSamochod.setText(test_samochod.getRejestracja());
            KolorSamochod.setText(test_samochod.getKolor());
            MarkaSamochod.setText(test_samochod.getMarka());
            WagaSamochod.setText(String.valueOf(test_samochod.obliczWage()));
            NazwaSprzeglo.setText(test_sprzeglo.getNazwa());
            NazwaSkrzynia.setText(test_skrzynia.getNazwa());
            NazwaSilnik.setText(test_silnik.getNazwa());
            MaxObrotySilnik.setText(String.valueOf(test_silnik.getMaxObroty()));
            AktualneObrotySilnik.setText(String.valueOf(test_silnik.getObroty()));
            IloscBiegowSkrzynia.setText(String.valueOf(test_skrzynia.iloscBiegow()));
            AktualnyBiegSkrzynia.setText(String.valueOf(test_skrzynia.getBieg()));

        }

    private Samochod_GUI(Sprzeglo sprzeglo, SkrzyniaBiegow skrzynia, Silnik silnik, Samochod samochod) {

        SliderSkrzynia.setMaximum(skrzynia.iloscBiegow());
        test_silnik.subskrybuj(this);


        załączoneRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                sprzeglo.zalacz();
                //System.out.println(sprzeglo.getStan());

            }
        });
        rozłączoneRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                sprzeglo.rozlacz();
                //System.out.println(sprzeglo.getStan());


            }
        });
        inicjalizacjaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //  -   -   -   -   -   -   -   //
                //         Inicjalizacja        //
                //  -   -   -   -   -   -   -   //
/*
                ModelSamochod.setText(samochod.getModel());
                RejestracjaSamochod.setText(samochod.getRejestracja());
                KolorSamochod.setText(samochod.getKolor());
                MarkaSamochod.setText(samochod.getMarka());
                WagaSamochod.setText(String.valueOf(samochod.obliczWage()));
                NazwaSprzeglo.setText(sprzeglo.getNazwa());
                NazwaSkrzynia.setText(skrzynia.getNazwa());
                NazwaSilnik.setText(silnik.getNazwa());
                MaxObrotySilnik.setText(String.valueOf(silnik.getMaxObroty()));
                AktualneObrotySilnik.setText(String.valueOf(silnik.getObroty()));
                IloscBiegowSkrzynia.setText(String.valueOf(skrzynia.iloscBiegow()));
                AktualnyBiegSkrzynia.setText(String.valueOf(skrzynia.getBieg()));
*/
                refresh();
            }
        });
        zwiększButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                silnik.zwiekszObroty(100);
                //AktualneObrotySilnik.setText(String.valueOf(silnik.getObroty()));
                refresh();

            }
        });
        zmniejszButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                silnik.zmniejszObroty(100);
                //AktualneObrotySilnik.setText(String.valueOf(silnik.getObroty()));
                refresh();

            }
        });
        zatrzymanyRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
             silnik.zatrzymaj();
             //silnik.zmniejszObroty(10000);
            // AktualneObrotySilnik.setText(String.valueOf(silnik.getObroty()));
                refresh();
            }
        });
        uruchomionyRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                silnik.uruchom();
                //silnik.zmniejszObroty(10000);
                //AktualneObrotySilnik.setText(String.valueOf(silnik.getObroty()));
                refresh();
            }
        });
        SliderSkrzynia.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {

                int value = SliderSkrzynia.getValue();
                try {
                    skrzynia.zmienBieg(value);
                } catch (Blad blad) {
                    SliderSkrzynia.setValue(value);
                    blad.printStackTrace();
                }

                //AktualnyBiegSkrzynia.setText(String.valueOf(skrzynia.getBieg()));
                refresh();
            }
        });

        refresh();
    }


    public static void main(String[] args) {

        JFrame frame = new JFrame("Samochod_GUI");
        frame.setContentPane(new Samochod_GUI(test_sprzeglo,test_skrzynia,test_silnik,test_samochod).panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        Thread t1 = new Thread(test_silnik);
        test_silnik.uruchom();
        t1.start();

        //test_silnik.subskrybuj(this);
    }

    public void inform() {
        refresh();
    }



    //create listener - action listener
    //Co ma się wykonać, np. metoda
    // edytowanie pol tekstowych z klasy pole.setText("fghfgh");


/*
    utworzyc wątek silnik, obroty mają fluuktuować
    ruunable do klasy silnik
    co 100ms zmiana obrotów o wartość (-5;5)


2
    uaktualnianie gui

    w silniku skladowa: Obserwator obserwator;
    definicja
    public interface Obserwator{
        public void informuj(){refresh();};
    }

    gui musi podłączyć się jako obserwator   subscribe(Obserwator)

1. dwa interfejsy
2 metoda inform
3. metody subscribe unsubscribe
4. w wątku w silniku obserwator.inform()
            5. w silniku subscribe()


*/
}
