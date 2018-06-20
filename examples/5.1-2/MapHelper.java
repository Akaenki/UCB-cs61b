package syntax3.map;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;

/**
 * Class to demonstrate how generic methods work in Java.
 */
public class MapHelper {
    /* Write the following three methods:
    /** Return item in map if it exists. 
      * Example of generic method (without instantiation a generic class)
      */
    public static <K, V> V get(Map61B<K, V> sim, K key) {
        if (sim.containsKey(key)) {
            return sim.get(key);
        }
        return null;
    }
    /** Returns max of all keys. Works only if x and y have comparable data. 
      * Type K extends the Comparable of type K, this is an type upper bound!
      */
    public static <K extends Comparable<K>, V> K maxKey(Map61B<K, V> map) {
        List<K> keylist = map.keys();
        K largest = keylist.get(0);
        for (K k : keylist) {
            if (k.compareTo(largest) > 0) {
                largest = k;
            }
        }
        return largest;
    }

    @Test
    public void testGet() {
        Map61B<String, Integer> m = new ArrayMap<String, Integer>();
        m.put("horse", 3);
        m.put("fish", 9);
        m.put("house", 10);
        /** Not like generic class, no need to specify types here
          * Java detects it automatically for generic method 
          */
        Integer actual = MapHelper.get(m, "fish");
        Integer expected = 9;
        assertEquals(expected, actual);

        Assert.assertEquals(null, MapHelper.get(m, "awefawefawef"));
    }

    @Test
    public void testMaxKey() {
        Map61B<String, Integer> m = new ArrayMap<String, Integer>();
        m.put("horse", 3);
        m.put("fish", 9);
        m.put("house", 10);

        String actual = MapHelper.maxKey(m);
        String expected = "house";
        assertEquals(expected, actual);
    }

    public static <K, V> void printSize(ArrayMap<K,V> am) {
        System.out.println(am.size());
    }
}
