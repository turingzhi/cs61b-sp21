package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;
    private Comparator<T> comparator;
    public MaxArrayDeque(Comparator<T> c) {
        super();
        comparator = c;
    }

    public T max() {
        return getMax(this.comparator);
    }

    public T max(Comparator<T> c) {
        return getMax(c);
    }

    private T getMax(Comparator<T> c) {
        if (this.size() == 0) {
            return null;
        }
        T max = this.get(0);
        for (int i = 1; i < this.size(); i++) {
            T temp = this.get(i);
            if (c.compare(temp, max) > 0) {
                max = temp;
            }
        }
        return max;
    }
}
