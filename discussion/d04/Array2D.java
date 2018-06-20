public class Array2D {
	public static int[] flatten(int[][] x){
		int totalLength = 0;

		for(int i = 0; i<x.length; i++){
			totalLength += x[i].length;
		}

		int[] a  = new int[totalLength];
		int aIndex = 0;
		for(int i = 0; i<x.length; i++){
			for(int j = 0; j<x[i].length; j++){
				a[aIndex] = x[i][j];
				aIndex++;
			}
		}
		return a;
	}

	public static void print(int[] x){
		for(int i = 0; i<x.length; i++){
			System.out.print(x[i] + " ");
		}
	}

	public static void main(String[] args){
		int[][] arr = new int[][]{{1,2,3},{},{7,8}};

		int[] arrf = flatten(arr);
		print(arrf);
	}
}
