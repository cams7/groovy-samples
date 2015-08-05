package groovy.sample.strings

class StringTest {

	//Single quoted string
	static void singleQuotedString() {
		println 'a single quoted string'
	}

	//String concatenation
	static void stringConcatenation() {
		assert 'ab' == 'a' + 'b'
	}

	//Triple single quoted string
	static void tripleSingleQuotedString() {
		println '''a triple single quoted string'''

		def aMultilineString = '''line one
		line two
		line three'''

		println aMultilineString

		def startingAndEndingWithANewline = '''
		line one
		line two
		line three
		'''
		println startingAndEndingWithANewline

		def strippedFirstNewline = '''\
		line one
		line two
		line three
		'''

		assert !strippedFirstNewline.startsWith('\n')

		println strippedFirstNewline
	}

	//Escaping special characters
	static void escapingSpecialCharacters() {
		println 'an escaped single quote: \' needs a backslash'
		println 'an escaped escape character: \\ needs a double backslash'
	}

	//Unicode escape sequence
	static void unicodeEscapeSequence() {
		println 'The Euro currency symbol: \u20AC'
	}

	//Double quoted string
	static void doubleQuotedString() {
		println "a double quoted string"
	}

	//String interpolation
	static void stringInterpolation() {
		def name = 'Guillaume' // a plain string
		def greeting = "Hello ${name}"

		assert greeting.toString() == 'Hello Guillaume'

		println greeting

		def sum = "The sum of 2 and 3 equals ${2 + 3}"
		assert sum.toString() == 'The sum of 2 and 3 equals 5'

		println sum

		def person = [name: 'Guillaume', age: 36]
		assert "$person.name is $person.age years old" == 'Guillaume is 36 years old'

		println person
	}

	//Special case of interpolating closure expressions
	static void specialCaseOfInterpolatingClosureExpressions() {
		def sParameterLessClosure = "1 + 2 == ${-> 3}"
		assert sParameterLessClosure == '1 + 2 == 3'

		def sOneParamClosure = "1 + 2 == ${ w -> w << 3}"
		assert sOneParamClosure == '1 + 2 == 3'

		def number = 1
		def eagerGString = "value == ${number}"
		def lazyGString = "value == ${ -> number }"

		assert eagerGString == "value == 1"
		assert lazyGString ==  "value == 1"

		number = 2
		assert eagerGString == "value == 1"
		assert lazyGString ==  "value == 2"
	}

	static String takeString(String message) {
		assert message instanceof String
		return message
	}

	//Interoperability with Java
	static void interoperabilityWithJava() {
		def message = "The message is ${'hello'}"
		assert message instanceof GString

		def result = takeString(message)
		assert result instanceof String
		assert result == 'The message is hello'

		println result
	}

	//GString and String hashCodes
	static void gStringAndStringHashCodes() {
		assert "one: ${1}".hashCode() != "one: 1".hashCode()

		def key = "a"
		def m = ["${key}": "letter ${key}"]

		assert m["a"] == null

		println "map values:"
		m.each {k,v ->
			println "$k = $v"
		}
	}

	//Triple double quoted string
	static void tripleDoubleQuotedString() {
		def name = 'Groovy'
		def template = """
    Dear Mr ${name},

    You're the winner of the lottery!

    Yours sincerly,

    Dave
"""

		assert template.toString().contains('Groovy')

		println template
	}

	//Slashy string
	static void slashyString() {
		def fooPattern = /.*foo.*/
		assert fooPattern == '.*foo.*'

		def escapeSlash = /The character \/ is a forward slash/
		assert escapeSlash == 'The character / is a forward slash'

		def multilineSlashy = /one
		two
		three/

		assert multilineSlashy.contains('\n')

		println multilineSlashy

		def color = 'blue'
		def interpolatedSlashy = /a ${color} car/

		assert interpolatedSlashy == 'a blue car'
	}

	//Dollar slashy string
	static void dollarSlashyString() {
		def name = "Guillaume"
		def date = "April, 1st"

		def dollarSlashy = $/
			Hello $name,
			today we're ${date}.
		
			$ dollar sign
			$$ escaped dollar sign
			\ backslash
			/ forward slash
			$/ escaped forward slash
			$/$ escaped dollar slashy string delimiter
		/$

		assert ['Guillaume', 'April, 1st', '$ dollar sign', '$ escaped dollar sign', '\\ backslash', '/ forward slash', '$/ escaped forward slash', '/$ escaped dollar slashy string delimiter'].each { dollarSlashy.contains(it) }

		println dollarSlashy
	}

	//Characters
	static void characters(){
		char c1 = 'A'
		assert c1 instanceof Character

		def c2 = 'B' as char
		assert c2 instanceof Character

		def c3 = (char)'C'
		assert c3 instanceof Character
	}

	static void main(String[] args) {
		singleQuotedString()

		stringConcatenation()

		tripleSingleQuotedString()

		escapingSpecialCharacters()

		unicodeEscapeSequence()

		doubleQuotedString()

		stringInterpolation()

		specialCaseOfInterpolatingClosureExpressions()

		interoperabilityWithJava()

		gStringAndStringHashCodes()

		tripleDoubleQuotedString()

		slashyString()

		dollarSlashyString()

		characters()
	}


}
