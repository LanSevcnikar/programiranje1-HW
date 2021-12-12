package cheetsheet;

public class Pravokotnik extends Lik {
  private int w;
  private int h;

  public Pravokotnik(int w, int h){
    this.w = w;
    this.h = h;
  }

  @Override
  public double ploscina() {
    return this.w * this.h;
  }

  @Override
  public double obseg() {
    return 2 * (this.w + this.h);
  }

  @Override
  public String vrsta() {
    return "Pravokotnik";
  }

  @Override
  public String podatki() {
    return String.format("Width: %d | Height: %d", this.w, this.h);
  }

  public int getWidth(){
    return this.w;
  }
}

