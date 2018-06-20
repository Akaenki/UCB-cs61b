/** Doubly linked list using circular sentinel */
public class LinkedListDeque<T> {
    /** Nested list Node class */
    private class Node {
        public Node prev;
        public Node next;
        public T item;

        public Node(T i, Node p, Node n){
            item = i;
            prev = p;
            next = n;
        }
    }

    private Node sentinel;
    private int size;

    /** Empty constructors */
    public LinkedListDeque(){
        size = 0;
        sentinel = new Node(null,null,null);
        /* make the sentinel circular */
        sentinel.prev = sentinel;
        sentinel.next = sentinel.prev;
    }

    /** Constructor */
    public LinkedListDeque(T x){
        size = 1;
        sentinel = new Node(null,null,null);
        sentinel.next = new Node(x,sentinel,sentinel);
        sentinel.prev = sentinel.next;
    }

    public void addFirst(T x){
        size += 1;
        sentinel.next = new Node(x,sentinel,sentinel.next);
        sentinel.next.next.prev = sentinel.next;
    }

    public void addLast(T x){
        size += 1;
        sentinel.prev.next = new Node(x,sentinel.prev,sentinel);
        sentinel.prev = sentinel.prev.next;
    }

    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        return false;
    }

    public int size(){
        return size;
    }

    /** print the deque from first item to last, returns null if empty */
    public void printDeque(){
        int s = size;
        if(size == 0){
            System.out.println("null");
            return;
        }
        Node cur = sentinel.next;
        while(s > 0){
            System.out.print(cur.item + " ");
            cur = cur.next;
            s -= 1;
        }
        System.out.println();
    }

    /** Removes and returns the first item in deque, returns null if empty */
    public T removeFirst(){
        if(size == 0){
            return null;
        }
        /** this newly created object will be cleaned after return (heap) */
        Node remove = new Node(sentinel.next.item,sentinel,sentinel.next.next);
        /* Clean memory */
        sentinel.next.next = null;
        sentinel.next.prev = null;
        sentinel.next.item = null;
        /* Reconstruct links */
        sentinel.next = remove.next;
        remove.next.prev = sentinel;
        size -= 1;
        return remove.item;
    }

    /** Removes and returns the last item in deque, returns null if empty */
    public T removeLast(){
        if(size == 0){
            return null;
        }
        Node remove = new Node(sentinel.prev.item,sentinel.prev.prev,sentinel);
        /* Clean memory */
        sentinel.prev.next = null;
        sentinel.prev.prev = null;
        sentinel.prev.item = null;
        /* Reconstruct links */
        sentinel.prev = remove.prev;
        remove.prev.next = sentinel;
        size -= 1;
        return remove.item;
    }

    /** Iterative */
    public T get(int index){
        Node r = sentinel.next;
        for(int i = 0; i<index; i++){
            r = r.next;
        }
        return r.item;
    }

    /** Recursive get function + helper method */
    private T getRecursive(int i, Node n){
        if(i == 0){
            return n.next.item;
        }
        return getRecursive(i-1, n.next);
    }
    public T getRecursive(int index){
        return getRecursive(index,sentinel);
    }


    public static void main(String[] args){
        LinkedListDeque<Integer> L = new LinkedListDeque<>(000);
        L.addFirst(555);
        L.addFirst(666);
        L.addLast(444);

        L.printDeque();
        System.out.println(L.getRecursive(2));
    }
}