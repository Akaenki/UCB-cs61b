public class dog {
	public int weight;
	public static String bioname = "Canis familiaris"; //a static variable of this class
	
	/** Constructor (like the custom constructor in cpp 
	 * @param startingWeight
	 */
	public dog(int startingWeight) {
		weight = startingWeight;
	}
	
	/** A non-static method or called an "Instance method"
	 * A method has to be instance to be invoked by an instance of this class
	 * and use the instance variable in the class (like weight)
	 */
	public void makeNoise() {
		if(weight < 10) {
			System.out.println("yipyip!");
		} else if(weight < 30) {
			System.out.println("bark. bark.");
		} else {
			System.out.println("woof!");
		}
	}
	
	/** A static method that can compare the weight of two input dogs
	 */
	public static dog maxDog(dog d1, dog d2) {
		if(d1.weight > d2.weight) {
			return d1;
		}
		return d2;
	}
	
	/** Another way to compare dog sizes using an instance method
	 */
	public dog maxDog(dog d2) {
		if(this.weight > d2.weight) { //this refer to the variable invoke this function
			return this;
		}
		return d2;
	}
}





