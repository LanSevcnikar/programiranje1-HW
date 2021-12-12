import java.util.Scanner;

class dn363210292 {

  static long pow(long a, long b){
    long c = 1;
    for (long i = 0; i < b; i++) {
      c *= a;
    }
    return c;
  }

  static long min(long a, long b){
    if(a > b) return b;
    return a;
  }

  static long solve(long w, long h, long k){
    if(k == -1) return 0;
    long ans = 0;

    long m = min(w,h);
    long pt = pow(2,k);

    if(pt > m) return solve(w, h, k-1);
    long tw = (w / pt);
    long th = (h / pt);

    ans = tw * th;
    ans += solve(w, h % pt, k-1);
    ans += solve(w % pt, h - (h % pt), k-1);

    return ans;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long h = sc.nextInt();
    long w = sc.nextInt();
    long k = sc.nextInt();

    System.out.println(solve(w,h,k));

    sc.close();
  }
}