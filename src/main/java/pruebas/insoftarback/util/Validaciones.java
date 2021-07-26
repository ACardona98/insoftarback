package pruebas.insoftarback.util;

import org.apache.commons.validator.routines.EmailValidator;;

public class Validaciones {
	public static boolean isValidEmailAddress(String email) {
	   return EmailValidator.getInstance().isValid(email);
	}
	public static boolean contieneLetras(String text) {
		return !text.matches("[0-9]+");
	}
	
}
