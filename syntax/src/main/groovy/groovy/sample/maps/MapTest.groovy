package groovy.sample.maps

class MapTest {

	static void main(String[] args) {

		def colors = [red: '#FF0000', green: '#00FF00', blue: '#0000FF']

		assert colors['red'] == '#FF0000'
		assert colors.green  == '#00FF00'

		colors['pink'] = '#FF00FF'
		colors.yellow  = '#FFFF00'

		assert colors.pink == '#FF00FF'
		assert colors['yellow'] == '#FFFF00'

		assert colors instanceof java.util.LinkedHashMap

		assert colors.unknown == null

		def numbers = [1: 'one', 2: 'two']

		assert numbers[1] == 'one'

		def key = 'name'
		def person = [key: 'Guillaume']

		assert !person.containsKey('name')
		assert person.containsKey('key')
		
		println "map values:"
		person.each{println it }

		person = [(key): 'Guillaume']

		assert person.containsKey('name')
		assert !person.containsKey('key')

		println "map values:"
		person.each{println it }
	}
}