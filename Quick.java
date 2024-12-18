import java.util.Random;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class Quick extends SortAndCount {
    private List<Comparable> list;

    public void sort(Comparable[] a) {
        list = Arrays.asList(a);
        Collections.shuffle(list, new Random(System.currentTimeMillis()));

        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int l, int r) {
        if (r <= l) return;
        int m = partition(a, l, r);
        sort(a, l, m - 1);
        sort(a, m + 1, r);
    }

    private int partition(Comparable[] a, int l, int r) {
        int i = l - 1;
        int j = r;
        while (true) {
            while (less(a[++i], a[r]))
                if (i == r) break;
            while (less(a[r], a[--j]))
                if (j == l) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, i, r);
        return i;
    }
}

