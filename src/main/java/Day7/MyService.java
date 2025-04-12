package Day7;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class MyService {

    public static class ExchangeRateResponse {
        public String source;
        public double rate;

        public ExchangeRateResponse(String source, double rate) {
            this.source = source;
            this.rate = rate;
        }

        @Override
        public String toString() {
            return "Source: " + source + ", Rate: " + rate;
        }
    }

    // Simulated async API call
    public CompletableFuture<ExchangeRateResponse> callApi(String source, String from, String to) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(new Random().nextInt(1000)); // Simulated delay
            } catch (InterruptedException ignored) {}

            double rate = 70 + new Random().nextDouble() * 10; // Simulated rate
            System.out.println("Fetched from " + source + ": " + rate);
            return new ExchangeRateResponse(source, rate);
        });
    }

    // Case 1: Get the fastest exchange rate response
    public CompletableFuture<ExchangeRateResponse> getFastestExchangeRate(String from, String to) {
        CompletableFuture<ExchangeRateResponse> api1 = callApi("EX1", from, to);
        CompletableFuture<ExchangeRateResponse> api2 = callApi("EX2", from, to);
        CompletableFuture<ExchangeRateResponse> api3 = callApi("EX3", from, to);
        CompletableFuture<ExchangeRateResponse> api4 = callApi("EX4", from, to);
        CompletableFuture<ExchangeRateResponse> api5 = callApi("EX5", from, to);

        return CompletableFuture.anyOf(api1, api2, api3, api4, api5)
                .thenApply(resp -> (ExchangeRateResponse) resp);
    }

    // Case 2: Aggregate all exchange rates
    public CompletableFuture<Map<String, Double>> getAllExchangeRates(String from, String to) {
        List<CompletableFuture<ExchangeRateResponse>> futures = Arrays.asList(
                callApi("EX1", from, to),
                callApi("EX2", from, to),
                callApi("EX3", from, to),
                callApi("EX4", from, to),
                callApi("EX5", from, to)
        );

        CompletableFuture<Void> allDone = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        return allDone.thenApply(v -> futures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toMap(resp -> resp.source, resp -> resp.rate)));
    }
}
