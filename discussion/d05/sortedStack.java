/** Implement an sorted stack that:
  * push(int) takes integers in
  * pop() pops the next smallest item in the stack
  */
import java.util.*;

public class sortedStack {
	Stack<Integer> A;
	Stack<Integer> B;

	public sortedStack(){
		A = new Stack<Integer>();
		B = new Stack<Integer>();
	}

	
	public void push(int element){
		while(!A.empty() && A.peek() < element){
			B.push(A.pop());
		}
		A.push(element);
		while(!B.empty()){
			A.push(B.pop());
		}
	}

	public int pop(){
			return A.pop();
	}

	public static void main(String[] args){
		sortedStack stack = new sortedStack();
		for(int i = 20; i>0; i-=2){
			stack.push(i);
		}

		for(int i = 20; i>0; i-=2){
			System.out.println(stack.pop());
		}
	}
}