package Day7;

import java.util.Map;

import Day7.MyService.ExchangeRateResponse;

public class Main {

	public static void main(String[] args) throws Exception {
        MyService service = new MyService();

        System.out.println("\n Fastest Exchange Rate Response:");
        ExchangeRateResponse fast = service.getFastestExchangeRate("USD", "INR").get();
        System.out.println("Fastest: " + fast);

        System.out.println("\n Aggregated Exchange Rates:");
        Map<String, Double> allRates = service.getAllExchangeRates("USD", "INR").get();
        allRates.forEach((src, rate) -> System.out.println(src + " => " + rate));
    }

}
