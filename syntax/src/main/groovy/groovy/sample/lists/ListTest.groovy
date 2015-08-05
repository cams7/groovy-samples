package groovy.sample.lists

class ListTest {

	static void main(String[] args) {
		def numbers = [1, 2, 3]

		assert numbers instanceof List
		assert numbers.size() == 3

		println "list values:"
		numbers.each { print "$it " }

		println "\nlist values:"
		def heterogeneous = [1, "a", true]
		heterogeneous.each { print "$it " }

		def arrayList = [1, 2, 3]
		assert arrayList instanceof java.util.ArrayList

		def linkedList = [2, 3, 4] as LinkedList
		assert linkedList instanceof java.util.LinkedList

		LinkedList otherLinked = [3, 4, 5]
		assert otherLinked instanceof java.util.LinkedList

		def letters = ['a', 'b', 'c', 'd']

		assert letters[0] == 'a'
		assert letters[1] == 'b'

		assert letters[-1] == 'd'
		assert letters[-2] == 'c'

		letters[2] = 'C'
		assert letters[2] == 'C'

		letters << 'e'
		assert letters[ 4] == 'e'
		assert letters[-1] == 'e'

		assert letters[1, 3] == ['b', 'd']
		assert letters[2..4] == ['C', 'd', 'e']

		println "letters:"
		letters.each { print "$it " }

		def multi = [[0, 1], [2, 3], [4, 5]]
		assert multi[1][0] == 2

		println "multi:"
		multi.each {i -> println "$i" }

		println "multi:"
		multi.each {i, j -> println "$i, $j" }
	}
}
