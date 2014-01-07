package com.helo478.mockitodemo;

public class TestObjectImpl implements TestObject {
	
	private Dependency dependency;
	
	public TestObjectImpl(Dependency dependency) {
		this.dependency = dependency;
	}

	@Override
	public int processNumber(final String numberFormattedString) {
		
		int parsedNumber = dependency.parse(numberFormattedString);
		
		return parsedNumber + 1;
	}

}
