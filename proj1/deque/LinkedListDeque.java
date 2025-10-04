package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {


    private class Node {
        T item;
        Node next;
        Node previous;
        Node(T item, Node next, Node previous) {
            this.item = item;
            this.next = next;
            this.previous = previous;
        }
    }

    private Node sentinel;
    private int size;

    @Override
    public void printDeque() {
        Node p = sentinel.next;
        while (p.next != sentinel.next) {
            System.out.println(p.item.toString() + " ");
            p = p.next;
        }
        System.out.println(p.item.toString());
    }

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        size = 0;
    }

    @Override
    public void addLast(T item) {
        size++;
        Node p = sentinel.next;
        if (p != null) {
            Node q = new Node(item, p, p.previous);
            p.previous.next = q;
            p.previous = q;
        } else {
            p = new Node(item, null, null);
            sentinel.next = p;
            p.previous = p;
            p.next = p;
        }

    }

    @Override
    public void addFirst(T item) {
        size++;
        Node p = sentinel.next;
        if (p != null) {
            Node q = new Node(item, p, p.previous);
            p.previous.next = q;
            p.previous = q;
            sentinel.next = q;
        } else {
            p = new Node(item, null, null);
            sentinel.next = p;
            p.previous = p;
            p.next = p;
        }


    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        size--;
        if (size == 0) {
            Node p = sentinel.next;
            sentinel.next = null;
            return p.item;
        }
        Node p = sentinel.next.previous;

        p.previous.next = p.next;
        sentinel.next.previous = p.previous;
        return p.item;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node p = sentinel.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListDequeIterator();
    }

    private class LinkedListDequeIterator implements Iterator<T> {
        private Node p;

        LinkedListDequeIterator() {
            p = sentinel.next;
        }


        @Override
        public boolean hasNext() {
            if(p.next != sentinel.next) {
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            if(hasNext()){
                T item = p.item;
                p = p.next;
                return item;
            }
            return null;
        }
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        size--;
        if (size == 0) {
            Node p = sentinel.next;
            sentinel.next = null;
            return p.item;
        }
        Node p = sentinel.next;
        p.next.previous = p.previous;
        p.previous.next = p.next;
        sentinel.next = p.next;
        return p.item;
    }

    @Override
    public int size() {
        return size;
    }


    public T getRecursive(int index) {
        Node p = sentinel.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.item;
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
