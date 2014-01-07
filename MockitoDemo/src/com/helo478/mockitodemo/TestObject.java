package com.helo478.mockitodemo;

public interface TestObject {

	/**
	 * A method which takes a number formatted String, processes it as an int
	 * and returns it. The returned value will be 1 greater than the input. If
	 * the String is not in number format, it will return 1.
	 * 
	 * @param numberFormattedString
	 *            the String to process
	 * @return an int that is 1 greater than the input; if not number format,
	 *         then 1
	 */
	int processNumber(String numberFormattedString);
}
