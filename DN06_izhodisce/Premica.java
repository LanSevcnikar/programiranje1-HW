public class Premica {

    private double k;
    private double n;

    public Premica(double k, double n) {
        this.k = k;
        this.n = n;
    }

    public double vrniK() {
        return this.k;
    }

    public double vrniN() {
        return this.n;
    }

    public String toString() {
        return String.format(java.util.Locale.US,"y = %.2f x + %.2f", this.k, this.n);
    }

    public Tocka tockaPriX(double x) {
        return new Tocka(x, this.k * x + this.n);
    }

    public static Premica skoziTocko(double k, Tocka t) {
        double n = t.vrniY() - k * t.vrniX();
        return new Premica(k, n);
    }

    public Premica vzporednica(Tocka t) {
        double n = t.vrniY() - k * t.vrniX();
        return new Premica(k, n);
    }

    public Premica pravokotnica(Tocka t) {
        double k = -1 / this.k;
        double n = t.vrniY() - k * t.vrniX();
        return new Premica(k, n);
    }

    public Tocka presecisce(Premica p, double epsilon) {
        if(Math.abs(p.vrniK() - this.k) < epsilon) return null;
        double x = (p.vrniN() - this.n)/(this.k - p.vrniK());
        return tockaPriX(x);
    }

    public Tocka projekcija(Tocka t) {
        if(this.tockaPriX(t.vrniX()).vrniY() == t.vrniY()){
            return t;
        }
        return this.presecisce(this.pravokotnica(t), 0);
    }

    public double razdalja(Tocka t) {
        return t.razdalja(this.projekcija(t));
    }

    public double razdaljaOdIzhodisca() {
        return this.razdalja(Tocka.izhodisce());
    }

    public double razdalja(double n) {
        return this.razdalja(new Tocka(0, n));
    }
}
