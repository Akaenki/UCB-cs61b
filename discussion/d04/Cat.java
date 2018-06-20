public class Cat extends Animal {
	/** Cat constructor */
	public Cat(String name, int age){
		/* this call the superclass' constructor */
		super(name, age);
		this.noise = "Meow!";
	}

	/** Create a new greet method to override the one of superclass */
	@Override
	public void greet(){
		System.out.println("Cat " + name + " says: " + makeNoise());
	}
}