package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> b = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                b.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
                System.out.println("addLast(" + randVal + ") in Buglist");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int size2 = b.size();
                System.out.println("size: " + size);
                System.out.println("size2: " + size2 + " in Buglist");
            } else if(operationNumber == 2){
                int size = L.size();
                if(size > 0){
                    int value = L.getLast();
                    System.out.println("getLast(" + value + ")");
                }
                int size2 = b.size();
                if(size2 > 0){
                    int value = b.getLast();
                    System.out.println("getLast(" + value + ")"+ " in Buglist");
                }
            } else if(operationNumber == 3){
                int size = L.size();
                if(size > 0){
                    int value = L.removeLast();
                    System.out.println("removeLast(" + value + ")");
                }
                int size2 = b.size();
                if(size2 > 0){
                    int value = b.removeLast();
                    System.out.println("removeLast(" + value + ")"+ " in Buglist");
                }
            }
        }
    }
}
