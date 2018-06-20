public class Dog extends Animal {
	public Dog(String name, int age){
		super(name, age);
		this.noise = "Woof!";
	}

	@Override
	public void greet(){
		System.out.println("Dog " + name + " says: " + makeNoise());
	}

	/** Dog class' own method */
	public void playFetch(){
		System.out.println("Fetch, " + name + "!");
	}
}