/**
 * 
 */
package groovy.sample.operators

/**
 * 1.2.2. Relational operators
 * 
 * @author cams7
 *
 */
class RelationalOperators {

	static main(args) {
		assert 1 + 2 == 3
		assert 3 != 4

		assert -2 < 3
		assert 2 <= 2
		assert 3 <= 4

		assert 5 > 1
		assert 5 >= -2

		println "ok"
	}
}
