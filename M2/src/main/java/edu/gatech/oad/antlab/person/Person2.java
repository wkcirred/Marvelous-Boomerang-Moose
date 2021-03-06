package edu.gatech.oad.antlab.person;

/**
 *  A simple class for person 2
 *  returns their name and a
 *  modified string 
 *
 * @author Tianxiao Liu
 * @version 1.1
 */
public class Person2 {
    /** Holds the persons real name */
    private String name;
	 	/**
	 * The constructor, takes in the persons
	 * name
	 * @param pname the person's real name
	 */
	 public Person2(String pname) {
	   name = pname;
	 }
	/**
	 * This method should take the string
	 * input and return its characters in
	 * random order.
	 * given "gtg123b" it should return
	 * something like "g3tb1g2".
	 *
	 * @param input the string to be modified
	 * @return the modified string
	 */
	private String calc(String input) {
	  //Person 2 put your implementation here
	  String s = input;
	  String out = "";
	  int pointer = 0;
	  for (int i = 0; i < input.length(); i++) {
	  	pointer = (int) Math.abs(Math.random() * s.length());
	  	out += s.charAt(pointer);
	  	if (pointer == 0 && s.length()==1) {
	  	} else if (pointer == 0) {
	  		s = s.substring(1, s.length());
	  	} else {
	  		s = s.substring(0, pointer) + s.substring(pointer+1, s.length()); 
	  	}
	  }
	  return out;
	}
	/**
	 * Return a string rep of this object
	 * that varies with an input string
	 *
	 * @param input the varying string
	 * @return the string representing the 
	 *         object
	 */
	public String toString(String input) {
	  return name + calc(input);
	}
}
