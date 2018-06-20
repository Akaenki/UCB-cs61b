public class function_intro {
	/** Returns the larger of x and y. 
	 * @author lmiao4
	 * @version 1.0 (current version number of program)
	 * @since 1.0 (the version this class/method was fist added to)
	 */
	public static int larger(int x, int y) {
		if(x > y) {
			return x;
		}
		return y;
	}
	
	public static void main(String[] argv) {
		System.out.println(larger(-5,10));
	}
}


/*
 * 1. Functions must be declared as part of a class (called method)
 * 2. All parameters and return value of a function must have a declared type
 * 3. Functions in Java return only one value (unlike python)
 * 4. Adding Javadoc comment and tag for self-describe 
 */