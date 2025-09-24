package deque;

public class ArrayDeque<T> {
    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextFirst = 0;
        nextLast = 1;
    }



    public boolean isFull(){
        return size == nextLast;
    }

    public int size(){
        return size;
    }

    public void resize(int scale){
        size = size * scale;

    }

    public void addFirst(T item){
        if (isFull()){
            this.resize(2);
            
        }
        else {
            items[nextFirst++] = item;
        }
    }


}
