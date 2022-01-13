
/*
 * tj.exe
 */

import java.util.*;

public class Cetrta {

    public static void main(String[] args) {
        // koda za ro"cno testiranje (po "zelji)
    }

    public static <T> List<T> razmnozi(List<T> seznam, int n) {
        int index = 0;
        List<T> someList = new ArrayList<T>();
        for (T t : seznam) {
            for (int i = 0; i < index + 1; i++) {
                someList.add(t);
            }
            index++;
            index %= n;
        }
        return someList;
    }

    public static <T> Iterator<T> razmnozevalnik(List<T> seznam, int n) {
        Iterator<T> it = new Iterator<T>() {

            private int indexInArray = 0;
            private int rotate = 0;
            private int _n = n;

            @Override
            public boolean hasNext() {
                if (rotate > 0) {
                    return true;
                }
                return indexInArray < seznam.size() && seznam.get(indexInArray) != null;
            }

            @Override
            public T next() {
                if (rotate > 0) {
                    this.rotate -= 1;
                    return seznam.get(indexInArray);
                }
                rotate = ((indexInArray+1) % _n);
                if(indexInArray + 1 == seznam.size()){
                    rotate = 0;
                }
                return seznam.get(indexInArray++);
            }

        };
        return it;
    }
}
