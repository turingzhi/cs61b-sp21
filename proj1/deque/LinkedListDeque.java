package deque;

import net.sf.saxon.om.Item;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T> {


    private class Node{
        public T item;
        public Node next;
        public Node previous;
        public Node(T item, Node next, Node previous){
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

    public LinkedListDeque(){
        sentinel = new Node(null, null, null);
        size = 0;
    }

    @Override
    public void addLast(T item){
        size++;
        Node p = sentinel.next;
        if(p!=null){
            while(p.next != sentinel.next){
                p = p.next;
            }
            p.next = new Node(item,sentinel.next,p);
        }else{
            p = new Node(item,null,null);
            sentinel.next = p;
            p.next = sentinel.next;
            p.previous = sentinel.next;
        }


    }

    @Override
    public void addFirst(T item){
        size++;
        Node p = sentinel.next;
        if(p != null){
            while(p.next != sentinel.next){
                p = p.next;
            }
            p.next = new Node(item,sentinel.next,p);
            sentinel.next = p.next;
        }else{
            p = new Node(item,null,null);
            sentinel.next = p;
            p.next = sentinel.next;
            p.previous = sentinel.next;

        }


    }

    @Override
    public T removeLast(){
        if(size == 0){
            return null;
        }
        size--;
        Node p = sentinel.next;
        while(p.next != sentinel.next){
            p = p.next;
        }

        p.previous.next = p.next;
        sentinel.next.previous = p.previous;
        return p.item;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index >= size){
            return null;
        }
        Node p = sentinel.next;
        for (int i = 0; i< index; i++){
            while(p.next != sentinel.next){
                p = p.next;
            }
        }
        return p.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListDequeIterator();
    }

    private class LinkedListDequeIterator implements Iterator<T>{
        private Node p;

        LinkedListDequeIterator(){
            p = sentinel.next;
        }


        @Override
        public boolean hasNext() {
            return p == sentinel;
        }

        @Override
        public T next() {
            T item = p.item;
            p = p.next;
            return item;
        }
    }

    public T removeFirst(){
        if(size == 0){
            return null;
        }
        size--;
        Node p = sentinel.next;
        while(p.next != sentinel.next){
            p = p.next;
        }
        Node q = p.next;
        p.next = sentinel.next.next;
        sentinel.next = p.next;
        return q.item;
    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public Node getLast(){
        Node p = sentinel.next;
        while(p.next != sentinel.next){
            p = p.next;
        }
        return p;
    }

    public T getRecursive(int index){
        Node p = sentinel.next;
        for(int i = 0; i < index; i++){
            p = p.next;
        }
        return p.item;
    }


}
