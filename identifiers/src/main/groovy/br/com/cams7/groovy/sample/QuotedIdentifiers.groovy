package br.com.cams7.groovy.sample

class QuotedIdentifiers {

	static void printMap1(){
		def map = [:]

		map."an identifier with a space and double quotes" = "ALLOWED"
		map.'with-dash-signs-and-single-quotes' = "ALLOWED"

		assert map."an identifier with a space and double quotes" == "ALLOWED"
		assert map.'with-dash-signs-and-single-quotes' == "ALLOWED"

		println "map1 values:"
		map.each {k,v ->
			println "$k = $v"
		}
	}

	static void printMap2(){
		def map = [:]

		map.'single quote' = "abc"
		map."double quote" = 1
		map.'''triple single quote''' = 2.5
		map."""triple double quote""" = 'a'
		map./slashy string/ = [1, 2, 3]
		map.$/dollar slashy string/$ = null

		println "map2 values:"
		map.each {k,v ->
			println "$k = $v"
		}
	}
	
	static void printMap3(){
		def map = [:]
		
		def firstname = "Homer"
		map."Simson-${firstname}" = "Homer Simson"
		
		assert map.'Simson-Homer' == "Homer Simson"
		
		println "map3 values:"
		map.each {k,v ->
			println "$k = $v"
		}
	}

	static void main(String[] args) {
		printMap1()
		printMap2()
		printMap3()
	}
}
