/**
 * Class for doing Radix sort
 *
 * @author Akhil Batra, Alexander Hwang
 *
 */
public class RadixSort {
    /**
     * Does LSD radix sort on the passed in array with the following restrictions:
     * The array can only have ASCII Strings (sequence of 1 byte characters)
     * The sorting is stable and non-destructive
     * The Strings can be variable length (all Strings are not constrained to 1 length)
     *
     * @param asciis String[] that needs to be sorted
     *
     * @return String[] the sorted array
     */
    public static String[] sort(String[] asciis) {
        String[] sorted = new String[asciis.length];
        int maxlen = 0;
        for(int i = 0; i<asciis.length; i++) {
            sorted[i] = asciis[i];
            maxlen = maxlen > asciis[i].length() ? maxlen : asciis[i].length();
        }

        for(int i = 0; i<maxlen; i++){
            sortHelperLSD(sorted,i);
        }
        return sorted;
    }

    public static String[] sortMSD(String[] asciis){
        String[] sorted = new String[asciis.length];
        int maxlen = 0;
        for(int i = 0; i<asciis.length; i++) {
            sorted[i] = asciis[i];
            maxlen = maxlen > asciis[i].length() ? maxlen : asciis[i].length();
        }

        sortHelperMSD(sorted,0,asciis.length,0);

        return sorted;
    }

    /**
     * LSD helper method that performs a destructive counting sort the array of
     * Strings based off characters at a specific index.
     * @param asciis Input array of Strings
     * @param index The position to sort the Strings on.
     */
    private static void sortHelperLSD(String[] asciis, int index) {
        String[] arr = new String[asciis.length];
        int[] count = new int[256];
        for(int i = 0; i<asciis.length; i++){
            arr[i] = asciis[i];
            count[getChar(asciis[i],index)] += 1;
        }

        int[] starts = new int[256];
        int pos = 0;
        for (int i = 0; i < starts.length; i += 1) {
            starts[i] = pos;
            pos += count[i];
        }

        for (int i = 0; i < arr.length; i += 1) {
            String item = arr[i];
            int place = starts[getChar(item,index)];
            asciis[place] = item;
            starts[getChar(item,index)] += 1;
        }
    }

    private static int getChar(String s, int index){
        int loc = s.length() - index - 1;
        if(loc < 0) return 0;

        char a = s.charAt(loc);
        return (int)a;
    }

    /**
     * MSD radix sort helper function that recursively calls itself to achieve the sorted array.
     * Destructive method that changes the passed in array, asciis.
     *
     * @param asciis String[] to be sorted
     * @param start int for where to start sorting in this method (includes String at start)
     * @param end int for where to end sorting in this method (does not include String at end)
     * @param index the index of the character the method is currently sorting on
     *
     **/
    private static void sortHelperMSD(String[] asciis, int start, int end, int index) {
        if(start+1 >= end) return;

        String[] arr = new String[asciis.length];
        int[] count = new int[256];
        int maxlen = 0;
        for(int i = start; i<end; i++){
            String item = asciis[i];
            arr[i] = item;
            count[getCharMSD(item,index)] += 1;
            maxlen = maxlen > asciis[i].length() ? maxlen : asciis[i].length();
        }

        if(maxlen <= index) return;

        int[] starts = new int[256];
        int[] ends = new int[256];
        int pos = 0;
        for (int i = 0; i < starts.length; i += 1) {
            starts[i] = pos;
            ends[i] = pos;
            pos += count[i];
        }

        for (int i = start; i<end; i += 1) {
            String item = arr[i];
            int place = ends[getCharMSD(item,index)];
            asciis[place] = item;
            ends[getCharMSD(item,index)] += 1;
        }

        for(int i = 0; i<starts.length; i++){
            sortHelperMSD(asciis,starts[i],ends[i],index+1);
        }
    }

    private static int getCharMSD(String s, int index){
        if(s.length() <= index) return 0;
        else return (int)s.charAt(index);
    }

    public static void main(String[] args){
        String[] in = new String[]{"ckk","ubw","ab","zzwbb","qqsas","d","pl"};
        String[] out = sortMSD(in);

        System.out.println("Input");
        for(String s: in){
            System.out.print(s + " ");
        }

        System.out.println();
        System.out.println("Output");
        for(String s: out){
            System.out.print(s + " ");
        }
    }
}
