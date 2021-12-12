import java.util.Scanner;

class dn05_363210292 {
  public static void main(String[] args) {

    int[][][] tps = new int[20][4][2];
    tps[0][0]  = new int[]{0, 0, 0, 0};
    tps[0][1]  = new int[]{1, 1, 1, 1};
    
    tps[1][0]  = new int[]{0, -1, -1, -1};
    tps[1][1]  = new int[]{4, 0, 0, 0};

    tps[2][0]  = new int[]{0, 0, -1, -1};
    tps[2][1]  = new int[]{2, 2, 0, 0};

    tps[3][0]  = new int[]{0, 0, 0, -1};
    tps[3][1]  = new int[]{1, 2, 1, 0};

    tps[4][0]  = new int[]{1, 0, -1, -1};
    tps[4][1]  = new int[]{2, 3, 0, 0};
   
    tps[5][0]  = new int[]{1, 0, 1, -1};
    tps[5][1]  = new int[]{2, 2, 2, 0};
    
    tps[6][0]  = new int[]{0, 1, -1, -1};
    tps[6][1]  = new int[]{3, 2, 0, 0};

    tps[7][0]  = new int[]{0, 0, -1, -1};
    tps[7][1]  = new int[]{3, 1, 0, 0};
    
    tps[8][0]  = new int[]{0, 0, 0, -1};
    tps[8][1]  = new int[]{1, 1, 2, 0};
    
    tps[9][0]  = new int[]{0, -1, -1, -1};
    tps[9][1]  = new int[]{4, 0, 0, 0};
    
    tps[1][0]  = new int[]{0, -1, -1, -1};
    tps[1][1]  = new int[]{4, 0, 0, 0};
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[] field = new int[3000];
    
    for (int i = 0; i < n; i++) {
      int tp = sc.nextInt();
      int x = sc.nextInt();
    }

    sc.close();
  }
}

// 5 12 6 7 2 10 6