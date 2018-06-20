
public class loop {
	public static boolean isPrime(int n) {
		/* C like for loop
		 * The condition must be i < n, increment at the end
		 */
		for(int i = 2; i<n; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] argv) {
		int n = 15;
		for(int i = 2; i<n; i++) {
			if(isPrime(i)) {
				System.out.println(i);
			}
		}
		
		/* Or can be done by a while loop */
		int divisor = 2;
		while(divisor < n) {
			if(isPrime(divisor)) {
				System.out.println(divisor);
			}
			divisor++;
		}
		
		/* Enhanced for loop: loop through all the element in an array
		 * break: break the innermost loop only.
		 * continue: skip current iteration immediately
		 */
		String[] a = {"cat", "dog", "laser horse", "ketchup", "horse", "horbse"};
		for (String s : a) {
			if(s.contains("laser")) {
				continue;
			}
			
            for (int j = 0; j < 3; j += 1) {
                System.out.println(s);
                if (s.contains("horse")) {
                    break;
                }                
            }
        }
	}
}
