public class array {
	public static void main(String[] argv) {
		/* declaring an array in Java */
		char[] c = new char[4];
		
		c[0] = 'b'; c[1] = 'l'; c[2] = 'u'; c[3] = 'e';
		System.out.println(c);
		
		/* Can also declare and initialize like this */
		int[] d = new int[] {1, 2, 3, 4, 5, 6};
		System.out.println(d); //this print out an address
		System.out.println("length: " + d.length);
		
		/* That declaration is same as this */
		int[] e = new int[3];
		e[0] = 1; e[1] = 2; e[2] = 3;
	}
}
