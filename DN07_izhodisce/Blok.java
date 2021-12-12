import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Blok {

    private Set<Stanovanje> stanovanja = new HashSet<Stanovanje>();
    private int blok[][] = new int[300][300];

    public Blok(Stanovanje stanovanje) {
        for (int x = 0; x < 300; x++) {
            for (int y = 0; y < 300; y++) {
                blok[x][y] = -1;
            }
        }

        buildBlok(stanovanje, 150, 150);

        Queue<Stanovanje> q = new LinkedList<Stanovanje>();
        q.add(stanovanje);
        while (!q.isEmpty()) {
            Stanovanje curr = q.remove();
            if (curr == null) {
                continue;
            }
            if (stanovanja.contains(curr)) {
                continue;
            }
            stanovanja.add(curr);
            for (Stanovanje sosed : curr.getSosedi()) {
                q.add(sosed);
            }
        }
    }

    public Oseba starosta() {
        Oseba[] maxOseba = new Oseba[110];
        int index = 0;
        for (Stanovanje S : this.stanovanja) {
            maxOseba[index] = S.starosta();
            index++;
        }
        int mx = 0;
        int index2 = -1;
        for (int i = 0; i < index; i++) {
            if (maxOseba[i] != null) {
                if (maxOseba[i].getStarost() > mx) {
                    mx = maxOseba[i].getStarost();
                    index2 = i;
                }
            }
        }
        if (index2 == -1)
            return null;
        return maxOseba[index2];
    }

    public int[][] razporeditev() {
        int xMin = 150;
        int yMin = 150;
        int xMax = 150;
        int yMax = 150;
        for (int x = 0; x < 300; x++) {
            for (int y = 0; y < 300; y++) {
                if (blok[x][y] != -1) {
                    xMin = Math.min(x, xMin);
                    yMin = Math.min(y, yMin);
                    xMax = Math.max(x, xMax);
                    yMax = Math.max(y, yMax);
                }
            }
        }

        int returnTabela[][] = new int[xMax - xMin + 1][yMax - yMin + 1];

        for (int x = 0; x < xMax - xMin + 1; x++) {
            for (int y = 0; y < yMax - yMin + 1; y++) {
                returnTabela[x][y] = blok[x + xMin][y + yMin];
            }
        }

        return returnTabela;
    }

    private void buildBlok(Stanovanje curr, int x, int y) {
        if (this.blok[x][y] != -1)
            return;
        if (curr == null)
            return;
        this.blok[x][y] = curr.steviloStanovalcev();
        buildBlok(curr.getSosedi()[0], x, y - 1);
        buildBlok(curr.getSosedi()[1], x - 1, y);
        buildBlok(curr.getSosedi()[2], x, y + 1);
        buildBlok(curr.getSosedi()[3], x + 1, y);
        return;
    }
}
