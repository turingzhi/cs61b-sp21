package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;
    private Comparator<T> comparator;
    public MaxArrayDeque(Comparator<T> c) {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 3;
        nextLast = 4;
        comparator = c;
    }

    public T max() {
        if (size == 0) {
            return null;
        }

        int i = nextFirst + 1;   // logical first index
        T best = items[i];

        for (int seen = 1; seen < size; seen++) {
            i = (i + 1) % items.length;
            T x = items[i];
            if (comparator.compare(x, best) > 0) {
                best = x;
            }
        }
        return best;

    }

    public T max(Comparator<T> c) {
        if (size == 0) {
            return null;
        }

        comparator = c;
        int i = nextFirst + 1;   // logical first index
        T best = items[i];

        for (int seen = 1; seen < size; seen++) {
            i = (i + 1) % items.length;
            T x = items[i];
            if (comparator.compare(x, best) > 0) {
                best = x;
            }
        }
        return best;
    }
}
