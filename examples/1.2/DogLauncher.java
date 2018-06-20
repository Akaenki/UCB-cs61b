public class DogLauncher {
	public static void main(String[] args) {
		dog smallDog; //Declaration of a dog variable
		new dog(20); //Instantiation of the dog class as a dog object (here is a garbege)
		smallDog = new dog(5); //Instantiation and assignment
		dog hugeDog = new dog(150); //Declaration, instantiation and assignment
		smallDog.makeNoise();
		hugeDog.makeNoise();
		
		/* Array of objects */
		dog[] dogs = new dog[2]; //create and array of dogs of size 2 (empty)
		dogs[0] = new dog(20);
		dogs[1] = new dog(5);
		dogs[0].makeNoise();
		
		/* Compare the size of two dogs using a static method */
		dog d1 = new dog(5);
		dog d2 = new dog(150);
		dog bigger = dog.maxDog(d1, d2);
		bigger.makeNoise();
		
		/* Compare the size of the dog to another using an instance method */
		bigger = d1.maxDog(d2);
		bigger.makeNoise();
		
		/* call a static variable of the dog class */
		//System.out.println(d1.bioname) //Technically works,
		System.out.println(dog.bioname); //But better to use static memeber by the class name
	}
}
