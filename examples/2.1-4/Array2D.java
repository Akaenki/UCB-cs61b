public class Array2D{
    public static void main(String[] args){
        /* 2D array is an array of array (references of references) */
        int[][] pTri;
        /* This create an array of int array references of size 4 */
        pTri = new int[4][];
        /* Copy the bits (reference, which is now null) */
        int[] rowZero = pTri[0];

        pTri[0] = new int[]{1};
        pTri[1] = new int[]{1,2};
        pTri[2] = new int[]{1,2,1};
        pTri[3] = new int[]{1,3,3,1};
        /* Make a new array rowTwo point to pTri[2] */
        int[] rowTwo = pTri[2];

        /* This create default (4X4) 2D Array with default value of zeros */
        int[][] matrix1 = new int[4][4];

        /* Can also initialize literally as this */
        int[][] matrix2 = new int[][]{{1},{1,1},{1,2,1},{1,3,3,1}};
    }
}
