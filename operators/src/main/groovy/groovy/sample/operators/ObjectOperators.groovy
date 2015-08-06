/**
 * 
 */
package groovy.sample.operators

/**
 * 1.2.6. Object operators
 * 
 * @author cams7
 *
 */
class ObjectOperators {

	//Safe navigation operator
	static safeNavigationOperator(){

		List<Person> persons = []
		persons << new Person(123, 'Java')
		persons << new Person(321, 'Groovy')

		def person = persons.find { it.id == 123 }
		def name = person?.name
		assert name == 'Java'

		println "person name=$name"

		persons.each {println it}
	}

	//Direct field access operator
	static void directFieldAccessOperator(){
		def user = new User('Bob')
		assert user.name == 'Name: Bob'

		assert user.@name == 'Bob'
	}

	def transform(List<Person> persons, Closure action) {
		def result = []
		persons.each {Person person ->
			result << action(person)
		}
		result
	}

	String describe(Person person) {
		person?"$person.name is $person.age":''
	}

	def doSomething(String str) {
		str.toUpperCase()
	}

	def doSomething(Integer x) {
		2*x
	}

	//Method pointer operator
	void methodPointerOperator(){
		def str = 'example of method reference'
		def fun = str.&toUpperCase
		def upper = fun()
		assert upper == str.toUpperCase()

		def action = this.&describe
		def persons = [new Person(name: 'Bob', age: 42), new Person(name: 'Julia', age: 35)]

		def results = transform(persons, action)
		assert results == ['Bob is 42', 'Julia is 35']

		def bob = persons.find{Person person ->
			person.name=='Bob' && person.age == 43
		}
		println "describe = ${describe(bob)}"

		results.each { println it }

		def reference = this.&doSomething
		assert reference('foo') == 'FOO'
		assert reference(123)   == 246
	}

	static main(args) {
		safeNavigationOperator()

		directFieldAccessOperator()

		new ObjectOperators().methodPointerOperator()
	}

	static class Person {
		int id
		String name
		int age

		Person(){
		}

		Person(int id, String name){
			setId(id)
			setName(name)
		}

		@Override
		String toString() {
			this.class.name + "[id:$id, name:$name, age:$age]"
		}
	}

	static class User {
		public final String name
		User(String name) { this.name = name}
		String getName() { "Name: $name" }
	}

}
