public class WordUtils {
    /** Can copy this method and change the input type but that's ugly */
    public static String longest(List61B<String> list){
        int maxid = 0;
        for(int i = 0; i < list.size(); i++){
            String longestString = list.get(maxid);
            String thisString = list.get(i);
            if(thisString.length() > longestString.length()){
                maxid = i;
            }
        }
        return list.get(maxid);
    }

    public static void main(String[] args){
        /** List61B is the static type (compile-time type) while the AList
         *  is the dynamics type (run-time type) of the object list.
         *  Then if run-time type overrides the method, the run-time type
         *  method is used (Dynamic Method Selection).
         */
        List61B<String> list = new AList<>();
        list.addFirst("last");
        list.addLast("lasting");
        list.addLast("longestlisting");
        list.addFirst("longestlongestlisting");

        System.out.println(longest(list));
    }
}

/** Hypernym in Java
 *  Step 1: define a reference type for our hypernym (i.e. List61B.java)
 *  Step 2: specify that SLList and Alist are hyponyms of that type.
 *  Look at List61B.java
 */