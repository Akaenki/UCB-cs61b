/** Exercise 1a:  print 
 * *
 * **
 * ***
 * ****
 * *****
 * using loops
 */
public class Ex1a {
	public static void main(String[] argv) {
		int row = 1;
		while (row < 6) {
			for(int col = 0; col < row; col++) {
				System.out.print("*");
			}
			System.out.println();
			row++;
		}
	}
}
