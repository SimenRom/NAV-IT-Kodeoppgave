package tester;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pakkeA.FodselsnummerValidator;

public class Tester {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		assertTrue(FodselsnummerValidator.validerNummer("15109841517"));
	}
	
}
