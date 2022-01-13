import java.util.Scanner;

class DN08_363210292 {
  private static class Monografija {
    private String[] avtorji;
    private String naslov;
    private String zalozba;
    private String letoIzdaje;
    private String ISBN;

    public double steviloTock;
    private String tockeString;

    private int index;

    public Monografija(
        int index,
        String[] avtorji,
        String naslov,
        String zalozba,
        String letoIzdaje,
        String ISBN) {

      this.avtorji = avtorji;
      this.naslov = naslov;
      this.zalozba = zalozba;
      this.letoIzdaje = letoIzdaje;
      this.ISBN = ISBN;

      this.steviloTock = 10 / this.avtorji.length;
      if (10 % this.avtorji.length == 0)
        this.tockeString = String.format("%d", 10 / this.avtorji.length);
      else
        this.tockeString = String.format("%d+%d/%d", (int) 10 / this.avtorji.length, 10 % this.avtorji.length,
            this.avtorji.length);
    }

    public String toString() {
      String temp = "";
      for (String avtor : avtorji) {
        temp += avtor + ", ";
      }
      return String.format("%s: %s. %s %s, ISBN %s | %s", temp, this.naslov, this.zalozba, this.letoIzdaje, this.ISBN,
          this.tockeString);
    }
  }

  private static class Referat {
    private String[] avtorji;
    private String naslov;
    private String naslovKonference;
    private String vrstaKonference;
    private int zacetnaStran;
    private int koncnaStran;
    private int index;
    public double steviloTock;
    private String tockeString;

    public Referat(
        int index,
        String[] avtorji,
        String naslov,
        String naslovKonference,
        String vrstaKonference,
        int zacetnaStran,
        int koncnaStran) {
      this.avtorji = avtorji;
      this.naslov = naslov;
      this.naslovKonference = naslovKonference;
      this.vrstaKonference = vrstaKonference;
      this.zacetnaStran = zacetnaStran;
      this.koncnaStran = koncnaStran;
      if (this.vrstaKonference.equals("true")) {
        this.steviloTock = 3 / avtorji.length;
        if (3 % this.avtorji.length == 0)
          this.tockeString = String.format("%d", 3 / this.avtorji.length);
        else
          this.tockeString = String.format("%d %d/%d", (int) 3 / this.avtorji.length, 1 % this.avtorji.length,
              this.avtorji.length);
      } else {
        this.steviloTock = 1 / avtorji.length;
        if (1 % this.avtorji.length == 0)
          this.tockeString = String.format("%d", 1 / this.avtorji.length);
        else
          this.tockeString = String.format("%d+%d/%d", (int) 1 / this.avtorji.length, 1 % this.avtorji.length,
              this.avtorji.length);
      }
    }

    public String toString() {
      String temp = "";
      for (String avtor : avtorji) {
        temp += avtor + ", ";
      }
      return String.format("%s: %s. %s: %d-%d | %s", temp, this.naslov, this.naslovKonference, this.zacetnaStran,
          this.koncnaStran,
          this.tockeString);
    }
  }

  private static class Clanek {
    private String[] avtorji;
    private String naslov;
    private String nazivRevije;
    private int stevilkaRevije;
    private String letoIzdaje;
    private int odmevnostRevije;
    private String letnik;
    private int zacetnaStran;
    private int koncnaStran;
    private int index;
    public int steviloTock;

    public Clanek(
        int index,
        String[] avtorji,
        String naslov,
        String nazivRevije,
        String letnik,
        int stevilkaRevije,
        String letoIzdaje,
        int odmevnostRevije,
        int zacetnaStran,
        int koncnaStran) {
      this.index = index;
      this.avtorji = avtorji;
      this.naslov = naslov;
      this.letnik = letnik;
      this.nazivRevije = nazivRevije;
      this.stevilkaRevije = stevilkaRevije;
      this.letoIzdaje = letoIzdaje;
      this.odmevnostRevije = odmevnostRevije;
      this.zacetnaStran = zacetnaStran;
      this.koncnaStran = koncnaStran;

      double p = ((double)this.stevilkaRevije / (double)this.odmevnostRevije);
      int tockovnaOsnova = 0;
      if(p <= 0.25){
        tockovnaOsnova = 10;
      }
      this.steviloTock = 2;
    }

    public String toString() {
      String temp = "";
      for (String avtor : avtorji) {
        temp += avtor + ", ";
      }
      return String.format("%s: %s. %s %s(%s): %d-%d (%s) | %s", temp, this.naslov, this.nazivRevije, this.letnik,
          this.stevilkaRevije,
          this.zacetnaStran, this.koncnaStran, this.letoIzdaje, this.steviloTock);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String avtor = sc.next();
    int T = sc.nextInt();

    Object[] objave = new Object[T];
    for (int t = 0; t < T; t++) {

      String tp = sc.next();
      int steviloAvtorjev = sc.nextInt();
      String[] avtorji = new String[steviloAvtorjev];
      for (int i = 0; i < steviloAvtorjev; i++) {
        avtorji[i] = sc.next();
        if (avtorji[i].equals("#")) {
          avtorji[i] = avtor;
        }
      }
      String naslov = sc.next();

      if (tp.equals("monografija")) {
        String zalozba = sc.next();
        String letoIzdaje = sc.next();
        String ISBN = sc.next();
        objave[t] = new Monografija(t, avtorji, naslov, zalozba, letoIzdaje, ISBN);
      }
      if (tp.equals("referat")) {
        String nazivKonference = sc.next();
        String vrstaKLonference = sc.next();
        int zacetnaStran = sc.nextInt();
        int koncnaStran = sc.nextInt();
        objave[t] = new Referat(t, avtorji, naslov, nazivKonference, vrstaKLonference, zacetnaStran, koncnaStran);
      }
      if (tp.equals("clanek")) {
        String nazivRevije = sc.next();
        String letnikRevije = sc.next();
        int stevilkaRevije = sc.nextInt();
        String letnikIzdaje = sc.next();
        int odmevnostRevije = sc.nextInt();
        String steviloOdmevnosti = sc.next();
        int zacetnaStran = sc.nextInt();
        int koncnaStran = sc.nextInt();
        objave[t] = new Clanek(t, avtorji, naslov, nazivRevije, letnikRevije, stevilkaRevije, letnikIzdaje,
            odmevnostRevije, zacetnaStran, koncnaStran);
      }
    }
    sc.close();

    for (Object objava : objave) {
      System.out.println(objava.toString());
    }
  }
}
