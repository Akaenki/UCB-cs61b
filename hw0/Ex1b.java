/** Exercise 1b: Function implementation of 
 * drawing triangle similar to Ex. 1a
 */
public class Ex1b {
	public static void DrawTriangle(int n) {
		for(int row = 1; row<=n; row++)  {
			for(int col = 0; col < row; col++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] argv) {
		int n = 7;
		DrawTriangle(n);
	}
}
