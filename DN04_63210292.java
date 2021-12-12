import java.util.Scanner;

class dn04_363210292 {
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();

    int[] occur = new int[1010];
    for (int i = 0; i < occur.length; i++) {
      occur[i] = 0;
    }

    for (long i = 0; i < n; i++) {
      int p = sc.nextInt();
      occur[p] += 1;
    }

    long value = 0;

    for (int i = 0; i < 1010; i++) {
      if (occur[i] >= 0) {
        if (k - i >= 0) {
          value += occur[i] * occur[k - i];
        }
      }
    }

    System.out.println(value);

    sc.close();
  }
}

// 5 12 6 7 2 10 6