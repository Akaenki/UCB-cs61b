public class conditions {
	public static void main(String[] argv) {
		int month = 2; 
		
		/* A switch can be used only if condition tests weather x is equal
		 * to some constant (integer)!
		 */
		
		switch(month) {
		case 1: 
			System.out.println("Jan.");
			break;
		case 2:
			System.out.println("Feb.");
			break;
		case 3:
			System.out.println("Mar.");
			break;
		}
		
		/* "break" help jumps to the end of switch, if not the flow of execution
		 * will continue right through the past case to the end
		 */
		
		month = 1;
		switch(month) {
		case 1: 
			System.out.println("Jan.");
		case 2:
			System.out.println("Feb.");
		case 3:
			System.out.println("Mar.");
		}
	}
}
