package references.streams_exception_handling.ae_avoid_rolling_into_a_runtime_exception;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

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

    public static String getNameOfAirport2(String iata) {
        try {
            return getNameOfAirport(iata);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void main(String[] args) {
        List<String> iataCodes = List.of("AUS", "IAH", "DFW", "TAS", "SAT");

        iataCodes.stream()
                .map(Sample::getNameOfAirport2)
                .forEach(System.out::println);
        //curl up in a corner and cry

        //don't do this
    }
}

