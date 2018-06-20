public class AltList<X, Y> {
	private X item;
	private AltList<Y, X> next;

	public AltList(X item, AltList<Y, X> next){
		this.item = item;
		this.next = next;
	}

	public AltList<Y, X> pairSwap(){
		AltList<Y, X> swap = new AltList<Y, X>(next.item,new AltList<X, Y>(item,null));
		if(next.next == null){
			return swap;
		}
		return swap.next.next = next.next.pairSwap();
	}

	public void printList(){

	}

	public static void main(String[] args){
		AltList<Integer, String> list = new AltList<Integer, String>(5,
			new AltList<String, Integer>("cat",
				new AltList<Integer, String>(10,
					new AltList<String, Integer>("dog",null))));

		AltList<String, Integer> newList = list.pairSwap();
	}
}


