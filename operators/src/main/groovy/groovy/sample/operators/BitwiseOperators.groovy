/**
 * 
 */
package groovy.sample.operators

/**
 * 1.2.4. Bitwise operators
 * 
 * @author cams7
 *
 */
class BitwiseOperators {

	static main(args) {
		int a = 0b00101010
		assert a==42
		int b = 0b00001000
		assert b==8
		assert (a & a) == a // and -> 00101010 & 00101010 = 00101010
		assert (a & b) == b // and -> 00101010 & 00001000 = 00001000
		assert (a | a) == a // or ->  00101010 & 00101010 = 00101010
		assert (a | b) == a // or ->  00101010 | 00001000 = 00101010

		int mask = 0b11111111
		assert ((a ^ a) & mask) == 0b00000000 // (exclusive or -> 00101010 ^ 00101010 = 00000000) & 11111111 = 00000000
		assert ((a ^ b) & mask) == 0b00100010 // (exclusive or -> 00101010 ^ 00001000 = 00100010) & 11111111 = 00100010
		assert ((~a) & mask)    == 0b11010101 // 			   (negation -> ~00101010 = 11010101) & 11111111 = 11010101
	}
}
