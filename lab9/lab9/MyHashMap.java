package lab9;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MyHashMap<K, V> implements Map61B<K, V> {

    private static final int DEFAULT_SIZE = 16;
    private static final double MAX_LF = 0.75;

    private ArrayMap<K, V>[] buckets;
    private int size;

    private double loadFactor() {
        return (double)size / buckets.length;
    }

    private void resize(int capacity) {
        ArrayMap<K,V>[] newBuckets = new ArrayMap[capacity];
        /** rehash all the key-value pairs */
        for(int i = 0; i<buckets.length; i++){
            for(K key : buckets[i]){
                int hc = hash(key);
                newBuckets[hc].put(key,buckets[i].get(key));
            }
        }
        buckets = newBuckets;
    }

    public MyHashMap() {
        buckets = new ArrayMap[DEFAULT_SIZE];
        this.clear();
    }

    /* Removes all of the mappings from this map. */
    @Override
    public void clear() {
        this.size = 0;
        for (int i = 0; i < this.buckets.length; i += 1) {
            this.buckets[i] = new ArrayMap<>();
        }
    }

    /** Computes the hash function of the given key. Consists of
     *  computing the hashcode, followed by modding by the number of buckets.
     *  To handle negative numbers properly, uses floorMod instead of %.
     */
    private int hash(K key) {
        if (key == null) {
            return 0;
        }

        int numBuckets = buckets.length;
        return Math.floorMod(key.hashCode(), numBuckets);
    }

    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    @Override
    public V get(K key) {
        int hc = hash(key);
        return buckets[hc].get(key);
    }

    /* Associates the specified value with the specified key in this map. */
    @Override
    public void put(K key, V value) {
        int hc = hash(key);
        int start = buckets[hc].size();
        buckets[hc].put(key,value);
        size += buckets[hc].size() - start;
        if(loadFactor() > MAX_LF) resize(buckets.length*2);
    }

    /* Returns the number of key-value mappings in this map. */
    @Override
    public int size() {
        return size;
    }

    //////////////// EVERYTHING BELOW THIS LINE IS OPTIONAL ////////////////

    /* Returns a Set view of the keys contained in this map. */
    @Override
    public Set<K> keySet() {
        Set<K> keyset = new HashSet<>();
        for(int i = 0; i<buckets.length; i++){
            keyset.addAll(buckets[i].keySet());
        }
        return keyset;
    }

    /* Removes the mapping for the specified key from this map if exists.
     * Not required for this lab. If you don't implement this, throw an
     * UnsupportedOperationException. */
    @Override
    public V remove(K key) {
        int hc = hash(key);
        int start = buckets[hc].size();
        V val = buckets[hc].remove(key);
        size += buckets[hc].size() - start;
        return val;
    }

    /* Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for this lab. If you don't implement this,
     * throw an UnsupportedOperationException.*/
    @Override
    public V remove(K key, V value) {
        int hc = hash(key);
        int start = buckets[hc].size();
        V val = buckets[hc].remove(key,value);
        size += buckets[hc].size() - start;
        return val;
    }

    @Override
    public Iterator<K> iterator() {
        return keySet().iterator();
    }

}
