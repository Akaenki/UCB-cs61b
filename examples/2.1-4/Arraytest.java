public class ArrayTest{
    public static void main(String[] args){
	/* All the followings are valid initiation of array */
	int[] z = null; //64 bit box of reference 
        int[] x,y;
	y = new int[3];
	x = new int[]{1,2,3,4,5}; 
	/* detect automatically size = 5 */
        int[] w = {0,10,11,12,13};

	/* Create an array of String References (each 64 bits) */
	String[] s = new String[6]; 
	s[4] = "ketchup"; 

	/** Copy array using arraycopy, it takes 5 parameters
 	 *  1. Source array
 	 *  2. Start position in source
 	 *  3. Target array
 	 *  4. Start position in target
 	 *  5. number to copy
 	 */
	int[] b = new int[5];
	/* the equal sign only copy the reference */
	//b = x;
	System.arraycopy(x,0,b,0,5);
    }
}
