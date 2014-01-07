package com.helo478.mockitodemo;

public interface Dependency {

	/**
	 * A method which parses a String as an int. If the String is not in number
	 * format, it will return 0.
	 * 
	 * @param numberFormattedString
	 *            the String to parse
	 * @return the int value of the String; if not number format, then 0
	 */
	int parse(String numberFormattedString);

	/**
	 * A method which should never be called.
	 */
	void unusedBehavior();
}
