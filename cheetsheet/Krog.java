package cheetsheet;

public class Krog extends Lik {

  private int r;

  public Krog(int r){
    this.r = r;
  }

  @Override
  public double ploscina() {
    return this.r * this.r * Math.PI;
  }

  @Override
  public double obseg() {
    return 2 * this.r * Math.PI;
  }

  @Override
  public String vrsta() {
    return "Krog";
  }

  @Override
  public String podatki() {
    return String.format("Radious: %d", this.r);
  }

}