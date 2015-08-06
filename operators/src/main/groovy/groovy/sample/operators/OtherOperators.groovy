/**
 * 
 */
package groovy.sample.operators

/**
 * 1.2.9. Operator precedence
 * 
 * Level	Operator(s)												Name(s)
 * 
 * 1		new		()												object creation, explicit parentheses
 * 			()		{}		[]										method call, closure, literal list/map
 * 			.		.&		.@										member access, method closure, field/attribute access
 * 			?.		*		*.		*:								safe dereferencing, spread, spread-dot, spread-map
 * 			~		!		(type)									bitwise negate/pattern, not, typecast
 * 			[]		++		--										list/map/array index, post inc/decrement
 * 2		**														power
 * 3		++		--		+		-								pre inc/decrement, unary plus, unary minus
 * 4		*		/		%										multiply, div, modulo
 * 5		+		-												addition, subtraction
 * 6		<<		>>		>>>		..		..<						left/right (unsigned) shift, inclusive/exclusive range
 * 7		<		<=		>		>=		in		instanceof		less/greater than/or equal, in, instanceof, type coercion
 * 			as
 * 8		==		!=		<=>										equals, not equals, compare to
 * 			=~		==~												regex find, regex match
 * 9		&														binary/bitwise and
 * 10		^														binary/bitwise xor
 * 11		|														binary/bitwise or
 * 12		&&														logical and
 * 13		||														logical or
 * 14		? :														ternary conditional
 * 			?:														elvis operator
 * 15		=		**==	*=		/=		%=		+=		-=		various assignments
 * 			<<=		>>=		>>>=	&=		^=		|=	
 * 
 * 1.2.8. Other operators	
 * 
 * @author cams7
 *
 */
class OtherOperators {

	//Spread operator
	static spreadOperator(){
		def cars = [new Car(make: 'Peugeot', model: '508'), new Car(make: 'Renault', model: 'Clio')]
		def makes = cars*.make
		assert makes == ['Peugeot', 'Renault']

		println "makes:"
		makes.each { print "$it " }

		cars = [new Car(make: 'Peugeot', model: '508'), null, new Car(make: 'Renault', model: 'Clio')]
		assert cars*.make == ['Peugeot', null, 'Renault']
		assert null*.make == null

		println "\nmakes:"
		makes.each { print "$it " }

		def composite = new CompositeObject()
		assert composite*.id == [1, 2]
		assert composite*.name == ['Foo', 'Bar']

		println "\ncomposite:"
		composite.each { print "$it.id " }
	}

	static int function(int x, int y, int z) {
		x*y+z
	}

	//Spreading method arguments
	static spreadingMethodArguments(){
		def args = [4, 5, 6]
		assert function(*args) == 26

		args = [4]
		assert function(*args,5,6) == 26

	}

	//Spread list elements
	static spreadListElements(){
		def items = [4, 5]
		def list = [1, 2, 3, *items, 6]
		assert list == [1, 2, 3, 4, 5, 6]
	}

	//Spread map elements
	static spreadMapElements(){
		def m1 = [c:3, d:4]
		def map = [a:1, b:2, *:m1]
		assert map == [a:1, b:2, c:3, d:4]

		map = [a:1, b:2, *:m1, d: 8]
		assert map == [a:1, b:2, c:3, d:8]
	}

	//Range operator
	static rangeOperator(){
		def range = 0..5
		assert (0..5).collect() == [0, 1, 2, 3, 4, 5]
		assert (0..<5).collect() == [0, 1, 2, 3, 4]
		assert (0..5) instanceof List
		assert (0..5).size() == 6

		assert ('a'..'d').collect() == ['a', 'b', 'c', 'd']
	}

	//Spaceship operator
	static spaceshipOperator(){
		assert (1 <=> 1) == 0
		assert (1 <=> 2) == -1
		assert (2 <=> 1) == 1
		assert ('a' <=> 'a') == 0
		assert ('a' <=> 'z') == -1
		assert ('z' <=> 'a') == 1
	}

	//Subscript operator
	static subscriptOperator(){
		def list = [0, 1, 2, 3, 4]
		assert list[2] == 2
		list[2] = 4
		assert list[0..2] == [0, 1, 4]
		list[0..2] = [6, 6, 6]
		assert list == [6, 6, 6, 3, 4]

		def user = new User(id: 1, name: 'Alex')
		assert user[0] == 1
		assert user[1] == 'Alex'
		user[1] = 'Bob'
		assert user.name == 'Bob'
	}

	//Membership operator
	static membershipOperator(){
		def list = ['Grace', 'Rob', 'Emmy']
		assert ('Emmy' in list)
	}

	//Identity operator
	static identityOperator(){
		def list1 = ['Groovy 1.8', 'Groovy 2.0', 'Groovy 2.3']
		def list2 = ['Groovy 1.8', 'Groovy 2.0', 'Groovy 2.3']
		def list3 = ['Groovy 1.8', 'Groovy 2.0', 'Groovy 2.3', 'Groovy 2.4']
		assert list1 == list2
		assert list1 != list3
		assert !list1.is(list2)
	}

	//Coercion operator
	static coercionOperator(){
		Integer x = 123
		String s = (String) x

		println ''
		println s

		s = x as String
		println s

		def u = new User(name: 'Xavier')
		def p = u as Identifiable
		assert p instanceof Identifiable
		assert !(p instanceof User)
	}

	//Diamond operator
	static diamondOperator(){
		List<String> strings = new LinkedList<>()
		strings << "Groovy"
		strings << "Java"

		strings.each { println it }
	}

	//Call operator
	static callOperator(){
		def mc = new MyCallable()
		assert mc.call(2) == 4
		assert mc(2) == 4
	}

	static main(args) {
		spreadOperator()

		spreadingMethodArguments()

		spreadListElements()

		spreadMapElements()

		rangeOperator()

		spaceshipOperator()

		subscriptOperator()

		membershipOperator()

		identityOperator()

		coercionOperator()

		diamondOperator()

		callOperator()
	}

	static class Car {
		String make
		String model
	}

	static class Component {
		Long id
		String name
	}

	static class CompositeObject implements Iterable<Component> {
		def components = [new Component(id: 1, name: 'Foo'), new Component(id: 2, name: 'Bar')]

		@Override
		Iterator<Component> iterator() {
			components.iterator()
		}
	}

	static class User {
		Long id
		String name

		def getAt(int i) {
			switch (i) {
				case 0: return id
				case 1: return name
			}
			throw new IllegalArgumentException("No such element $i")
		}

		void putAt(int i, def value) {
			switch (i) {
				case 0: id = value; return
				case 1: name = value; return
			}
			throw new IllegalArgumentException("No such element $i")
		}

		def asType(Class target) {
			if (target==Identifiable) {
				return new Identifiable(name: name)
			}
			throw new ClassCastException("User cannot be coerced into $target")
		}
	}

	static class Identifiable {
		String name
	}

	static class MyCallable {
		int call(int x) {
			2*x
		}
	}
}
