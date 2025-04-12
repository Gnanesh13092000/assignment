package Day4.util;

import java.util.Random;
import java.util.function.Supplier;

public class PasswordUtil {

	 public static Supplier<String> getPasswordSupplier() {
	        return () -> {
	            String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#$";
	            StringBuilder sb = new StringBuilder();
	            Random rand = new Random();
	            for (int i = 0; i < 16; i++) {
	                sb.append(chars.charAt(rand.nextInt(chars.length())));
	            }
	            return sb.toString();
	        };
	    }
}
