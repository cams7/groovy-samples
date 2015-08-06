/**
 * 
 */
package groovy.sample.operators

import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * 1.2.7. Regular expression operators
 * 
 * @author cams7
 *
 */
class RegularExpressionOperators {

	//Pattern operator
	static patternOperator(){
		def p = ~/foo/
		assert p instanceof Pattern

		p = ~'foo'
		assert p instanceof Pattern

		p = ~"foo"
		assert p instanceof Pattern

		p = ~$/dollar/slashy $ string/$
		assert p instanceof Pattern

		def pattern = "foo"
		p = ~"${pattern}"
		assert p instanceof Pattern
	}

	//Find operator
	static findOperator(){
		def text = "some text to match"
		def m = text =~ /match/
		assert m instanceof Matcher
		if (!m) {
			throw new RuntimeException("Oops, text not found!")
		}
	}

	//Match operator
	static matchOperator(){
		def text = "some text to match"
		def m = text ==~ /match/
		assert m instanceof Boolean
		if (m) {
			throw new RuntimeException("Should not reach that point!")
		}
	}

	static main(args) {
		patternOperator()

		findOperator()

		matchOperator()
	}

}
