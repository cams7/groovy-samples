/**
 * 
 */
package groovy.sample.operators

/**
 * 1.2.1. Arithmetic operators
 * 
 * @author cams7
 *
 */
class ArithmeticOperators {

	//Normal arithmetic operators
	static normalArithmeticOperators(){
		assert  1  + 2 == 3
		assert  4  - 3 == 1
		assert  3  * 5 == 15
		assert  3  / 2 == 1.5
		assert 10  % 3 == 1
		assert  2 ** 3 == 8
	}

	//Unary operators
	static unaryOperators(){
		assert +3 == 3
		assert -4 == 0 - 4

		assert -(-1) == 1

		def a = 2
		def b = a++ * 3

		assert a == 3 && b == 6

		def c = 3
		def d = c-- * 2

		assert c == 2 && d == 6

		def e = 1
		def f = ++e + 3

		assert e == 2 && f == 5

		def g = 4
		def h = --g + 1

		assert g == 3 && h == 4
	}


	//Assignment arithmetic operators
	static assignmentArithmeticOperators(){
		def a = 4
		a += 3

		assert a == 7

		def b = 5
		b -= 3

		assert b == 2

		def c = 5
		c *= 3

		assert c == 15

		def d = 10
		d /= 2

		assert d == 5

		def e = 10
		e %= 3

		assert e == 1

		def f = 3
		f **= 2

		assert f == 9
	}

	static main(args) {
		normalArithmeticOperators()

		unaryOperators()

		assignmentArithmeticOperators()

		println "ok"
	}

}
