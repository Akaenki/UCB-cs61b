public class IntList {
	public int first;
	public IntList rest;
	
	public IntList(int f, IntList r) {
		first = f;
		rest = r;
	}
	
	/** Return the size of the list using recursion */
	public int size() {
		if(this.rest == null) {
			return 1;
		} else{
			return 1 + this.rest.size();
		}
	}
	
	/** Return the size of the list using no recursion */
	public int iterativeSize() {
		IntList r = this.rest;
		int i = 1;
		while(r != null) {
			i++;
			r = r.rest;
		}
		return i;
	}
	
	/** Return the ith item of this IntList */
	public int get(int i) {
		if (i==0) {
			return this.first;
		}
		return this.rest.get(i-1);
	}
	
	/** Increment the whole list by x */
	public static IntList incrList(IntList L, int x) {
		if(L.rest == null) {
			return new IntList(L.first + x, null);
		} else {
			return new IntList(L.first + x, incrList(L.rest,x));
		}
	}
	
	public static IntList dincrList(IntList L, int x) {
		if(L.rest == null) {
			L.first += x;
			return L;
		} else {
			L.first += x;
			L.rest = dincrList(L.rest,x);
			return L;
		}
	}
	
	public static void main(String[] args) {
		IntList L = new IntList(15, null);
		L = new IntList(10, L);
		L = new IntList(5, L);
		IntList Q = dincrList(L, 2);
		System.out.println(Q.get(0)+","+L.get(0));
		System.out.println(Q.get(1)+","+L.get(1));
		System.out.println(Q.get(2)+","+L.get(2));
	}
}
