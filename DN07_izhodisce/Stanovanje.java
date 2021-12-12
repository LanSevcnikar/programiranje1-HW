import java.util.HashSet;
import java.util.Set;

public class Stanovanje {

    private Oseba[] stanovalci;
    private Stanovanje[] sosedi;

    public Stanovanje(Oseba[] stanovalci) {
        this.stanovalci = stanovalci;
    }

    public int steviloStanovalcev() {
        return this.stanovalci.length;
    }

    public int steviloStarejsihOd(Oseba os) {
        int count = 0;
        for (Oseba oseba : this.stanovalci) {
            if (oseba.jeStarejsaOd(os)) {
                count += 1;
            }
        }
        return count;
    }

    public int[] mz() {
        int count = 0;
        for (Oseba oseba : this.stanovalci) {
            if (oseba.getSpol() == 'M') {
                count += 1;
            }
        }
        int[] ret = { count, this.stanovalci.length - count };
        return ret;
    }

    public Oseba starosta() {
        int mx = 0;
        int index = -1;
        for (int i = 0; i < this.stanovalci.length; i++) {
            if (this.stanovalci[i].getStarost() > mx) {
                mx = this.stanovalci[i].getStarost();
                index = i;
            }
        }
        if (index == -1)
            return null;
        return this.stanovalci[index];
    }

    public void nastaviSosede(Stanovanje levi, Stanovanje zgornji,
            Stanovanje desni, Stanovanje spodnji) {
        this.sosedi = new Stanovanje[] { levi, zgornji, desni, spodnji };
    }

    public Oseba starostaSosescine() {
        Oseba[] maxSosed = new Oseba[5];
        maxSosed[0] = this.starosta();
        for (int i = 0; i < this.sosedi.length; i++) {
            if (this.sosedi[i] != null) {
                maxSosed[i + 1] = this.sosedi[i].starosta();
            } else {
                maxSosed[i + 1] = null;
            }
        }
        int mx = 0;
        int index = -1;
        for (int i = 0; i < maxSosed.length; i++) {
            if (maxSosed[i] != null) {
                if (maxSosed[i].getStarost() > mx) {
                    mx = maxSosed[i].getStarost();
                    index = i;
                }
            }
        }
        if (index == -1)
            return null;
        return maxSosed[index];
    }

    public Oseba[] sosedjeSosedov() {
        Set<Oseba> sosediSosedov = new HashSet<Oseba>();
        for (Stanovanje stanovanje : this.sosedi) {
            if (stanovanje == null) {
                continue;
            }
            for (Stanovanje stanovanje2 : stanovanje.getSosedi()) {
                if (stanovanje2 == null) {
                    continue;
                }
                if (stanovanje2 != this) {
                    for (Oseba oseba : stanovanje2.getStanovalci()) {
                        sosediSosedov.add(oseba);
                    }
                }
            }
        }
        Oseba[] sosediSosedovTabela = new Oseba[sosediSosedov.size()];
        int i = 0;
        for (Oseba oseba : sosediSosedov) {
            sosediSosedovTabela[i] = oseba;
            i++;
        }
        return sosediSosedovTabela;
    }

    public Oseba[] getStanovalci() {
        return this.stanovalci;
    }

    public Stanovanje[] getSosedi() {
        return this.sosedi;
    }
}
