import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Kalkulator {
    private static HashSet<Integer> możliweWartości = new HashSet<>(Arrays.asList(1, 2, 5, 10, 20, 50, 100));
    private static int max = Collections.max(możliweWartości);
    private static final int SUFIT_SZANSY = 100;

    public HashMap<Integer, Moneta> twórzMonety(HashMap<Integer, Integer> szanse) {
        Moneta m1 = new Moneta(1, 1.64, szanse.get(1));
        Moneta m2 = new Moneta(2, 2.13, szanse.get(2));
        Moneta m5 = new Moneta(5, 3.59, szanse.get(5));
        Moneta m10 = new Moneta(10, 2.51, szanse.get(10));
        Moneta m20 = new Moneta(20, 3.22, szanse.get(20));
        Moneta m50 = new Moneta(50, 3.94, szanse.get(50));
        Moneta m100 = new Moneta(100, 5, szanse.get(100));

        HashSet<Moneta> monety = new HashSet<>();
        monety.add(m1);
        monety.add(m2);
        monety.add(m5);
        monety.add(m10);
        monety.add(m20);
        monety.add(m50);
        monety.add(m100);

        HashMap<Integer, Moneta> ret = new HashMap<>();
        for (Moneta m : monety) {
            ret.put(m.getWartość(), m);
        }

        return ret;
    }

    public HashMap<Integer, Integer> dopasujSzanse() {
        HashMap<Integer, Integer> szanse = new HashMap<>();

        for (int w : możliweWartości) {
            szanse.put(w, obliczSzansę(w, szanse));
        }
    }

    private int obliczSzansę(int w, HashMap<Integer, Integer> szanse) {
        if (sumujSzanse(szanse) == SUFIT_SZANSY) {
            return 0;
        }

        if (w == max) {
            return SUFIT_SZANSY - sumujSzanse(szanse);
        }

        
    }

    private int sumujSzanse(HashMap<Integer, Integer> szanse) {
        int ret = 0;
        for (Integer s : szanse.values()) {
            ret += s;
        }
        return ret;
    }
}