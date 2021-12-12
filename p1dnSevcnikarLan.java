import java.util.Scanner;

class HelloWorld {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int b = sc.nextInt();
    int p = sc.nextInt();

    int e = b / p;
    int o = b % p;

    System.out.println(e);
    System.out.println(o);

    sc.close();
  }
}