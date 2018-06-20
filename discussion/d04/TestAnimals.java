public class TestAnimals {
	public static void main(String[] args){
		Animal a = new Animal("Pluto", 10);
		Cat c  = new Cat("Garfield", 6);
		Dog d = new Dog("Fido", 4);

		a.greet();
		c.greet();
		d.greet();

		d.playFetch();

		/* An Cat class can be convert into an animal class */
		a = c; 
		a.greet();

		a = new Dog("Spot", 10);
		a.greet();

		/* playFetch is not a method in Animal which is the static type of a */
		//a.playFetch();

		/* However an animal class cannot be convert to Cat class */
		//d = a; // This will generate error during compiling
		d = (Dog) a; // This bound a to an object that is compatible with Dog type
		d.greet();

		/* The static type of d is Dog, it can call the playFetch method */
		d.playFetch();

	}
}