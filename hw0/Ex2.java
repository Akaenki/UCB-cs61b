/** Exercise 2 and 3: Find the largest number in an array
 * (with only positive entries)
 */
public class Ex2 {
    /** Returns the maximum value from m. */
    public static int max(int[] m) {
    	int max = -1;
    	for(int i : m) {
    		if(i > max) {
    			max = i;
    		}
    	}
        return max;
    }
    public static void main(String[] args) {
       int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};  
       System.out.println(max(numbers));
    }
}
