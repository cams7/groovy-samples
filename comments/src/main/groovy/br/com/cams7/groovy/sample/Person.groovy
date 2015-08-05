package br.com.cams7.groovy.sample

/**
 * A Class description
 */
class Person {
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

	static void main(String[] args) {
		Person p = new Person();
		p.setName("Java");
		System.out.println("Name: " + p.getName());
		System.out.println(p.greet("Groovy"));
	}
}
