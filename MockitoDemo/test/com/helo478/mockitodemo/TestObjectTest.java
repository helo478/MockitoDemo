package com.helo478.mockitodemo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class TestObjectTest {

	private static final String NUMBER_FORMATTED_STRING = "10";

	@Mock
	Dependency mockDependency;

	@Mock
	Dependency unusedMock;

	TestObjectImpl testObjectImpl;

	@Before
	public void setUp() {

		MockitoAnnotations.initMocks(this);

		testObjectImpl = new TestObjectImpl(mockDependency);
	}

	@Test
	public void processNumberTest_shouldCallParseOnDependency() {

		final String parameter = NUMBER_FORMATTED_STRING;

		testObjectImpl.processNumber(parameter);

		Mockito.verify(mockDependency).parse(NUMBER_FORMATTED_STRING);
	}

	@Test
	public void processNumberTest_shouldCallParseOnDependencyOnce() {

		final String parameter = NUMBER_FORMATTED_STRING;

		testObjectImpl.processNumber(parameter);

		Mockito.verify(mockDependency, Mockito.times(1)).parse(
				NUMBER_FORMATTED_STRING);
	}

	@Test
	public void processNumberTest_shouldNotCallUnusedMethodOnDependency() {

		final String parameter = NUMBER_FORMATTED_STRING;

		testObjectImpl.processNumber(parameter);

		Mockito.verify(mockDependency, Mockito.never()).unusedBehavior();
	}

	@Test
	public void processNumberTest_shouldNotInteractWithUnusedMock() {

		final String parameter = NUMBER_FORMATTED_STRING;

		testObjectImpl.processNumber(parameter);

		Mockito.verifyZeroInteractions(unusedMock);
	}

	@Test
	public void processNumberTest_5_shouldReturn6() {

		final String parameter = "5";
		final int expected = 6;

		Mockito.when(mockDependency.parse(parameter)).thenReturn(5);

		final int received = testObjectImpl.processNumber(parameter);

		assertEquals("'5' should return 6", expected, received);
	}

	// By isolating the class under test, we remove the possibility that a
	// failed test could be caused by a dependency.
	@Test
	public void processNumberTest_5and7_shouldReturn6and8() {
		final String[] parameters = { "5", "7" };
		final int[] expected = { 6, 8 };

		Mockito.when(mockDependency.parse(parameters[0])).thenReturn(5);
		Mockito.when(mockDependency.parse(parameters[1])).thenReturn(8);

		final int[] received = { mockDependency.parse(parameters[0]),
				mockDependency.parse(parameters[1]) };

		assertEquals("'5' should return 6", expected[0], received[0]);
		assertEquals("'7' should return 8", expected[1], received[1]);
	}

	@Test
	public void processNumberTest_5and5_and5_shouldReturn6and6and6() {

		final String parameter = "5";
		final int expected = 6;

		// Each argument on .thenReturn() will be returned in order.
		// The last argument will be used for subsequent calls.
		Mockito.when(mockDependency.parse(parameter)).thenReturn(5, 5);
	}
}
