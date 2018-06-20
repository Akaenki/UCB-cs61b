public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    private static int RFACTOR = 2;
    private static double UFACTOR = 0.25;

    public ArrayDeque(){
        size = 0;
        items = (T[]) new Object[8];
        nextFirst = 0;
        nextLast = 1;
    }

    /** Helper: Resize function */
    private void resize(int capacity){
        T[] a = (T[]) new Object[capacity];
        int size1 = size - nextLast;
        int size2 = size - size1;
        if(size1 < 0 || size2 <0){
            System.arraycopy(items,incrId(nextFirst),a,0,size);
        } else {
            System.arraycopy(items, size2, a, 0, size1);
            System.arraycopy(items, 0, a, size1, size2);
        }
        items = a;
        nextFirst = capacity-1;
        nextLast = size;
    }

    /** Helper: Add index by 1 with loop */
    private int incrId(int index){
        int id = index + 1;
        if(id >= items.length){
            id= 0;
        }
        return id;
    }

    /** Helper: Minus index by 1 with loop */
    private int decrId(int index){
        int id = index - 1;
        if(id < 0){
            id = items.length - 1;
        }
        return id;
    }

    /** Helper: Calculate current usage factor */
    private double usageFactor(){
        return 1.0*size/items.length;
    }


    public void addFirst(T item){
        if(size == items.length){
            resize(size * RFACTOR);
        }
        items[nextFirst] = item;
        size += 1;
        nextFirst = decrId(nextFirst);
    }

    public void addLast(T item){
        if(size == items.length){
            resize(size * RFACTOR);
        }
        items[nextLast] = item;
        size += 1;
        nextLast = incrId(nextLast);
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

    public T removeFirst(){
        if(items.length>16 && usageFactor() < UFACTOR){
            resize(items.length / 2);
        }
        nextFirst = incrId(nextFirst);
        T x = items[nextFirst];
        items[nextFirst] = null;
        size -= 1;
        return x;
    }

    public T removeLast(){
        if(items.length>16 && usageFactor() < UFACTOR){
            resize(items.length / 2);
        }
        nextLast = decrId(nextLast);
        T x = items[nextLast];
        items[nextLast] = null;
        size -= 1;
        return x;
    }

    public T get(int index){
        int ptr = nextFirst;
        for(int i = 0; i<=index; i++){
            ptr = incrId(ptr);
        }
        return items[ptr];
    }

    /** Print function */
    public void printDeque(){
        int ptr = incrId(nextFirst);
        int remain = size;
        while(remain > 0){
            System.out.print(items[ptr]+" ");
            remain -= 1;
            ptr = incrId(ptr);
        }
        System.out.println();
    }

    public static void main(String[] args){
        ArrayDeque<Integer> A = new ArrayDeque<>();
        for(int i = 0; i<=33; i++){
            A.addLast(i);
        }
        A.printDeque();
        System.out.println(A.get(33));
    }
}
