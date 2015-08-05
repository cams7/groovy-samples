/**
 * 
 */
package br.com.cams7.groovy.sample;

/**
 * @author cams7
 *
 */
public class Main {
	public static void main(String[] args) {
		Person p = new Person();
		p.setName("Java");
		System.out.println("Name: " + p.getName());
		System.out.println(p.greet("Groovy"));
	}
}
