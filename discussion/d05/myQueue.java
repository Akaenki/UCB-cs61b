/** Define a queue class thet implements push and pop methods 
  * using only the stack ADT and its methods:
  */
import java.util.*;

public class myQueue<E> {
	private Stack<E> stack = new Stack<>();

	public void push(E element){
		stack.push(element);
	}

	public E pop(){
		Stack<E> s2 = new Stack<>();
		while(!stack.empty()){
			s2.push(stack.pop());
		}
		E item = s2.pop();
		while(!s2.empty()){
			stack.push(s2.pop());
		}
		return item;
	}

	public static void main(String[] args){
		myQueue<Integer> q = new myQueue<>();
		for(int i = 0; i<10; i++){
			q.push(i);
		}

		for(int i = 0; i<10; i++){
			System.out.println(q.pop());
		}
	}

}
