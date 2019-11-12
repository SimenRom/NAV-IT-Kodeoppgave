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
	public void testMedGyldigeNummer() {
		//tilfeldige Fodselsnummer fra http://www.fnrinfo.no/Verktoy/FinnLovlige_Dato.aspx
		assertTrue(FodselsnummerValidator.validerNummer("15109841517"));
		assertTrue(FodselsnummerValidator.validerNummer("12111996596"));
		assertTrue(FodselsnummerValidator.validerNummer("12111996162"));
		assertTrue(FodselsnummerValidator.validerNummer("12111995964"));
		assertTrue(FodselsnummerValidator.validerNummer("12111995964"));
		assertTrue(FodselsnummerValidator.validerNummer("12111990210"));
		assertTrue(FodselsnummerValidator.validerNummer("12111989085"));
		assertTrue(FodselsnummerValidator.validerNummer("12111981203"));
		assertTrue(FodselsnummerValidator.validerNummer("12111979527"));
		assertTrue(FodselsnummerValidator.validerNummer("12111978733"));
		assertTrue(FodselsnummerValidator.validerNummer("12111976560"));
		assertTrue(FodselsnummerValidator.validerNummer("12111971402"));
		assertTrue(FodselsnummerValidator.validerNummer("12111965038"));
		assertTrue(FodselsnummerValidator.validerNummer("12111963531"));
		assertTrue(FodselsnummerValidator.validerNummer("12111962586"));
		assertTrue(FodselsnummerValidator.validerNummer("12111950340"));
		assertTrue(FodselsnummerValidator.validerNummer("12111950693"));
		assertTrue(FodselsnummerValidator.validerNummer("12111950421"));
	}
	
	@Test
	public void testMedUgyldigeNummer() {
		assertFalse(FodselsnummerValidator.validerNummer("01012023233"));
		assertFalse(FodselsnummerValidator.validerNummer(""));
		assertFalse(FodselsnummerValidator.validerNummer("abcdefghijk"));
		assertFalse(FodselsnummerValidator.validerNummer("1211 1950421"));
		assertFalse(FodselsnummerValidator.validerNummer("00000000000"));
		assertFalse(FodselsnummerValidator.validerNummer("11111111111"));


	}
	
}
