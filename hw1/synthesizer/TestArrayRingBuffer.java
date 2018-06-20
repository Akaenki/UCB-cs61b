package synthesizer;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Double> arb = new ArrayRingBuffer<>(4);
        arb.enqueue(33.1);
        arb.enqueue(44.8);
        arb.enqueue(62.3);
        arb.enqueue(-3.4);
        assertEquals(arb.dequeue(),(Double)33.1); //Manually Unboxing
        assertEquals(arb.dequeue(),(Double)44.8);
        assertEquals(arb.dequeue(),(Double)62.3);
        assertEquals(arb.dequeue(),(Double)(-3.4));
    }

    @Test
    public void iteratorTest() {
        ArrayRingBuffer<Double> arb = new ArrayRingBuffer<>(4);
        Deque<Double> rand = new ArrayDeque<>();

        for(int i = 0; i<4; i++){
            rand.add(Math.random()-0.5);
            arb.enqueue(rand.getLast());
        }

        Iterator<Double> itr = arb.iterator();
        for(Double i : arb){
            assertEquals(rand.removeFirst(),i,0.0001);
        }
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
