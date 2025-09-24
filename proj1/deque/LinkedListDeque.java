package deque;

import net.sf.saxon.om.Item;
import org.w3c.dom.Node;

public class LinkedListDeque<T> {


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
