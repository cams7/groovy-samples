/**
 * 
 */
package groovy.sample.operators

/**
 * 1.2.10. Operator overloading
 * 
 * Operator		Method			|	Operator	Method
 * 								|
 * +			a.plus(b)		|	a[b]		a.getAt(b)
 * -			a.minus(b)		|	a[b] = c	a.putAt(b, c)
 * *			a.multiply(b)	|	<<			a.leftShift(b)
 *	/			a.div(b)		|	>>			a.rightShift(b)
 *	%			a.mod(b)		|	++			a.next()
 *	**			a.power(b)		|	--			a.previous()
 *	|			a.or(b)			|	+a			a.positive()
 * 	&			a.and(b)		|	-a			a.negative()
 * 	^			a.xor(b)		|	~a			a.bitwiseNegative()
 * @author cams7
 *
 */
class OperatorOverloading {

	static main(args) {
		def b1 = new Bucket(4)
		def b2 = new Bucket(11)
		assert (b1 + b2).size == 15
	}

	static class Bucket {
		int size

		Bucket(int size) {
			this.size = size
		}

		Bucket plus(Bucket other) {
			return new Bucket(this.size + other.size)
		}
	}
}
