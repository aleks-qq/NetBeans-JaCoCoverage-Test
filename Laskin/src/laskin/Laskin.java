package laskin;



public class Laskin {

    private static double tulos;  // Muuttuja tulokselle
    
    public void nollaa() {     // Nollaa tuloksen
        tulos = 0;
    }

    public double annaTulos() {
        return tulos;
    }
    
    public void lisaa(double n) {
        tulos = tulos + n;
    }

    public void vahenna(double n) {
        tulos = tulos - n;     // bugi korjattu, 1 > n
    }

    public void kerro(double n) {
       tulos = tulos * n; // toimii
    }

    public void jaa(double n) {
        if (n == 0) throw new ArithmeticException("Nollalla jako ei onnistu.");
        else tulos = (tulos / n);
    }

    public void nelio(double n) {
        tulos = n * n;
    }

    public void neliojuuri(double n) {
        if (n < 0) throw new ArithmeticException("Et voi ottaa neliöjuurta negatiivisesta luvusta.");
        
        else tulos = Math.sqrt(n);   // korjattu Bugi
    }
    
    public void virtaON() {
        // Tähän voisi laittaa alkutoimet
        tulos = 0;
    }

    public void virtaOFF() {
        // Tähän voisi laittaa lopputoimet
        tulos = 0;
    }

}
