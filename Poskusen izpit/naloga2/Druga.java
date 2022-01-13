
/*
 * tj.exe Druga.java . .
 */

import java.util.*;

public class Druga {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w, h;
        h = sc.nextInt();
        w = sc.nextInt();

        int[] p = new int[1000];
        for (int i = 0; i < 1000; i++) {
            p[i] = -1;
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int inp = sc.nextInt();
                if(inp == 1){
                    if(p[j] == -1){
                        p[j] = h-i;
                    }
                }
            }
        }

        int v = 0;
        int s = 0;

        for (int i = 0; i < w - 1; i++) {
            if(p[i] < p[i+1]){
                v += p[i+1] - p[i];
            }else{
                s += p[i] - p[i+1];
            }
        }

        System.out.println(v);
        System.out.println(s);
    }
}
