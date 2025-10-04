package deque;

import org.junit.Test;
import static org.junit.Assert.*;


public class ArrayDequeTest {
    @Test
    public void addIsEmpty() {
        ArrayDeque<Integer> a = new ArrayDeque<Integer>();
        assertTrue("A newly empty deque is empty", a.isEmpty());
        a.addFirst(0);
        a.removeLast();
        a.addFirst(2);
        a.addLast(3);
        a.removeFirst();
        a.removeLast();
        a.addFirst(6);
        System.out.println(a.removeLast());
        System.out.println("Printing out deque: ");
        a.printDeque();
    }

    @Test
    public void addRemoveTest() {
        ArrayDeque<Integer> array = new ArrayDeque<Integer>();
        // should be empty
        assertTrue("array should be empty upon initialization", array.isEmpty());

        array.addFirst(10);
        // should not be empty
        assertFalse("array should contain 1 item", array.isEmpty());

        array.removeFirst();
        // should be empty
        assertTrue("array should be empty after removal", array.isEmpty());

    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {

        //System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> array = new ArrayDeque<>();
        array.addFirst(3);

        array.removeLast();
        array.removeFirst();
        array.removeLast();
        array.removeFirst();

        int size = array.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);

    }

    @Test
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {


        LinkedListDeque<String>  lld1 = new LinkedListDeque<String>();
        LinkedListDeque<Double>  lld2 = new LinkedListDeque<Double>();
        LinkedListDeque<Boolean> lld3 = new LinkedListDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();

    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {

        //System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());


    }

}
