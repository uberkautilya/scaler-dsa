package references.streams_exception_handling.af_more_antipattern;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class Sample {
    public static String getNameOfAirport(String iata) throws IOException {
        var url = "https://soa.smext.faa.gov/asws/api/airport/status/" + iata;

        try (var scanner = new Scanner(new URL(url).openStream())) {
            var response = scanner.nextLine();

            if (!response.contains("Name")) {
                throw new RuntimeException("Invalid airport code " + iata);
            }

            return response.split("\"")[3];
            //way too lazy to do the real work to get the data
        }
    }

    interface FunctionEx<T, R> {
        public R apply(T input) throws Exception;
    }

    //DON't DO THIS
    static <T, R> Function<T, R> convertToRuntimeException(FunctionEx<T, R> func) {
        return input -> {
            try {
                return func.apply(input);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
    }

    public static void main(String[] args) {
        List<String> iataCodes = List.of("AUS", "IAH", "DFW", "TAS", "SAT");

        iataCodes.stream()
                .map(convertToRuntimeException(Sample::getNameOfAirport))
                .forEach(System.out::println);
    }
}

