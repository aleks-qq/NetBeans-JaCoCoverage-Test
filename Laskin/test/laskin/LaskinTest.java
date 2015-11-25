package laskin;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

// Luokan nimen loppu pitää olla Test
public class LaskinTest {

    // Fixture ("vakiokaluste"): kaikki testit käyttävät samaa laskinta,
    // joka nollataan ennen kutakin testiä.
    private static Laskin laskin = new Laskin();

    @Before
    public void clearCalculator() {
        laskin.nollaa();
    }

    // Testimetodin nimi voi olla mitä tahansa, edessä annotaatio @Test    
    @Test
    public void testLisaa() {
        laskin.lisaa(1.00);
        laskin.lisaa(1.00);
        assertEquals("1 + 1 ", 2.00, laskin.annaTulos(),0.01);
    }

    @Test
    public void testVahenna() {
        laskin.lisaa(10.00);
        laskin.vahenna(2.00);
        assertEquals("10 - 2 ", laskin.annaTulos(), 8.00,0.01);
    }

    @Test
    public void testJaa() {
        laskin.lisaa(8);
        laskin.jaa(2);
        assert laskin.annaTulos() == 4; //korjattu vitonen neloseksi
    }

    // Nollalla jaon pitäisi heittää poikkeus
    @Test(expected = ArithmeticException.class)
    public void testJaaNollalla() {
        laskin.jaa(0);
    }

    // Tätä testiä ei haluta vielä ajaa
    @Test
    public void testKerro() {
        laskin.lisaa(10);
        laskin.kerro(10);
        assertEquals("10 * 10 ", 100.00, laskin.annaTulos(),0.01);
    }
}
