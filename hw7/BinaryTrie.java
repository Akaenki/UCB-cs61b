import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;

public class BinaryTrie implements Serializable {
    private static class Node implements Comparable<Node> {
        char c;
        int freq;
        Node left,right;

        Node(char c, int freq, Node left, Node right){
            this.c = c;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        boolean isLeaf(){
            return (this.left == null) && (this.right == null);
        }

        public int compareTo(Node o){
            return this.freq - o.freq;
        }
    }

    private Node root;

    public BinaryTrie(Map<Character,Integer> frequencyTable){
        MinPQ<Node> pq = new MinPQ<Node>();
        for(Map.Entry<Character,Integer> i : frequencyTable.entrySet()){
            if(i.getValue() > 0)
                pq.insert(new Node(i.getKey(),i.getValue(),null,null));
        }

        // special case in case there is only one character with a nonzero frequency
        if (pq.size() == 1) {
            root = new Node('\1',0,null,pq.delMin());
        }

        // merge two smallest trees
        while (pq.size() > 1) {
            Node left  = pq.delMin();
            Node right = pq.delMin();
            Node parent = new Node('\0', left.freq + right.freq, left, right);
            pq.insert(parent);
        }
        root = pq.delMin();
    }

    public Match longestPrefixMatch(BitSequence querySequence){
        Node search = root;
        String prefix = "";
        int i = 0;

        for (i = 0; i < querySequence.length(); i++) {
            if (querySequence.bitAt(i) == 0) {
                search = search.left;
                prefix += "0";
            }
            else if(querySequence.bitAt(i) == 1) {
                search = search.right;
                prefix += "1";
            }
            if(search.isLeaf()) break;
        }
        return new Match(new BitSequence(prefix),search.c);
    }

    public Map<Character,BitSequence> buildLookupTable(){
        Map<Character,BitSequence> map = new HashMap<>();
        buildLookupTable(map, root, "");
        return map;
    }

    private static void buildLookupTable(Map<Character,BitSequence> table, Node root,String bit){
        if(root.isLeaf()){
            table.put(root.c,new BitSequence(bit));
            return;
        }
        buildLookupTable(table, root.left, bit+"0");
        buildLookupTable(table, root.right, bit+"1");
    }

    public static void main (String[] args){
        BitSequence bit = new BitSequence();
        bit.appended(0);
        System.out.println(bit.toString());
    }
}
