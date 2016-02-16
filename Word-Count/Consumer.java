public interface Consumer <AnyType>{
	/**
	 * This interface defines a functional object. 
	 * Some method in some class that takes a Consumer object as argument can invoke the 
	 * the accept() method of the Consumer object, passing it some data.
	 * Typically used by algorithms that walk over data structures.
	 * 
	 * @author hako
	 *
	 * @param <AnyType>
	 */

	 void accept(AnyType actor);

}
