/**
 * 
 */
package groovy.sample.operators

/**
 * 1.2.5. Conditional operators
 * 
 * @author cams7
 *
 */
class ConditionalOperators {

	//Not operator
	static notOperator(){
		assert (!true)    == false
		assert (!'foo')   == false
		assert (!'')      == true
	}

	static result1(string=null){
		def result
		if (string!=null && string.length()>0) {
			result = 'Found'
		} else {
			result = 'Not found'
		}
	}

	static result2(string=null){
		def result = (string!=null && string.length()>0) ? 'Found' : 'Not found'
	}

	static result3(string=null){
		def result = string ? 'Found' : 'Not found'
	}

	//Ternary operator
	static ternaryOperator(){
		println "result1: ${result1()}, ${result1('')}, ${result1(' ')}"
		println "result2: ${result2()}, ${result2('')}, ${result2(' ')}"
		println "result3: ${result3()}, ${result3('')}, ${result3(' ')}"
	}

	static displayName1(user){
		def displayName = user.name ? user.name : 'Anonymous'
	}

	static displayName2(user){
		def displayName = user.name ?: 'Anonymous'
	}

	//Elvis operator
	static elvisOperator(){
		println "displayName1: ${displayName1([name:null])}, ${displayName1([name:''])}, ${displayName1([name:'Groovy'])}"
		println "displayName2: ${displayName2([name:null])}, ${displayName2([name:''])}, ${displayName2([name:'Groovy'])}"
	}

	static main(args) {
		notOperator()

		ternaryOperator()

		elvisOperator()
	}

}
