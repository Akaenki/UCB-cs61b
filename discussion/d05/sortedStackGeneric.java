import java.util.*;

public class sortedStackGeneric<Item extends Comparable<Item>> {
	private Stack<Item> a;
	private Stack<Item> b;

	public sortedStackGeneric(){
		a = new Stack<>();
		b = new Stack<>();
	}

	public void push(Item t){
		while (!a.empty() && a.peek().compareTo(t) < 0){
			b.push(a.pop());
		}
		a.push(t);
		while(!b.empty()){
			a.push(b.pop());
		}
	}

	public Item pop(){
		return a.pop();
	}


	public static void main(String[] args){
		sortedStackGeneric<Integer> stack = new sortedStackGeneric();
		for(int i = 20; i>0; i-=2){
			stack.push(i);
		}

		for(int i = 20; i>0; i-=2){
			System.out.println(stack.pop());
		}
	}
}