package deque;

import org.antlr.v4.runtime.misc.NotNull;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 3;
        nextLast = 4;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (int i = 0; i < size(); i++) {
            System.out.print(items[(i + nextFirst + 1) % size] + " ");
        }

    }

    @Override
    public T removeFirst() {
        if (size > 0) {
            nextFirst = (nextFirst + 1) % size;
            T ret = items[nextFirst];
            items[nextFirst] = null;
            size--;
            return ret;
        }
        return null;
    }

    @Override
    public T removeLast() {
        if (size > 0) {
            nextLast = (nextLast - 1) % size;
            T ret = items[nextLast];
            items[nextLast] = null;
            size--;
            return ret;
        }
        return null;
    }

    @Override
    public T get(int index) {
        return items[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<T> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }
    }

    private void resize(int scale) {
        size = size * scale;

    }

    @Override
    public void addFirst(T item) {
        if (nextFirst == nextLast) {
            this.resize(2);
        } else {
            items[nextFirst] = item;
            nextFirst = (nextFirst - 1) % size;
            size++;
        }
    }

    @Override
    public void addLast(T item) {
        if (nextLast == nextFirst) {
            this.resize(2);

        } else {
            items[nextLast] = item;
            nextLast = (nextLast + 1) % size;
            size++;
        }

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }


}
