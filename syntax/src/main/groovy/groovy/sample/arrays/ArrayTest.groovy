package groovy.sample.arrays

class ArrayTest {

	static void main(String[] args) {
		String[] arrStr = ['Ananas', 'Banana', 'Kiwi']

		assert arrStr instanceof String[]
		assert !(arrStr instanceof List)

		def numArr = [1, 2, 3] as int[]

		assert numArr instanceof int[]
		assert numArr.size() == 3

		println "array values:"
		arrStr.each {print "$it " }
		println "\narray values:"
		numArr.each {print "$it " }

		def matrix3 = new Integer[3][3]
		assert matrix3.size() == 3

		Integer[][] matrix2
		matrix2 = [[1, 2], [3, 4]]
		assert matrix2 instanceof Integer[][]

		String[] names = ['C�dric', 'Guillaume', 'Jochen', 'Paul']
		assert names[0] == 'C�dric'

		names[2] = 'Blackdrag'
		assert names[2] == 'Blackdrag'
	}
}
