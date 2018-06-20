/** Define a queue class thet implements push and pop methods 
  * using only the stack ADT and its methods
  * RECURSIVE POP
  */
import java.util.*;

public class myQueueRec<E> {
	private Stack<E> stack = new Stack<>();

	public void push(E element){
		stack.push(element);
	}

	public E pop(){
		return pop(stack.pop());
	}
	private E pop(E previous){
		if(stack.empty()){
			return previous;
		}
		E current = stack.pop();
		E toReturn = pop(current);
		push(previous);
		return toReturn;
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