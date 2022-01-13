
/*
 * tj.exe Prva.java . .
 */

import java.util.*;

public class Prva {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        for (int i = 0; i < 2 * a; i++) {
            String st = "";
            for (int j = 0; j <  b; j++) {
                st += "*";
            }
            for (int j = 0; j <  b; j++) {
                st += "  ";
            }
            for (int j = 0; j <  b; j++) {
                st += "*";
            }
            System.out.println(st);
        }
        for (int i = 0; i < a; i++) {
            String st = "";
            for (int j = 0; j <  b; j++) {
                st += "****";
            }
            System.out.println(st);
        }
        for (int i = 0; i < 2 * a; i++) {
            String st = "";
            for (int j = 0; j <  b; j++) {
                st += "*";
            }
            for (int j = 0; j <  b; j++) {
                st += "  ";
            }
            for (int j = 0; j <  b; j++) {
                st += "*";
            }
            System.out.println(st);
        }
    }
}
