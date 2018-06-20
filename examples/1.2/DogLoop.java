public class DogLoop{
	public static void main(String[] args) {
		dog smallDog = new dog(5);
		dog mediumDog = new dog(25);
		dog hugeDog = new dog(150);
		
		dog[] manyDogs = new dog[4];
		manyDogs[0] = smallDog;
		manyDogs[1] = hugeDog;
		manyDogs[2] = new dog(130);
		/* Uninitialized fourth entry of the namyDogs array is NULL
		 * can be compiled but cannot run (Null.pointer.exception)
		 */
		
		int i = 0;
		while(i < manyDogs.length) {
			dog.maxDog(manyDogs[i], mediumDog).makeNoise();
			i++;
		}
	}
}
