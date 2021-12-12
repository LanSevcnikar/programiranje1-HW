public class Tocka {

    private double x;
    private double y;

    public Tocka(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double vrniX() {
        return this.x;
    }

    public double vrniY() {
        return this.y;
    }

    public String toString() {
        return String.format(java.util.Locale.US,"(%.2f, %.2f)", this.x, this.y);
    }

    public static Tocka izhodisce() {
        return new Tocka(0, 0);
    }
    
    public double razdalja(Tocka t) {
        double dx = t.vrniX() - this.x;
        double dy = t.vrniY() - this.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double razdaljaOdIzhodisca() {
        return this.razdalja(Tocka.izhodisce());
    }
}
