package Day2;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Task1 {

	public static void main(String[] args) {
		int precision = 25;
        int scale = 5;

        testRounding("12345.12345467", "12345.12345", precision, scale);
        testRounding("12345.123456", "12345.12346", precision, scale);
    }

    public static void testRounding(String input, String expectedStr, int precision, int scale) {
        BigDecimal original = new BigDecimal(input);

        MathContext mc = new MathContext(precision, RoundingMode.HALF_UP);

        BigDecimal rounded = original.round(mc).setScale(scale, RoundingMode.HALF_UP);

        BigDecimal expected = new BigDecimal(expectedStr);

        System.out.println("Original : " + original);
        System.out.println("Rounded  : " + rounded);
        System.out.println("Expected : " + expected);

        boolean matches = rounded.compareTo(expected) == 0;
        System.out.println("Match    : " + matches);
        System.out.println("--------------------------------");
    }
}
