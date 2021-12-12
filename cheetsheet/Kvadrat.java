package cheetsheet;

public class Kvadrat extends Pravokotnik{

  public Kvadrat(int w) {
    super(w, w);
  }
  
  @Override
  public String vrsta() {
    return "Kvadrat";
  }

  @Override
  public String podatki() {
    return String.format("Width: %d", super.getWidth());
  }
}