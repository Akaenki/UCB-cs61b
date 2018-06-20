public interface PaperShredder {
	/** These methods need to be override by class that implements this
	  * this interface */
	void shred(Document d);
	void shredAll(Document);
}