/** An example of declaring and generic DLList that can accept any type of memebers */
public class DLList<typeA> {
    private class stuffNode {
        public typeA item;
        public stuffNode next;

        public stuffNode(typeA i, stuffNode n){
            item = i;
            next = n;
        }
    }

    public static void main(String[] args){
        /* specify the type here when declare the new list */
        DLList<String> s1 = new DLList<>("bone");
        s1.addFirst("thugs);
    }
}
