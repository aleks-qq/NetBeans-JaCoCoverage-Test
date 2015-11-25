package laskin;

import java.util.Arrays;
import java.util.List;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;



@RunWith(Parameterized.class)
public class ExtraTest extends AbstractParent {

    private static Laskin laskin;
    private double luku;
    private double tulos;

    @Parameterized.Parameters
    public static List testiTapaukset() {
        return Arrays.asList(new Object[][]{
            {0, Math.sqrt(0)},
            {1, Math.sqrt(1)},
            {2, Math.sqrt(2)},
            {4, Math.sqrt(4)},
            {5, Math.sqrt(5)},
            {6, Math.sqrt(6)},
            {7, Math.sqrt(7)} 
        });
    }

    // Konstruktori, jota JUnit kutsuu kullekin listan testitapaukselle.
    // Parametrien kytkentä sijainnin / järjestyksen perusteella:
    // ekana syötetty luku, toisena odotettu arvo
    public ExtraTest(double luku, double tulos) {
        this.luku = luku;
        this.tulos = tulos;
    }

    @BeforeClass
    public static void testVirtaON() {
        System.out.println("@BeforeClass Virta ON (ennen ensimmäistä testiä).");
        laskin = new Laskin();
        laskin.virtaON();
    }

    @AfterClass
    public static void testVirtaOFF() {
        System.out.println("@AfterClass Virta OFF (kaikki testit ajettu).");
        laskin.virtaOFF();
        laskin = null;
    }

    @Before
    public void testNollaa() {
        System.out.println("  Nollaa laskin.");
        laskin.nollaa();
    }

    // Aseta testille maksimi kestoaika
    @Test(timeout = 1000)
    public void testNeliojuuri2() {
        laskin.neliojuuri(2);
    }

    @Test
    public void testExtra() {
        laskin.neliojuuri(luku);
        assertEquals("nelio(+" + luku + ") ", tulos, laskin.annaTulos(),0.01);
    }

    @Test(expected = ArithmeticException.class)
    public void testNegaNelio() {
        laskin.neliojuuri(-5);
        assertEquals("nelio(5) ", 25, laskin.annaTulos(),0.01);
    }

}
