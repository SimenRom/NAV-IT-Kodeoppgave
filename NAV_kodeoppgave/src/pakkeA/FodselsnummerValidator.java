package pakkeA;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FodselsnummerValidator {
	public static void main(String[] args) {
		System.out.println(validerNummer("12111995883"));
	}

	public static boolean validerNummer(String nummer) {
		if (nummer.length() == 11 && nummer.matches("[0-9]{11}")) {
			String fodselsdato = nummer.substring(0, 6);
			if (erDatoEksisterende(fodselsdato)) {
				Integer individnr = Integer.parseInt(nummer.substring(6, 9));
				return (individnrMatcherDato(individnr, fodselsdato) && kontrollsiffer(nummer));
			}
		}
		return false;
	}

	private static boolean kontrollsiffer(String nummer) {
		Integer[] tallrekkeA = { 3, 7, 6, 1, 8, 9, 4, 5, 2, 1 };
		Integer[] tallrekkeB = { 5, 4, 3, 2, 7, 6, 5, 4, 3, 2, 1 };
		Integer sumA = 0;
		Integer sumB = 0;
		for (int i = 0; i < tallrekkeA.length; i++) {
			sumA += tallrekkeA[i] * Integer.parseInt(nummer.substring(i, i + 1));
			sumB += tallrekkeB[i] * Integer.parseInt(nummer.substring(i, i + 1));
		}
		sumB += tallrekkeB[10] * Integer.parseInt(nummer.substring(10, 11));

		if ((sumA % 11) != 0 && (sumB % 11) != 0) {
			return false;
		}
		return true;
	}

	private static boolean erDatoEksisterende(String input) {
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

	private static boolean individnrMatcherDato(Integer individnr, String fodselsdato) {
		Integer aar = Integer.parseInt(fodselsdato.substring(4, 6));
		if (individnr <= 749 && individnr >= 500 && aar >= 54 && aar <= 99) {
			return true;
		} else if (individnr <= 749 && individnr >= 000 && aar >= 00 && aar <= 99) {
			return true;
		} else if (individnr <= 999 && individnr >= 900 && aar >= 40 && aar <= 99) {
			return true;
		} else if (individnr <= 999 && individnr >= 500 && aar >= 00 && aar <= 39) {
			return true;
		}
		return false;
	}
}
