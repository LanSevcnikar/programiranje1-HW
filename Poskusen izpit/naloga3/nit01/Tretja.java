
/*
 * tj.exe
 */

/*
 * Razli"cni objekti tipa Oseba, Cilj oz. Nocitev predstavljajo razli"cne
 * osebe, cilje oz. no"citve.
 */

import java.util.*;

public class Tretja {

    public static void main(String[] args) {
        // koda za ro"cno testiranje (po "zelji)
    }

    // =========================================================================
    public static class Oseba {
        private String ip;
        private String drzava;

        public Oseba(String ip, String drzava) {
            this.ip = ip;
            this.drzava = drzava;
        }
    }

    // =========================================================================
    public static class Cilj {
        private String kraj;
        private String drzava;

        public Cilj(String kraj, String drzava) {
            this.kraj = kraj;
            this.drzava = drzava;
        }
    }

    // =========================================================================
    public static class Nocitev {
        private Oseba oseba;
        private Cilj cilj;
        private int leto;

        public Nocitev(Oseba oseba, Cilj cilj, int leto) {
            this.oseba = oseba;
            this.cilj = cilj;
            this.leto = leto;
        }
    }

    // =========================================================================
    public static int notranje(Nocitev[] nocitve) {
        int s = 0;
        for (Nocitev nocitev : nocitve) {
            // System.out.println(nocitev.cilj.drzava + " " + nocitev.oseba.drzava);
            if (nocitev.cilj.drzava.equals(nocitev.oseba.drzava)) {
                s++;
            }
        }
        return s;
    }

    // =========================================================================
    public static boolean jeZvesta(Nocitev[] nocitve, Oseba oseba) {
        Cilj kraj = nocitve[0].cilj;
        boolean returnsEarly = true;
        for (Nocitev nocitev : nocitve) {
            if (oseba.equals(nocitev.oseba)) {
                kraj = nocitev.cilj;
                returnsEarly = false;
            }
        }
        if (returnsEarly) {
            return true;
        }
        for (Nocitev nocitev : nocitve) {
            if (oseba.equals(nocitev.oseba)) {
                if (kraj.equals(nocitev.cilj) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    // =========================================================================
    public static int[][] obiskanost(Nocitev[] nocitve, Cilj[] cilji,
            int minLeto, int maxLeto) {
        int[][] op = new int[cilji.length][maxLeto - minLeto + 1];
        for (int i = 0; i < maxLeto - minLeto + 1; i++) {
            for (int j = 0; j < cilji.length; j++) {
                op[j][i] = 0;
            }
        }
        for (Nocitev nocitev : nocitve) {
            if (nocitev.leto >= minLeto && nocitev.leto <= maxLeto) {

                int leto = nocitev.leto - minLeto;
                for (int i = 0; i < cilji.length; i++) {
                    if (nocitev.cilj.equals(cilji[i])) {
                        op[i][leto] ++;
                    }
                }
            }
        }
        return op;
    }
}
