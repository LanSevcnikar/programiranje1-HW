package cheetsheet;

public abstract class Lik {
  public abstract double ploscina();
  public abstract double obseg(); 
  public abstract String vrsta();
  public abstract String podatki();

  public String toString(){
    return String.format("%s  ->  %s", this.vrsta(), this.podatki());
  }

  public void print(){
    System.out.println(this.toString());
  }

  public static void printLiki(Lik[] liki){
    for (Lik lik : liki) {
      System.out.printf("%s:\no = %.1f\np = %.1f\n\n", 
        lik.toString(), lik.obseg(), lik.ploscina());
    }
  }

  //Comperative
  @Override
  public boolean equals(Object obj) {
    if(this == obj) return true; // if the two are exactly the same thing, pointers wise
    if(!(obj instanceof Lik)) return false; //if the second object is not of type lik, it is not the same
    Lik lik = (Lik) obj;
    if(this.vrsta() == lik.vrsta()) return true;
    return false;
    //this checks if both are of the saem type and this is clearly not how most peple imagine the equals operator but it is done here like this because I cannot be bothered
    //Also this is to write the .equals  operator, not the == operator
  }
}