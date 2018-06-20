public abstract class DeluxeModel implements PaperShredder {
	public int count = 0;
	public void count(){
		return count;
	}

	/** Concrete method that override the abstract on in PaperShredder */
	public shredAll(Document[] d){
		for(int i = 0; i<d.length; i++){
			shred(d);
		}
	}

	/** This abstract method must be override by class that extends this
	  * abstract class 
	  */
	public abstract void connectToWifi();
}

/** No concrete method that override the abstract method Shred in the 
  * PaperShredder interface, it must be override by any class that extends
  * this abstract method 
  */