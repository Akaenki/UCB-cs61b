/** And SLList is a list of interger, which hides the nakeness within
 *  This is an example of OOP, where the object SLList controls everything
 *  without messing up the IntNode, which is a more natural way of coding.
 */
public class SLList {
    /* Nested Class also allowed in Java. Make the nested class private
     * while this paticular class will only be used in this class.
     * If the nested class never look outward, then make it static (save memory).
     * By doing this, the IntNode class will never access SLList class.
     */
    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n){
            item = i;
            next = n;
        }

    }

    /* Make the variable private to prevent access from other class */
    //private IntNode first;
    /* The first item (if it exist) is at sentinel.next */
    private IntNode sentinel;
    /* Instead of calculating size, an O(N) operation, we store the size */
    private int size;

    /** Creates and empty SLList (default constructor) */
    public SLList(){
        //first = null;
        sentinel = new IntNode(0,null);
        size = 0;
    }

    public SLList(int x){
        //first = new IntNode(x, null);
        sentinel = new IntNode(0,null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public static void main(String[] args) {
        /* creates a list of one integer */
        SLList L = new SLList();
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(20);

        /* create an infinite loop */
        //L.first.next.next = L.fist.next.next;

        System.out.println(L.size());
    }

    /** Adds x to the front of the list */
    public void addFirst(int x){
        size += 1;
        //first = new IntNode(x, first);
        sentinel.next = new IntNode(x,sentinel.next);
    }

    /** Returns the first item in the list */
    public int getFirst() {
        return sentinel.next.item;
    }

    /** Adds an item to the end to the list */
    public void addLast(int x){
        size += 1;
        IntNode r = sentinel;
        while(r.next != null) {
            r = r.next;
        }
        r.next = new IntNode(x,null);
    }

    /** Returns the size of the list that starts at IntNope p.
     *  An helpler function, make it recursive and private
     */
    private static int size(IntNode p) {
        if(p.next == null){
            return 1;
        }
        return 1 + size(p.next);
    }
    /** Then just return the private helpler function */
    public int size(){
        //return size(first);
        return size;
    }
}

/* Unlike IntList, a neked recursion (users have variables that point
 * to the middle of the IntList), SLList acts as a middle man between
 * user and raw data structure.
 */
