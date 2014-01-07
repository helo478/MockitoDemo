package com.helo478.mockitodemo;

public class DependencyImpl implements Dependency {

	@Override
	public int parse(String numberFormattedString) {

		try {
			int parsedNumber = Integer.parseInt(numberFormattedString);
			return parsedNumber;
		} catch (final NumberFormatException nfe) {
			return 0;
		}
	}

	@Override
	public void unusedBehavior() {
		// No implementation necessary
	}

}
