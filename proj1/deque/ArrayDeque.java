package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;
    private int length;

    @SuppressWarnings("unchecked")
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 8;
        length = 0;
        nextFirst = 0;
        nextLast = 1;
    }


    @Override
    public int size() {
        return length;
    }

    @Override
    public void printDeque() {
        for (int i = 0; i < length; i++) {
            System.out.print(items[(i + nextFirst + 1) % size] + " ");
        }

    }

    @Override
    public T removeFirst() {
        if (length < 0.25 * size && length > 1) {
            resize((int) (0.5 * size));
        }
        if (length > 0) {
            nextFirst = (nextFirst + 1) % size;
            T ret = items[nextFirst];
            items[nextFirst] = null;
            length--;
            return ret;
        }
        return null;
    }

    @Override
    public T removeLast() {
        if (length < 0.25 * size && length > 1) {
            resize((int) (0.5 * size));
        }
        if (length > 0) {
            nextLast = (nextLast - 1 + size) % size;
            T ret = items[nextLast];
            items[nextLast] = null;
            length--;
            return ret;
        }
        return null;
    }

    @Override
    public T get(int index) {
        return items[(index + nextFirst + 1) % size ];
    }


    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<T> {

        private int index;

        ArrayIterator() {
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < length;
        }

        @Override
        public T next() {
            index = (index + 1) % size;
            return  items[(index + nextFirst) % size];
        }
    }

    private void resize(int newSize) {
        T[] temp = (T[]) new Object[newSize];
        int i = nextFirst;
        int j = 0;
        while (j < this.length) {
            i = (i + 1) % size;
            temp[j] = items[i];
            j++;
        }
        this.size = newSize;
        nextFirst = size - 1;
        if (isEmpty()) {
            nextLast = 0;
        } else {
            nextLast = j;
        }
        items = temp;

    }

    @Override
    public void addFirst(T item) {
        if (length == size) {
            this.resize(2 * size);
            System.out.println(size);
        }

        items[nextFirst] = item;
        nextFirst = (nextFirst - 1 + size) % size;
        length++;

    }

    @Override
    public void addLast(T item) {
        if (length == size) {
            this.resize(size * 2);
            System.out.println(size);
        }
        items[nextLast] = item;
        nextLast = (nextLast + 1 + size) % size;
        length++;

    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Deque) || ((Deque<?>) o).size() != this.size()) {
            return false;
        }
        if (o == this) {
            return true;
        }
        for (int i = 0; i < this.size(); i++) {
            Object item = ((Deque<?>) o).get(i);
            if (!(this.get(i).equals(item))) {
                return false;
            }
        }
        return true;
    }


}
