package pakkeA;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FodselsnummerValidator {
	public static boolean validerNummer(String nummer) {
		if (nummer.length() == 11 && nummer.matches("[0-9]{11}") && erDatoGyldig(nummer.substring(0, 6))) {
			Integer individnr = Integer.parseInt(nummer.substring(6, 9));
			Date min = new Date();
			Date max = new Date();
			if (individnr <= 749 && individnr >= 500) {
				
			} else if (individnr <= 749 && individnr >= 000) {
				
			} else if (individnr <= 999 && individnr >= 900) {
				
			} else if (individnr <= 999 && individnr >= 500) {
				
			} else {
				
			}
			return true;
		}
		System.out.println("Ugyldig nummer!");
		return false;
	}

	public static void main(String[] args) {
		System.out.println(validerNummer("15109841517"));
	}

	private static boolean erDatoGyldig(String input) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("ddMMyy");
			format.setLenient(false);
			format.parse(input);
		} catch (ParseException e) {
			return false;
		} catch (IllegalArgumentException e) {
			return false;
		}

		return true;
	}
}
