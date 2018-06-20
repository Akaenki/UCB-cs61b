import java.util.Iterator;
import java.util.NoSuchElementException;

public class KthIntList implements Iterator<Integer> {
	public int k;
	private IntList curList;
	private boolean hasNext;

	public KthIntList(IntList I, int k){
		this.k = k;
		this.curList = I;
		this.hasNext = true;
	}

	/** Returns true iff there is a next Kth element */
	public boolean hasNext(){
		return this.hasNext;
	}

	/** Returns the next Kth element of IntList, return 0th element first */
	public Integer next(){
		if(curList == null){
			throw new NoSuchElementException("oops!");
		}
		Integer current = curList.first;
		
		for(int i = 0; i<k && curList != null; i++){
			curList = curList.rest;
		}
		return current;
	}

	public static void main(String[] args){
		IntList list = new IntList(0,
			new IntList(1,
				new IntList(2,
					new IntList(3,
						new IntList(4,
							new IntList(5,null))))));
		for (Iterator<Integer> p = new KthIntList(list, 2); p.hasNext();){
			System.out.println(p.next());
		}

	}
}