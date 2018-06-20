public class ArgsDemo {
	/** Sum over all the argumenst */
	public static void main(String[] args) {
		int N = args.length;
		int i = 0;
		int sum = 0;
		while (i < N) {
			sum += Integer.parseInt(args[i]); //convert string to integer
			i++;
		}
		System.out.println(sum);
	}
}
