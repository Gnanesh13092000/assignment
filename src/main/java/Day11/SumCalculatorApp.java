package Day11;

import java.util.*;

// 1. Strategy Interface
interface SumStrategy {
    boolean isEligible(int number);
}

// 2. Concrete Strategies
class AllStrategy implements SumStrategy {
    public boolean isEligible(int number) {
        return true;
    }
}

class OddStrategy implements SumStrategy {
    public boolean isEligible(int number) {
        return number % 2 != 0;
    }
}

class EvenStrategy implements SumStrategy {
    public boolean isEligible(int number) {
        return number % 2 == 0;
    }
}

class PrimeStrategy implements SumStrategy {
    public boolean isEligible(int number) {
        if (number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}

// 3. Context (Processor)
class SumProcessor {
    private final SumStrategy strategy;

    public SumProcessor(SumStrategy strategy) {
        this.strategy = strategy;
    }

    public int calculateSum(List<Integer> numbers) {
        return numbers.stream()
                      .filter(strategy::isEligible)
                      .mapToInt(Integer::intValue)
                      .sum();
    }
}

public class SumCalculatorApp {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 4, 7, 10, 13, 17, 20);

        int choice = 3; 

        SumStrategy strategy = getStrategy(choice);
        SumProcessor processor = new SumProcessor(strategy);

        int result = processor.calculateSum(numbers);
        System.out.println("Sum based on chosen strategy: " + result);
    }

    private static SumStrategy getStrategy(int choice) {
        return switch (choice) {
            case 1 -> new AllStrategy();
            case 2 -> new OddStrategy();
            case 3 -> new EvenStrategy();
            case 4 -> new PrimeStrategy();
            default -> throw new IllegalArgumentException("Invalid choice");
        };
    }
}

