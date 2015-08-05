package groovy.sample.identifiers

class QuotedIdentifiers {

	//Quoted identifiers
	static void quotedIdentifiers(){
		def map = [:]

		map."an identifier with a space and double quotes" = "ALLOWED"
		map.'with-dash-signs-and-single-quotes' = "ALLOWED"

		assert map."an identifier with a space and double quotes" == "ALLOWED"
		assert map.'with-dash-signs-and-single-quotes' == "ALLOWED"

		map.'single quote' = "abc"
		map."double quote" = 1
		map.'''triple single quote''' = 2.5
		map."""triple double quote""" = 'a'
		map./slashy string/ = [1, 2, 3]
		map.$/dollar slashy string/$ = null

		def firstname = "Homer"
		map."Simson-${firstname}" = "Homer Simson"

		assert map.'Simson-Homer' == "Homer Simson"

		println "map values:"
		map.each {k,v ->
			println "$k = $v"
		}
	}


	static void main(String[] args) {
		quotedIdentifiers()
	}
}
