package deque;

import org.junit.Test;

import java.util.Comparator;

public class MaxArrayDequeTest {

    @Test
    public void testMax() {
        MaxArrayDeque<Integer> m = new MaxArrayDeque<Integer>(Comparator.naturalOrder());

        m.addFirst(1);
        m.addFirst(2);
        m.addFirst(3);
        m.addFirst(4);
        System.out.println(m.size());
        System.out.println(m.max());
        System.out.println(m.max(Comparator.comparing(Integer::intValue)));

    }
}
