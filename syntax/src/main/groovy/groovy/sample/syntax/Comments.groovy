/**
 * 
 */
package groovy.sample.syntax

/**
 * 1.1.2. Keywords
 * 
 * as		assert		break		case
 * catch	class		const		continue
 * def		default		do			else
 * enum		extends		false		finally
 * for		goto		if			implements
 * import	in			instanceof	interface
 * new		null		package		return
 * super	switch		this		throw
 * throws	trait		true		try
 * while
 * 
 * 1.1.1. Comments
 * 
 * @author cams7
 *
 */
class Comments {

	static main(args) {
		Person p = new Person()
		p.setName("Java")
		System.out.println("Name: " + p.getName())
		System.out.println(p.greet("Groovy"))
	}

	/**
	 * A Class description
	 */
	static class Person {
		/** the name of the person */
		String name

		/**
		 * Creates a greeting method for a certain person.
		 *
		 * @param otherPerson the person to greet
		 * @return a greeting message
		 */
		String greet(String otherPerson) {
			"Hello ${otherPerson}"
		}
	}
}
