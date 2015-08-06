/**
 * 
 */
package groovy.sample.operators

/**
 * 1.2.3. Logical operators
 * 
 * @author cams7
 *
 */
class LogicalOperators {

	//Precedence
	static precedence(){
		assert (!false && false) == false

		assert true || true && false
	}


	boolean called

	boolean checkIfCalled() {
		println "called=$called"
		called = true
	}

	//Short-circuiting
	def shortCircuiting(){
		
		println "assert 1"
		
		called = false
		true || checkIfCalled()
		assert !called
		
		println "assert 2"

		called = false
		false || checkIfCalled()
		assert called
		
		println "assert 3"

		called = false
		false && checkIfCalled()
		assert !called
		
		println "assert 4"

		called = false
		true && checkIfCalled()
		assert called
	}

	static main(args) {
		assert !false
		assert true && true
		assert true || false

		precedence()

		new LogicalOperators().shortCircuiting()
	}
}
