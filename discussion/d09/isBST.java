public class isBST {
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
	}

	/** Check if the Tree is BST, but do not gurantee */
	public static boolean isBSTBad(TreeNode T){
		if(T==null) return true;
		else if(T.left !=null && T.left.val > T.val)
			return false;
		else if(T.right !=null && T.left.val < T.val)
			return false;
		else return isBSTBad(T.left) && isBSTBad(T.right);
	}

	/** Only return true when given tree is a BST */
	public static boolean isBSTGood(TreeNode T){
		isBSTHelper(T,Integer.MAX_VALUE,Integer.MIN_VALUE);
	}

	private static boolean isBSTHelper(TreeNode T, int max, int min){
		if(T == null) return true;
		else if(T.val<min || T.val>max)
			return false;
		else  return isBSTHelper(T.left,T.val,min) 
					&& isBSTHelper(T.right,max,T.val);
	}

}