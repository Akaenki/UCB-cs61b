import org.junit.Test;
import static org.junit.Assert.*;

public class TestDequeGold {

    @Test
    public void TestArrayDeque(){
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> sad2 = new ArrayDequeSolution<>();

        while(true){
            double rand1 = StdRandom.uniform();
            double rand2 = StdRandom.uniform();
            int numToAdd = StdRandom.uniform(100);

            if (rand1 < 0.5) {
                sad1.addLast(numToAdd);
                sad2.addLast(numToAdd);
            } else {
                sad1.addFirst(numToAdd);
                sad2.addFirst(numToAdd);
            }

            if(rand2 < 0.33){
                assertEquals("removeFirst is buggy",sad1.removeFirst(),sad2.removeFirst());
            } else if(rand2 < 0.66){
                assertEquals("removeLast is buggy",sad1.removeLast(),sad2.removeLast());
            } else{
                assertEquals("get is buggy",sad1.get(0), sad2.get(0));
            }
        }
    }
}
